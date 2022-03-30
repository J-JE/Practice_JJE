package com.uni.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class ThumbnailInsertServlet
 */
@WebServlet("/insertThumb.do")
public class ThumbnailInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThumbnailInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(request)) { //멀티파트로 넘어옴
			int maxSize = 10 * 1024 * 1024;
			
			String resources = request.getSession().getServletContext().getRealPath("/resources");

			String savePath = resources + "\\board_upfiles\\";
			
			System.out.println("savePath : "+ savePath);
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			//복사함
			
			//hidden으로 writer 넘어오고 title, content 넘어옴. 받아서 보드 객체 생성
			Board b = new Board();
			String writer = multiRequest.getParameter("writer");
			String title = multiRequest.getParameter("title");
			String content = multiRequest.getParameter("content");
			
			b.setBoardTitle(title);
			b.setBoardContent(content);
			b.setBoardWriter(writer);
			
			ArrayList<Attachment> fileList  = new ArrayList<>(); //파일 받아올 리스트 생성
			
			for(int i = 1; i <= 4; i++) { //업로드 파일 4개임 (1번부터 4번까지)
				String name = "file"+i; //파일 이름이 file1, 2... for문 돌리면서
				
				if(multiRequest.getOriginalFileName(name) != null) { //대표이미지는 들어가야 하기 때문에 null이 아닐 때 돌려야 함
					String originName = multiRequest.getOriginalFileName(name);
					String changeName = multiRequest.getFilesystemName(name);
					
					Attachment at = new Attachment(); //첨부파일 객체 생성
					at.setFilePath(savePath);
					at.setOriginName(originName);
					at.setChangeName(changeName); 
					
					fileList.add(at); //어레이리스트에 첨부파일 담기
				}
			}//for문 밖에서
			int result = new BoardService().insertThumbnail(b, fileList);
			
			if(result > 0) { //성공하면
				response.sendRedirect("listThumb.do");
			}else {
				for(int i = 0; i<fileList.size(); i++){//실패하면 업로드된 파일 삭제해야 함
					File failedFile = new File(savePath + fileList.get(i).getChangeName());
					failedFile.delete();
				}
				request.setAttribute("msg", "사진 게시글 등록 실패");
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
