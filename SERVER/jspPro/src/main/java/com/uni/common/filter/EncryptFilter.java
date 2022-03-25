package com.uni.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.uni.common.wrapper.EncryptWrapper;

/**
 * Servlet Filter implementation class EncryptFilter
 */
//@WebFilter(filterName = "encryptFilter",urlPatterns={"/loginMember.do","/insertMember.do","/updatePwd.do"}) //url맵핑으로 한다면 이렇게 해야한다.
public class EncryptFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncryptFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//Wrapper 전 (암호화 전)
		if(request.getParameter("newPwd") == null) { //newPwd가 null이면 로그인, 회원가입할 때. (패스워드 변경할 때만 newPwd를 사용함)
			request.setAttribute("originPwd", request.getParameter("userPwd")); //originPwd에 로그인할 때 받은 userPwd를 넣어둠
			
			System.out.println("변경전 userPwd : "+ request.getParameter("userPwd"));
		}else { //패스워드를 변경하는 경우에는 userPwd대신 newPwd를 사용한다.
			request.setAttribute("originPwd", request.getParameter("newPwd"));
			
			System.out.println("변경전 newPwd : "+ request.getParameter("newPwd"));
		}
		
		EncryptWrapper encRequest = new EncryptWrapper((HttpServletRequest)request); //암호화 된 request를 encRequest에 담는다.
		
		//Wrapper 후 (암호화 된 값이 들어있음)
		if(request.getParameter("newPwd") == null) {
			
			System.out.println("변경후 userPwd : "+ encRequest.getParameter("userPwd"));
		}else {
			
			System.out.println("변경후 newPwd : "+ encRequest.getParameter("newPwd"));
		}

		chain.doFilter(encRequest, response); //기존의 request가 아닌 변경된(암호화 된) encRequest를 보내야 함
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
