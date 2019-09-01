package lookid.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lookid.server.dao.ReservationListDAO;
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
		try{
			return list.today(user_pid);
		}catch (Exception e){
			System.out.println(e);
			return null;
		}
	}

	// 예약 내역 조회
	@Override
	public ReservationListDTO[] list(int user_pid) {
		try{
			return list.list(user_pid);
		}catch (Exception e){
			return null;
		}
	}

	// 예약 내역 상세 조회
	@Override
	public ReservationDetailDTO detail(int rv_pid) {
		try{
			ReservationDetailDTO result = new ReservationDetailDTO();
			// 예약 정보 담기
			result.setReservation(list.reservation_detail(rv_pid));
			// 그룹 정보 받아오기
			
			// 그룹 개수 만큼 
			// 그룹 정 보 담고
			// child 정보 담기
			// admin정보 담기
			
			return result;
		}catch (Exception e){
			return null;
		}
	}

}
