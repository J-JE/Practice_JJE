package com.uni.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.uni.model.dto.User;

/**
 * Servlet implementation class JqAjaxServlet4
 */
@WebServlet("/jqTest4.do")
public class JqAjaxServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JqAjaxServlet4() {
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
		
		
		int input = Integer.parseInt(request.getParameter("input"));
		
		User findUser = null; //찾은 유저를 담기 위헤 객체 생성, jar 받아서 폴더에 넣기
		JSONObject jsonUser = null;
		
		for(int i = 0; i <list.size(); i++) {
			if(list.get(i).getNo() == input) {
				findUser = list.get(i);
				
				jsonUser = new JSONObject();
				jsonUser.put("no", findUser.getNo());
				jsonUser.put("name", findUser.getName());
				jsonUser.put("age", findUser.getAge());
				jsonUser.put("gender", findUser.getGender()+""); //char형이라 문자형으로 형변환
			
			
			}
		}
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
//		System.out.println(jsonUser.toJSONString()); 값이 있으면 상관 없지만 없는 경우 null처리를 해야 함
//		System.out.println(jsonUser.toString()); 안그러면 오류
		System.out.println(jsonUser); //값이 없으면 "null"을 띄움
		
		out.print(jsonUser); //때문에 자바 객체를 그냥 내보낼 수 없음, json에 담아 보내야 함
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
