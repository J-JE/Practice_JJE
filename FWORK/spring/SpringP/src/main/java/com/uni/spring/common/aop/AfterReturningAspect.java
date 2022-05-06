package com.uni.spring.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.uni.spring.common.interceptor.LoginInterceptor;
import com.uni.spring.member.model.dto.Member;

import ch.qos.logback.classic.Logger;

@Aspect
@Component
public class AfterReturningAspect {
	private static final Logger logger=(Logger) LoggerFactory.getLogger(AfterReturningAspect.class); //다른 클래스 이름을 적으면 오류는 안뜨지만 로그 경로에 다르게 표현됨
	
	@AfterReturning(pointcut="execution(* com.uni.spring..*ServiceImpl.login*(..))", returning="returnObj")
	public void loggerAdvice(JoinPoint join, Object returnObj) {
		
		if(returnObj instanceof Member) { //Member객체로 형변환이 가능한 객체인지 (로그인이 도ㅔㅐㅆ는자ㅣ
			
			Member m =(Member)returnObj;
			
			if(m.getUserId().equals("admin")) {
				logger.info("[LOG] : 관리자님 환영합니다.");
			}else {
				logger.info("[LOG] : "+m.getUserId()+" 로그인 성공!!");
			}
		}
	}
	
}
