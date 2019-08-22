package lookid.server.service;

import java.util.Map;

public interface JWTService {

	public <T> String create(String key, T data);

	boolean isUsable(String jwt);

	public byte[] generateKey();
	
	public Map<String, Object> get(String key);

	public void detroy(String jwt);

	public int getUser_pid();
	
}
