package lookid.server.dao;

import lookid.server.dto.AdminDTO;
import lookid.server.dto.ChildDTO;
import lookid.server.dto.GroupDTO;
import lookid.server.vo.ReservationVO;

public interface ReservationCMCDAO {

	public int reservation_create(ReservationVO input) throws Exception;

	public int group_create(int rv_pid, GroupDTO input) throws Exception;

	public void child_create(int g_pid, ChildDTO[] child) throws Exception;

	public void admin_create(int g_pid, AdminDTO[] admin) throws Exception;

	public void reservation_modify(ReservationVO inpuFt) throws Exception;

	public void group_delete(int rv_pid) throws Exception;

	public void reservation_cancle(int rv_pid) throws Exception;
}
