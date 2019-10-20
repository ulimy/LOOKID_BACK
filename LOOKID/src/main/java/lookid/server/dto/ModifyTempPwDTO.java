package lookid.server.dto;

// 비밀번호 찾기 시 임시비밀번호로 DB 수정 
public class ModifyTempPwDTO {

	private String id;
	private String pw;
	private String mail;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "ModifyTempPwDTO [id=" + id + ", pw=" + pw + ", mail=" + mail + "]";
	}

}
