package lookid.server.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lookid.server.dao.UserDAO;
import lookid.server.dto.FindAdminDTO;
import lookid.server.dto.FindIdDTO;
import lookid.server.dto.FindPwDTO;
import lookid.server.dto.SigninDTO;
import lookid.server.dto.SuccessDTO;
import lookid.server.vo.UserVO;

@Service("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;

	private final SuccessDTO success = new SuccessDTO(true);
	private final SuccessDTO fail = new SuccessDTO(false);

	// 아이디 중복확인
	@Override
	public SuccessDTO checkId(String id) throws Exception {
		try {
			if (dao.checkId(id) != 0) {
				return success;
			} else {
				return null;
			}
		} catch (Exception e) {
			return fail;
		}

	}

	// 회원가입
	@Override
	public SuccessDTO signup(UserVO user) throws Exception {

		// phone이 중복되어 insert 안 됐을 시 fail 리턴 예외처리
		int beforeInsert,afterInsert;
		
		try {
			beforeInsert = count();
			dao.signup(user);
			afterInsert = count();
			
			if(beforeInsert == afterInsert) { //phone 중복으로 튜플이 늘어나지 않았을 때 fail을 리턴
				return fail;
			}
			else { // phone이 중복되지 않아 정상적으로 회원가입 완료
				return success;
			}
					
		} catch (Exception e) {
			return fail;
		}

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

		return dao.find_id(user);
	}

	// 비밀번호 찾기
	@Override
	public SuccessDTO find_pw(FindPwDTO user) throws Exception {
		return null;
	}

	// 관리자 검색
	@Override
	public FindAdminDTO find_admin(String id) throws Exception {
		return dao.find_admin(id);
	}
	
	//튜플 카운트
	@Override
	public int count() throws Exception{
		return dao.count();
	}
}
