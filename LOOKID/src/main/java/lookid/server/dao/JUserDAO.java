package lookid.server.dao;

import lookid.server.dto.ModifyPwDTO;
import lookid.server.dto.SigninDTO;
import lookid.server.vo.UserVO;

public interface JUserDAO {

   public UserVO signin(SigninDTO user) throws Exception;
   
   public void modify_pw(ModifyPwDTO user) throws Exception;

   public void modify(UserVO user) throws Exception;

}