package com.uni.part01.object_vs_objectArray.run;

import com.uni.part01.object_vs_objectArray.model.vo.Product;

public class ObjectArrayTest2 {

	public static void main(String[] args) {
		Product[] arr =new Product[3];
		
		arr[0]=new Product("갤럭시",1000,"삼성");
		arr[1]=new Product("갤럭시1",2000,"삼성1");
		arr[2]=new Product("갤럭시2",3000,"삼성2");
		
		//for each문 사용해서 출력
		for(Product p :arr) {
			System.out.println(p.information());
		}
	}

}
