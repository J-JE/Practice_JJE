package com.uni.ajax;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.uni.model.dto.User;

/**
 * Servlet implementation class JqAjaxServlet6
 */
@WebServlet("/jqTest6.do")
public class JqAjaxServlet6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JqAjaxServlet6() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<User> list = new ArrayList<>();
		
		list.add(new User(1, "유재석", 30, '남'));
		list.add(new User(2, "한지민", 32, '여'));
		list.add(new User(3, "배수지", 31, '여'));
		list.add(new User(4, "송지효", 32, '여'));
		list.add(new User(5, "김종국", 33, '남'));
		
		String keyword = request.getParameter("keyword");
		
		System.out.println(keyword);
		
		JSONArray jArr = new JSONArray();
		JSONObject jsonUser = null;
		
		for(User user: list) {
			if(user.getName().contains(keyword)) {
				jsonUser = new JSONObject();
				
				jsonUser.put("no", user.getNo());
				jsonUser.put("name", user.getName());
				jsonUser.put("age", user.getAge());
				jsonUser.put("gender", user.getGender()+"");
				
				jArr.add(jsonUser);
			}
		}
		
		JSONObject jsonMap = null; //여러개를 보낼 때
		if(keyword != null && jArr != null) {
			jsonMap = new JSONObject();
			
			jsonMap.put("keyword", keyword);
			jsonMap.put("jArr", jArr);
		}
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(jsonMap);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
