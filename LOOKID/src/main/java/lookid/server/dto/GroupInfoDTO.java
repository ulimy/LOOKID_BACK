package lookid.server.dto;

import java.util.Arrays;

public class GroupInfoDTO {

	// 그룹 정보
	private GroupDTO group;
	// child 정보
	private ChildDTO[] child;
	// admin 정보
	private AdminDTO[] admin;

	// 기본 생성자
	public GroupInfoDTO() {
		super();
	}

	// groupdto를 받는 생성자
	public GroupInfoDTO(GroupDTO groupdto) {
		this.group = groupdto;
	}

	public GroupDTO getGroup() {
		return group;
	}

	public void setGroup(GroupDTO group) {
		this.group = group;
	}

	public ChildDTO[] getChild() {
		return child;
	}

	public void setChild(ChildDTO[] child) {
		this.child = child;
	}

	public AdminDTO[] getAdmin() {
		return admin;
	}

	public void setAdmin(AdminDTO[] admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "GroupInfoDTO [group=" + group + ", child=" + Arrays.toString(child) + ", admin="
				+ Arrays.toString(admin) + "]";
	}

}
