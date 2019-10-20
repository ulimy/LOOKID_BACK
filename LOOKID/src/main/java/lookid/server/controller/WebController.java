package lookid.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 우편번호 검색 API, 실종아동 API, 관리자 페이지  jsp 실행 컨트롤러
@Controller
@RequestMapping(value = "/web")
public class WebController {

	// 주소 검색 open API 다음 kakao
	// http://localhost:8080/web/address
	@RequestMapping(value = "/address", method = RequestMethod.GET)
	public String searchAddress() {

		return "address/addressAction";
	}
	
	// 실종 아동 open API (표 형식)
	// http://localhost:8080/web/child
	@RequestMapping(value = "/child", method = RequestMethod.GET)
	public String searchChild() {

		return "child/childAction";
	}

	// 실종 아동 open API (템플릿)
	// http://localhost:8080/web/childTemplate
	@RequestMapping(value = "/childTemplate", method = RequestMethod.GET)
	public String searchChildTemplate() {

		return "child/childTemplateAction";
	}

	// 관리자 페이지
	// http://localhost:8080/web/admin
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage() {

		return "admin/admin";
	}

}
