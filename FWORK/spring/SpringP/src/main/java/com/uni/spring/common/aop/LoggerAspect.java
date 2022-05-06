package com.uni.spring.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import com.uni.spring.member.model.dto.Member;

import ch.qos.logback.classic.Logger;

public class LoggerAspect {
	private static final Logger logger=(Logger) LoggerFactory.getLogger(LoggerAspect.class);
	
	public Object aroundLogAdvice(ProceedingJoinPoint join) throws Throwable {
		
		Signature sig = join.getSignature();
		String type = sig.getDeclaringTypeName();
		String methodName = sig.getName();
		
		String cName ="";
		
		if(type.indexOf("Controller") >-1) { //인덱스가 0이상일 때 (실행될때) (-> com.uni...등의 경로에 존재만 한다면 0이상이기만 하면 존재한다는 뜻)
			cName = "Controller : ";
		}else if(type.indexOf("Service") >-1){
			cName = "Service : ";
		}else if(type.indexOf("Dao") >-1){
			cName = "Dao : ";
		}
		
		logger.info("[Before] "+cName+type+"."+methodName+"()");
		
		Object obj = join.proceed(); //proceed() : 전과 후를 나누는 기준이 된다.
		
		logger.info("[After] "+cName+type+"."+methodName+"()");

		return obj;
	}
}
