package lookid.server.dao;

import org.apache.ibatis.annotations.Param;

import lookid.server.dto.AdminDTO;
import lookid.server.dto.ChildDTO;
import lookid.server.dto.FindIdDTO;
import lookid.server.dto.GroupDTO;
import lookid.server.dto.ModifyPwDTO;
import lookid.server.dto.ModifyTempPwDTO;
import lookid.server.dto.ReservationListDTO;
import lookid.server.dto.RvPidDTO;
import lookid.server.dto.SigninDTO;
import lookid.server.dto.UserPageDTO;
import lookid.server.vo.DeviceChildVO;
import lookid.server.vo.DeviceVO;
import lookid.server.vo.GroupVO;
import lookid.server.vo.ReservationVO;
import lookid.server.vo.UserVO;

public interface Mapper {
	
	public void device(DeviceVO vo);
	
	public UserPageDTO userPage(@Param("user_pid") int user_pid);
	
	public void truncate_table();
	
	public void device_child(DeviceChildVO vo);
	
	public Integer checkId(@Param("id") String id); 

	public void signup(UserVO user);

	public UserVO signin(SigninDTO user);

	public FindIdDTO find_id(@Param("name") String name, @Param("phone") String phone);

	public String find_pw(@Param("id") String id, @Param("mail") String mail);

	public void modify_temp_pw(ModifyTempPwDTO user);

	public AdminDTO find_admin(@Param("id") String id);

	public void modify(UserVO user);

	public void modify_pw(ModifyPwDTO user);

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
