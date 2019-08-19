package lookid.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lookid.server.dao.UserDAO;
import lookid.server.dto.FindIdDTO;
import lookid.server.dto.FindPwDTO;
import lookid.server.dto.SigninDTO;
import lookid.server.dto.SuccessDTO;
import lookid.server.vo.UserVO;

@Service("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;

	// 아이디 중복확인
	@Override
	public SuccessDTO checkId(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	// 회원가입
	@Override
	public SuccessDTO signup(UserVO user) throws Exception {

		return null;

	}

	// 로그인
	@Override
	public UserVO signin(SigninDTO user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	// 아이디 찾기
	@Override
	public FindIdDTO find_id(FindIdDTO user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	// 비밀번호 찾기
	@Override
	public SuccessDTO find_pw(FindPwDTO user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
