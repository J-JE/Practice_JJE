package com.uni.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uni.notice.model.dto.Notice;
import com.uni.notice.model.service.NoticeService;

/**
 * Servlet implementation class NoticeDetailServlet
 */
@WebServlet("/detailNotice.do")
public class NoticeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nno = Integer.parseInt(request.getParameter("nno")); //noticeListView.jsp에서 파라미터로 넘어온 nno를 int타입으로 받아서 
		
		Notice notice = new NoticeService().selectNotice(nno); //nno로 Notice를 찾아와 객체 생성
		
		String view = "";
		if(notice != null) { //notice에 값이 담겨 있다면
			request.setAttribute("notice", notice); //request에 notice정보를 담아서 noticeDetailView.jsp로 넘김
			view = "views/notice/noticeDetailView.jsp";
		}else {
			request.setAttribute("msg", "공지사항 조회에 실패하였습니다."); //errorPage에 오류 메세지 넘김
			
			view="views/common/errorPage.jsp";
		}
		request.getRequestDispatcher(view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
