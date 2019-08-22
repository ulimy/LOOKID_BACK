package lookid.server.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lookid.server.dto.UserDTO;

@Repository
public class JUserDAOImpl implements JUserDAO {

	@Autowired
	private Mapper mapper;

	// 비밀번호 변경
	@Override
	public void modify_pw(String pw) throws Exception {

	}

	// 내 정보 수정
	@Override
	public void modify(UserDTO user) throws Exception {
		mapper.modify(user.getId(), user.getPw(), user.getName(), user.getPhone(), user.getMail(), user.getAddress(), user.getBank_name(), user.getBank_num(), user.getBank_holder());
	}
}
