package lookid.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lookid.server.dao.ReservationCancleDAO;
import lookid.server.dao.ReservationCreateDAO;
import lookid.server.dao.ReservationModifyDAO;
import lookid.server.dto.GroupInfoDTO;
import lookid.server.dto.ReservationDetailDTO;
import lookid.server.dto.RvPidDTO;
import lookid.server.dto.SuccessDTO;
import lookid.server.vo.ReservationVO;

@Service("ReservationCMCService")
public class ReservationCMCServiceImpl implements ReservationCMCService {

	@Autowired
	@Qualifier("ReservationCreateDAO")
	ReservationCreateDAO create;

	@Autowired
	@Qualifier("ReservationModifyDAO")
	ReservationModifyDAO modify;

	@Autowired
	@Qualifier("ReservationCancleDAO")
	ReservationCancleDAO cancle;

	private final SuccessDTO success = new SuccessDTO(true);
	private final SuccessDTO fail = new SuccessDTO(false);

	// 예약 하기
	@Override
	public SuccessDTO create(int user_pid, ReservationDetailDTO input) throws Exception {
		try {
			// 예약 정보 뽑아 user_pid와 함께 디비에 넣고 rv_pid 돌려받기
			ReservationVO rvo = input.getReservation();
			rvo.setUser_pid(user_pid);
			int rv_pid = create.reservation_create(rvo);
			// 그룹 개수만큼
			for (GroupInfoDTO group : input.getGroupInfo()) {
				// 그룹 정보 디비에 넣고 g_pid 돌려받기
				int g_pid = create.group_create(rv_pid, group.getGroup());
				// chiㅣd 정보 뽑아 디비에 넣기
				create.child_create(g_pid, group.getChild());
				// admin 정보 뽑아 디비에 넣기
				create.admin_create(g_pid, group.getAdmin());
			}
			return success;
		} catch (Exception e) {
			System.out.println(e);
			return fail;
		}
	}

	// 예약 수정
	@Override
	public SuccessDTO modify(ReservationDetailDTO input) {
		try {
			// 예약 정보 수정
			modify.reservation_modify(input.getReservation());
			// 그룹 개수만큼
			for (GroupInfoDTO group : input.getGroupInfo()) {
				int g_pid = group.getGroup().getG_pid();
				// 그룹 정보 수정
				modify.group_modify(group.getGroup());
				// child 정보 수정
				modify.child_modify(g_pid, group.getChild());
				// admin 정보 수정
				modify.admin_modify(g_pid, group.getAdmin());
			}
			return success;

		} catch (Exception e) {
			return fail;
		}

	}

	@Override
	public SuccessDTO cancle(RvPidDTO input) throws Exception {
		try {
			cancle.reservation_cancle(input.getRv_pid());
			return success;
		} catch (Exception e) {
			return fail;
		}
	}

}
