package lookid.server.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import lookid.server.dto.SigninDTO;
import lookid.server.dto.SuccessDTO;
import lookid.server.dto.UserDTO;
import lookid.server.service.JUserService;
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
	
	//JWTInterceptor 를 이용하여 url로 지정한 컨트롤러로 들어오는 요청에 앞서 전처리해주어 토큰을 파싱해준다. 단 모든 메소드가아닌 필요한 메소드의 url만 지정.

	// 아이디 중복확인
	@RequestMapping(value = "/idcheck", method = RequestMethod.GET)
	public @ResponseBody SuccessDTO idcheck(@RequestParam(value = "id") String id) throws Exception {
		// null처리
		return service.checkId(id);
	}

	// 회원가입
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public @ResponseBody SuccessDTO signup(@RequestBody UserVO user) throws Exception {
		// 동일인 중복회원가입 방지 -> find_id에서 select시 에러발생 -> phone으로 중복체크
		return service.signup(user);
	}

	// 로그인
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public @ResponseBody UserDTO signin(@RequestBody SigninDTO user,HttpServletResponse response) throws Exception {
		// null처리
		return service.signin(user,response);
	}

	// 아이디 찾기
	@RequestMapping(value = "/find_id", method = RequestMethod.GET)
	public @ResponseBody FindIdDTO find_id(@RequestBody FindIdDTO user) throws Exception {
		// null처리
		return service.find_id(user);
	}

	// 비밀번호 찾기
	@RequestMapping(value = "/find_pw", method = RequestMethod.GET)
	public @ResponseBody SuccessDTO find_pw(@RequestBody FindPwDTO user) throws Exception {
		// null처리
		return service.find_pw(user);
	}

	// 관리자 검색
	@RequestMapping(value = "/find_admin", method = RequestMethod.GET)
	public @ResponseBody FindAdminDTO find_admin(@RequestParam(value = "id") String id) throws Exception {

		return service.find_admin(id);

	}

	// 로그아웃  -> interceptor 포함 url 지정
	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public void signout(HttpServletRequest request) throws Exception {
		// jwt 서비스로 가서 토큰 삭제
		// 로그아웃후 다시 로그인했을때 로그아웃전 토큰과 동일한 String의 토큰이 생성되는지 아닌지 확인
		
		jservice.signout(request);
		
		return;
	}
	
	// 비밀번호 변경  -> interceptor 포함 url 지정
	@RequestMapping(value = "/modify_pw", method = RequestMethod.PUT)
	public @ResponseBody SuccessDTO modify_pw(@RequestParam(value = "pw") String pw, HttpServletRequest request) throws Exception {
		return jservice.modify_pw(pw, request);
	}

	// 내 정보 수정  -> interceptor 포함 url 지정
	@RequestMapping(value = "/modify", method = RequestMethod.PUT)
	public @ResponseBody SuccessDTO modify(@RequestBody UserVO user, HttpServletRequest request) throws Exception {
		// 내정보수정버튼을 클릭했을 때 현재 본인의 정보가 먼저 텍스트필드칸에 채워지게 구현(안드로이드) 빈칸으로 수정 누르면 null값으로 들어감 bank정보를 not null 처리하지 않았기 때문.
		return jservice.modify(user,request);
	}

}