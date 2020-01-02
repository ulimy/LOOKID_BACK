package lookid.server.service;

import lookid.server.dto.GroupDTO;

public interface MapService {

	// 초기화
	public GroupDTO[] group(int rv_pid) throws Exception;
	
	// 위치조회
	public void child() throws Exception;
	
}
