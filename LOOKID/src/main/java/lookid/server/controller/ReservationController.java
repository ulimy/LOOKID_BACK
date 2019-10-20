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

	// JWT
	@Autowired
	@Qualifier("JWTService")
	private JWTService JWTService;

	// 예약 내역 조회, 예약 상세 조회 Service
	@Autowired
	@Qualifier("ReservationListService")
	ReservationListService list;

	// 예약 하기, 예약 수정, 예약 취소 Service
	@Autowired
	@Qualifier("ReservationCMCService")
	ReservationCMCService cmc;

	// 이용당일 여부 확인
	@RequestMapping(value = "/today", method = RequestMethod.GET)
	public @ResponseBody RvPidDTO[] today(HttpServletRequest request) throws Exception {
		final String token = request.getHeader("Authorization");
		try {
			if (token != null && JWTService.isUsable(token)) {
				int user_pid = JWTService.getUser_pid(token); // 토큰 user_pid 파싱
				return list.today(user_pid);
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// 예약 내역 조회
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody ReservationListDTO[] list(HttpServletRequest request) throws Exception {
		final String token = request.getHeader("Authorization");
		try {
			if (token != null && JWTService.isUsable(token)) {
				int user_pid = JWTService.getUser_pid(token); // 토큰 user_pid 파싱
				return list.list(user_pid);
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	// 예약 내역 상세 조회
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public @ResponseBody ReservationDetailDTO detail(@RequestParam int rv_pid) throws Exception {
		return list.detail(rv_pid);
	}

	// 예약 하기
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody SuccessDTO create(@RequestBody ReservationDetailDTO input,HttpServletRequest request) throws Exception {
		final String token = request.getHeader("Authorization");
		try {
			if (token != null && JWTService.isUsable(token)) {
				int user_pid = JWTService.getUser_pid(token); // 토큰 user_pid 파싱
				return cmc.create(user_pid, input);
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// 예약 수정
	@RequestMapping(value = "/modify", method = RequestMethod.PUT)
	public @ResponseBody SuccessDTO modify(@RequestBody ReservationDetailDTO input) throws Exception {
		return cmc.modify(input);
	}

	// 예약 삭제
	@RequestMapping(value = "/cancle", method = RequestMethod.DELETE)
	public @ResponseBody SuccessDTO cancle(@RequestBody RvPidDTO input) throws Exception {
		return cmc.cancle(input);
	}

}
