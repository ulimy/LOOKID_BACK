package lookid.server.service;

import lookid.server.dto.AdminDTO;
import lookid.server.dto.FindIdDTO;
import lookid.server.dto.FindPwDTO;
import lookid.server.dto.SuccessDTO;
import lookid.server.vo.UserVO;

public interface UserService {

	public SuccessDTO checkId(String id) throws Exception;

	public SuccessDTO signup(UserVO user) throws Exception;

	public FindIdDTO find_id(FindIdDTO user) throws Exception;

	public SuccessDTO find_pw(FindPwDTO user) throws Exception;

	public AdminDTO find_admin(String id) throws Exception;
	
	public int count() throws Exception;

}
