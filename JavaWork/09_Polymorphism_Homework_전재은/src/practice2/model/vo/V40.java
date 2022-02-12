package practice2.model.vo;

public class V40 extends SmartPhone{

	public V40() {
	}
	
	@Override
	public void makeaCall() { //전화 걸기
		System.out.println("번호를 누르고 통화버튼을 누름");
	}
	
	@Override
	public void takeaCall() { //전화 받기
		System.out.println("수신 버튼을 누름");	}
	
	@Override
	public void picture() { //촬영 방식
		System.out.println("1200, 1600만 화소 트리플 카메라");	}
	
	@Override
	public void charge() { //충전 방식
		System.out.println("고속 충전");	}
	
	@Override
	public void touch() { //터치 방식
		System.out.println("정전식");	}
	
	@Override
	public void printMaker() { //메이커
		System.out.print("LG");	}
	
}
