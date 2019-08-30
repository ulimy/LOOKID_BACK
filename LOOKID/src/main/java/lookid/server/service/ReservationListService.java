package lookid.server.service;

import lookid.server.dto.ReservationDetailDTO;
import lookid.server.dto.ReservationListDTO;
import lookid.server.dto.RvPidDTO;

public interface ReservationListService {

	public RvPidDTO today();

	public ReservationListDTO[] list();

	public ReservationDetailDTO detail(int rv_pid);

}
