package com.java.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.common.service.JwtService;
import com.java.service.UserService;
import com.java.vo.BlacklistVO;
import com.java.vo.UserVO;

/*
 * 
 * https://jwt.io/ 홉페이지 Debugger에 인코딩된 토큰을 입력하면 디코딩 돼서 토큰의 정보가 나타남.
 * 
 * https://github.com/viviennes7/luvook/tree/master/src/main/java/com/ms/luvook
 */

/*
 * # 프로젝트 진행시 기능별로 폴더를 만든다. 즉 아래와 같이 나눔.
 * com.java.kr 아래에
 * 
 * -HomeController
 * -user
 * 	- service
 *  - controller
 *  - dao
 *  - vo(dto)
 *  
 * -board
 *  - service
 *  - controller
 *  - dao
 *  - vo(dto)
 * 
 * -common
 *  - service (JwtService, JwtServiceImpl)
 *  - config 
 *  - interceptor
 *  - exception
 *  - 등등
 * 
 */

/*
 * 
 택코드 수정
+ JwtService인터페이스 Autowired해서 구현함
+ 토큰생성시 토큰만료시간등등 추가함
- 토큰만료 혹은 로그아웃시 BlackList DB 만료토큰관리 어떻게?
 */


/*
 * @Controller와 @RestController의 차이 -> HTTP Response Body가 생성되는 방식의 차이.
	기존의 MVC @Controller는 View 기술을 사용하지만, @RestController는 객체를 반환할때 객체 데이터는 바로 JSON/XML 타입의 HTTP 응답을 직접 리턴하게 된다.
 */

@Controller
@RequestMapping("/jwtTest")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private JwtService jwtService;
	
	private Map<String,String> tokenMap = new LinkedHashMap<String, String>(); //토큰임시저장 (로그아웃기능)

	@ResponseBody
	@RequestMapping(value = "/signup", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public Integer signup(@RequestBody UserVO vo) throws Exception {

		if (userService.signupcheckid(vo.getUserId()) == 0) { //아이디 중복확인
			try {
				userService.signup(vo);

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println("성공적인 회원가입");
			}
			return 1; // 회원가입 성공시 1을 리턴
		} else {
			System.out.println("아이디 중복");
			return 0; // 회원가입 실패시(아이디중복) 0을 리턴
		}

	}


	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public JSONObject login(@RequestBody UserVO vo, HttpServletResponse response) throws Exception {
		
		/*
		 * 아직 안드로이드와 통신 전이라 Postman에서 임의로 DB에 있는 사용자정보를 입력하여 토큰을 생성하였지만 
		 * 안드로이드와 연동이 되면 안드로이드에서 서버로 넘어오는 회원 정보를 파라미터로 받아서 DB 존재여부등 검사 후 토큰을 생성하여 코드를 진행해야함
		 */
				
		JSONObject json = new JSONObject();
		
		if (userService.login(vo) != 0) {

			String token = jwtService.create(vo.getUserId(), vo, "user" , "lookid_api"); // key, data, subject(토큰제목), issuer(발행자정보) 
			
			tokenMap.put(vo.getUserId(), token); // 로그아웃 구현을 위해 맵에 토큰 임시저장
			
			response.setHeader("Authorization", token); // HTTP Authorization 헤더에 JWT(토큰)를 담아서 응답.
			
			if (jwtService.isUsable(token)) {
				System.out.println("token : ");
				System.out.println("[ " + token + " ]");
				
				json.put("token", token);
				
			}
			System.out.println("로그인성공");
			
			//return 1; // 로그인 성공시 1을 리턴
			
		} else if (userService.login(vo) == 0) {
			if (userService.signupcheckid(vo.getUserId()) == 0) {
				System.out.println("존재하지 않는 아이디입니다.");
				json.put("status", "invalid userId");

			} else {
				System.out.println("잘못된 비밀번호입니다.");
				json.put("status", "invalid userPw");

			}
			//return 0; // 로그인 실패시 0을 리턴.

		} else {
			System.out.println("db오류");
			json.put("status", "Database Error");
			//return -1; // db error.
		}
		
		return json;

	}

	//로그아웃
	//로그아웃시킨 토큰은 blacklist 테이블에서 관리되도록 한다.
	@ResponseBody
	@RequestMapping(value = "/logout" , method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public JSONObject logout(@RequestBody UserVO userVo) throws Exception{
		
		JSONObject json = new JSONObject(); 
	
		String tempId = userVo.getUserId();
		String tempToken = tokenMap.get(tempId); // 전역변수 맵에 저장되어있는 토큰저장
		
		if(tempToken != null) {
			
			if(jwtService.isUsable(tempToken)) {
			
				if(userService.tokenCount(tempToken) == 0) { //blacklist 테이블에 동일한 토큰이 이미 존재하면 중복등록 방지
					
					BlacklistVO blacklistVo = new BlacklistVO();
					blacklistVo.setLogoutId(tempId); //로그아웃 시킬 아이디 설정
					blacklistVo.setLogoutToken(tempToken); //로그아웃 시킬 토큰 설정
					userService.logout(blacklistVo); //로그아웃 된 토큰을 blacklist 테이블에 저장하여 관리.
					System.out.println("로그아웃성공");
				
				}
				
				json.put("status", "logout is completed!!");
				//return -1 // 로그아웃을 알림
			}
			
		}else {
			json.put("status", "token does not exist...");
		}
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/listAll", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public List<UserVO> listAll() throws Exception {

		return userService.listAll();

	}
}
