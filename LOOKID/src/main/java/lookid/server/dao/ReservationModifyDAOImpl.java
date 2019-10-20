package lookid.server.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lookid.server.dto.AdminDTO;
import lookid.server.dto.GroupDTO;
import lookid.server.vo.ReservationVO;

@Repository("ReservationModifyDAO")
public class ReservationModifyDAOImpl implements ReservationModifyDAO {
	
	@Autowired
	private Mapper mapper;

	@Override
	public void reservation_modify(ReservationVO input) {
		mapper.reservation_modify(input);
		return;
	}

	@Override
	public void group_modify(GroupDTO input) {
		mapper.group_modify(input);
		return;
	}

	@Override
	public void child_modify(int g_pid, String child) {
		mapper.child_delete(g_pid);
		mapper.child_create(g_pid, child.split(","));
		return;
	}

	@Override
	public void admin_modify(int g_pid, AdminDTO[] admin) {
		mapper.admin_delete(g_pid);
		mapper.admin_create(g_pid, admin);
		return;
	}

}
