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
import com.uni.member.model.dto.Member;

/**
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet("/insertBoard.do")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(request)) {//encType이 멀티포트로 잘 넘어간 경우에만 실행할것임
//			1. 전송된 파일들을 처리할 작업 내용 (전송되는 파일의 용량 제한, 전달된 파일을 저장할 폴더 경로) //제일 먼저 해야하는 것이 파일의 사이즈를 정의하는 것
			
//			   1_1. 전송파일 용량 제한 (int maxSize)
//					: 10Mbyte로 제한  ([참고] cos.jar로 파일 업로드 시 최대 2기가(1.6)까지만 가능)
//					1Kbyte = 1024byte (킬로바이트)
//					1Mbyte = 1024Kbyte = 1024 * 1024 byte (메가바이트)
//					1Gbyte = 1024Mbyte = 1024 * 1024 * 1024 Byte (기가바이트)
//					10Mbyte = 10 * 1024 * 1024 byte
			
			int maxSize = 10 * 1024 * 1024;
			
//			1_2. 전달된 파일을 저장할 서버의 폴더 경로 //원래는 파일이 저장될 서버의 폴더 경로 지정 원래는 첨부파일 저장하는 서버가 따로 있음
			String resources = request.getSession().getServletContext().getRealPath("/resources");
			//저장할 페스를 바로 지정하기
			String savePath = resources + "\\board_upfiles\\";
			
			System.out.println("savePath : "+ savePath);
			
//			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy()); //DefaultFileRenamePolicy은 파일 저장할 때 한글 이름으로 하는 경우(?), 같은 이름의 파일이면 뒤에 (1)이 붙게함
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
//			System.out.println(multiRequest.getOriginalFileName("upfile")); //넘어온 파라미터는 앞에서 넘어온 이름 그대로 써야함
//			System.out.println(multiRequest.getFilesystemName("upfile")); //바뀐 파일 이름
			
			String category = multiRequest.getParameter("category");
			String title = multiRequest.getParameter("title");
			String content = multiRequest.getParameter("content");
			
			int userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
			
			Board b = new Board(); //게시글 객체 생성자에 원하는게 없으면 기본생성자 쓰고 set사용하기
			b.setCategory(category);
			b.setBoardTitle(title);
			b.setBoardContent(content);
			b.setBoardWriter(String.valueOf(userNo)); //userNo를 String타입으로 변환해서 넣어주기
			
			Attachment at = null;
			if(multiRequest.getOriginalFileName("upfile") != null) {
				String originName = multiRequest.getOriginalFileName("upfile");
				String changeName = multiRequest.getFilesystemName("upfile");
				
				System.out.println("originName : "+originName);
				System.out.println("changeName : "+changeName);
				
				at = new Attachment();
				at.setFilePath(savePath);
				at.setOriginName(originName);
				at.setChangeName(changeName);
			}
			
			int result = new BoardService().insertBoard(b, at);
			
			if(result > 0) {
				request.getSession().setAttribute("msg", "게시글이 성공적으로 등록되었습니다.");
				response.sendRedirect("listBoard.do");
			}else {
				if(at != null) {//파일 지우기
					File faildFile = new File(savePath+ at.getChangeName());
					faildFile.delete();
				}
				
				request.setAttribute("msg", "게시글 등록에 실패했습니다.");
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
