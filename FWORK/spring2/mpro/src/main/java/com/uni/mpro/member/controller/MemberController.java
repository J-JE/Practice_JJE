package com.uni.mpro.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.uni.mpro.member.dto.Member;
import com.uni.mpro.member.service.MemberService;

@SessionAttributes("loginUser") //키값에 해당하면 들어오면 자동으로 세션에 등록
@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	//메인화면 연결
	@RequestMapping("/") //@RequestMapping 했는데 됐음...
	public String mainForm() {
		return "main";
	}
	
	//로그인
	@RequestMapping("login.do")
	public String loginMember(Member m, Model model) {
		Member loginUser = memberService.loginMember(m);
		System.out.println("loginUser : "+loginUser); //출력
		model.addAttribute("loginUser",loginUser);
		return "main";
	}
	
	//로그아웃
//	@RequestMapping("logout.do")
//	public String logoutMember(HttpSession session) {
//		session.invalidate();
//		return "redirect:/";
//	}
	@RequestMapping("logout.do")
	public String logoutMember(SessionStatus status) {
		status.setComplete(); //@SessionAttributes 저장 세션 삭제하는 메소드
		return "redirect:/";
	}
}
