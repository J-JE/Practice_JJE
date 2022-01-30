package com.uni.chap03_char.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileChatTest {

	public void fileSave() {
		
		
		//FileWriter : 파일로 데이터를 2byte 단위로 출력하기 (한글이 깨지지않는다)
		
	    //1. FileWriter 객체생성 --> 해당 파일이 없으면 자동으로 만들어지고 연결 통로를 만들어준다. 해당 파일이 기존에있으면 연결통로만 연결.
		
		
		FileWriter fw = null;
		try {
			fw = new FileWriter("b_char.txt",false);
			
			fw.write("와 재밌다.");
			fw.write('A');
			fw.write(' ');
			fw.write("\n");
			
			char[] cArr = {'a','p','p','l','e'};
			fw.write(cArr);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fw != null)
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
	
	public void fileOpen() {
		
		//FileReader : 파일로부터 데이터를 2byte단위로 입력받기
		//1.FileReader 객체생성 --> 파일과 연결통로 만들어짐
		FileReader fr =null;
		
		try {
			fr=new FileReader("b_char.txt");
			
//			System.out.println(fr.read());
//			System.out.println(fr.read());
//			System.out.println(fr.read());
//			System.out.println(fr.read());
//			System.out.println(fr.read());
//			System.out.println(fr.read());
//			System.out.println(fr.read());
//			System.out.println(fr.read());

			int value =0;
			while((value = fr.read()) != -1){
				System.out.print((char)value);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fr != null)
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
	
	
	
}
