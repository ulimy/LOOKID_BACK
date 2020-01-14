package lookid.server.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lookid.server.dto.AdminDTO;
import lookid.server.dto.ChildDTO;
import lookid.server.dto.GroupDTO;
import lookid.server.vo.GroupVO;
import lookid.server.vo.ReservationVO;

@Repository("ReservationCMCDAO")
public class ReservationCMCDAOImpl implements ReservationCMCDAO {

	@Autowired
	private Mapper mapper;

	@Override
	public int reservation_create(ReservationVO input) throws Exception {
		mapper.reservation_create(input);
		return input.getRv_pid();
	}

	@Override
	public int group_create(int rv_pid, GroupDTO input) throws Exception {
		GroupVO gv = new GroupVO(rv_pid, input);
		mapper.group_create(gv);
		return gv.getG_pid();
	}

	@Override
	public void child_create(int g_pid, ChildDTO[] child) throws Exception {
		mapper.child_create(g_pid, child);
		return;
	}

	@Override
	public void admin_create(int g_pid, AdminDTO[] admin) throws Exception {
		mapper.admin_create(g_pid, admin);
		return;
	}

	@Override
	public void reservation_modify(ReservationVO input) throws Exception {
		mapper.reservation_modify(input);
		return;
	}

	@Override
	public void group_delete(int rv_pid) throws Exception {

		mapper.group_delete(rv_pid);
	}

	@Override
	public void reservation_cancle(int rv_pid) {
		mapper.reservation_delete(rv_pid);
		return;
	}

}
