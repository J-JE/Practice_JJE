package com.uni.spring.member.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.spring.common.CommException;
import com.uni.spring.member.model.dao.MemberDao;
import com.uni.spring.member.model.dto.Member;

//@EnableAspectJAutoProxy //트랜젝션 같은 경우에 발생하는것마다 우리가 일일히 처리되게, 행당 관점
//@Transactional//(noRollbackFor = Exception.class) //트랜젝션 처리
@Service //비즈니스 로직을 처리하는 클래스(빈)이다.
public class MemberServiceImpl2 {

	@Autowired 
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private MemberDao memberDao; 
	
	public Member updateMember(Member m) throws Exception{
		
		int result = memberDao.updateMember(sqlSession, m);
		//memberDao.insertMember(sqlSession, m);
		//DataIntegrityViolationException이 뜸 더이상 sqlException이 뜨는게 아님
		//모든 예외의 상위에 DataAccessException가 있음
		if(result < 0) { //결과가 0보다 크면 제대로 수정됨
			Member loginUser = memberDao.loginMember(sqlSession, m);
			//수정된 loginUser값 넘기기
			return loginUser;
		}else { //수정 실패
			throw new CommException("회원수정실패");
//			throw new RuntimeException("회원수정실패");
//			throw new Exception("회원수정실패");
		}
	}
	

}
