package lookid.server.dto;

import java.util.Date;

// 예약 내역 조회
public class ReservationListDTO {

	private int rv_pid;
	private String r_name;
	private Date s_date;
	private Date e_date;
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

	public Date getS_date() {
		return s_date;
	}

	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}

	public Date getE_date() {
		return e_date;
	}

	public void setE_date(Date e_date) {
		this.e_date = e_date;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "ReservationListDTO [rv_pid=" + rv_pid + ", r_name=" + r_name + ", s_date=" + s_date + ", e_date="
				+ e_date + ", state=" + state + "]";
	}

}
