package lookid.server.dto;

public class UserPageDTO {

	private int user_pid;
	private String id;
	private String name;
	private String phone;
	private String mail;
	private String address;
	private String address_detail;
	private String bank_name;
	private String bank_num;
	private String bank_holder;

	public int getUser_pid() {
		return user_pid;
	}

	public void setUser_pid(int user_pid) {
		this.user_pid = user_pid;
	}

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
		return "user_pid=" + user_pid + "<br/>" + "id=" + id + "<br/>" + "name=" + name + "<br/>" + "phone=" + phone
				+ "<br/>" + "mail=" + mail + "<br/>" + "address=" + address + "<br/>" + "address_detail="
				+ address_detail + "<br/>" + "bank_name=" + bank_name + "<br/>" + "bank_num=" + bank_num + "<br/>"
				+ "bank_holder=" + bank_holder + "<br/>";
	}

}
