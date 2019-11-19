package lookid.server.dao;

import lookid.server.dto.AdminDTO;
import lookid.server.dto.ChildDTO;
import lookid.server.dto.GroupDTO;
import lookid.server.vo.ReservationVO;

public interface ReservationCreateDAO {
	
	// 예약 정보 생성
	public int reservation_create(ReservationVO input) throws Exception;
	
	// 그룹 정보 생성
	public int group_create(int rv_pid, GroupDTO input) throws Exception;
	
	// 피보호자 정보 생성
	public void child_create(int g_pid, ChildDTO[] child) throws Exception;
	
	// 관리자 정보 생성
	public void admin_create(int g_pid, AdminDTO[] admin)  throws Exception;
}
