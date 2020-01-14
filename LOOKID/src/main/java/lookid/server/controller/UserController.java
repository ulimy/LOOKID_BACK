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

import lookid.server.dto.AdminDTO;
import lookid.server.dto.FindIdDTO;
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

	@RequestMapping(value = "/idcheck", method = RequestMethod.GET)
	public @ResponseBody SuccessDTO idcheck(@RequestParam(value = "id") String id) throws Exception {
		return service.checkId(id);
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public @ResponseBody SuccessDTO signup(@RequestBody UserVO user) throws Exception {

		return service.signup(user);
	}

	@RequestMapping(value = "/find_id", method = RequestMethod.GET)
	public @ResponseBody FindIdDTO find_id(@RequestParam(value = "name") String name, @RequestParam(value = "phone") String phone) throws Exception {

		return service.find_id(name,phone);

	}

	@RequestMapping(value = "/find_pw", method = RequestMethod.GET)
	public @ResponseBody SuccessDTO find_pw(@RequestParam(value = "id") String id, @RequestParam(value = "mail") String mail) throws Exception {
		return service.find_pw(id,mail);
	}

	@RequestMapping(value = "/find_admin", method = RequestMethod.GET)
	public @ResponseBody AdminDTO find_admin(@RequestParam(value = "id") String id) throws Exception {

		return service.find_admin(id);
	}

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public @ResponseBody UserDTO signin(@RequestBody SigninDTO user, HttpServletResponse response)
			throws NullPointerException, Exception {

		try {

			UserVO uvo = jservice.signin(user);

			int user_pid = uvo.getUser_pid();
			UserDTO udto = new UserDTO(uvo);

			String token = JWTService.create("user_pid", user_pid);

			if (JWTService.isUsable(token)) {
				response.setHeader("Authorization", token);

			}
			return udto;
		} catch (NullPointerException e) {

			UserDTO u = new UserDTO(e);
			return u;
		}
	}

	@ResponseBody
	@RequestMapping(value = "/signout", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public JSONObject signout(HttpServletRequest request, HttpServletResponse response) throws Exception {

		JSONObject json = new JSONObject();
		return json;
	}

	@RequestMapping(value = "/modify_pw", method = RequestMethod.PUT)
	public @ResponseBody SuccessDTO modify_pw(@RequestBody ModifyPwDTO user, HttpServletRequest request)
			throws Exception {

		final String token = request.getHeader("Authorization");

		final SuccessDTO fail = new SuccessDTO(false);

		try {
			if (token != null && JWTService.isUsable(token)) {
				int user_pid = JWTService.getUser_pid(token);
				return jservice.modify_pw(user, user_pid);
			} else {
				return fail;
			}
		} catch (Exception e) {
			return fail;
		}
	}

	@RequestMapping(value = "/modify", method = RequestMethod.PUT)
	public @ResponseBody SuccessDTO modify(@RequestBody UserVO user, HttpServletRequest request) throws Exception {

		final String token = request.getHeader("Authorization");

		final SuccessDTO fail = new SuccessDTO(false);

		try {
			if (token != null && JWTService.isUsable(token)) {
				int user_pid = JWTService.getUser_pid(token);
				return jservice.modify(user, user_pid);
			} else {
				return fail;
			}
		} catch (Exception e) {
			return fail;
		}
	}

}