package com.uni.variable;

public class C_Overflow {

	public void printVariablesize() {
		
		System.out.println("byte의 크기  : "+ Byte.BYTES + "byte");
		System.out.println("short의 크기  : "+ Short.BYTES + "byte");
		System.out.println("int의 크기  : "+ Integer.BYTES + "byte");
		System.out.println("long의 크기  : "+ Long.BYTES + "byte");
		System.out.println("float의 크기  : "+ Float.BYTES + "byte");
		System.out.println("double의 크기  : "+ Double.BYTES + "byte");
		System.out.println("char의 크기  : "+ Character.BYTES + "byte");

	}
	
	public void ocerflow() {
		byte bNum = 127;
		System.out.println(bNum);
		
		
		byte result = (byte) (bNum + 3); //130 // -128 -127 -126
		System.out.println("result :" + result);
		
		int num1 = 1000000; //100만
		int num2 = 700000;  //70만
		
		int result2 = num1 * num2; //7조 
		System.out.println("result2 :" + result2);
		
		long result3 = (long)num1 * num2; //이미 곱셈자체에서 int 형으로 결과가 나오기 때문에 그 순간 이미 오버플로우가 발생했다.
										  //그래서 둘중 하나라도 long 형으로 강제 형변환을 시켜줘야한다.
		System.out.println("result3 :" + result3);

	}
	
}
