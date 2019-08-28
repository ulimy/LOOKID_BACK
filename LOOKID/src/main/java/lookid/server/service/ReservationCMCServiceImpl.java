package lookid.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lookid.server.dao.ReservationCreateDAO;
import lookid.server.dto.GroupInfoDTO;
import lookid.server.dto.ReservationDetailDTO;
import lookid.server.dto.RvPidDTO;
import lookid.server.dto.SuccessDTO;

@Service("ReservationCMCService")
public class ReservationCMCServiceImpl implements ReservationCMCService {
	
	@Autowired
	@Qualifier("ReservationCreateDAO")
	ReservationCreateDAO create;

	private final SuccessDTO success = new SuccessDTO(true);
	private final SuccessDTO fail = new SuccessDTO(false);

	// 예약 하기
	@Override
	public SuccessDTO create(int user_pid, ReservationDetailDTO input) throws Exception {
		try {
			// 예약 정보 뽑아 디비에 넣고 rv_pid 돌려받기
			int rv_pid = create.reservation_create(user_pid,input.getReservation());
			System.out.println(rv_pid);

			// 그룹 개수만큼
			for (GroupInfoDTO group : input.getGroupInfo()) {
				// 그룹 정보에 rv_pid 정보 넣기
				// group.getGroup().setRv_pid(rv_pid);
				// 그룹 정보 디비에 넣기
				
			}

			// 그룹 정보 뽑아 디비에 넣고 g_pid 돌려받기

			// child 정보 뽑아 디비에 넣기

			// admin 정보 뽑아 디비에 넣기

			
			
			return success;
		} catch (Exception e) {
			System.out.println(e);
			return fail;
		}
	}

	@Override
	public void modify(ReservationDetailDTO input) throws Exception {
		
	}

	@Override
	public void cancle(RvPidDTO input) throws Exception {

	}

}
