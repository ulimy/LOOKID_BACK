package lookid.server.dao;

import lookid.server.dto.AdminDTO;
import lookid.server.dto.FindIdDTO;
import lookid.server.dto.ModifyTempPwDTO;
import lookid.server.vo.UserVO;

public interface UserDAO {

   public Integer checkId(String id) throws Exception;

   public void signup(UserVO user) throws Exception;

   public FindIdDTO find_id(String name, String phone) throws Exception;

   public String find_pw(String id, String mail) throws Exception;
   
   public void modify_temp_pw(ModifyTempPwDTO user) throws Exception;
   
   public AdminDTO find_admin(String id) throws Exception;   
   
   public int count() throws Exception;
   
}