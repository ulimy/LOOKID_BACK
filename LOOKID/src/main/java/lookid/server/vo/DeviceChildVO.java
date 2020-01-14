package lookid.server.vo;

public class DeviceChildVO {

	private int dc_pid;
	private String device;
	private String child;

	public DeviceChildVO(String device, String child) {
		this.device = device;
		this.child = child;
	}

	public int getDc_pid() {
		return dc_pid;
	}

	public void setDc_pid(int dc_pid) {
		this.dc_pid = dc_pid;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getChild() {
		return child;
	}

	public void setChild(String child) {
		this.child = child;
	}

	@Override
	public String toString() {
		return "DeviceChildVO [dc_pid=" + dc_pid + ", device=" + device + ", child=" + child + "]";
	}
	
	
}
