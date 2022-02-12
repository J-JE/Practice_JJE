package com.uni.chap02_listsort.model.vo;

public class Travel implements Comparable<Travel>{
	private int tNum;
	private String country;
	private String point;
	
	
	public Travel() {}


	public Travel(int tNum, String country, String point) {
		super();
		this.tNum = tNum;
		this.country = country;
		this.point = point;
	}


	public int gettNum() {
		return tNum;
	}


	public void settNum(int tNum) {
		this.tNum = tNum;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getPoint() {
		return point;
	}


	public void setPoint(String point) {
		this.point = point;
	}


	@Override
	public String toString() {
		return "Travel [tNum ="+ tNum + ", Country = "+ country + ", point = " +point +" ]";
	}

	/*compareTo()는 int 타입을 반환하며, 파라미터로 비교 대상이 되는 객체가 들어오게 된다.
	두 문자열을 사전적으로 비교, 비교는 문자열에있는 각 문자의 유니 코드 값을 기반 .
	return하는 int 값은 기준이 있다.

	A.compareTo(B) 일 때 A<B 인 경우는 음수를 리턴하고, A=B일 때는 0을 리턴하고, A>B일 때 양수를 리턴한다.

	// this(앞)   vs   o(뒤)
	// Travel          Travel
	
	// Collections.sort(정렬하고자하는리스트) 호출시 
	// 내부적으로 해당 리스트에 담겨있는 각각의 Travel 객체들을 가지고
	// 해당 이 compareTo 메소드가 실행이된다.
	
	// 이때  이 메소드의 반환값이 만약 양수일 경우 두 객체의 순서가 바뀌게 됨! 
	
	// 즉, 나라명 오름차순 정렬 할 수 있도록 하려면
	
	// this(앞)   vs   o(뒤)
	//  Travel          Travel
	
	//    this(앞)의 나라명 이 o(뒤)의 나라명 보다 더 큰 값일 경우 순서를 변경해줘야됨 => 즉, 양수값 반환
	//ex   "보홀"			"라오스"
	

	// 이때 String 클래스에서 제공하는 compareTo 메소드를 호출하면 알아서 계산해서 반환해줌
	// 즉  this의 나라명.compareTo(o의 나라명) 하게 되면
	// 비교주체가 대상과 같으면 0, 주체가 대상보다 크면 1 , 주체가 대상보다 작으면 -1 반환
	*/

	//오름차순
//	@Override
//	public int compareTo(Object o) {
//		System.out.println("this  : " + (this.tNum) + "  Object  :  "+ (((Travel)o).tNum) + " return  : " + (this.tNum - ((Travel)o).tNum));
//
//		return this.tNum- ((Travel)o).tNum;
//	}
	
	//내림차순
//	@Override
//	public int compareTo(Object o) {
////		return -(this.tNum- ((Travel)o).tNum);
//		return ((Travel)o).tNum - this.tNum ;
//	}

	
	/* 각인덱스 의  값 비교 
	 * 라오스      아이슬란드  
	 * 보홀         라오스           -> 라오스 보홀  다시 아이슬란드와 비교 
	 * 블라디보스톡     보홀  -> 보홀 블라디보스톡 다시 아이슬란드 비교
	 * 크로아티아         블라디보스톡  -> 블라디 보스톡  크로아티아 다시 아이슬란드 비교  -> 아이슬란드  크로아티아로 변경 
	 * 
	 * 
	 *  compareTo : 라오스 아이슬란드 return : -3528
		compareTo : 보홀 라오스 return : 1400
		compareTo : 보홀 아이슬란드 return : -2128
		compareTo : 보홀 라오스 return : 1400
		compareTo : 블라디보스톡 보홀 return : 288
		compareTo : 블라디보스톡 아이슬란드 return : -1840
		compareTo : 크로아티아 블라디보스톡 return : 4696
		compareTo : 크로아티아 아이슬란드 return : 2856
	 * 
	 * 
	 */
//	@Override
//	public int compareTo(Object o) {
//		System.out.println(" this : "+country  +"   Object : "+ (((Travel)o).country)+" return : "+ country.compareTo(((Travel)o).country) );
//
//		return country.compareTo(((Travel)o).country);
//	}
	
//	@Override
//	public int compareTo(Object o) {
//		return country.compareTo(((Travel)o).country);
//		}
	
	@Override
	public int compareTo(Travel o) {
		return country.compareTo(o.country);
	}
}