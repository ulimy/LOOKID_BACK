package lookid.server.vo;

public class GroupVO {

	private int g_pid;
	private int rv_pid;
	private String g_name;
	private int count;

	public int getG_pid() {
		return g_pid;
	}

	public void setG_pid(int g_pid) {
		this.g_pid = g_pid;
	}

	public int getRv_pid() {
		return rv_pid;
	}

	public void setRv_pid(int rv_pid) {
		this.rv_pid = rv_pid;
	}

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "GroupVO [g_pid=" + g_pid + ", rv_pid=" + rv_pid + ", g_name=" + g_name + ", count=" + count + "]";
	}

}
