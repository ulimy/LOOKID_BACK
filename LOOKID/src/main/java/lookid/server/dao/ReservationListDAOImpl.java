package lookid.server.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lookid.server.dto.GroupDTO;
import lookid.server.dto.ReservationListDTO;
import lookid.server.dto.RvPidDTO;
import lookid.server.vo.ReservationVO;

@Repository("ReservationListDAO")
public class ReservationListDAOImpl implements ReservationListDAO {
	
	@Autowired
	private Mapper mapper;

	@Override
	public RvPidDTO today() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// 예약 내역 조회
	@Override
	public ReservationListDTO[] list(int user_pid) throws Exception {
		return mapper.reservation_list(user_pid);
	}

	@Override
	public ReservationVO reservation_detail(int rv_pid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupDTO[] group_detail(int rv_pid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String admin_detail(int g_pid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String child_detail(int g_pid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
