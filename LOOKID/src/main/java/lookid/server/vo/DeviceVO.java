package lookid.server.vo;

public class DeviceVO {

	private int d_pid;
	private String d_num;

	public DeviceVO(String d_num) {
		this.d_num = d_num;
	}

	public int getD_pid() {
		return d_pid;
	}

	public void setD_pid(int d_pid) {
		this.d_pid = d_pid;
	}

	public String getD_num() {
		return d_num;
	}

	public void setD_num(String d_num) {
		this.d_num = d_num;
	}

	@Override
	public String toString() {
		return "deviceVO [d_pid=" + d_pid + ", d_num=" + d_num + "]";
	}

}
