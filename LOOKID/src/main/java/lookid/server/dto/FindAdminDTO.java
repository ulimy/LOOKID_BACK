package lookid.server.dto;

// 관리자 추가할때 이름으로 관리자 검색
public class FindAdminDTO {

	private String id;
	private String name;
	private int user_pid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUser_pid() {
		return user_pid;
	}

	public void setUser_pid(int user_pid) {
		this.user_pid = user_pid;
	}

	@Override
	public String toString() {
		return "FindAdminDTO [id=" + id + ", name=" + name + ", user_pid=" + user_pid + "]";
	}

}