package lookid.server.dao;

import org.apache.ibatis.annotations.Param;

import lookid.server.dto.FindAdminDTO;
import lookid.server.dto.FindIdDTO;
import lookid.server.dto.GroupDTO;
import lookid.server.dto.ReservationDTO;
import lookid.server.dto.ReservationListDTO;
import lookid.server.dto.RvPidDTO;
import lookid.server.vo.GroupVO;
import lookid.server.vo.ReservationVO;
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

	public void modify_temp_pw(@Param("id") String id, @Param("pw") String pw, @Param("mail") String mail);

	public FindAdminDTO find_admin(@Param("id") String id);

	public void modify(@Param("user_pid") int user_pid, @Param("name") String name, @Param("phone") String phone,
			@Param("mail") String mail, @Param("address") String address, @Param("bank_name") String bank_name,
			@Param("bank_num") String bank_num, @Param("bank_holder") String bank_holder);

	public void modify_pw(@Param("user_pid") int user_pid, @Param("pw") String pw);

	public int count();

	// 예약 당일 여부 확인
	public RvPidDTO[] today(@Param("user_pid") int user_pid, @Param("now") String now);

	// 예약 내역 조회
	public ReservationListDTO[] reservation_list(@Param("user_pid") int user_pid);

	// 예약 상세 조회
	public ReservationDTO reservation_detail(@Param("rv_pid") int rv_pid);

	// 그룹 상세 조회
	public GroupDTO[] group_detail(@Param("rv_pid") int rv_pid);

	// child 상세 조회
	public String[] child_detail(@Param("g_pid") int g_pid);

	// admin 상세 조회
	public FindAdminDTO[] admin_detail(@Param("g_pid") int g_pid);

	// 예약 정보 생성
	public void reservation_create(ReservationVO input);

	// 그룹 정보 생성
	public void group_create(GroupVO input);

	// child 정보 생성
	public void child_create(@Param("g_pid") int g_pid, @Param("children") String[] children);

	// admin 정보 생성
	public void admin_create(@Param("g_pid") int g_pid, @Param("admins") FindAdminDTO[] admins);

	// 예약 정보 수정
	public void reservation_modify(ReservationDTO input);

	// 그룹 정보 수정
	public void group_modify(GroupDTO input);

	// child 정보 수정을 위한 child 정보 삭제
	public void child_delete(@Param("g_pid") int g_pid);

	// admin 정보 수정을 위한 child 정보 삭제
	public void admin_delete(@Param("g_pid") int g_pid);

	// 예약 취소
	public void reservation_delete(@Param("rv_pid")int rv_pid);

}
