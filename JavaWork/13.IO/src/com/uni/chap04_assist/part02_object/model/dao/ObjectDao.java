package com.uni.chap04_assist.part02_object.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.uni.chap04_assist.part02_object.model.vo.Phone;

public class ObjectDao {

	
	public void fileSave() {
		//객체를 파일에 출력할때 사용되는 스트림
		//FileOutputStream : 파일출력에 사용되는 기반 바이트 스트림 클래스
		//ObjectOutputStream : 객체 단위로 출력시 사용되는 보조 바이트 스트림 클래스

		Phone ph =new Phone("삼성", 2000);
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("phone.txt"))){
			
			
			oos.writeObject(ph);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void fileOpen() {
		//FileInputStream : 파일로부터 데이터를 읽어들이기 위해  사용되는 기반 바이트 스트림 클래스
		//ObjectInputStream : 스트림으로 부터 객체 단위로 읽어들이기 위해 사용되는 보조 바이트 스트림 클래스
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("phone.txt"))){
			
			Phone ph =(Phone)ois.readObject();
			System.out.println(ph.toString());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
