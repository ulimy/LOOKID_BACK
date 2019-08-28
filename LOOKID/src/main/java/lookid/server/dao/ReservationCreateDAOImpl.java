package lookid.server.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lookid.server.dto.GroupDTO;
import lookid.server.vo.ReservationVO;

@Repository("ReservationCreateDAO")
public class ReservationCreateDAOImpl implements ReservationCreateDAO {

	@Autowired
	private Mapper mapper;

	@Override
	public int reservation_create(int user_pid, ReservationVO input) throws Exception {
		input.setUser_pid(user_pid);
		mapper.reservation_create(input);
		int rv_pid = input.getRv_pid();
		return rv_pid;
	}

	@Override
	public int group_create(GroupDTO input, int rv_pid) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void child_create(String child, int g_pid) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void admin_create(int admin, int g_pid) throws Exception {
		// TODO Auto-generated method stub

	}

}
