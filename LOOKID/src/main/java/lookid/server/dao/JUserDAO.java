package lookid.server.dao;

import lookid.server.dto.ModifyPwDTO;
import lookid.server.vo.UserVO;

public interface JUserDAO {

	public void modify_pw(ModifyPwDTO user) throws Exception;

	public void modify(UserVO user) throws Exception;

}
