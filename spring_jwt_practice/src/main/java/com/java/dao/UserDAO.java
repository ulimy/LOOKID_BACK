package com.java.dao;

import java.util.List;

import com.java.vo.BlacklistVO;
import com.java.vo.UserVO;

public interface UserDAO {

	public Integer login(UserVO vo) throws Exception;

	public void signup(UserVO vo) throws Exception;

	public Integer signupcheckid(String userId) throws Exception;
	
	public List<UserVO> listAll() throws Exception;
	
	public void logout(BlacklistVO vo) throws Exception;
	
	public Integer tokenCount(String logoutToken) throws Exception;

}
