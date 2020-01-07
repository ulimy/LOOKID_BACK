package lookid.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/web")
public class WebController {

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

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage() {

		return "admin/admin";
	}

}