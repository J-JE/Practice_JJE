package mvc.controller;

import mvc.model.vo.Book;
import mvc.model.vo.AniBook;
import mvc.model.vo.CookBook;
import mvc.model.vo.Member;

public class LibraryManager {

	private Member mem =null;
	private Book[] bList = new Book[5];
	int couponCount =0;

	{ // 초기화 블록을 이용하여 샘플 데이터 초기화
		bList[0] = new CookBook("백종원의 집밥", "백종원", "tvN", true);
		bList[1] = new AniBook("한번 더 해요", "미티", "원모어", 19);
		bList[2] = new AniBook("루피의 원피스", "루피", "japan", 12);
		bList[3] = new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false);
		bList[4] = new CookBook("최현석 날 따라해봐", "최현석", "소금책", true);
		}

	
	/*전달받은 mem을 LibraryManager의 mem에 대입*/
	public void insertMember(Member mem) {
		// 전달받은 mem 주소 값을 해당 회원 레퍼런스(mem)에 대입
		this.mem=mem;
	}
	
	
	/*회원 레퍼런스(mem) 리턴*/
	public Member myInfo() {
		// 회원 레퍼런스(mem) 주소 값 리턴
		return mem;
	}
	
	
	/*도서 전체 목록 (bList) 주소 값 리턴*/
	public Book[] selectAll() {
		// 도서 목록 레퍼런스(bList) 주소 값 리턴
		return bList;
	}
	
	
	/*전달받은 키워드가 포함된 도서가 여러개가 존재할 수 있으니
	 * 검색된 도서를 담아줄 Book 객체 배열을 새로이 생성하고
	 * for문을 통해 bList 안의 도서들과 전달받은 키워드를 비교하여
	 * 포함하고있는 경우 새로운 배열에 차곡차곡 담기
	 * -> 그 배열 주소 값 리턴*/
	public Book[] searchBook(String keyword) {
		// 검색 결과를 담아줄 새로운 Book 객체 배열 생성
		// 검색 결과 도서 목록이 최대 5개일 수 있으니 임의로 크기 5 할당
		Book[] b = new Book[5];
		
		// for문을 이용하여 bList 도서 목록들의 도서명과 전달받은 keyword 비교
		// 전달받은 keyword를 포함하고 있으면  HINT : String 클래스의 contains() 참고
		// 검색결과의 도서목록에 담기  HINT : count 이용
		int count =0;
		for(int i =0; i<b.length;i++) {
			if(bList[i].getTitle().contains(keyword)) {
				b[count++]=bList[i];
			}
		}
		// 해당 검색결과의 도서목록 주소 값 리턴
		return b;
	}
	
	
	/*result를 0으로 초기화 한 후 전달받은 인덱스의 도서가 만화책인 경우
	 * 회원의 나이와 해당 만화책의 제한 나이를 비교하여
	 * 회원 나이가 더 적은 경우 result를 1로 초기화
	 * 아니면 전달받은 인덱스의 도서가 요리책이면서 해당 요리책의
	 * 쿠폰 유무가 true일 경우 회원의 couponCount를 1증가 시킨 후
	 * result 2로 초기화
	 * ->result 리턴*/
	public int rentBook(int index) {
		int result =0;
		if(bList[index] instanceof AniBook) {
			// 전달 받은 index의 bList 객체가 실제 AniBook 객체를 참조하고 있고
			// 해당 만화책의 제한 나이와 회원의 나이를 비교하여 회원 나이가 적을 경우
			// result를 1로 초기화  나이 제한으로 대여 불가하다는 의미
			if(((AniBook)bList[index]).getAccessAge()>mem.getAge()) {
				result=1;
			}
		}else if(bList[index] instanceof CookBook) {
			// 전달 받은 index의 bList 객체가 실제 CookBook 객체를 참조하고 있고
			// 해당 요리책의 쿠폰유무가 “true”일 경우
			// 회원의 couponCount 1 증가 처리 후
			// result를 2로 초기화  성공적으로 대여 완료, 요리학원 쿠폰이 발급됐다는 의미
			if(((CookBook)bList[index]).isCoupon()==true) {
				mem.setCouponCount(++couponCount);
				result=2;
			}
		}
		// result 값 리턴
		return result;
	}
}
