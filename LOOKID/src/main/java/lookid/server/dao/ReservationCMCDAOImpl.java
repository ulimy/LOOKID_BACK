package lookid.server.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lookid.server.dto.AdminDTO;
import lookid.server.dto.ChildDTO;
import lookid.server.dto.GroupDTO;
import lookid.server.vo.GroupVO;
import lookid.server.vo.ReservationVO;

@Repository("ReservationCMCDAO")
public class ReservationCMCDAOImpl implements ReservationCMCDAO {

	@Autowired
	private Mapper mapper;

	// 예약 정보 추가
	@Override
	public int reservation_create(ReservationVO input) throws Exception {
		System.out.println(input.toString());
		mapper.reservation_create(input);
		return input.getRv_pid();
	}

	// 그룹 정보 추가
	@Override
	public int group_create(int rv_pid, GroupDTO input) throws Exception {
		GroupVO gv = new GroupVO(rv_pid, input);
		mapper.group_create(gv);
		return gv.getG_pid();
	}

	// child 정보 추가
	@Override
	public void child_create(int g_pid, ChildDTO[] child) throws Exception {
		mapper.child_create(g_pid, child);
		return;
	}

	// 관리자 정보 추가
	@Override
	public void admin_create(int g_pid, AdminDTO[] admin) throws Exception {
		mapper.admin_create(g_pid, admin);
		return;
	}
	
	// 예약 정보 수정
	@Override
	public void reservation_modify(ReservationVO input) throws Exception {
		mapper.reservation_modify(input);
		return;
	}
	
	// 그룹 정보 삭제
	@Override
	public void group_delete(int rv_pid) throws Exception {
		// 그룹 개수가 달라질 경우를 고려하여 삭제 후 재생성
		mapper.group_delete(rv_pid);
	}

	// 예약 취소
	@Override
	public void reservation_cancle(int rv_pid) {
		mapper.reservation_delete(rv_pid);
		return;
	}

}
