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

	// 예약 하기
	@Override
	public SuccessDTO create(int user_pid, ReservationDetailDTO input) throws Exception {
		try {
			// 예약 정보 추가
			// 예약 정보 뽑아 user_pid와 함께 디비에 넣고 rv_pid 돌려받기
			ReservationVO rvo = input.getReservation();
			rvo.setUser_pid(user_pid);

			// 돌려받은 rv_pid와 함께 그룹 정보 추가
			create_group(dao.reservation_create(rvo), input.getGroup_list());

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
			ReservationVO rvo = input.getReservation();
			int rv_pid = rvo.getRv_pid();

			// 예약 정보 수정
			dao.reservation_modify(rvo);

			// 그룹 개수가 변할 경우를 대비하여 삭제 후 재생성
			dao.group_delete(rv_pid);
			create_group(rv_pid, input.getGroup_list());

			return success;

		} catch (Exception e) {
			System.out.println(e);
			return fail;
		}

	}

	// 예약 외 모든 정보 추가
	@Override
	public void create_group(int rv_pid, List<GroupInfoDTO> group_list) throws Exception {
		// 그룹 개수만큼
		for (GroupInfoDTO group : group_list) {
			// 그룹 정보 디비에 넣고 g_pid 돌려받기
			int g_pid = dao.group_create(rv_pid, group.getGroup());
			// chiㅣd 정보 뽑아 디비에 넣기
			dao.child_create(g_pid, group.getChild());
			// admin 정보 뽑아 디비에 넣기
			dao.admin_create(g_pid, group.getAdmin());
		}
		return;
	}

	// 예약 취소
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
