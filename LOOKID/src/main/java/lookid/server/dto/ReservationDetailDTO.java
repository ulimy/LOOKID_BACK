package lookid.server.dto;

import java.util.ArrayList;
import java.util.List;

// 전체 예약 정보 (예약 하기, 예약 조회, 예약 수정 등에 사용)
public class ReservationDetailDTO {

	// 예약 정보
	private ReservationDTO reservation;
	// 그룹 당 피보호자, 관리자 정보¸
	private List<GroupInfoDTO> groupInfo;
	
	public ReservationDetailDTO(){
		this.groupInfo = new ArrayList<GroupInfoDTO>();
	}

	public ReservationDTO getReservation() {
		return reservation;
	}

	public void setReservation(ReservationDTO reservation) {
		this.reservation = reservation;
	}

	public List<GroupInfoDTO> getGroupInfo() {
		return groupInfo;
	}

	public void setGroupInfo(List<GroupInfoDTO> groupInfo) {
		this.groupInfo = groupInfo;
	}
	
	// GroupInfoDTO 중에서 Group정보만 넣어서  add
	public void addGroupInfoDTO(GroupInfoDTO groupinfodto){
		this.groupInfo.add(groupinfodto);
	}

	@Override
	public String toString() {
		return "ReservationDetailDTO [reservation=" + reservation + ", groupInfo=" + groupInfo + "]";
	}

}
