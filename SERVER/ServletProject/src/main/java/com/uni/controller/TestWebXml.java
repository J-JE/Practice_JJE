package com.uni.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestWebXml
 */
public class TestWebXml extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int initCount = 1;
	private int doGetCount = 1;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestWebXml() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메소드는 첫요청시 한번만 호출  : "+ initCount++);
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("톰캣종료시 한번실행");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet 메소드는 요청시 마다 호출  : "+ doGetCount++);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
