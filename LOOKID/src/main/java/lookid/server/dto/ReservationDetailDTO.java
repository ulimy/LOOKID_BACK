package lookid.server.dto;

import java.util.ArrayList;
import java.util.List;

import lookid.server.vo.ReservationVO;

// 전체 예약 정보 (예약 하기, 예약 조회, 예약 수정 등에 사용)
public class ReservationDetailDTO {

	// 예약 정보
	private ReservationVO reservation;
	// 그룹 당 피보호자, 관리자 정보¸
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

	// GroupInfoDTO 중에서 Group정보만 넣어서 add
	public void addGroupInfoDTO(GroupInfoDTO groupinfodto) {
		this.group_list.add(groupinfodto);
	}

	@Override
	public String toString() {
		return "ReservationDetailDTO [reservation=" + reservation + ", group_list=" + group_list + "]";
	}

}
