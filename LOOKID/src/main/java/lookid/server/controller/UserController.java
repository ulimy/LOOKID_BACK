package lookid.server.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lookid.server.dto.FindAdminDTO;
import lookid.server.dto.FindIdDTO;
import lookid.server.dto.FindPwDTO;
import lookid.server.dto.ModifyPwDTO;
import lookid.server.dto.SigninDTO;
import lookid.server.dto.SuccessDTO;
import lookid.server.dto.UserDTO;
import lookid.server.service.JUserService;
import lookid.server.service.JWTService;
import lookid.server.service.UserService;
import lookid.server.vo.UserVO;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	@Qualifier("JUserService")
	private JUserService jservice;

	@Autowired
	@Qualifier("UserService")
	private UserService service;

	@Autowired
	@Qualifier("JWTService")
	private JWTService JWTService;

	// JWTInterceptor 를 이용하여 url로 지정한 컨트롤러로 들어오는 요청에 앞서 전처리해주어 토큰유효성을 검증 해준다.
	// 단 모든 메소드가아닌 필요한 메소드의 url만 지정.

	// 아이디 중복확인
	@RequestMapping(value = "/idcheck", method = RequestMethod.GET)
	public @ResponseBody SuccessDTO idcheck(@RequestParam(value = "id") String id) throws Exception {
		return service.checkId(id);
	}

	// 회원가입
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public @ResponseBody SuccessDTO signup(@RequestBody UserVO user) throws Exception {
		// 동일인 중복회원가입 방지 -> find_id에서 select시 에러발생 -> phone으로 중복체크
		return service.signup(user);
	}

	// 아이디 찾기
	@RequestMapping(value = "/find_id", method = RequestMethod.GET)
	public @ResponseBody FindIdDTO find_id(@RequestBody FindIdDTO user) throws Exception {

		return service.find_id(user);

	}

	// 비밀번호 찾기
	@RequestMapping(value = "/find_pw", method = RequestMethod.GET)
	public @ResponseBody SuccessDTO find_pw(@RequestBody FindPwDTO user) throws Exception {
		return service.find_pw(user);
	}

	// 관리자 검색
	@RequestMapping(value = "/find_admin", method = RequestMethod.GET)
	public @ResponseBody FindAdminDTO find_admin(@RequestParam(value = "id") String id) throws Exception {

		return service.find_admin(id);
	}

	// 로그인
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public @ResponseBody UserDTO signin(@RequestBody SigninDTO user, HttpServletResponse response)
			throws NullPointerException, Exception {
		// NullPointException처리
		// user_pid는 토큰에, 나머지정보는 UserDTO에 담기
		try {
			// id , pw 존재할 시
			UserVO uvo = jservice.signin(user);

			int user_pid = uvo.getUser_pid(); // 토큰생성에 쓰일 user_pid 따로 저장
			UserDTO udto = new UserDTO(uvo); // UserVO정보를 UserDTO에 담기

			String token = JWTService.create("user_pid", user_pid); // 토큰 생성

			if (JWTService.isUsable(token)) { // 토큰이 유효할 때
				response.setHeader("Authorization", token); // http 헤더에 토큰 담기. 안드로이드로 전송?
				// http 헤더 토큰 키 네임 : Authorization

				System.out.println("token : " + "\n" + "[ " + token + " ]"); // jwt 콘솔 출력
			}
			return udto; // 안드로이드에게 userDTO정보를 넘겨줌.
		} catch (NullPointerException e) {
			// id, pw가 틀릴 시 NullPointerException 발생
			System.out.println(e);
			UserDTO u = new UserDTO(e);
			return u; // UserDTO의 각 속성을 null값으로 넘겨줌
		}
	}

	// 로그아웃 -> interceptor 포함 url 지정
	@ResponseBody
	@RequestMapping(value = "/signout", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public JSONObject signout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 토큰 자체는 삭제 못하나 destroy한 토큰에 요청이 들어오면 잘못된 접근임을 알수있게 무효화

		JSONObject json = new JSONObject();

		String token = request.getHeader("Authorization"); // HTTP 헤더에 담긴 토큰을 꺼냄 (요청)
		int user_pid = JWTService.getUser_pid(token);

		try {
			if (token != null && JWTService.isUsable(token)) {
				JWTService.destroy(token, user_pid, response); // 토큰 무효화

				token = request.getHeader("Authorization");

				try {
					if (token != null && JWTService.isUsable(token)) {
						System.out.println("토큰이 아직 유효합니다.");
						json.put("success", false);
					}
				} catch (Exception e) {
					json.put("success", true);
					System.out.println(e);
					System.out.println("토큰이 삭제되었습니다. 로그아웃 성공");
				}

			} else {
				System.out.println("HTTP JWT 파싱 실패");
				json.put("success", false);
			}
		} catch (Exception e) {
			System.out.println(e);
			json.put("success", false);
		}
		return json;

	}

	// 비밀번호 변경 -> interceptor 포함 url 지정
	@RequestMapping(value = "/modify_pw", method = RequestMethod.PUT)
	public @ResponseBody SuccessDTO modify_pw(@RequestBody ModifyPwDTO user, HttpServletRequest request)
			throws Exception {

		final String token = request.getHeader("Authorization"); // HTTP 헤더에 담긴 토큰을 꺼냄 (요청)

		final SuccessDTO fail = new SuccessDTO(false);

		try {
			if (token != null && JWTService.isUsable(token)) {
				int user_pid = JWTService.getUser_pid(token); // 토큰 user_pid 파싱
				return jservice.modify_pw(user, user_pid);
			} else {
				return fail;
			}
		} catch (Exception e) {
			System.out.println(e);
			return fail;
		}
	}

	// 내 정보 수정 -> interceptor 포함 url 지정
	@RequestMapping(value = "/modify", method = RequestMethod.PUT)
	public @ResponseBody SuccessDTO modify(@RequestBody UserVO user, HttpServletRequest request) throws Exception {
		// 내정보수정버튼을 클릭했을 때 현재 본인의 정보가 먼저 텍스트필드칸에 채워지게 구현(안드로이드) 빈칸으로 수정 누르면 null값으로 들어감
		// bank정보를 not null 처리하지 않았기 때문.

		final String token = request.getHeader("Authorization"); // HTTP 헤더에 담긴 토큰을 꺼냄 (요청)

		final SuccessDTO fail = new SuccessDTO(false);

		try {
			if (token != null && JWTService.isUsable(token)) {
				int user_pid = JWTService.getUser_pid(token); // 토큰 user_pid 파싱
				return jservice.modify(user, user_pid);
			} else {
				return fail;
			}
		} catch (Exception e) {
			System.out.println(e);
			return fail;
		}
	}

}