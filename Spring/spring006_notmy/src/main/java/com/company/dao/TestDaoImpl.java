package com.company.dao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class TestDaoImpl implements TestDao{
	@Autowired  private SqlSession sqlSession;  //sql ½ÇÇà
	private static final String namespace="com.company.dao.TestDao";
	@Override public String now() { 
		return sqlSession.selectOne(namespace + ".now");
	}
}
