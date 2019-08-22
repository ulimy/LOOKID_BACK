package lookid.server.dto;

// 임시비밀번호로 DB 수정 
public class ModifyTempPwDTO {

	private String pw;
	private String mail;

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
		return "ModifyTempPwDTO [pw=" + pw + ", mail=" + mail + "]";
	}

}
