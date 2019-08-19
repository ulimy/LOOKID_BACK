package lookid.server.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lookid.server.dto.SuccessDTO;
import lookid.server.vo.UserVO;

@Repository
public class JUserDAOImpl implements JUserDAO{

	@Autowired
	private Mapper mapper;

	// 비밀번호 변경
	@Override
	public SuccessDTO modify_pw(String pw) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	// 내 정보 수정
	@Override
	public SuccessDTO modify(UserVO user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
