package com.uni.mybatis.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uni.mybatis.member.model.dto.Member;
import com.uni.mybatis.member.model.service.MemberService;
import com.uni.mybatis.member.model.service.MemberServiceImpl;

/**
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/insertMember.do")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//다형성을 활용해서 부모타입이지만 자식 타입으로 생성
	private MemberService memberService = new MemberServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8"); //한글 입력값이 있을 수 있기 때문에 인코딩 (post
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String birthday = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		Member m = new Member(userId, userPwd, userName, email, birthday, gender, phone, address);
	
		try {
			memberService.insertMember(m);
			response.sendRedirect(request.getContextPath()); //메인화면으로 돌려보내기
		} catch (Exception e) {
			request.setAttribute("msg", "회원가입에 실패하였습니다.");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);

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
