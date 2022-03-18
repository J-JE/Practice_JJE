package com.uni.cookie.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteCookieServlet
 */
@WebServlet("/deleteCookie.do")
public class DeleteCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie deleteCookie = new Cookie("Id",""); //쿠키 지우기
		
		deleteCookie.setMaxAge(0); //유효기간
		
		response.addCookie(deleteCookie);
		
		String html = "<html>";
		html+="<body>";
		html+="<h1>현재사이트에서 저장한 쿠키값 </h1>";
		html+="<ul>";
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie c : cookies) {
				html += "<li>"+c.getName()+" : "+c.getValue()+"</li>";
			}
		}
		
		html+="</ul>";
		html+="<button onclick='location.replace(\"deleteCookie.do\");'>쿠키값 삭제하기 </button>";//replace : 변경이전 페이지로 이동이 불가능 
		html+="<button onclick=\"history.back();\">이전 페이지로</button>";
		html+="<button onclick=\"history.go(-1);\">이전(go-1) 페이지로</button>";
		html+="<button onclick=\"history.go(0);\">새로고침</button>";
		html+="<button onclick='location.replace(\"/\");'>메인으로</button>";
		System.out.println(request.getContextPath()); //빈 문자열이 뜸 -> 다시 공부하기
		html+="</body>";
		html+= "</html>";
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
