package com.uni.common.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncryptWrapper extends HttpServletRequestWrapper{

	public EncryptWrapper(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}

	@Override //HttpServletRequestWrapper를 상속받으면 구현이 가능함
	public String getParameter(String key) {
		
		String value = ""; //value값이 리턴값이기 때문에 전역에서 선언
		
		if(key != null && (key.equals("userPwd")||key.equals("newPwd"))) { //두개의 경우를 제외하고는 암호화 할 필요 없음
			try {
				MessageDigest md = MessageDigest.getInstance("SHA-512");//SHA-512 암호화 객체 이용
				
				
				byte[] bytes = super.getParameter(key).getBytes(Charset.forName("UTF-8"));// 전달받은 비밀번호를 바이트 배열로 받아주기 
				
				md.update(bytes);// md 객체에 변환한 바이트 배열을 전달해서 갱신
				
				value = Base64.getEncoder().encodeToString(md.digest());// java.util.Base64 인코더를 이용하여 암호화된 바이트 배열을 인코딩 과정을통해 문자열로 출력
			}catch(NoSuchAlgorithmException e) {
				e.printStackTrace();
				
			}
		}else {
			value = super.getParameter(key); //암호화가 필요없는 것들은 super를 사용해 그냥 넣어주면 됨
		}
		
		
		return value;
	}

}
