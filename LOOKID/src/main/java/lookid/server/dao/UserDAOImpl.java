package lookid.server.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lookid.server.dto.AdminDTO;
import lookid.server.dto.FindIdDTO;
import lookid.server.dto.FindPwDTO;
import lookid.server.dto.ModifyTempPwDTO;
import lookid.server.vo.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private Mapper mapper;

	@Override
	public Integer checkId(String id) throws Exception {
		return mapper.checkId(id);
	}

	@Override
	public void signup(UserVO user) throws Exception {

		mapper.signup(user.getId(), user.getPw(), user.getName(), user.getPhone(), user.getMail(), user.getAddress(),
				user.getAddress_detail(), user.getBank_name(), user.getBank_num(), user.getBank_holder());
		return;

	}

	@Override
	public FindIdDTO find_id(FindIdDTO user) throws Exception {
		return mapper.find_id(user.getName(), user.getPhone());
	}

	@Override
	public String find_pw(FindPwDTO user) throws Exception {
		return mapper.find_pw(user.getId(), user.getMail());
	}

	@Override
	public void modify_temp_pw(ModifyTempPwDTO user) throws Exception {
		mapper.modify_temp_pw(user.getId(), user.getPw(), user.getMail());
		return;
	}

	@Override
	public AdminDTO find_admin(String id) throws Exception {
		return mapper.find_admin(id);
	}

	@Override
	public int count() throws Exception {
		return mapper.count();
	}

}