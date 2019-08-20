package lookid.server.dao;

import lookid.server.vo.UserVO;

public interface JUserDAO {

	public void modify_pw(String pw) throws Exception;

	public void modify(UserVO user) throws Exception;

}
