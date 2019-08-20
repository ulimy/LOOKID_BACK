package lookid.server.controller;

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
import lookid.server.service.JUserService;
import lookid.server.service.JWTService;
import lookid.server.service.UserService;
import lookid.server.vo.UserVO;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	@Qualifier("JWTService")
	private JWTService JWTService;

	@Autowired
	@Qualifier("JUserService")
	private JUserService juss;

	@Autowired
	@Qualifier("UserService")
	private UserService uss;

	// 아이디 중복확인
	@RequestMapping(value = "/idcheck", method = RequestMethod.GET)
	public @ResponseBody SuccessDTO idcheck(@RequestParam(value = "id") String id) {
		//null처리
		return null;
	}

	// 회원가입
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public @ResponseBody SuccessDTO signup(@RequestBody UserVO user) throws Exception {
		//동일인 중복회원가입 방지 -> find_id에서 select시 에러발생 -> phone으로 중복체크 
		return uss.signup(user);
	}

	// 로그인
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public @ResponseBody UserVO signin(@RequestBody SigninDTO user) {
		//jwt 토큰생성
		//null처리
		//user_pid는 토큰에, 나머지정보는 UserDTO에 담기
		return null;
	}

	// 로그아웃
	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public void signout() {
		// jwt 서비스로 가서 토큰 삭제
		return;
	}

	// 아이디 찾기
	@RequestMapping(value = "/find_id", method = RequestMethod.GET)
	public @ResponseBody FindIdDTO find_id(@RequestBody FindIdDTO user) {
		//null처리
		return null;
	}

	// 비밀번호 찾기
	@RequestMapping(value = "/find_pw", method = RequestMethod.GET)
	public @ResponseBody SuccessDTO find_pw(@RequestBody FindPwDTO user) {
		//null처리
		return null;
	}

	// 비밀번호 변경
	@RequestMapping(value = "/modify_pw", method = RequestMethod.PUT)
	public @ResponseBody SuccessDTO modify_pw(@RequestParam(value = "pw") String pw) {
		return null;
	}

	// 내 정보 수정
	@RequestMapping(value = "/modify", method = RequestMethod.PUT)
	public @ResponseBody SuccessDTO modify(@RequestBody UserVO user) {
		
		return null;
	}

	// 관리자 검색
	@RequestMapping(value = "/find_admin", method = RequestMethod.GET)
	public @ResponseBody FindAdminDTO find_admin(@RequestParam(value = "id") String id) {

		return null;

	}

}