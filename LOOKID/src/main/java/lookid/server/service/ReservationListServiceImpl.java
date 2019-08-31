package lookid.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lookid.server.dao.ReservationListDAO;
import lookid.server.dto.ReservationDetailDTO;
import lookid.server.dto.ReservationListDTO;
import lookid.server.dto.RvPidDTO;

@Service("ReservationListService")
public class ReservationListServiceImpl implements ReservationListService {
	
	@Autowired
	@Qualifier("ReservationListDAO")
	ReservationListDAO list;

	@Override
	public RvPidDTO[] today(int user_pid) {
		try{
			return list.today(user_pid);
		}catch (Exception e){
			System.out.println(e);
			return null;
		}
	}

	@Override
	public ReservationListDTO[] list(int user_pid) {
		try{
			return list.list(user_pid);
		}catch (Exception e){
			return null;
		}
	}

	@Override
	public ReservationDetailDTO detail(int rv_pid) {
		// TODO Auto-generated method stub
		return null;
	}

}
