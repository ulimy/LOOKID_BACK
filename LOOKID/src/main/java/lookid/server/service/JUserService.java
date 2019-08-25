package lookid.server.service;

import javax.servlet.http.HttpServletRequest;

import lookid.server.dto.SuccessDTO;
import lookid.server.vo.UserVO;

public interface JUserService {

	public void signout(HttpServletRequest request) throws Exception;

	public SuccessDTO modify_pw(String pw) throws Exception;

	public SuccessDTO modify(UserVO user) throws Exception;

}
