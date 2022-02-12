package mvc.controller;

import mvc.model.vo.Member;

public class MemberController {
	
	public int SIZE =10;
	
	private int memberCount = 0;
	private Member[] mem =new Member[SIZE];
	
	{
		mem[0] = new Member("user01", "pass01", "김유신", 20, 'M', "kim12@naver.com");
		mem[1] = new Member("user02", "pass02", "이순신", 60, 'M', "lee2@naver.com");
		mem[2] = new Member("user03", "pass03", "유관순", 17, 'F', "yo5@hanmail.net");
		mem[3] = new Member("user04", "pass04", "연개소문", 57, 'M', "yeon@gmail.com");
		mem[4] = new Member("user05", "pass05", "신사임당", 45, 'F', "shin@naver.com");
		memberCount = 5;

	}

	public int getMemberCount() {
		// memberCount 리턴
		return memberCount;
	}
	
	public Member[] getMem() {
		// mem 주소 값 리턴
		return mem;
	}

	
	public Member checkId(String userId) {
		// 아이디로 검색된 결과를 담을 변수 초기화
		Member m = null;
		
		// mem 에서 매개변수로 전달받은 userId와 동일한 아이디를 가지고 있는 회원을 m에 대입
		for(int i=0; i<memberCount;i++) {
			if(mem[i].getUserld().equals(userId)) {
				m= mem[i];
			}
		}
		// m 리턴
		return m;
	}
	
	public void insertMember(Member m) {
		// 매개변수로 전달받은 회원객체를 mem 배열에 추가
		if(memberCount<=SIZE) {
			mem[memberCount++]=m;
		}else {
			System.out.println("더이상 추가할 수 없습니다.");
		}
		// memberCount 1 증가
		
	}
	
	
	public Member searchMember(int menu, String search) {
		Member searchMember = null; // 검색된 회원 정보를 담을 변수 초기화
		// 매개변수로 전달받은 search 문자열을 menu 번호에 따라
		// 1 인 경우 아이디로 검색 후 결과를 searchMember에 대입하고
		// 2 인 경우 이름으로 검색 후 결과를 searchMember에 대입하고
		// 3 인 경우 이메일로 검색 후 결과를 searchMember에 대입하고
		// searchMember 주소 값 리턴
		
		switch(menu) {
		case 1 :
			for(int i=0; i<memberCount;i++) {
				if(mem[i].getUserld().equals(search)) {
					return mem[i];
				}
			}break;
		case 2 :
			for(int i=0; i<memberCount;i++) {
				if(mem[i].getName().equals(search)) {
					return mem[i];
				}
			}break;
		case 3 :
			for(int i=0; i<memberCount;i++) {
				if(mem[i].getEmail().equals(search)) {
					return mem[i];
				}
			}break;
		}
		return null;
	}
	
	
	public void updateMember(Member m, int menu, String update) {
		// 매개변수로 전달받은 m 회원과 변경 내용인 update 문자열을 menu에 따라
		// 1 인 경우 setter 메소드를 이용하여 m의 비밀번호를 update 문자열로 변경
		// 2 인 경우 setter 메소드를 이용하여 m의 이름을 update 문자열로 변경
		// 3 인 경우 setter 메소드를 이용하여 m의 이메일을 update 문자열로 변경
		
		switch(menu) {
		case 1:
			for(int i=0;i<memberCount;i++) {
				if(mem[i].getUserld().equals(m.getUserld())) {
					mem[i].setUserPwd(update);
				}
			}
			break;
		case 2 :
			for(int i=0;i<memberCount;i++) {
				if(mem[i].getUserld().equals(m.getUserld())) {
					mem[i].setName(update);
				}
			}
			break;
		case 3 :
			for(int i=0;i<memberCount;i++) {
				if(mem[i].getUserld().equals(m.getUserld())) {
					mem[i].setEmail(update);
				}
			}
			break;
		}
	}
	
	
	public void deleteMember(String userId) {
		// 매개변수로 전달받은 userId가 mem에 존재하는 경우 해당 회원 삭제 후
		for(int i=0; i<memberCount;i++) {
			if(mem[i].getUserld().equals(userId)) {
				mem[i]=null;
				memberCount--;
			}
		}
		
		// 다음 인덱스 객체들의 정보를 한 칸씩 앞으로 이동 시킴
		// 실행 시 NullPointerException 발생할 수 있음 -> 왜 그런지 생각해보고 해결하시오
		// memberCount 1 감소
		for(int i=0; i<memberCount+1;i++) {
			if(mem[i]==null) {
				
				Member temp=mem[i];
				mem[i]=mem[i+1];
				mem[i+1]=temp;
			}
		}
	}
	
//	public void deleteMember2(String userId) {
//		
//		// 현재 회원수만큼 반복
//		for(int i=0; i<memberCount; i++) {
//			
//			 // 해당 순차적으로 접근한 객체의 아이디와 전달된 삭제할 회원의 아이디와 비교
//			if(mem[i].getUserld().equals(userId)) {// 일치하는 회원 찾았을 경우 
//				
//				// 만약 해당 회원이 마지막 회원이였을 경우
//				if(i == memberCount-1) {
//					mem[i] = null; // 해당 회원 삭제만하면 됨 (null로 대입)
//					
//				}else { // 만약 해당 회원이 마지막 회원이 아닌 중간에 있었던 회원이였을 경우 => 뒤에 있는 회원들을 한칸씩 앞으로 땡겨야 된다.
//					
//					// 뒤에 있었던 회원들을 한칸씩 앞으로 땡기는 작업
//					for(int j=i; j<memberCount-1; j++) {
//						mem[j] = mem[j+1];
//					}
//					mem[memberCount - 1] = null; // 그리고 마지막이였던 회원은 null로
//				}
//				
//				memberCount--; // 삭제했으니깐 memberCount 1감소
//				
//				break; // 삭제 한 후 이 반복문 빠져나가야됨
//				
//			}
//			
//		}
//		
//	}
	
