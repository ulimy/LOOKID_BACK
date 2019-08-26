package lookid.server.dto;

//user_pid를 제외한 DTO
public class UserDTO {

	private String name;
	private String phone;
	private String mail;
	private String address;
	private String bank_name;
	private String bank_num;
	private String bank_holder;

	public UserDTO(String name, String phone, String mail, String address, String bank_name, String bank_num,
			String bank_holder) {
		this.name = name;
		this.phone = phone;
		this.mail = mail;
		this.address = address;
		this.bank_name = bank_name;
		this.bank_num = bank_num;
		this.bank_holder = bank_holder;
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
		return "UserDTO [name=" + name + ", phone=" + phone + ", mail=" + mail + ", address=" + address + ", bank_name="
				+ bank_name + ", bank_num=" + bank_num + ", bank_holder=" + bank_holder + "]";
	}

}
