package com.uni.spring.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

//	https://docs.spring.io/spring-framework/docs/5.2.9.RELEASE/spring-framework-reference/core.html#aop-at-aspectj : 참고 링크

@Aspect
@Component
public class AspectTest {
	//* 임의의 문자열 1개를 의미
	//.. 임의의 문자열 0개이상을 의미
	//*(..) 모든 메서드의미

	@Pointcut("execution(* com.uni.spring..*ServiceImpl.*(..))")
	public void pointCut() {}
	
	//@Before("execution(* com.uni.spring..*ServiceImpl.*(..))") //바로 쓰는것도 가능 하지만 계속 쓸것이기 때문에 따로 메서드 생성
	@Before("pointCut()") //before가 동작할 포인트컷 명시, 메소드가 실행되기 전에 공통으로 처ㅏ리할 작업을 위해 사용
	public void before(JoinPoint join) {
		//JoinPoint : 어드바이스 메소드를 의미 있게 구현하려면 클라이언트가 호출한 비즈니스 메소드의 정보가 필요하다. 
		//어떤 메소드에서 어떤 동작이 이루어졌는지 알면 굉장히 편하다. 
		//스프링에서는 이런 정보들을 이용할 수 있도록 JoinPoint 인터페이스를 제공한다.
		//실제로 JoinPoint 인터페이스에 들어가보면 아래에서 사용될 getSignature(), getArgs()가 선언되어있음을 확인할 수 있다. 
		
		Signature sig = join.getSignature(); //AOP가 적용되는 메소드의 정보 반환
		
		Object[] params = join.getArgs(); //파라미터값 확인
		for(Object obj : params) {
			System.out.println("obj : "+obj);
		}
		
		System.out.println("메소드 호출전 확인 : "+sig.getDeclaringTypeName()+" : "+sig.getName()); 
		//sig.getDeclaringTypeName() : 메소드가 있는 클래스의 풀네임
		//sig.getName() : 타겟 객체의 메소드명
		
	}
	
	@After("pointCut()") //예외발생여부에 상관없이 비즈니스 로직 후 무조건 수행하는 기능을 작성하는 advice
	public void after(JoinPoint join) {
		
		Signature sig = join.getSignature(); //AOP가 적용되는 메소드의 정보 반환
	
		System.out.println("메소드 호출후 확인 : "+sig.getDeclaringTypeName()+" : "+sig.getName()); 
		
	}
	
	@AfterReturning(pointcut="pointCut()", returning="returnObj") //두가지 들어감, 정상적으로 비지니스 메소드가 리턴한 결과 데이터를 다른 용도로 처리할때
	public void returningPoint(JoinPoint join, Object returnObj) {
		//After Returning 어드바이스 : 어떤 메소드가 어떤 값을 리턴했는지 알아야 사후 처리 기능을 다양하게 구현할 수 있다.
		//returnObj를 '바인드 변수'라고 한다.
		//바인드 변수는 비즈니스 메소드가 리턴한 결과값을 바인딩할 목적으로 사용하며, 어떤 값이 리턴될지 모르기 때문에 Object 타입으로 선언한다. 
		Signature sig = join.getSignature();
		
		System.out.println("메소드 호출후 @AfterReturning 확인 : "+sig.getDeclaringTypeName()+" : "+sig.getName()+" returnObj :"+returnObj); 
	}
	
	@AfterThrowing(pointcut="pointCut()", throwing="exceptionObj") //예외발생시 수행
	public void throwingPoint(JoinPoint join, Exception exceptionObj) {
		Signature sig = join.getSignature();
		
		System.out.println("메소드 호출후 @AfterThrowing 확인 : "+sig.getDeclaringTypeName()+" : "+sig.getName()); 
		
		//IllegalArgumentException : 메소드가 잘못되어썩나 부적절한 인자를 전달했음을 나타내기 위해 던져진다.
		if(exceptionObj instanceof IllegalArgumentException) {
			System.out.println("부적합한 값이 입력되었습니다.");
		}else {
			System.out.println("예외 발생 메세지 :"+exceptionObj.getMessage());
			System.out.println("예외 발생 종류 :"+exceptionObj.getClass().getName());
			
		}
	}
	
	@Around("pointCut()")
	public Object aroundLog(ProceedingJoinPoint join) throws Throwable {
		//https://developer-joe.tistory.com/221
		
		String methodName = join.getSignature().getName();
		
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		
		Object obj = join.proceed(); //proceed() : 전과 후를 나누는 기준이 된다.
		
		stopwatch.stop();
		System.out.println(methodName+" 소요시간(ms) : "+stopwatch.getTotalTimeMillis()+"초");
		return obj; //중간에 비즈니스 로직을 가로챘기 때문에 그 로직의 결과를 반환해야 한다. 때문에 Object타입으로 반환
	}
}
