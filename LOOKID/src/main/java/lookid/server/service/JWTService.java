package lookid.server.service;

import java.util.Map;

public interface JWTService {

	public <T> String create(String user_pid, T data);

	boolean isUsable(String jwt);

	public Map<String, Object> get(String user_pid);

	public void detroy(String jwt);

}
