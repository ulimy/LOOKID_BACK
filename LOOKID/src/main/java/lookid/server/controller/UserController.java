package lookid.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lookid.server.dto.SigninDTO;
import lookid.server.dto.SuccessDTO;
import lookid.server.service.UserSignService;
import lookid.server.vo.UserVO;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	@Qualifier("UserSignService")
	private UserSignService uss;

	// 아이디 중복확인
	@RequestMapping(value="/idcheck",method=RequestMethod.GET)
	public @ResponseBody SuccessDTO idcheck(@RequestParam(value="id")String id){
		return null;
	}
	
	// 회원가입
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public @ResponseBody SuccessDTO signup(@RequestBody UserVO user){
		return null;
	}
	
	// 로그인
	@RequestMapping(value="/signin",method=RequestMethod.POST)
	public @ResponseBody UserVO signup(@RequestBody SigninDTO user){
		return null;
	}
	
	//로그아웃 
	@RequestMapping(value="/signout",method=RequestMethod.GET)
	public void signout(){
		// jwt 서비스로 가서 토큰 삭제
		return;
	}
}
