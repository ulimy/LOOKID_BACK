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
			System.out.println(e);
			return null;
		}
	}

	// 예약 내역 조회
	@Override
	public ReservationListDTO[] list(int user_pid) {
		try {
			return list.list(user_pid);
		} catch (Exception e) {
			return null;
		}
	}

	// 예약 내역 상세 조회
	@Override
	public ReservationDetailDTO detail(int rv_pid) {
		try {
			// 전체 결과를 담을 ReservationDetailDTO
			ReservationDetailDTO result = new ReservationDetailDTO();
			// 예약 정보 담기
			result.setReservation(list.reservation_detail(rv_pid));
			// 그룹 개수 만큼
			for (GroupDTO gd : list.group_detail(rv_pid)) {
				// 그룹 정보를 담을 GroupInfoDTO에 그룹 정보 담기
				GroupInfoDTO gid = new GroupInfoDTO(gd);
				//child, admin 정보를 가져오기 위한 g_pid
				int g_pid = gd.getG_pid();
				// child 정보 담기
				gid.setChild(list.child_detail(g_pid));
				// admin정보 담기
				
				//GroupInfoDTO를 result에 추가
				result.addGroupInfoDTO(gid);
			}
			return result;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
