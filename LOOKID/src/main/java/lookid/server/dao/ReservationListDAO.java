package lookid.server.dao;

import lookid.server.dto.GroupDTO;
import lookid.server.dto.ReservationListDTO;
import lookid.server.dto.RvPidDTO;
import lookid.server.vo.ReservationVO;

public interface ReservationListDAO {
	
	public RvPidDTO today();
	
	public ReservationListDTO[] list(int user_pid) throws Exception;
	
	public ReservationVO reservation_detail(int rv_pid) throws Exception;
	
	public GroupDTO[] group_detail(int rv_pid) throws Exception;
	
	public String admin_detail(int g_pid) throws Exception;
	
	public String child_detail(int g_pid) throws Exception;
}
