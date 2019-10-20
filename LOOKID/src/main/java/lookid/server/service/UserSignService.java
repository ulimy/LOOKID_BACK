package lookid.server.service;

import lookid.server.dto.SigninDTO;
import lookid.server.dto.SuccessDTO;
import lookid.server.vo.UserVO;

public interface UserSignService {

	public SuccessDTO checkId(String id);

	public SuccessDTO signup(UserVO user);

	public UserVO signin(SigninDTO user);

	public void signout();

}
