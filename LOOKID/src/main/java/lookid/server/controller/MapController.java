package lookid.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lookid.server.dto.GroupDTO;
import lookid.server.service.MapService;

@Controller
@RequestMapping(value = "/map")
public class MapController {
	
	@Autowired
	@Qualifier("MapService")
	MapService map;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody GroupDTO[] group(@RequestParam int rv_pid) throws Exception {
		return map.group(rv_pid);
	}
	
}
