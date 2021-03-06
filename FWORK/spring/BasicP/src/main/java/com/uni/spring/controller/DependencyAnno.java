package com.uni.spring.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.uni.spring.model.anno.dto.Person;

/**
 * Servlet implementation class DependencyAnno
 */
@WebServlet("/annoDI.do")
public class DependencyAnno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DependencyAnno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 어노테이션을 활용한 객체 의존성 주입
		 * 어노테이션이 붙은 클래스를 탐색해서 컨테이너에 자동으로 등록(컴포넌트 스캔) 
		 * 
		 * @Component(클래스) , @Bean(메소드, @Configuration)
		 * 
		 * */

		/*AbstractApplicationContext cntx = new AnnotationConfigApplicationContext(BeanFactory.class);
		
		Person2 p = (Person2) cntx.getBean("createPerson"); //메소드명으로 겟빈
		
		p.getMyFood().eat("태리");
		System.out.println(p);
		
		Person2 p2 = (Person2) cntx.getBean("createPerson2"); //메소드명으로 겟빈
		
		p2.getMyFood().eat("푸라닭");
		System.out.println(p2);*/
		
		AbstractApplicationContext cntx = new GenericXmlApplicationContext("/di-anno-context.xml");
		
		Person p = (Person)cntx.getBean("person");
		p.getMyFood().eat("굽네");
		
		System.out.println(p);

		System.out.println(cntx.isActive()); //활성화 여부
		
		cntx.close(); //강제로 닫기
		System.out.println(cntx.isActive()); //활성화 여부 ->false
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
