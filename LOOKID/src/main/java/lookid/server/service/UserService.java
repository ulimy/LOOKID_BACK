package lookid.server.service;

import lookid.server.dto.AdminDTO;
import lookid.server.dto.FindIdDTO;
import lookid.server.dto.SuccessDTO;
import lookid.server.vo.UserVO;

public interface UserService {

	public SuccessDTO checkId(String id) throws Exception;

	public SuccessDTO signup(UserVO user) throws Exception;

	public FindIdDTO find_id(String name, String phone) throws Exception;

	public SuccessDTO find_pw(String id, String mail) throws Exception;

	public AdminDTO find_admin(String id) throws Exception;
	
	public int count() throws Exception;

}
