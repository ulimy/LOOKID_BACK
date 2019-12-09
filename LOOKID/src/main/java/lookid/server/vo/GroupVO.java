package lookid.server.vo;

import lookid.server.dto.GroupDTO;

public class GroupVO {

	private int g_pid;
	private int rv_pid;
	private String g_name;
	
	public GroupVO(int rv_pid, GroupDTO dto){
		this.rv_pid = rv_pid;
		this.g_name = dto.getG_name();
	}

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


	@Override
	public String toString() {
		return "GroupVO [g_pid=" + g_pid + ", rv_pid=" + rv_pid + ", g_name=" + g_name + "]";
	}

}
