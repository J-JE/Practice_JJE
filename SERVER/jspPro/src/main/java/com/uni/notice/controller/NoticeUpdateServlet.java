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
 * Servlet implementation class NoticeUpdateServlet
 */
@WebServlet("/updateNotice.do")
public class NoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//title, content 수정하기, where에 nno값이 들어가야 함
		int nno = Integer.parseInt(request.getParameter("nno")); //nno는 int형
		String newTitle = request.getParameter("title");
		String newContent = request.getParameter("content");
		
		//service로 수정할 내용 보내기, nno은 where절에 사용해야 함 
		//content로 입력받은 값의"\n"을 "<br>"로 치환시켜야 출력할 때 띄어쓰기가 적용된다.
		int updateNotice = new NoticeService().updateNotice(nno, newTitle, newContent.replace("\n", "<br>")); 
		
		//수정 성공 후 nno번 글 상세 페이지로 이동
		if(updateNotice > 0) {
			request.getSession().setAttribute("msg", "공지 수정이 완료되었습니다.");
			response.sendRedirect("detailNotice.do?nno="+nno);
		}else {
			request.setAttribute("msg", "공지 수정에 실패했습니다.");
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
