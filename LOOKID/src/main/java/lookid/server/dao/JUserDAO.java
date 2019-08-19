package lookid.server.dao;

import lookid.server.dto.SuccessDTO;
import lookid.server.vo.UserVO;

public interface JUserDAO {

	public SuccessDTO modify_pw(String pw) throws Exception;

	public SuccessDTO modify(UserVO user) throws Exception;

}
