package lookid.server.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("ReservationCancleDAO")
public class ReservationCancleDAOImpl implements ReservationCancleDAO {

	@Autowired
	Mapper mapper;
	
	@Override
	public void reservation_cancle(int rv_pid) {
		mapper.reservation_delete(rv_pid);
		return;
	}

}
