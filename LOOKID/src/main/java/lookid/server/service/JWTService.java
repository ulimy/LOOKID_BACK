package lookid.server.service;

import javax.servlet.http.HttpServletResponse;

public interface JWTService {

	public <T> String create(String key, T data);

	boolean isUsable(String jwt);

	public byte[] generateKey();

	public int getUser_pid(String jwt);

	public void destroy(String jwt, int user_pid, HttpServletResponse response);

}
