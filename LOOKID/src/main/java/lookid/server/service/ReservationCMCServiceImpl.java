package lookid.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lookid.server.dao.ReservationCMCDAO;
import lookid.server.dto.GroupInfoDTO;
import lookid.server.dto.ReservationDetailDTO;
import lookid.server.dto.RvPidDTO;
import lookid.server.dto.SuccessDTO;
import lookid.server.vo.ReservationVO;

@Service("ReservationCMCService")
public class ReservationCMCServiceImpl implements ReservationCMCService {

	@Autowired
	@Qualifier("ReservationCMCDAO")
	ReservationCMCDAO dao;

	private final SuccessDTO success = new SuccessDTO(true);
	private final SuccessDTO fail = new SuccessDTO(false);

	@Override
	public SuccessDTO create(int user_pid, ReservationDetailDTO input) throws Exception {
		try {

			ReservationVO rvo = input.getReservation();
			rvo.setUser_pid(user_pid);


			// 돌려받은 rv_pid와 함께 그룹 정보 추가
			create_group(dao.reservation_create(rvo), input.getGroup_list());
			return success;
		} catch (Exception e) {
			return fail;
		}
	}

	@Override
	public SuccessDTO modify(ReservationDetailDTO input) {
		try {
			ReservationVO rvo = input.getReservation();
			int rv_pid = rvo.getRv_pid();

			dao.reservation_modify(rvo);

			dao.group_delete(rv_pid);
			create_group(rv_pid, input.getGroup_list());

			return success;

		} catch (Exception e) {
			return fail;
		}

	}

	@Override
	public void create_group(int rv_pid, List<GroupInfoDTO> group_list) throws Exception {

		for (GroupInfoDTO group : group_list) {

			int g_pid = dao.group_create(rv_pid, group.getGroup());

			dao.child_create(g_pid, group.getChild());

			dao.admin_create(g_pid, group.getAdmin());
		}
		return;
	}

	@Override
	public SuccessDTO cancle(RvPidDTO input) throws Exception {
		try {
			dao.reservation_cancle(input.getRv_pid());
			return success;
		} catch (Exception e) {
			return fail;
		}
	}

}
