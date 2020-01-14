package lookid.server.dto;

import java.util.Arrays;

public class GroupInfoDTO {

	private GroupDTO group;

	private ChildDTO[] child;

	private AdminDTO[] admin;

	public GroupInfoDTO() {
		super();
	}

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
