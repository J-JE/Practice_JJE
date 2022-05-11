package com.uni.spring.board.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.uni.spring.board.model.dto.Board;
import com.uni.spring.board.model.dto.PageInfo;
import com.uni.spring.board.model.service.BoardService;
import com.uni.spring.common.CommException;
import com.uni.spring.common.Pagination;

@Controller
public class BoardController {
	
	@Autowired
	public BoardService boardService; //왜 public? private?
	
	@RequestMapping("listBoard.do")
	public String selectList(@RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage, Model model) {
		
		//@RequestParam(value="currentPage") int currentPage -> 값이 넘어오지 않아 에러 발생
		
		//@RequestParam(value="currentPage", required = false) int currentPage
		//required : 해단 파라미터가 필수인지 여부 (기본값 true : 필수)
		//required = false : 값을 꼭 받아줄 필요가 없다고 선언. -> null이 들어올 수 있다. (기본자료형이기 때문이다.)
		//--> null은 기본형 int에 들어갈 수 없기 떄문에 에러 발생
		
		//@RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage
		//defaultValue : 넘어오는 값이 null인 경우 해당 파라미터에 기본값을 지정
		
		int listCount = boardService.selectListCount();
		System.out.println(listCount);
		
//		int pageLimit = 10; //페이지 수
//		int boardLimit = 5; //게시글 수
//		PageInfo pi = Pagination.getPageInfo(listCount, currentPage, pageLimit, boardLimit);
		
		PageInfo pi = Pagination.getPageInfo(listCount, currentPage, 10, 5);
		
		ArrayList<Board> list = boardService.selectList(pi);
		
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		
		return"board/boardListView";
	}
	
	@RequestMapping("enrollFormBoard.do")
	public String enrollForm() {
		return "board/boardEnrollForm";
	}
	
	@RequestMapping("insertBoard.do")
	public String insertBoard(Board b/*파라미터값이 많음*/, HttpServletRequest request, @RequestParam(name="uploadFile", required = false) MultipartFile file/*upload파일은 보드객체로 받을 수 없음*/) {
		System.out.println(b);
		System.out.println(file.getOriginalFilename()); //NullPointerException -> savePath, fileSize 등 설정을 해야 함 pom.xml에 라이브러리 추가 , root-context.xml
		//=> "MultipartResolver가 Muiltpart객체를 컨트롤러에 전달하는 역할을 한다" (지수님)
		//반드시 파일 업로드를 할 때는 jsp의 form 태그안에 enctype = multipart/form-data로 작성해야하고, method = post여야 한다.
		//=> 그래야 MultipartResolver가 multipartFile객체를 컨트롤러에 전달할 수 있다. 
		
		if(!file.getOriginalFilename().equals("")) { //첨부파일이 빈값이 아니라면
			//파일 저장 경로 지정하고 파일 이름 네임폴리시->메소드로 빼서 사용하자!
			String changeName = saveFile(file, request); //오리지널 파일과 리퀘스트를 메소드에 넘기기
			
			if(changeName != null) {//잘 업로드 됐으면 null이 아닐 것
				b.setOriginName(file.getOriginalFilename());
				b.setChangeName(changeName);
			}
			
			boardService.insertBoard(b);
			
		}
		return "redirect:listBoard.do";
	}

	//전달받은 파일을 업로드 시키고 수정된 파일명을 반환하는 메소드
	private String saveFile(MultipartFile file, HttpServletRequest request) {
		
		String resources = request.getSession().getServletContext().getRealPath("resources"); //웹컨테이너 안에있는 리소스의 경로를 추출해서 담기
		//System.out.println("확인 : " + request.getSession().getServletContext()); 
		//org.apache.catalina.core.ApplicationContextFacade @6bb44c08
		//System.out.println("확인 : " + request.getSession().getServletContext().getRealPath("resources"));
		//C:\FWORK\spring1\SpringP\src\main\webapp\resources 
		String savaPath = resources + "\\upload_files\\"; //업로드 경로 (이스테이프 문자로 "\" 두번 쓰기)
		
		String originName = file.getOriginalFilename();
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()); //util.Date
		
		String ext = originName.substring(originName.lastIndexOf(".")); //.이 있는 인덱스를 구해서 그 뒤까지 전부 가져오기 (확장자 가져오기)

