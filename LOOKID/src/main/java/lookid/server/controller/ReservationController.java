package lookid.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lookid.server.dto.ReservationDetailDTO;
import lookid.server.dto.SuccessDTO;
import lookid.server.service.ReservationCMCService;

@Controller
@RequestMapping(value="/reservation")
public class ReservationController {

	// 예약 하기, 예약 수정, 예약 취소 Service
	@Autowired
	@Qualifier("ReservationCMCService")
	ReservationCMCService cmc;
	
	// 예약 하기
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public @ResponseBody SuccessDTO create(@RequestBody ReservationDetailDTO input) throws Exception{
		// jwt 개발 전이라 임의로 선언
		int user_pid = 1;
		return cmc.create(user_pid, input);
	}
	
}
