package com.uni.chap04_assist.part03_data.model.dao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataTest {
	// Data outut/input 보조스트림은 
	// 데이터를 읽고 쓰는데 있어서 byte단위가 아닌 기본자료형의 크기로 읽고 쓸수 있다.
	// 단, 각 기본 자료형의 크기가 다르기 때문에 출력한 데이터 순서와 똑같은 순서로 읽어와야된다.

	
	public void fileSaveOpen() {
		
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("d_data.dat"));
				DataInputStream dis = new DataInputStream(new FileInputStream("d_data.dat")) ){
			
			dos.writeUTF("박효신");
			dos.writeInt(94);
			dos.writeChar('A');
			dos.writeBoolean(true);
			dos.writeDouble(15.21);
			
			while(true) {
				System.out.println(dis.readUTF()+ ", "+
									dis.readInt()+ ", "+
									dis.readChar()+ ", "+
									dis.readBoolean()+ ", "+
									dis.readDouble() );
			}
			
		} catch(EOFException e) {
			System.out.println("파일 읽기 완료");
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