		String changeName = currentTime+ext; //합치기
		System.out.println("changeName : "+changeName); //콘솔 출력
		
		//transferTo 매개변수 안에 있는 메소드를 업로드 해주는 메소드
		try {
			file.transferTo(new File(savaPath+changeName)); // 파일 생성해서 업로드 (이름 바꾼 파일을 업로드)
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			throw new CommException("file Upload Error");//에러가 발생한 경우
		} 
		return changeName;
	}
	
	@RequestMapping("detailBoard.do")
	public ModelAndView selectBoard(int bno, ModelAndView mv) {
		
		Board b = boardService.selectBoard(bno);
		mv.addObject("b", b).setViewName("board/boardDetailView"); //조회한 객체와 화면을 동시에 반환
		return mv;
	}
	
	@RequestMapping("updateFormBoard.do")
	public ModelAndView updateForm(int bno, ModelAndView mv) {
		mv.addObject("b",boardService.selectBoard(bno))
		.setViewName("board/boardUpdateForm");
		return mv;
	}
	
	@RequestMapping("updateBoard.do")
	public ModelAndView updateBoard(Board b, ModelAndView mv, HttpServletRequest request,
									@RequestParam(name = "reUploadFile", required=false)MultipartFile file) {
		
		//이전에 업로드 된 파일이 있는지 확인하는 과정이 있어야 함
		/*
		 * 1. 기존의 첨부파일 X, 새로 첨부된 파일 X 	
		 * 	  --> originName : null, changeName : null
		 * 
		 * 2. 기존의 첨부파일 X, 새로 첨부된 파일 O		
		 * 	  --> 서버에 업로드 후 
		 * 	  --> originName : 새로첨부된파일원본명, changeName : 새로첨부된파일수정명
		 * 
		 * 3. 기존의 첨부파일 O, 새로 첨부된 파일 X		
		 * 	  --> originName : 기존첨부파일원본명, changeName : 기존첨부파일수정명
		 * 
		 * 4. 기존의 첨부파일 O, 새로 첨부된 파일 O  
		 * 	  --> 서버에 업로드 후	
		 * 	  --> originName : 새로첨부된파일원본명, changeName : 새로첨부된파일수정명
		 */

		String orgChangeName = b.getChangeName(); //기존 첨부 파일
		
		if(!file.getOriginalFilename().equals("")) { //새로 등록된 파일이 있는 경우
			
			String changeName = saveFile(file, request); //saveFile메소드에 오리지널 파일과 리퀘스트를 메소드에 넘기기 ()
			
			b.setOriginName(file.getOriginalFilename());
			b.setChangeName(changeName);
			
		}
		
		boardService.updateBoard(b);
		
		//기존 파일을 지우는 경우
		if(orgChangeName != null) {
			//게시글 삭제할 때도 사진 지워질것, 공통으로 메소드 만들어놓기
			deleteFile(orgChangeName, request); //request를 넘기는 이유
		}
		
		mv.addObject("bno", b.getBoardNo()).setViewName("redirect:detailBoard.do"); //boardDetailView에 가기 위해서는 bno가 필요함
		//redirect -> url 호출, forward -> jsp
		return mv;
	}

	//첨부파일 삭제 메소드
	//파일 삭제 메소드
	private void deleteFile(String orgChangeName, HttpServletRequest request) {

		String resources = request.getSession().getServletContext().getRealPath("resources"); //웹컨테이너 안에있는 리소스의 경로를 추출해서 담기
		String savaPath = resources + "\\upload_files\\"; //업로드 경로
		
		File deleteFile = new File(savaPath+orgChangeName); //삭제할 파일(오리지날 파일) 생성
		
		deleteFile.delete();
	}
	
	@RequestMapping("deleteBoard.do")
	public String deleteBoard(int bno, String fileName, HttpServletRequest request) {
		
		//글 삭제
		boardService.deleteBoard(bno);

		//첨부파일 삭제
//		if(fileName != null) {
		if(!fileName.equals("")/* != null*/) { //changeName
			deleteFile(fileName, request);
		}
		
		//메인으로
		return "redirect:listBoard.do";
	}
}
