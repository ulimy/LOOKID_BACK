package lookid.server.service;

import java.util.List;

import lookid.server.dto.GroupInfoDTO;
import lookid.server.dto.ReservationDetailDTO;
import lookid.server.dto.RvPidDTO;
import lookid.server.dto.SuccessDTO;

public interface ReservationCMCService {

	// 예약 하기
	public SuccessDTO create(int user_pid, ReservationDetailDTO input) throws Exception;
	
	// 예약 수정
	public SuccessDTO modify(ReservationDetailDTO input) throws Exception;
	
	// 예약 외 모든 정보 추가
	public void create_group(int rv_pid, List<GroupInfoDTO> group_list) throws Exception;

	// 예약 취소
	public SuccessDTO cancle(RvPidDTO input) throws Exception;
	
}