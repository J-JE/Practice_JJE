package com.uni.mybatis.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uni.mybatis.board.model.dto.Board;
import com.uni.mybatis.board.model.dto.PageInfo;
import com.uni.mybatis.board.model.service.BoardService;
import com.uni.mybatis.board.model.service.BoardServiceImpl;
import com.uni.mybatis.common.Pagination;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/listBoard.do")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//게시글 수 가져오기
			int listCount = boardService.getListCount();
			
			//현제 페이지를 1로 설정해놓기
			int currentPage = 1;
			
			if(request.getParameter("currentPage") != null) { //현재페이지가 있으면 페이지값 담아주기
				currentPage = Integer.parseInt(request.getParameter("currentPage")); //숫자 형변환
			}
			
			int pageLimit = 10; //총 페이지 수
			int boardLimit = 5; // 한 페이지에 보일 보드 갯수
			
			PageInfo pi = Pagination.getPageInfo(listCount, currentPage, pageLimit, boardLimit); // 나머지 페이징에 쓰이는 값 가져오기
			
			ArrayList<Board> list = boardService.selectList(pi);
			
			request.setAttribute("list",list);
			request.setAttribute("pi",pi);
			
			request.getRequestDispatcher("WEB-INF/views/board/boardListView.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
