package lookid.server.dto;

// 비밀번호 찾기
public class FindPwDTO {

	private String id;
	private String mail;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "FindPwDTO [id=" + id + ", mail=" + mail + "]";
	}

}
