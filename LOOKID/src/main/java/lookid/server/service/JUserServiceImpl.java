package lookid.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lookid.server.dao.JUserDAO;
import lookid.server.dto.SuccessDTO;
import lookid.server.vo.UserVO;

@Service("JUserService")
public class JUserServiceImpl implements JUserService {

	@Autowired
	private JUserDAO jdao;

	private final SuccessDTO success = new SuccessDTO(true);
	private final SuccessDTO fail = new SuccessDTO(false);

	// 로그아웃
	@Override
	public void signout() throws Exception {
		// destroy 메소드를 통해 토큰 삭제

	}

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
