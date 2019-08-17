package lookid.server.vo;

public class UserVO {

	private String id;
	private String pw;
	private String name;
	private String phone;
	private String mail;
	private String address;
	private String bank_name;
	private String bank_num;
	private String bank_holder;

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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getBank_num() {
		return bank_num;
	}

	public void setBank_num(String bank_num) {
		this.bank_num = bank_num;
	}

	public String getBank_holder() {
		return bank_holder;
	}

	public void setBank_holder(String bank_holder) {
		this.bank_holder = bank_holder;
	}

	@Override
	public String toString() {
		return "LookidDTO [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", mail=" + mail
				+ ", address=" + address + ", bank_name=" + bank_name + ", bank_num=" + bank_num + ", bank_holder="
				+ bank_holder + "]";
	}

}
