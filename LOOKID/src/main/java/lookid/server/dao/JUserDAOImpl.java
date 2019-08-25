package lookid.server.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lookid.server.dto.ModifyPwDTO;
import lookid.server.vo.UserVO;

@Repository
public class JUserDAOImpl implements JUserDAO {

	@Autowired
	private Mapper mapper;

	// 비밀번호 변경
	@Override
	public void modify_pw(ModifyPwDTO user) throws Exception {
		
		mapper.modify_pw(user.getUser_pid(),user.getPw());
		
		return ;
	}

	// 내 정보 수정
	@Override
	public void modify(UserVO user) throws Exception {
		mapper.modify(user.getUser_pid(), user.getPw(), user.getName(), user.getPhone(), user.getMail(), user.getAddress(), user.getBank_name(), user.getBank_num(), user.getBank_holder());
		return ;
	}
}
