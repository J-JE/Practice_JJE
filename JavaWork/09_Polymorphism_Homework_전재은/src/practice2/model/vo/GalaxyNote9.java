package practice2.model.vo;

public class GalaxyNote9 extends SmartPhone{
	
	public GalaxyNote9() {
	}
	
	@Override
	public void makeaCall() { //전화 걸기
		System.out.println("번호를 누르고 통화버튼을 누름");
	}
	
	@Override
	public void takeaCall() { //전화 받기
		System.out.println("수신 버튼을 누름");
	}
	
	@Override
	public void picture() { //촬영 방식
		System.out.println("1200만 듀얼 카메라");
	}
	
	@Override
	public void charge() { //충전 방식
		System.out.println("고속 충전, 고속 무선 충전");
	}
	
	@Override
	public void touch() { //터치 방식
		System.out.println("정전식, 와콤펜 지원 ");
	}
	
	@Override
	public void printMaker() { //메이커
		System.out.print("삼성");
	}
	
}
