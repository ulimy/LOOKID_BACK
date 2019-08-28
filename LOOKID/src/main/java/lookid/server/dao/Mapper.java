package lookid.server.dao;

import lookid.server.vo.ReservationVO;

public interface Mapper {
	// public ReservationDTO reservation_create(@Param("user_pid") int user_pid,@Param("rv_pid")int rv_pid, @Param("r_name") String r_name, @Param("r_date") Date r_date, @Param("s_date")Date s_date, @Param("e_date") Date e_date, @Param("name") String name, @Param("phone") String phone, @Param("bank_name") String bank_name, @Param("bank_holder") String bank_holder, @Param("receipt_item") int receipt_item, @Param("return_item") int return_item, @Param("address") String address, @Param("wb_num") String wb_num, @Param("cost") int cost, @Param("deposit") int deposit, @Param("state") int state);
	public void reservation_create(ReservationVO input);
	
	
}