	public Member[] sortIdAsc() {
		// 기존의 회원 객체 배열(mem)을 변경하지 않고 단지 정렬된 결과만을 보여주기 위해
		// 기존의 배열 복사해서 사용 (clone(), System.arraycopy() 둘 중 하나 사용해서 복사) 
		Member[] copy =mem.clone();
		
		// copy 배열을 아이디 별 오름차순 정렬 진행 
		// --> HINT : String 클래스의 compareTo() 메소드 활용
		for(int i=0;i<memberCount;i++) {
			for(int j=0;j<i;j++) {
				int num=copy[i].getUserld().compareTo(copy[j].getUserld());
				if(num<0) {
					Member tmp=copy[i];
					copy[i]=copy[j];
					copy[j]=tmp;
				}
			}
		}
		// copy 주소 값 리턴
		return copy;
	}
	
	
	public Member[] sortIdDesc() {
		// 위와 동일한 방식이지만 내림차순으로 정렬 후 주소 값 리턴
		Member[] copy =mem.clone();
		for(int i=0;i<memberCount;i++) {
			for(int j=0;j<i;j++) {
				int num=copy[i].getUserld().compareTo(copy[j].getUserld());
				if(num>0) { //여기만 다름
					Member tmp=copy[i];
					copy[i]=copy[j];
					copy[j]=tmp;
				}
			}
		}
		return copy;
	}
	
	
	public Member[] sortAgeAsc() {
		// 위와 동일한 방식이지만 나이별 오름차순 정렬 후 주소 값 리턴
		// (숫자 비교이기 때문에 compareTo 사용X)
		Member[] copy =mem.clone();

		for(int i=0;i<memberCount;i++) {			
			for(int j=0;j<i;j++) {
				if(copy[i].getAge() < copy[j].getAge()) {
					Member tmp=copy[i];
					copy[i]=copy[j];
					copy[j]=tmp;
				}
			}
		}
		return copy;
	}
	
	
	public Member[] sortAgeDesc() {
		// 위와 동일한 방식이지만 내림차순으로 정렬 후 주소 값 리턴
		Member[] copy =mem.clone();

		for(int i=0;i<memberCount;i++) {			
			for(int j=0;j<i;j++) {
				if(copy[i].getAge() > copy[j].getAge()) {
					Member tmp=copy[i];
					copy[i]=copy[j];
					copy[j]=tmp;
				}
			}
		}
		return copy;
	}
	
	
	public Member[] sortGenderDesc() {
		// 위와 동일한 방식이지만 성별 별 내림차순으로 정렬 후 주소 값 리턴
		// (남여 순으로 정렬)
		Member[] copy =mem.clone();
		for(int i=0;i<memberCount;i++) {			
			for(int j=0;j<i;j++) {
				if(copy[i].getGender()=='M' && copy[j].getGender()=='F') {
					Member tmp=copy[i];
					copy[i]=copy[j];
					copy[j]=tmp;
				}
			}
		}
		return copy;
	}
	
}
