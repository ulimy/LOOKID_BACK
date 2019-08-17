package lookid.server.vo;

public class AdminVO {

	private int idx;
	private int user_pid;
	private int g_pid;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getUser_pid() {
		return user_pid;
	}

	public void setUser_pid(int user_pid) {
		this.user_pid = user_pid;
	}

	public int getG_pid() {
		return g_pid;
	}

	public void setG_pid(int g_pid) {
		this.g_pid = g_pid;
	}

	@Override
	public String toString() {
		return "adminVO [idx=" + idx + ", user_pid=" + user_pid + ", g_pid=" + g_pid + "]";
	}

}
