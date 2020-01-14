package lookid.server.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lookid.server.dto.AdminDTO;
import lookid.server.dto.ChildDTO;
import lookid.server.dto.GroupDTO;
import lookid.server.dto.ReservationListDTO;
import lookid.server.dto.RvPidDTO;
import lookid.server.vo.ReservationVO;

@Repository("ReservationListDAO")
public class ReservationListDAOImpl implements ReservationListDAO {

	@Autowired
	private Mapper mapper;

	@Override
	public RvPidDTO[] today(int user_pid) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar time = Calendar.getInstance();
		return mapper.today(user_pid, format.format(time.getTime()));
	}

	@Override
	public ReservationListDTO[] list(int user_pid) throws Exception {
		return mapper.reservation_list(user_pid);
	}

	@Override
	public ReservationVO reservation_detail(int rv_pid) throws Exception {
		return mapper.reservation_detail(rv_pid);
	}

	@Override
	public GroupDTO[] group_detail(int rv_pid) throws Exception {
		return mapper.group_detail(rv_pid);
	}

	@Override
	public ChildDTO[] child_detail(int g_pid) throws Exception {
		return mapper.child_detail(g_pid);
	}

	@Override
	public AdminDTO[] admin_detail(int g_pid) throws Exception {
		return mapper.admin_detail(g_pid);
	}

}
