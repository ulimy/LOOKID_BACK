package lookid.server.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lookid.server.dto.FindAdminDTO;
import lookid.server.dto.FindIdDTO;
import lookid.server.dto.FindPwDTO;
import lookid.server.dto.SigninDTO;
import lookid.server.dto.SuccessDTO;
import lookid.server.vo.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private Mapper mapper;

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

	// 관리자 검색
	@Override
	public FindAdminDTO find_admin(String id) throws Exception {
		return null;
	}

}
