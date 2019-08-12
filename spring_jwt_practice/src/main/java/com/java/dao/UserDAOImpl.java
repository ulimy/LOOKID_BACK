package com.java.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.java.vo.BlacklistVO;
import com.java.vo.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {

	@Inject
	private SqlSession sqlSession;

	private static String namespace = "com.java.mappers.UserMapper";

	@Override
	public Integer login(UserVO vo) throws Exception {
		return sqlSession.selectOne(namespace + ".login", vo);
	}

	@Override
	public void signup(UserVO vo) throws Exception {
		sqlSession.insert(namespace + ".signup", vo);

	}

	@Override
	public Integer signupcheckid(String userId) throws Exception {
		return sqlSession.selectOne(namespace + ".signupcheckid", userId);
	}

	@Override
	public List<UserVO> listAll() throws Exception {

		return sqlSession.selectList(namespace + ".listAll");

	}

	@Override
	public void logout(BlacklistVO vo) throws Exception{
		sqlSession.insert(namespace+ ".logout" , vo);
	}
	
	@Override
	public Integer tokenCount(String logoutToken) throws Exception{
		return sqlSession.selectOne(namespace+".tokenCount", logoutToken);
	}

}
