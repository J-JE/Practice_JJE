package com.uni.session.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTestServlet
 */
@WebServlet("/sessionTest.do")
public class SessionTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getSessoin() : 세션이 생성되어있으면 생성된session을 리턴, 생성되어있지 않으면 새session을 생성해서 리턴
		//getSessoin(false) : 세션이 생성되어있지 않으면 null 리턴
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(60); //1분
		session.setAttribute("testValue", session.getId());
		
		response.sendRedirect("/");//04A9D2A5F2D4B6B66CE252BEFE67F1D9
		//request값을 꼭 안가져가도 될 때 사용 
		//게시글 작성 후 목록으로 이동할 때, 로그인 성공 후 메인페이지로 이동할 때, 사용 게시글 수정할 때는 게시글 넘버값을 갖고가야 함(이어져야 하는 경우) requestDispatcher
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
