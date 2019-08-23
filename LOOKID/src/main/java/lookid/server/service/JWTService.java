package lookid.server.service;

public interface JWTService {

	public <T> String create(String key, T data);

	boolean isUsable(String jwt);

	public byte[] generateKey();

	public void detroy(String jwt);

	public String getUser_pid(String jwt);

}
