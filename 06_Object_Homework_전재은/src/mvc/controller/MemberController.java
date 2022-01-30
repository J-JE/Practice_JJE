package mvc.controller;

import mvc.model.vo.Member;

public class MemberController {
	
	private Member mem = new Member("admin", "1234", "홍길동", "901022-1562334", 163.0);

	public MemberController() { //기본생성자
		// TODO Auto-generated constructor stub
	}
	
	public int login(String id, String pwd) {
		// 전달받은 id, pwd값과 mem의 memberId와 memberPwd 비교했을 때
		// 모두 같으면 1을 리턴
		// 아니면 0을 리턴

		if(mem.getMemberId().equals(id) && mem.getMemberPwd().equals(pwd)) {//문자열은 equals()메소드로 비교
			return 1;
		}else {
			return 0;
		}
		
	}
	
	public Member readInfo() {
		// mem의 주소 값을 리턴
		return mem;
	}
	
	public int readAge() {
		// mem의 주민번호의 앞 2자리를 추출해서 출생년도를 알아낼 것
		//HINT : String클래스의 substring() 메소드, Integer클래스의 parseInt() 메소드 참고

		//substring->(시작 인덱스, 끝 인덱스-1)
		String str =mem.getCitizenNo().substring(0, 2);
		//parseInt()-> 숫자형의 문자열을 10진수 정수형으로 변환
		int num = Integer.parseInt(str);
		
		// 나이 = 올해년도 – 출생년도 + 1 ( 어떤 조건이 필요한지 생각해보시오 )
		// 구한 나이 값 리턴
		
		int age = 2021 -(1900+num)+1;
		
		return age;
	}
	
	public void updateHeight(double height) {
		// 전달 받은 height값으로 mem의 height값 수정
		mem.setHeight(height);//view에서 입력 받음
	}
}
