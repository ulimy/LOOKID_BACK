package lookid.server.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lookid.server.dto.ReservationDetailDTO;
import lookid.server.dto.ReservationListDTO;
import lookid.server.dto.RvPidDTO;
import lookid.server.dto.SuccessDTO;
import lookid.server.service.JWTService;
import lookid.server.service.ReservationCMCService;
import lookid.server.service.ReservationListService;

@Controller
@RequestMapping(value = "/reservation")
public class ReservationController {

	@Autowired
	@Qualifier("JWTService")
	private JWTService JWTService;

	@Autowired
	@Qualifier("ReservationListService")
	ReservationListService list;

	@Autowired
	@Qualifier("ReservationCMCService")
	ReservationCMCService cmc;

	@RequestMapping(value = "/today", method = RequestMethod.GET)
	public @ResponseBody RvPidDTO[] today(HttpServletRequest request) throws Exception {
		final String token = request.getHeader("Authorization");
		try {
			if (token != null && JWTService.isUsable(token)) {
				int user_pid = JWTService.getUser_pid(token);
				return list.today(user_pid);
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody ReservationListDTO[] list(HttpServletRequest request) throws Exception {
		final String token = request.getHeader("Authorization");
		try {
			if (token != null && JWTService.isUsable(token)) {
				int user_pid = JWTService.getUser_pid(token);
				return list.list(user_pid);
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}

	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public @ResponseBody ReservationDetailDTO detail(@RequestParam int rv_pid) throws Exception {
		return list.detail(rv_pid);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody SuccessDTO create(@RequestBody ReservationDetailDTO input, HttpServletRequest request)
			throws Exception {
		final String token = request.getHeader("Authorization");
		try {
			if (token != null && JWTService.isUsable(token)) {
				int user_pid = JWTService.getUser_pid(token);
				return cmc.create(user_pid, input);
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

	@RequestMapping(value = "/modify", method = RequestMethod.PUT)
	public @ResponseBody SuccessDTO modify(@RequestBody ReservationDetailDTO input) throws Exception {
		return cmc.modify(input);
	}

	@RequestMapping(value = "/cancle", method = RequestMethod.DELETE)
	public @ResponseBody SuccessDTO cancle(@RequestBody RvPidDTO input) throws Exception {
		return cmc.cancle(input);
	}

}
