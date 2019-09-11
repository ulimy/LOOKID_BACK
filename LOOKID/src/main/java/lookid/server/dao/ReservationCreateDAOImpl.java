package lookid.server.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lookid.server.dto.AdminDTO;
import lookid.server.dto.GroupDTO;
import lookid.server.vo.GroupVO;
import lookid.server.vo.ReservationVO;

@Repository("ReservationCreateDAO")
public class ReservationCreateDAOImpl implements ReservationCreateDAO {

	@Autowired
	private Mapper mapper;

	// 예약 정보 추가
	@Override
	public int reservation_create(ReservationVO input) throws Exception {
		mapper.reservation_create(input);
		return input.getRv_pid();
	}

	// 그룹 정보 추가
	@Override
	public int group_create(int rv_pid, GroupDTO input) throws Exception {
		GroupVO gv = new GroupVO(rv_pid, input);
		mapper.group_create(gv);
		return gv.getG_pid();
	}

	@Override
	public void child_create(int g_pid, String child) throws Exception {
		// child 정보 , 으로 잘라 배열로 만들어서 g_pid와 함께 mapper로 전달
		mapper.child_create(g_pid,child.split(","));
	}

	@Override
	public void admin_create(int g_pid, AdminDTO[] admin) throws Exception {
		mapper.admin_create(g_pid, admin);
	}

}
