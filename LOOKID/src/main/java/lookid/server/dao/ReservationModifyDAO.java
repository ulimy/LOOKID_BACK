package lookid.server.dao;

import lookid.server.dto.GroupDTO;
import lookid.server.dto.ReservationDTO;

public interface ReservationModifyDAO {

	public void reservation_modify(ReservationDTO input);

	public void group_modify(GroupDTO input);
	
	public void child_modify(int g_pid, String child);
	
	public void admin_modify(int g_pid, String admin);
}
