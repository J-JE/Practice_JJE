package com.uni.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uni.notice.model.service.NoticeService;

/**
 * Servlet implementation class NoticeDelete
 */
@WebServlet("/deleteNotice.do")
public class NoticeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. nno값 받기
		int nno = Integer.parseInt(request.getParameter("nno"));
		//2. int result로 Service연결해서 반환값 받기
		int result = new NoticeService().deleteNotice(nno);
		//3. restult값 if문 돌려서 잘 동작했는지 확인하기
		if(result > 0) {
			//3-1. 확인창 띄우기
			request.getSession().setAttribute("msg","공지 삭제가 완료되었습니다.");
			response.sendRedirect("listNotice.do");
		}else {
			//3-2. restult값 0 이하면 에러창 띄우기
			request.setAttribute("msg","공지 삭제에 실패했습니다.");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
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
