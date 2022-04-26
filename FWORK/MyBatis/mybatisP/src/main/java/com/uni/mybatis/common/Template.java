package com.uni.mybatis.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {

	public static SqlSession getSqlSession() {
		SqlSession sqlSession = null;
		
		try {
			InputStream stream = Resources.getResourceAsStream("/mybatis-config.xml"); //mybatis-config.xml파일 연결
			//인풋스트림을 사용해서 SqlSessionFactoryBuilder 생성, openSession까지 생성 (sqlSession객체 생성 완료)
			sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession(false); // openSession(true) = 오토커밋, 기본값은 false임
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSession;
	}
}
