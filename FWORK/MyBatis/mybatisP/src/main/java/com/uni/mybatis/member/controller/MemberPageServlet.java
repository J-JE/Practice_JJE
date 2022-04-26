package com.uni.mybatis.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uni.mybatis.member.model.dto.Member;
import com.uni.mybatis.member.model.service.MemberService;
import com.uni.mybatis.member.model.service.MemberServiceImpl;

/**
 * Servlet implementation class MyPageServlet
 */
@WebServlet("/myPage.do")
public class MemberPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Member loginUser = (Member)request.getSession().getAttribute("loginUser"); //세션에서 로그인 유저값 받기
//		String userId = loginUser.getUserId(); //로그인할 때 id,pwd만 있었음
		
//		try {
//			Member member = memberService.selectMember(userId);//userId로 select 해오기
//			System.out.println("MemberPageServlet : "+member);
//			System.out.println("MemberPageServlet : "+loginUser);
			
//			if(member != null) {
//			if(loginUser != null) {
//				request.getSession().setAttribute("loginUser", loginUser);
				request.getRequestDispatcher("WEB-INF/views/member/myPage.jsp").forward(request, response);
//			}else {
//				throw new Exception();
//			}
//		} catch (Exception e) {
//			request.setAttribute("msg", "마이페이지 조회에 실패하였습니다.");
//			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);

//			e.printStackTrace();
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
