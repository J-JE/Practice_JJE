package com.uni.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uni.member.model.service.MemberService;

/**
 * Servlet implementation class MemberDeleteServlet
 */
@WebServlet("/deleteMember.do")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
//		String userId = request.getParameter("loginId");
		String userId = request.getParameter("userId");
		
		int result = new MemberService().deleteMember(userId);
		
		if(result > 0) {
			HttpSession session = request.getSession(); //서버에 세션이 없다면 생성, 있다면 가져온다.
			session.removeAttribute("loginUser"); //세션에 저장된 loginUser 속성을 삭제한다.
			session.setAttribute("msg","회원탈퇴가 완료되었습니다. 북구관련사항은 관리자에게 문의하세요.");
			response.sendRedirect(request.getContextPath()); //메인페이지로 이동
		}else {
			request.setAttribute("msg","회원탈퇴에 실패하였습니다.");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp"); //에러페이지로 데이터와 함께 이동함
			view.forward(request, response);
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
