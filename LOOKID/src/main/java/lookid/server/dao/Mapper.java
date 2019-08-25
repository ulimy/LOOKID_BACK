package lookid.server.dao;

import org.apache.ibatis.annotations.Param;

import lookid.server.dto.FindAdminDTO;
import lookid.server.dto.FindIdDTO;
import lookid.server.vo.UserVO;

public interface Mapper {

	public Integer checkId(@Param("id") String id);

	public void signup(@Param("id") String id, @Param("pw") String pw, @Param("name") String name,
			@Param("phone") String phone, @Param("mail") String mail, @Param("address") String address,
			@Param("bank_name") String bank_name, @Param("bank_num") String bank_num,
			@Param("bank_holder") String bank_holder);

	public UserVO signin(@Param("id") String id, @Param("pw") String pw);

	public FindIdDTO find_id(@Param("name") String name, @Param("phone") String phone);

	public String find_pw(@Param("id") String id, @Param("mail") String mail);
	
	public void modify_temp_pw(@Param("id") String id,@Param("pw") String pw, @Param("mail") String mail);

	public FindAdminDTO find_admin(@Param("id") String id);	
	
	public void modify(@Param("user_pid") int user_pid, @Param("pw") String pw, @Param("name") String name,
			@Param("phone") String phone, @Param("mail") String mail, @Param("address") String address,
			@Param("bank_name") String bank_name, @Param("bank_num") String bank_num,
			@Param("bank_holder") String bank_holder);

	public void modify_pw(@Param("user_pid") int user_pid, @Param("pw") String pw);

	public int count();
	
}
