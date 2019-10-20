package lookid.server.service;

import lookid.server.dto.ModifyPwDTO;
import lookid.server.dto.SigninDTO;
import lookid.server.dto.SuccessDTO;
import lookid.server.vo.UserVO;

public interface JUserService {

	public UserVO signin(SigninDTO user) throws Exception;
	
	public SuccessDTO modify_pw(ModifyPwDTO user,int user_pid) throws Exception;

	public SuccessDTO modify(UserVO user, int user_pid) throws Exception;

}
