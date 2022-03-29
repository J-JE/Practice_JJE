package com.uni.board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.uni.board.model.dto.Attachment;
import com.uni.board.model.dto.Board;
import com.uni.board.model.service.BoardService;
import com.uni.common.MyFileRenamePolicy;

/**
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/updateBoard.do")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(request)) { //멀티파트로 잘 넘어왔을 때
			int maxSize = 10 * 1024 * 1024;
			
			String resources = request.getSession().getServletContext().getRealPath("/resources");

			String savePath = resources + "\\board_upfiles\\";
			
			System.out.println("savePath : "+ savePath);
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			///////
			
			int bno = Integer.parseInt(multiRequest.getParameter("bno"));
			
			Board b = new Board(); //보드 객체 생성
			b.setBoardTitle(multiRequest.getParameter("title"));
			b.setBoardContent(multiRequest.getParameter("content"));
			b.setCategory(multiRequest.getParameter("category"));
			b.setBoardNo(bno);
			
			Attachment at = null;
			if(multiRequest.getOriginalFileName("upfile") != null) { //(기존 파일이 없어서) 새로 첨부하는 파일이 있는가
				String originName = multiRequest.getOriginalFileName("upfile");
				String changeName = multiRequest.getFilesystemName("upfile");
				
				at = new Attachment(); //첨부파일 객체 생성
				at.setFilePath(savePath);
				at.setOriginName(originName);
				at.setChangeName(changeName);
				
				if(multiRequest.getParameter("originFile") != null) {
					
					File deleteFile = new File(savePath + multiRequest.getParameter("originFile"));
					
					deleteFile.delete();
					
					at.setFileNo(Integer.parseInt(multiRequest.getParameter("originFileNo"))); //파일번호 set
					
				}else {//기존의 파일이 없는 경우
					at.setRefBoardNo(bno); //보드 번호 설정
				}
			}
			
			int result = new BoardService().updateBoard(b, at);
			
			if(result > 0) {
				response.sendRedirect("detailBoard.do?bno="+bno);
			}else {
				request.setAttribute("msg", "게시글 수정 실패");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
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
