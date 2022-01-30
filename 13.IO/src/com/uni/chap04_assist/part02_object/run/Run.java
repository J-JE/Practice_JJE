package com.uni.chap04_assist.part02_object.run;

import com.uni.chap04_assist.part02_object.model.dao.ObjectDao;
import com.uni.chap04_assist.part02_object.model.dao.ObjectsDao;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ObjectDao od = new ObjectDao();
//		od.fileSave();
//		od.fileOpen();
		
		ObjectsDao ods = new ObjectsDao();
		ods.fileSave();
		ods.fileOpen();
		
		
	}

}
