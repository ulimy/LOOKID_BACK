package lookid.server.vo;

import java.util.Date;

import lookid.server.dto.ReservationDTO;

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

	public ReservationVO(int user_pid, ReservationDTO dto) {
		this.user_pid = user_pid;
		this.r_name = dto.getR_name();
		this.r_date = dto.getR_date();
		this.s_date = dto.getS_date();
		this.e_date = dto.getE_date();
		this.name = dto.getName();
		this.phone = dto.getPhone();
		this.bank_name = dto.getBank_name();
		this.bank_num = dto.getBank_num();
		this.bank_holder = dto.getBank_holder();
		this.receipt_item = dto.getReceipt_item();
		this.return_item = dto.getReturn_item();
		this.address = dto.getAddress();
		this.address_detail = dto.getAddress_detail();
		this.wb_num = dto.getWb_num();
		this.cost = dto.getCost();
		this.deposit = dto.getDeposit();
		this.state = dto.getState();
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
		return "ReservationVO [rv_pid=" + rv_pid + ", user_pid=" + user_pid + ", r_name=" + r_name + ", r_date="
				+ r_date + ", s_date=" + s_date + ", e_date=" + e_date + ", name=" + name + ", phone=" + phone
				+ ", bank_name=" + bank_name + ", bank_num=" + bank_num + ", bank_holder=" + bank_holder
				+ ", receipt_item=" + receipt_item + ", return_item=" + return_item + ", address=" + address
				+ ", address_detail=" + address_detail + ", wb_num=" + wb_num + ", cost=" + cost + ", deposit="
				+ deposit + ", state=" + state + "]";
	}

}
