package lookid.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lookid.server.dao.JUserDAO;
import lookid.server.dto.ModifyPwDTO;
import lookid.server.dto.SigninDTO;
import lookid.server.dto.SuccessDTO;
import lookid.server.vo.UserVO;

@Service("JUserService")
public class JUserServiceImpl implements JUserService {

	@Autowired
	private JUserDAO jdao;

	private static final SuccessDTO success = new SuccessDTO(true);
	private static final SuccessDTO fail = new SuccessDTO(false);

	@Override
	public UserVO signin(SigninDTO user) throws Exception {
		return jdao.signin(user);
	}

	@Override
	public SuccessDTO modify_pw(ModifyPwDTO user, int user_pid) throws Exception {

		try {
			ModifyPwDTO mpdto = new ModifyPwDTO();
			mpdto.setUser_pid(user_pid);
			mpdto.setPw(user.getPw());

			jdao.modify_pw(mpdto);
			return success;
		} catch (Exception e) {
			return fail;
		}
	}

	@Override
	public SuccessDTO modify(UserVO user, int user_pid) throws Exception {
		try {
			user.setUser_pid(user_pid);
			jdao.modify(user);
			return success;
		} catch (Exception e) {
			return fail;
		}

	}

}
