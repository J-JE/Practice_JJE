package com.uni.chap02_stringBuffer_stringBuilder.run;

public class Run {

	public static void main(String[] args) {
//		method1();
//		method2();
//		method3();
		method4();
	}

	private static void method4() {
		StringBuffer stringBuffer = new StringBuffer();
		StringBuilder stringBuilder = new StringBuilder();
		new Thread(() -> {
			int a = 0;
		    for(int i=0; i<10000; i++) {
		    	
		    	a = i;
		        stringBuffer.append(1);
		        stringBuilder.append(1);
		    }
		   System.out.println(a+1);
		}).start();

		new Thread(() -> {
			int b = 0;
		    for(int i=0; i<10000; i++) {
		    
		    	b=i;
		        stringBuffer.append(1);
		        stringBuilder.append(1);
		    }
		    System.out.println(b+1);
		}).start();

		new Thread(() -> {
		    try {
		        Thread.sleep(5000);
		        
		        System.out.println("StringBuffer.length: "+ stringBuffer.length());
		        System.out.println("StringBuilder.length: "+ stringBuilder.length());
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		}).start();

		}

	private static void method3() {
		StringBuilder sb = new StringBuilder("난");
		
		//append : 뒤에 값을 추가
		sb.append("배가고프다").append("!!!!"); //메소드 체이닝 : 여러 메소드를 이어서 호출하는 문법
		
		System.out.println(sb);
		System.out.println(sb.capacity());
		System.out.println(sb.length());
		
		sb.insert(1, "저녁시간 전이라");
		System.out.println(sb);
		
		sb.delete(0, 9);
		System.out.println(sb);
		
		sb.reverse();
		System.out.println(sb);
	}

	private static void method2() {
		
		String str = "반가워";
		System.out.println("str 기존 : "+str +" 주소 : "+ System.identityHashCode(str));
		str +="난 스트링이라고해 ";
		System.out.println("str 변경후 : "+str +" 주소 : "+ System.identityHashCode(str));
		
		StringBuffer sbf = new StringBuffer("안녕~~");
		System.out.println("sbf 기존 : "+sbf + " 주소 : "+ System.identityHashCode(sbf));
		sbf.append("난 스트링 버퍼야");
		System.out.println("sbf 변경후 : "+sbf + " 주소 : "+ System.identityHashCode(sbf));
		
		StringBuilder sbd = new StringBuilder("Wow");
		System.out.println("sbd 기존 : "+sbd + " 주소 : "+ System.identityHashCode(sbd));
		sbd.append("난 스트링 빌더야");
		System.out.println("sbd 변경후 : "+sbd + " 주소 : "+ System.identityHashCode(sbd));
		
	}

	private static void method1() {
		
		StringBuilder sb= new StringBuilder("놀면뭐하니");
		
		System.out.println(sb.capacity());//sb의 크기
		System.out.println(sb.length());//sb 문자열의길이
		
		StringBuilder sb1 = new StringBuilder(20);// 기본 메모리 확보 크기를 정해서 생성할 수 있다.
		System.out.println(sb1.capacity());
		
	}

}
