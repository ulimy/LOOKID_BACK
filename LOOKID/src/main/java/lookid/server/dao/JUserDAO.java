package lookid.server.dao;

import lookid.server.dto.UserDTO;

public interface JUserDAO {

	public void modify_pw(String pw) throws Exception;

	public void modify(UserDTO user) throws Exception;

}
