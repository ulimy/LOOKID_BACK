package lookid.server.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lookid.server.dao.Mapper;
import lookid.server.dto.UserPageDTO;
import lookid.server.vo.DeviceChildVO;
import lookid.server.vo.DeviceVO;
import lookid.server.vo.ReservationVO;

@Controller
@RequestMapping(value = "/web")
public class WebController {
	
	@Autowired
	private Mapper mapper;

	@RequestMapping(value = "/address", method = RequestMethod.GET)
	public String searchAddress() {

		return "address/addressAction";
	}

	@RequestMapping(value = "/child", method = RequestMethod.GET)
	public String searchChild() {

		return "child/childAction";
	}

	@RequestMapping(value = "/childTemplate", method = RequestMethod.GET)
	public String searchChildTemplate() {

		return "child/childTemplateAction";
	}

	@RequestMapping(value = "/childCustom", method = RequestMethod.GET)
	public String searchChildCustom() {

		return "child/childCustomAction";
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String mainPage() {

		return "admin/main";
	}

	@RequestMapping(value = "/device", method = RequestMethod.GET)
	public String devicePage() {

		return "admin/device";
	}

	@RequestMapping(value = "/deviceAction", method = RequestMethod.POST)
	public String deviceActionPage(HttpServletRequest request) {
		mapper.truncate_table();
		
		int j = 1;
		while(!request.getParameter("child" + Integer.toString(j)).equals("")) {
			j++;
		}
		
		for(int i = 1; i < j; i++) {
		
			DeviceChildVO dcvo = new DeviceChildVO(request.getParameter("device" + Integer.toString(i)), request.getParameter("child" + Integer.toString(i)));
			DeviceVO dvo = new DeviceVO(request.getParameter("device" + Integer.toString(i)));
			mapper.device_child(dcvo);		
			mapper.device(dvo);
		}
		
		return "admin/deviceAction";
	}

	@RequestMapping(value = "/reservation", method = RequestMethod.GET)
	public String reservationPage() {

		return "admin/reservation";
	}

	@RequestMapping(value = "/reservationAction", method = RequestMethod.POST)
	public String reservationActionPage(HttpServletRequest request) {
		
		ReservationVO vo = null;
	
		for(int i = 1; i <= 500; i++) {
			if((vo = mapper.reservation_detail(i)) != null) {
				request.setAttribute("reservationDetail"+Integer.toString(i), vo);
			}
		}
		
		return "admin/reservationAction";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String userPage() {

		return "admin/user";
	}

	@RequestMapping(value = "/userAction", method = RequestMethod.POST)
	public String userActionPage(HttpServletRequest request) {
		
		UserPageDTO dto = null;
		int count = mapper.count() + 1;
//		request.setAttribute("count", count);
		
		for(int i = 1; i <= count; i++) {
			if((dto = mapper.userPage(i)) != null) {
				request.setAttribute("userInfo"+Integer.toString(i), dto);
			}
		}
		
		return "admin/userAction";
	}

}