package com.uni.chap02_byte.run;

import com.uni.chap02_byte.model.dao.FileByteTest;

public class Run {
	// 스트림의 특징
	// - 단방향 : 입력이면 입력/ 출력이면 출력만 가능! 입력과 출력을 동시다발적으로 하고자 한다면 하나의 스트림으로 안됨! 입렵스트립, 출력스트림 따로 열어야됨!!
	// - 선입선출 : 통로가 곧 파이프같은 개념이기 때문에 먼저 보낸 값이 먼저 나옴! 시간지연
	
	// 스트림의 구분
	// > 통로의 사이즈(1byte짜리 / 2byte짜리)
	//	- 바이트 스트림 : 1byte짜리 왔다 갔다 할 수 있을 정도의 사이즈! (좁은 통로)	=> 입력(InputStream) / 출력(OutputStream)
	//	- 문자 스트림 : 2byte짜리 왔다 갔다 할 수 있을 정도의 사이즈! (좀 더 넓은 통로)	=> 입력(Reader) / 출력(Writer)
	
	// > 외부 매체와 직접 연결하는 유무
	//	- 기반 스트림 : 외부매체와 직접적으로 연결하는 통로
	//	- 보조 스트림 : 말 그대로 보조역할만 하는 통로 (속도를 빠르게 한다거나, 그 외에 유용한 기능들을 제공 한다거나)
	//			     따라서 보조스트림 단독으로는 사용 불가! 반드시 외부 매체와 연결되어 있는 기반 스트림은 기본적으로 있어야됨!

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileByteTest f = new FileByteTest();
//		f.fileSave();
		f.fileRead();
	}

}
