package lookid.server.vo;

public class ChildVO {

	private int childpid;
	private int g_pid;
	private int d_pid;
	private String c_name;

	public int getChildpid() {
		return childpid;
	}

	public void setChildpid(int childpid) {
		this.childpid = childpid;
	}

	public int getG_pid() {
		return g_pid;
	}

	public void setG_pid(int g_pid) {
		this.g_pid = g_pid;
	}

	public int getD_pid() {
		return d_pid;
	}

	public void setD_pid(int d_pid) {
		this.d_pid = d_pid;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	@Override
	public String toString() {
		return "ChildVO [childpid=" + childpid + ", g_pid=" + g_pid + ", d_pid=" + d_pid + ", c_name=" + c_name + "]";
	}

}
