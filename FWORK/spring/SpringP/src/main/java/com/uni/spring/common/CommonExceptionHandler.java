package com.uni.spring.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice("com.uni.spring")//해당 패키지 내에서 예외가 발생하면 아래 메소드에서 잡을 수 있도록 어드바이스를 어노테이션 (빈 등록해야 함)
public class CommonExceptionHandler {
	
	
	@ExceptionHandler(value = Exception.class)//어떤 에러를 받을지 작성
	public ModelAndView controllerExceptionHandler (Exception e) {
		
		e.printStackTrace(); //어떤 에러가 발생했는지
		return new ModelAndView("common/errorPage").addObject("msg",e.getMessage()); //ModelAndView : 페이지와 넘길값 같이
	
	}
}
