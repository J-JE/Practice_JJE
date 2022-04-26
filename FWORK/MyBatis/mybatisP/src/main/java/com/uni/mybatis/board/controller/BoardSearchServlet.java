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
import com.uni.mybatis.board.model.dto.SearchCondition;
import com.uni.mybatis.board.model.service.BoardService;
import com.uni.mybatis.board.model.service.BoardServiceImpl;
import com.uni.mybatis.common.Pagination;

/**
 * Servlet implementation class BoardSearchServlet
 */
@WebServlet("/searchBoard.do")
public class BoardSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardService boardService = new BoardServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String condition = request.getParameter("condition"); //jsp에서 넘긴 파라미터 받아오기
		String search = request.getParameter("search");
		
		SearchCondition sc = new SearchCondition();
		
		switch(condition) { //넘어온 컨디션 값에 따라서 다르게 값을 세팅하기
		case "writer":
			sc.setWriter(search);
			break;
		case "title":
			sc.setTitle(search);
			break;
		case "content":
			sc.setContent(search);
			break;
		}
		
		//검색된 게시글 갯수 조회
		try {
			int listCount = boardService.getSearchListCount(sc);
			
			int currentPage =1;
			if(request.getParameter("currentPage")!=null) {
				currentPage=Integer.parseInt(request.getParameter("currentPage"));
			}
			
			int pageLimit = 10;
			int boardLimit = 5;
			
			PageInfo pi = Pagination.getPageInfo(listCount, currentPage, pageLimit, boardLimit); //페이지 정보
			
			ArrayList<Board> list = boardService.selectSearchList(sc,pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			//search, condition도 넘겨줘야 함
			request.setAttribute("search", sc);
			request.setAttribute("condition", condition);
			//forward로
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
