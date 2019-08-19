package lookid.server.dao;

import org.apache.ibatis.annotations.Param;

import lookid.server.dto.FindIdDTO;
import lookid.server.dto.SuccessDTO;
import lookid.server.vo.UserVO;

public interface Mapper {

	public SuccessDTO checkId(@Param("id") String id);

	public SuccessDTO signup(@Param("id") String id, @Param("pw") String pw, @Param("name") String name,
			@Param("phone") String phone, @Param("mail") String mail, @Param("address") String address,
			@Param("bank_name") String bank_name, @Param("bank_num") String bank_num,
			@Param("bank_holder") String bank_holder);

	public UserVO signin(@Param("id") String id, @Param("pw") String pw);

	public FindIdDTO find_id(@Param("name") String name, @Param("phone") String phone);

	public SuccessDTO find_pw(@Param("id") String id, @Param("mail") String mail);

	public SuccessDTO modify(@Param("id") String id, @Param("pw") String pw, @Param("name") String name,
			@Param("phone") String phone, @Param("mail") String mail, @Param("address") String address,
			@Param("bank_name") String bank_name, @Param("bank_num") String bank_num,
			@Param("bank_holder") String bank_holder);

	public SuccessDTO modify_pw(@Param("pw") String pw);

}
