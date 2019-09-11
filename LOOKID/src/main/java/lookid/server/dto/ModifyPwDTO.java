package lookid.server.dto;

// 비밀번호 변경
public class ModifyPwDTO {

	private int user_pid;
	private String pw;

	public int getUser_pid() {
		return user_pid;
	}

	public void setUser_pid(int user_pid) {
		this.user_pid = user_pid;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "ModifyPwDTO [user_pid=" + user_pid + ", pw=" + pw + "]";
	}

}
