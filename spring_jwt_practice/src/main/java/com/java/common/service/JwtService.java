package com.java.common.service;

import java.util.Map;

public interface JwtService {
	
	public <T> String create(String key, T data, String subject, String issuer);

	public byte[] generateKey();

	boolean isUsable(String jwt);

	public Map<String, Object> get(String key);
	
}
