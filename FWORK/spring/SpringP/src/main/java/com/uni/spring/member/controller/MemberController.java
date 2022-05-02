package com.uni.spring.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uni.spring.member.model.dto.Member;

@Controller //bean Scanning으로 검색이 가능하도록 bean 등록
public class MemberController {

	
	//1. HttpServletRequest를 통해 전송받기 (기존 jsp/servlet 방식)
	/*@RequestMapping(value="login.do", method=RequestMethod.POST) //@RequestMapping을 붙여줌으로써 HandlerMapping으로 등록
	public String loginMember(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		System.out.println(userId);
		System.out.println(userPwd);
		return "main"; //리턴되는 문자열을 servlet-context.xml의 viewResolver에 의해서 사용자가 보게될 뷰로 포워딩
	}*/
		
	
	//2.@RequestParam - 스프링에서 제공하는 파라미터를 받아오는 방식\
	/*@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String loginMember(@RequestParam("userId") String userId, @RequestParam("userPwd") String userPwd) {
		
		System.out.println(userId);
		System.out.println(userPwd);
		return "main";
	}*/
	
	//3. @RequestParam 생략 - 매개변수에 name과 동일하게 작성해야 자동으로 값이 주어진다. 
	/*@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String loginMember(String userId, String userPwd) {
		
		System.out.println(userId);
		System.out.println(userPwd);
		return "main";
	}*/
	
	//4. @ModelAttribute 를 이용한 방법 - 요청 파라미터가 많은경우 객체 타입으로 넘겨 받는데 기본 생성자와 setter 를 이용한 주입 방식 이므로 둘중하나라도 
	//없으면 에러 . 반드시 name 속성에 있는 값과 필드명이 동일 해야 하고 setter 작성하는 규칙에 맞게 작성되어야 한다.
	/*@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String loginMember(@ModelAttribute Member m) {
		
		System.out.println("Id : "+ m.getUserId());
		System.out.println("Pwd : "+ m.getUserPwd());
		return "main";
	}*/
	
	//5. @ModelAttribute생략
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String loginMember(Member m) {
		
		System.out.println("Id : "+ m.getUserId());
		System.out.println("Pwd : "+ m.getUserPwd());
		return "main";
	}
}
