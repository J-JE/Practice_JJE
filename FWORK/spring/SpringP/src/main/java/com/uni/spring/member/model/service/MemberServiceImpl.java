package com.uni.spring.member.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uni.spring.common.CommException;
import com.uni.spring.member.model.dao.MemberDao;
import com.uni.spring.member.model.dto.Member;

//@EnableAspectJAutoProxy //트랜젝션 같은 경우에 발생하는것마다 우리가 일일히 처리되게, 행당 관점
//@Transactional//(noRollbackFor = Exception.class) //트랜젝션 처리
@Service //비즈니스 로직을 처리하는 클래스(빈)이다.
public class MemberServiceImpl implements MemberService {

	//root-context.xml에 bean 생성(템플릿)
	@Autowired 
	private SqlSessionTemplate sqlSession;
	
	//@Repository에서 네이밍을 따로 하지 않았기 때문에 앞글자 소문자로 연결하기
	@Autowired
	private MemberDao memberDao; 
	
	@Override
	public Member loginMember(Member m) throws Exception {
		
		Member loginUser = memberDao.loginMember(sqlSession, m);
		
		System.out.println("loginUser : "+loginUser);
		
		if(loginUser == null) { //조회결과 없으면
			throw new Exception("loginUser 확인"); //예외 발생시키기
		}
		return loginUser; //로그인유저 정보 넘기기
	}

	@Override
	public void insertMember(Member m) {
		int result = memberDao.insertMember(sqlSession, m);
		
		if(result <0) {
			//RuntimeException은 스프링에서 롤백을 하도록 지원해줌
//			throw new RuntimeException(); 
			//RuntimeException을 상속받은 commonException을 사용할것임
			throw new CommException("회원가입에 실패하였습니다.");
		}
	}

	@Override
	public Member loginMember(BCryptPasswordEncoder bCryptPasswordEncoder, Member m) {
		//로그인 호출 (쿼리 수정)
		Member loginUser = memberDao.loginMember(sqlSession, m);
		if(loginUser == null) { //조회결과 없으면
			throw new CommException("loginUser 확인"); //예외 발생시키기
		}
		
		//비교를 해주는 메소드 지원해줌
		//matches(평문, 암호화 된 값) -> true, false를 반환해줌
		if(!bCryptPasswordEncoder.matches(m.getUserPwd(), loginUser.getUserPwd())) {//일치하지 않으면
			throw new CommException("암호 불일치"); //예외 발생시키기
		}
		return loginUser;
	}

	@Override
	public Member updateMember(Member m) throws Exception{
		
		int result = memberDao.updateMember(sqlSession, m);
		//memberDao.insertMember(sqlSession, m);
		//DataIntegrityViolationException이 뜸 더이상 sqlException이 뜨는게 아님
		//모든 예외의 상위에 DataAccessException가 있음
		if(result > 0) { //결과가 0보다 크면 제대로 수정됨
			Member loginUser = memberDao.loginMember(sqlSession, m);
			//수정된 loginUser값 넘기기
			return loginUser;
		}else { //수정 실패
			throw new CommException("회원수정실패");
//			throw new RuntimeException("회원수정실패");
//			throw new Exception("회원수정실패");
		}
	}
	//트랜젝션 처리를 위해선 어노테이션 처리가 필요하다. (하나 더 있음)

	@Override
	public Member updatePwd(BCryptPasswordEncoder bCryptPasswordEncoder, String originPwd, String updatePwd, Member m)
			throws Exception {
		
		if(!bCryptPasswordEncoder.matches(originPwd, m.getUserPwd())) { //입력받은 originPwd랑 암호화된 비밀번호 비교
			throw new CommException("암호 불일치");
		}else {
			String encPwd = bCryptPasswordEncoder.encode(updatePwd); //입력받은 updatePwd 암호화
			
			m.setUserPwd(encPwd); //멤버 객체 비밀번호 수정
			
			int result = memberDao.updatePwd(sqlSession, m); //dao로 넘겨서 처리
			
			if(result > 0) { //처리 결과가 0이상이면 성공
				//수정된 Member 넘기기
				return memberDao.loginMember(sqlSession, m);
			}else { //수정 실패
				throw new CommException("비밀번호수정실패");
			}
		}
	}

	
	@Override
	public int idCheck(String userId) {
		int count = memberDao.idCheck(sqlSession, userId);
		
		if(count < 0) {
			throw new CommException("아이디 체크에 실패했습니다.");
		}
		return count;
	}

}
