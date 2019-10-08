package lookid.server.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lookid.server.dto.ModifyPwDTO;
import lookid.server.dto.SigninDTO;
import lookid.server.vo.UserVO;

@Repository
public class JUserDAOImpl implements JUserDAO {

   @Autowired
   private Mapper mapper;

   // 로그인
   @Override
   public UserVO signin(SigninDTO user) throws Exception {
      return mapper.signin(user.getId(), user.getPw());
   }

   // 비밀번호 변경
   @Override
   public void modify_pw(ModifyPwDTO user) throws Exception {
      mapper.modify_pw(user.getUser_pid(), user.getPw());
      return;
   }

   // 내 정보 수정
   @Override
   public void modify(UserVO user) throws Exception {
      mapper.modify(user.getUser_pid(), user.getName(), user.getPhone(), user.getMail(), user.getAddress(),
            user.getAddress_detail(), user.getBank_name(), user.getBank_num(), user.getBank_holder());
      return;
   }
}