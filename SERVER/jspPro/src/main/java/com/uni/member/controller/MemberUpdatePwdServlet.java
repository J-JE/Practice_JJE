package com.uni.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uni.member.model.dto.Member;
import com.uni.member.model.service.MemberService;

/**
 * Servlet implementation class MemberUpdatePwdServlet
 */
@WebServlet("/updatePwdMember.do")
public class MemberUpdatePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdatePwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId(); //session에 저장된 로그인 유저의 id값을 getAttribute로 받아옴 
		
		String userPwd = request.getParameter("userPwd"); //jsp에서 넘어온 기존 비밀번호 값을 객체에 저장
		String newPwd = request.getParameter("newPwd"); //jsp에서 넘어온 새로운 비밀번호 값을 객체에 저장
//		String originPwd = request.getParameter("newPwd");
		//암호화 필터에서 암호화를 거치기 전에 setAttribute로 originPwd를 설정했음
		//때문에 originPwd에 newPwd를 담으면 암호화된 비밀번호가 화면에 출력됨 -> Wrapper에서 newPwd와 uerPwd는 암호화 됨
		String originPwd = (String)request.getAttribute("originPwd"); //인크립트 필터에서 originPwd
		
		Member updateMem = new MemberService().updatePwd(userId, userPwd, newPwd);
		
		RequestDispatcher view = request.getRequestDispatcher("views/member/pwdUpdateForm.jsp");
		if(updateMem != null) {
			request.setAttribute("sTag", "Y");
			request.setAttribute("msg", "성공적으로 비밀번호를 변경하였습니다.");
			request.getSession().setAttribute("loginUser", updateMem);
			request.getSession().setAttribute("originPwd", originPwd);
		}else {
			request.setAttribute("msg", "비밀번호 변경에 실패했습니다.");
		}
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
