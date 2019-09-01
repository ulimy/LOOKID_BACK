package lookid.server.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lookid.server.dto.GroupDTO;
import lookid.server.dto.ReservationDTO;
import lookid.server.dto.ReservationListDTO;
import lookid.server.dto.RvPidDTO;

@Repository("ReservationListDAO")
public class ReservationListDAOImpl implements ReservationListDAO {
	
	@Autowired
	private Mapper mapper;
	
	// 예약 당일 여부 확인
	@Override
	public RvPidDTO[] today(int user_pid) {
		// 오늘 날짜 계산
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar time = Calendar.getInstance();       
		return mapper.today(user_pid, format.format(time.getTime()));
	}
	
	// 예약 내역 조회
	@Override
	public ReservationListDTO[] list(int user_pid) throws Exception {
		return mapper.reservation_list(user_pid);
	}

	@Override
	public ReservationDTO reservation_detail(int rv_pid) throws Exception {
		return mapper.reservation_detail(rv_pid);
	}

	@Override
	public GroupDTO[] group_detail(int rv_pid) throws Exception {
		return mapper.group_detail(rv_pid);
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
