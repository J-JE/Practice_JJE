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
 * Servlet implementation class MemberPageServlet
 */
@WebServlet("/mypageMember.do")
public class MemberPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		
		Member loginUser = (Member)request.getSession().getAttribute("loginUser"); //세션에서 로그인 유저 정보를 받아옴. getAttribute를 사용하면 Object 형태로 넘어오기 때문에 무조건 형변환 시켜야 함
		String userId = loginUser.getUserId(); //로그인 유저에서 아이디값을 빼서 userId 객체에 저장
		
		Member member = new MemberService().selectMember(userId); //userId로 selectMember()메소드를 호출해 Member객체에 담는다.
		
		System.out.println(member); //로그인 유저의 정보를 콘솔창에서 확인
		
		RequestDispatcher view = null; //null값으로 선언
		
		if(member != null) { //넘어온 Member객체가 null값이 아닌 경우
			request.setAttribute("loginUser", member); //request의 loginUser 속성을 member로 설정 
			view = request.getRequestDispatcher("views/member/myPage.jsp"); //myPage와 연결 
		}else { //넘어온 Member객체가 null인 경우
			request.setAttribute("msg", "조회 실패하였습니다."); //request의 msg 속성에 오류 메세지 설정
			view = request.getRequestDispatcher("views/common/errorPage.jsp"); //errorPage와 연결
		}
		
		view.forward(request, response); //응닶값을 넘김
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
