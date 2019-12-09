package lookid.server.dto;

import java.util.ArrayList;
import java.util.List;

import lookid.server.vo.ReservationVO;

public class ReservationDetailDTO {

	private ReservationVO reservation;

	private List<GroupInfoDTO> group_list;

	public ReservationDetailDTO() {
		this.group_list = new ArrayList<GroupInfoDTO>();
	}

	public ReservationVO getReservation() {
		return reservation;
	}

	public void setReservation(ReservationVO reservation) {
		this.reservation = reservation;
	}

	public List<GroupInfoDTO> getGroupInfo() {
		return group_list;
	}

	public void setGroupInfo(List<GroupInfoDTO> groupInfo) {
		this.group_list = groupInfo;
	}

	public void addGroupInfoDTO(GroupInfoDTO groupinfodto) {
		this.group_list.add(groupinfodto);
	}

	@Override
	public String toString() {
		return "ReservationDetailDTO [reservation=" + reservation + ", group_list=" + group_list + "]";
	}

}
