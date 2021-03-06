package com.uni.spring.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.uni.spring.model.dto.Singer;
import com.uni.spring.model.dto.SingerMgt;

/**
 * Servlet implementation class DependencyServlet1
 */
@WebServlet("/dependency.do")
public class DependencyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DependencyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*IOC & DI :
		 *  개발자가 직접 new 하여 객체를 생성하던 방식에서 
		 *  개발자의 부담을 덜어주며, 보다 편하게 개발 가능하도록 스프링 자체에서 객체를 생성, 수정, 삭제 (소멸 ) 하도록 구현한 기술 	 */

		//1. 일반 클래스 생성 - 버전1에서 버전2로 변경시 모든 내용을 변경해야하는 경우가 생김, 이를 결합도가 높다고 표현 -> 유지보수 어려움
		
		/*Twice singer = new Twice();
		singer.sing();
		singer.compose();*/
		
		/*Blackpink singer = new Blackpink();
		singer.sing();
		singer.compose();*/
		
		//2. 인터페이스를 사용해서 결합도를 낮추기
		
		/*Singer singer = new Blackpink(); //new 부분만 바꾸면 됨
		singer.sing();
		singer.compose();
		singer.dance();*/
		
		//3. 전략 디자인 패턴으로 결합도 낮추기 (전달받은 값에 따라서 바뀌는 방법) - 전달받은 값에 따라 해당하는 객체를 생성해주는 방식(이런 구조의 beanFactory를 스프링이 제공)
		
		/*Singer singer = (Singer)BeanFactory.getBean(request.getParameter("bean"));
		singer.sing();
		singer.compose();
		singer.dance();*/
		
		//4. 스프링 컨테이너를 사용한 객체 생성하기  (xml)-xml문서를 읽어들여 객체에 대한 결합도를  xml파일에 양도 (제어의 역전) -> 개발자 중심의 코드가 아닌 스프링 프레임워크 중심의 제어의 반전(IoC)
		
		AbstractApplicationContext cntx = new GenericXmlApplicationContext("/sample-context.xml"); //xml을 읽어서 컨테이너 역할
		
		Singer singer = (cntx.getBean("singerMgt", SingerMgt.class)).getSinger(); //xml에 설정되어있는 bean을 통해서 객체 생성
//		Singer singer = ((SingerMgt) cntx.getBean("singerMgt")).getSinger();
		
		singer.sing();
		singer.compose();
		singer.dance();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
