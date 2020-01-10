package lookid.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lookid.server.dao.ReservationListDAO;
import lookid.server.dto.GroupDTO;
import lookid.server.dto.GroupInfoDTO;
import lookid.server.dto.ReservationDetailDTO;
import lookid.server.dto.ReservationListDTO;
import lookid.server.dto.RvPidDTO;

@Service("ReservationListService")
public class ReservationListServiceImpl implements ReservationListService {

	@Autowired
	@Qualifier("ReservationListDAO")
	ReservationListDAO list;

	@Override
	public RvPidDTO[] today(int user_pid) {
		try {
			return list.today(user_pid);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public ReservationListDTO[] list(int user_pid) {
		try {
			return list.list(user_pid);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public ReservationDetailDTO detail(int rv_pid) {
		try {

			ReservationDetailDTO result = new ReservationDetailDTO();

			result.setReservation(list.reservation_detail(rv_pid));

			for (GroupDTO gd : list.group_detail(rv_pid)) {

				GroupInfoDTO gid = new GroupInfoDTO(gd);

				int g_pid = gd.getG_pid();

				gid.setChild(list.child_detail(g_pid));

				gid.setAdmin(list.admin_detail(g_pid));

				result.addGroupInfoDTO(gid);
			}
			return result;
		} catch (Exception e) {
			return null;
		}
	}

}
