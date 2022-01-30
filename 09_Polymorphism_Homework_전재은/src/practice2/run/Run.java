package practice2.run;

import practice2.model.vo.GalaxyNote9;
import practice2.model.vo.SmartPhone;
import practice2.model.vo.V40;

public class Run {

	public static void main(String[] args) {
		// 2개의 객체를 저장할 수 있는 객체배열 생성 (SmartPhone타입)
		SmartPhone[] sp;
		sp=new SmartPhone[2];
		
		sp[0]=new GalaxyNote9();
		sp[1]=new V40();
		
		for(int i =0;i<sp.length;i++) {
			if(i==0) {
				System.out.print("갤럭시 노트 9은 ");
			}else {
				System.out.print("V40은 ");
			}
			sp[i].printMaker();
			System.out.print(" 에서 만들어 졌다.\n");
			sp[i].makeaCall();
			sp[i].takeaCall();
			sp[i].touch();
			sp[i].charge();
			sp[i].picture();

			System.out.println(); // 한 줄 띄기

		}

	}

}
