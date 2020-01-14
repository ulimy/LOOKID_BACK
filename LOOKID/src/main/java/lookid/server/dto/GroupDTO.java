package lookid.server.dto;

public class GroupDTO {

	private int g_pid;
	private String g_name;

	public int getG_pid() {
		return g_pid;
	}

	public void setG_pid(int g_pid) {
		this.g_pid = g_pid;
	}

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

	@Override
	public String toString() {
		return "GroupDTO [g_pid=" + g_pid + ", g_name=" + g_name + "]";
	}

}
