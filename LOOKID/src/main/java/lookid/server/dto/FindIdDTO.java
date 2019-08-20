package lookid.server.dto;

// 아이디 찾기
public class FindIdDTO {

	private String name;
	private String phone;
	private String id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "FindIdDTO [name=" + name + ", phone=" + phone + ", id=" + id + "]";
	}

}
