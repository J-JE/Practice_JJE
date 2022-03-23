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
//@WebFilter(filterName = "encryptFilter",urlPatterns={"/loginMember.do","/insertMember.do","/updatePwd.do"})
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
		if(request.getParameter("newPwd") == null) {
			request.setAttribute("originPwd", request.getParameter("userPwd"));
			
			System.out.println("변경전 userPwd : "+ request.getParameter("userPwd"));
		}else {
			request.setAttribute("originPwd", request.getParameter("newPwd"));
			
			System.out.println("변경전 newPwd : "+ request.getParameter("newPwd"));
		}
		
		EncryptWrapper encRequest = new EncryptWrapper((HttpServletRequest)request); //암호화 된 request를 encRequest에 담는다.
		
		if(request.getParameter("newPwd") == null) {
			
			System.out.println("변경후 userPwd : "+ encRequest.getParameter("userPwd"));
		}else {
			
			System.out.println("변경후 newPwd : "+ encRequest.getParameter("newPwd"));
		}

		chain.doFilter(encRequest, response); //변경된(암호화 된) request인 encRequest로 변경
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
