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
 * Servlet implementation class UpdateNoticePageServlet
 */
@WebServlet("/updateFormNotice.do")
public class UpdateNoticePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNoticePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//noticeDetailView에서 nno를 url에 담아서 넘겨 받음.
		int nno = Integer.parseInt(request.getParameter("nno"));
		//받아온 nno로 notice 객체에 현재 조회중인 공지 정보 담기
		Notice notice = new NoticeService().selectNotice(nno);
		//현재 조회중인 공지 정보를 리퀘스트에 담기
		request.setAttribute("notice", notice);
		
		//noticeUpdateForm으로 넘기기
		RequestDispatcher view = request.getRequestDispatcher("views/notice/noticeUpdateForm.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
