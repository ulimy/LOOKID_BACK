package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.UserDAO;
import com.java.vo.BlacklistVO;
import com.java.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;

	@Override
	public Integer login(UserVO vo) throws Exception {
		return dao.login(vo);
	}

	@Override
	public void signup(UserVO vo) throws Exception {
		dao.signup(vo);
	}

	@Override
	public Integer signupcheckid(String userId) throws Exception {
		return dao.signupcheckid(userId);
	}

	@Override
	public List<UserVO> listAll() throws Exception {

		return dao.listAll();

	}

	@Override
	public void logout(BlacklistVO vo) throws Exception {
		dao.logout(vo);
	}

	@Override
	public Integer tokenCount(String logoutToken) throws Exception {
		return dao.tokenCount(logoutToken);

	}

}
