package lookid.server.service;

import lookid.server.dto.ReservationDetailDTO;
import lookid.server.dto.RvPidDTO;

public interface ReservationCMCService {

	public void create(ReservationDetailDTO input) throws Exception;
	
	public void modify(ReservationDetailDTO input) throws Exception;
	
	public void cancle(RvPidDTO input) throws Exception;
	
}