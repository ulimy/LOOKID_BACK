package lookid.server.dao;

import lookid.server.dto.FindAdminDTO;
import lookid.server.dto.FindIdDTO;
import lookid.server.dto.FindPwDTO;
import lookid.server.dto.ModifyTempPwDTO;
import lookid.server.dto.SigninDTO;
import lookid.server.vo.UserVO;

public interface UserDAO {

	public Integer checkId(String id) throws Exception;

	public void signup(UserVO user) throws Exception;

	public UserVO signin(SigninDTO user) throws Exception;

	public FindIdDTO find_id(FindIdDTO user) throws Exception;

	public String find_pw(FindPwDTO user) throws Exception;
	
	public void modify_temp_pw(ModifyTempPwDTO user) throws Exception;
	
	public FindAdminDTO find_admin(String id) throws Exception;	
	
	public int count() throws Exception;
	
}
