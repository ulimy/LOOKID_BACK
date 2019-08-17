package lookid.server.dto;

import java.util.Date;

// 예약 내역 조회
public class ReservationListDTO {

	private int rv_pid;
	private String r_name;
	private Date r_date;
	private int state;

	public int getRv_pid() {
		return rv_pid;
	}

	public void setRv_pid(int rv_pid) {
		this.rv_pid = rv_pid;
	}

	public String getR_name() {
		return r_name;
	}

	public void setR_name(String r_name) {
		this.r_name = r_name;
	}

	public Date getR_date() {
		return r_date;
	}

	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "ReservationListDTO [rv_pid=" + rv_pid + ", r_name=" + r_name + ", r_date=" + r_date + ", state=" + state
				+ "]";
	}

}
