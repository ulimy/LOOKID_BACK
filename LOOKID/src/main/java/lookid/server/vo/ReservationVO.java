package lookid.server.vo;

import java.util.Date;

public class ReservationVO {

	private int rv_pid;
	private int user_pid;
	private String r_name;
	private Date r_date;
	private Date s_date;
	private Date e_date;
	private String name;
	private String phone;
	private String bank_name;
	private String bank_num;
	private String bank_holder;
	private int receipt_item;
	private int return_item;
	private String address;
	private String address_detail;
	private String wb_num;
	private int cost;
	private int deposit;
	private int state;

	public ReservationVO() {
		super();
	}

	public int getRv_pid() {
		return rv_pid;
	}

	public void setRv_pid(int rv_pid) {
		this.rv_pid = rv_pid;
	}

	public int getUser_pid() {
		return user_pid;
	}

	public void setUser_pid(int user_pid) {
		this.user_pid = user_pid;
	}

	public String getR_name() {
		return r_name;
	}

	public void setR_name(String r_name) {
		this.r_name = r_name;
	}

	public Date getR_date() {
		return r_date;
	}

	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}

	public Date getS_date() {
		return s_date;
	}

	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}

	public Date getE_date() {
		return e_date;
	}

	public void setE_date(Date e_date) {
		this.e_date = e_date;
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

	public int getReceipt_item() {
		return receipt_item;
	}

	public void setReceipt_item(int receipt_item) {
		this.receipt_item = receipt_item;
	}

	public int getReturn_item() {
		return return_item;
	}

	public void setReturn_item(int return_item) {
		this.return_item = return_item;
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

	public String getWb_num() {
		return wb_num;
	}

	public void setWb_num(String wb_num) {
		this.wb_num = wb_num;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "rv_pid=" + rv_pid + "<br/>" + "user_pid=" + user_pid + "<br/>" + "r_name=" + r_name + "<br/>" + "r_date="
				+ r_date + "<br/>" + "s_date=" + s_date + "<br/>" + "e_date=" + e_date + "<br/>" + "name=" + name + "<br/>"
				+ "phone=" + phone + "<br/>" + "bank_name=" + bank_name + "<br/>" + "bank_num=" + bank_num + "<br/>"
				+ "bank_holder=" + bank_holder + "<br/>" + "receipt_item=" + receipt_item + "<br/>" + "return_item="
				+ return_item + "<br/>" + "address=" + address + "<br/>" + "address_detail=" + address_detail + "<br/>"
				+ "wb_num=" + wb_num + "<br/>" + "cost=" + cost + "<br/>" + "deposit=" + deposit + "<br/>" + "state=" + state
				+ "<br/>";
	}

}
