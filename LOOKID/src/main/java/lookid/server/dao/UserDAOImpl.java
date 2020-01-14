package lookid.server.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lookid.server.dto.AdminDTO;
import lookid.server.dto.FindIdDTO;
import lookid.server.dto.ModifyTempPwDTO;
import lookid.server.vo.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {

   @Autowired
   private Mapper mapper;

   // 아이디 중복확인
   @Override
   public Integer checkId(String id) throws Exception {
      return mapper.checkId(id);
   }

   // 회원가입
   @Override
   public void signup(UserVO user) throws Exception {

      mapper.signup(user);
      return;

   }

   // 아이디 찾기
   @Override
   public FindIdDTO find_id(String name, String phone) throws Exception {
      return mapper.find_id(name, phone);
   }

   // 비밀번호 찾기
   @Override
   public String find_pw(String id, String mail) throws Exception {
      return mapper.find_pw(id, mail);
   }

   // 임시 비밀번호 수정
   @Override
   public void modify_temp_pw(ModifyTempPwDTO user) throws Exception {
      mapper.modify_temp_pw(user);
      return;
   }

   // 관리자 검색
   @Override
   public AdminDTO find_admin(String id) throws Exception {
      return mapper.find_admin(id);
   }

   // 튜플 카운트
   @Override
   public int count() throws Exception {
      return mapper.count();
   }

}