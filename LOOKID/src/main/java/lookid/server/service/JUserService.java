package lookid.server.service;

import lookid.server.dto.SuccessDTO;
import lookid.server.dto.UserDTO;

public interface JUserService {

	public void signout() throws Exception;

	public SuccessDTO modify_pw(String pw) throws Exception;

	public SuccessDTO modify(UserDTO user) throws Exception;

}
