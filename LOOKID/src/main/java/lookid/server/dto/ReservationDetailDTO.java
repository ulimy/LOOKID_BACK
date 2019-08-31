package lookid.server.dto;

import java.util.Arrays;

import lookid.server.vo.ReservationVO;

// 전체 예약 정보 (예약 하기, 예약 조회, 예약 수정 등에 사용)
public class ReservationDetailDTO {

	// 예약 정보
	private ReservationDTO reservation;
	// 그룹 당 피보호자, 관리자 정보¸
	private GroupInfoDTO[] groupInfo;

	public ReservationDTO getReservation() {
		return reservation;
	}

	public void setReservation(ReservationDTO reservation) {
		this.reservation = reservation;
	}

	public GroupInfoDTO[] getGroupInfo() {
		return groupInfo;
	}

	public void setGroupInfo(GroupInfoDTO[] groupInfo) {
		this.groupInfo = groupInfo;
	}

	@Override
	public String toString() {
		return "ReservationDetailDTO [reservation=" + reservation + ", groupInfo="
				+ Arrays.toString(groupInfo) + "]";
	}

}
