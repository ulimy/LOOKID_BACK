package lookid.server.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service("JWTService")
public class JWTServiceImpl implements JWTService {

	// 토큰 생성
	@Override
	public <T> String create(String user_pid, T data) {
		// TODO Auto-generated method stub
		return null;
	}

	// 토큰 유효성 검사
	@Override
	public boolean isUsable(String jwt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, Object> get(String user_pid) {
		// TODO Auto-generated method stub
		return null;
	}

	// 토큰 삭제
	@Override
	public void detroy(String jwt) {
		// TODO Auto-generated method stub

	}

}
