package lookid.server.service;

import org.springframework.stereotype.Service;

import lookid.server.dto.SigninDTO;
import lookid.server.dto.SuccessDTO;
import lookid.server.vo.UserVO;

@Service("UserSignService")
public class UserSignServiceImpl implements UserSignService {

	@Override
	public SuccessDTO checkId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SuccessDTO signup(UserVO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO signin(SigninDTO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void signout() {
		// TODO Auto-generated method stub

	}

}
