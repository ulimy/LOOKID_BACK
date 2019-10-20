package lookid.server.dao;

import lookid.server.dto.AdminDTO;
import lookid.server.dto.GroupDTO;
import lookid.server.dto.ReservationListDTO;
import lookid.server.dto.RvPidDTO;
import lookid.server.vo.ReservationVO;

public interface ReservationListDAO {

	public RvPidDTO[] today(int user_pid);

	public ReservationListDTO[] list(int user_pid) throws Exception;

	public ReservationVO reservation_detail(int rv_pid) throws Exception;

	public GroupDTO[] group_detail(int rv_pid) throws Exception;

	public String child_detail(int g_pid) throws Exception;

	public AdminDTO[] admin_detail(int g_pid) throws Exception;

}
