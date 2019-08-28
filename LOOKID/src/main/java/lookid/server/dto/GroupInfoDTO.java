package lookid.server.dto;

public class GroupInfoDTO {

	// 그룹 정보
	private GroupDTO group;
	// child_pid 가 , 로 구분되어 string 으로
	private String child;
	// admin (user_pid) 가 , 로 구분되어 string으로
	private String admin;

	public GroupDTO getGroup() {
		return group;
	}

	public void setGroup(GroupDTO group) {
		this.group = group;
	}

	public String getChild() {
		return child;
	}

	public void setChild(String child) {
		this.child = child;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "GroupInfoDTO [group=" + group + ", child=" + child + ", admin=" + admin + "]";
	}

}
