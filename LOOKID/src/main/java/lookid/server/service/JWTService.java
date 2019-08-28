package lookid.server.service;

public interface JWTService {

	public <T> String create(String key, T data);

	boolean isUsable(String jwt);

	public byte[] generateKey();

	public int getUser_pid(String jwt);

	public String detroy(String jwt);

}
