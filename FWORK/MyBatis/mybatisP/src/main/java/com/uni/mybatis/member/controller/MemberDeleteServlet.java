package com.uni.mybatis.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uni.mybatis.member.model.service.MemberService;
import com.uni.mybatis.member.model.service.MemberServiceImpl;

/**
 * Servlet implementation class MemberDeleteServlet
 */
@WebServlet("/deleteMember.do")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		try {
			memberService.deleteMember(userId);
			//세션에 저장된 loginUser 속성을 삭제한다.
			request.getSession().removeAttribute("loginUser");
			//탈퇴 성공하면 메인화면으로 돌려보내기
			response.sendRedirect(request.getContextPath()); 
		} catch (Exception e) {
			request.setAttribute("msg", "회원탈퇴에 실패하였습니다.");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);

			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
