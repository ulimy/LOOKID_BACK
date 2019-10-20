package lookid.server.service;

import lookid.server.dto.ReservationDetailDTO;
import lookid.server.dto.RvPidDTO;
import lookid.server.dto.SuccessDTO;

public interface ReservationCMCService {

	// 예약 하기
	public SuccessDTO create(int user_pid, ReservationDetailDTO input) throws Exception;
	
	// 예약 수정
	public SuccessDTO modify(ReservationDetailDTO input) throws Exception;

	// 예약 취소
	public SuccessDTO cancle(RvPidDTO input) throws Exception;
	
}