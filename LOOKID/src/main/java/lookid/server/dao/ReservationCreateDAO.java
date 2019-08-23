package lookid.server.dao;

import lookid.server.dto.GroupDTO;
import lookid.server.dto.ReservationDTO;

public interface ReservationCreateDAO {
	
	public int reservation_create(ReservationDTO input) throws Exception;
	
	public int group_create(GroupDTO input,int rv_pid) throws Exception;
	
	public void child_create(String child,int g_pid) throws Exception;
	
	public void admin_create(int admin,int g_pid)  throws Exception;
}
