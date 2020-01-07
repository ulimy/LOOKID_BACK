package lookid.server.service;

import java.util.List;

import lookid.server.dto.GroupInfoDTO;
import lookid.server.dto.ReservationDetailDTO;
import lookid.server.dto.RvPidDTO;
import lookid.server.dto.SuccessDTO;

public interface ReservationCMCService {

	public SuccessDTO create(int user_pid, ReservationDetailDTO input) throws Exception;

	public SuccessDTO modify(ReservationDetailDTO input) throws Exception;

	public void create_group(int rv_pid, List<GroupInfoDTO> group_list) throws Exception;

	public SuccessDTO cancle(RvPidDTO input) throws Exception;

}