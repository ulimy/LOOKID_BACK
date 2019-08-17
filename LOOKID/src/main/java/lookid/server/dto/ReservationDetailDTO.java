package lookid.server.dto;

import java.util.Arrays;

// 전체 예약 정보 (예약 하기, 예약 조회, 예약 수정 등에 사용)
public class ReservationDetailDTO {

	// 예약 정보
	private ReservationDTO reservation;
	// 그룹 개수
	private int groupCount;
	// 그룹 당 피보호자, 관리자 정보¸
	private GroupInfoDTO[] groupInfo;

	public ReservationDTO getReservation() {
		return reservation;
	}

	public void setReservation(ReservationDTO reservation) {
		this.reservation = reservation;
	}

	public int getGroupCount() {
		return groupCount;
	}

	public void setGroupCount(int groupCount) {
		this.groupCount = groupCount;
	}

	public GroupInfoDTO[] getGroupInfo() {
		return groupInfo;
	}

	public void setGroupInfo(GroupInfoDTO[] groupInfo) {
		this.groupInfo = groupInfo;
	}

	@Override
	public String toString() {
		return "ReservationDetailDTO [reservation=" + reservation + ", groupCount=" + groupCount + ", groupInfo="
				+ Arrays.toString(groupInfo) + "]";
	}

}
