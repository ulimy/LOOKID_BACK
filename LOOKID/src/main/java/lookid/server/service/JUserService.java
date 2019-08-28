package lookid.server.service;

import javax.servlet.http.HttpServletRequest;

import lookid.server.dto.ModifyPwDTO;
import lookid.server.dto.SuccessDTO;
import lookid.server.vo.UserVO;

public interface JUserService {

	public void signout(HttpServletRequest request) throws Exception;

	public SuccessDTO modify_pw(ModifyPwDTO user, HttpServletRequest request) throws Exception;

	public SuccessDTO modify(UserVO user, HttpServletRequest request) throws Exception;

}
