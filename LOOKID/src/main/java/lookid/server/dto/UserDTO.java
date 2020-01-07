package lookid.server.dto;

import lookid.server.vo.UserVO;

public class UserDTO {

	private String name;
	private String phone;
	private String mail;
	private String address;
	private String address_detail;
	private String bank_name;
	private String bank_num;
	private String bank_holder;

	public UserDTO(UserVO vo) {
		this.name = vo.getName();
		this.phone = vo.getPhone();
		this.mail = vo.getMail();
		this.address = vo.getAddress();
		this.address_detail = vo.getAddress_detail();
		this.bank_name = vo.getBank_name();
		this.bank_num = vo.getBank_num();
		this.bank_holder = vo.getBank_holder();
	}

	public UserDTO(NullPointerException e) {

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

	public String getAddress_detail() {
		return address_detail;
	}

	public void setAddress_detail(String address_detail) {
		this.address_detail = address_detail;
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
		return "UserDTO [name=" + name + ", phone=" + phone + ", mail=" + mail + ", address=" + address
				+ ", address_detail=" + address_detail + ", bank_name=" + bank_name + ", bank_num=" + bank_num
				+ ", bank_holder=" + bank_holder + "]";
	}

}