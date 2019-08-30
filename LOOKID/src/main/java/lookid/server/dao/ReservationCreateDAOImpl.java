package lookid.server.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lookid.server.dto.GroupDTO;
import lookid.server.vo.GroupVO;
import lookid.server.vo.ReservationVO;

@Repository("ReservationCreateDAO")
public class ReservationCreateDAOImpl implements ReservationCreateDAO {

	@Autowired
	private Mapper mapper;

	// 예약 정보 추가
	@Override
	public int reservation_create(int user_pid, ReservationVO input) throws Exception {
		input.setUser_pid(user_pid);
		mapper.reservation_create(input);
		return input.getRv_pid();
	}

	// 그룹 정보 추가
	@Override
	public int group_create(int rv_pid, GroupDTO input) throws Exception {
		GroupVO gv = new GroupVO(rv_pid,input);
		mapper.group_create(gv);
		return gv.getG_pid();
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
