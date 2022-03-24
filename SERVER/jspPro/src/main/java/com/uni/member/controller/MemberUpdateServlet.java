package com.uni.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uni.member.model.dto.Member;
import com.uni.member.model.service.MemberService;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/updateMember.do")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8"); //언제 인코딩 하는지 알아보기
		
		//myPage에서 넘어온 name값들을 키값으로해서 받아옴
		String userId = request.getParameter("userId");
//		String originPwd = request.getParameter("originPwd"); readonly임
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String[] interests = request.getParameterValues("interest"); //배열
		
		String interest = ""; //문자열로 받기 위해 빈값 선언 비우기
		if(interests != null) { //null이 아니라면
			interest = String.join(",", interests); //","를 사용해서 문자열에 저장
		}
		
		//Member mem = new Member(userId, userName, phone, email, address, interest); Member에 생성자가 구현 되어있는지 확인
	
		Member updateMem = new MemberService().updateMember(new Member(userId, userName, phone, email, address, interest)); //생성자가 구현되어있는지 확인 후
		
		if(updateMem != null) { //updateMem가 null값이 아니라면
			request.getSession().setAttribute("msg", "성공적으로 회원정보를 수정하였습니다.");
			request.getSession().setAttribute("loginUser", updateMem);//세션에 담긴 유저 정보 갱신
			response.sendRedirect(request.getContextPath()); //다시 메인으로 가기 sendRedirect-> 해당 페이지로 이동ㅡ request.getContextPath()-> 메인페이지 경로가 됨
		}else { //null이라면
			request.setAttribute("msg", "회원정보 수정에 실패하였습니다.");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp"); //errorPage에 msg에 담아 경고창에 담기
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
