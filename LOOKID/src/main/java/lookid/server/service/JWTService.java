package lookid.server.service;

import javax.servlet.http.HttpServletRequest;

public interface JWTService {

	public <T> String create(String key, T data);

	boolean isUsable(String jwt);

	public byte[] generateKey();

	public int getUser_pid(String jwt);

	public void detroy(String jwt, HttpServletRequest request);

}
