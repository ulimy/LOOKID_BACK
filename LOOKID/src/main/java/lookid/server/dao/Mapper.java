package lookid.server.dao;

import org.apache.ibatis.annotations.Param;

import lookid.server.dto.AdminDTO;
import lookid.server.dto.ChildDTO;
import lookid.server.dto.FindIdDTO;
import lookid.server.dto.GroupDTO;
import lookid.server.dto.ReservationListDTO;
import lookid.server.dto.RvPidDTO;
import lookid.server.vo.GroupVO;
import lookid.server.vo.ReservationVO;
import lookid.server.vo.UserVO;

public interface Mapper {
	public Integer checkId(@Param("id") String id);

	public void signup(@Param("id") String id, @Param("pw") String pw, @Param("name") String name,
			@Param("phone") String phone, @Param("mail") String mail, @Param("address") String address,
			@Param("address_detail") String address_detail, @Param("bank_name") String bank_name,
			@Param("bank_num") String bank_num, @Param("bank_holder") String bank_holder);

	public UserVO signin(@Param("id") String id, @Param("pw") String pw);

	public FindIdDTO find_id(@Param("name") String name, @Param("phone") String phone);

	public String find_pw(@Param("id") String id, @Param("mail") String mail);

	public void modify_temp_pw(@Param("id") String id, @Param("pw") String pw, @Param("mail") String mail);

	public AdminDTO find_admin(@Param("id") String id);

	public void modify(@Param("user_pid") int user_pid, @Param("name") String name, @Param("phone") String phone,
			@Param("mail") String mail, @Param("address") String address,
			@Param("address_detail") String address_detail, @Param("bank_name") String bank_name,
			@Param("bank_num") String bank_num, @Param("bank_holder") String bank_holder);

	public void modify_pw(@Param("user_pid") int user_pid, @Param("pw") String pw);

	public int count();

	public RvPidDTO[] today(@Param("user_pid") int user_pid, @Param("now") String now);

	public ReservationListDTO[] reservation_list(@Param("user_pid") int user_pid);

	public ReservationVO reservation_detail(@Param("rv_pid") int rv_pid);

	public GroupDTO[] group_detail(@Param("rv_pid") int rv_pid);

	public ChildDTO[] child_detail(@Param("g_pid") int g_pid);

	public AdminDTO[] admin_detail(@Param("g_pid") int g_pid);

	public void reservation_create(ReservationVO input);

	public void group_create(GroupVO input);

	public void child_create(@Param("g_pid") int g_pid, @Param("children") ChildDTO[] children);

	public void admin_create(@Param("g_pid") int g_pid, @Param("admins") AdminDTO[] admins);

	public void reservation_modify(ReservationVO input);

	public void group_delete(@Param("rv_pid") int rv_pid);

	public void reservation_delete(@Param("rv_pid") int rv_pid);

}
