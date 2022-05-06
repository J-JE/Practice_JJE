package test.solution;

import java.util.Scanner;

public class RectangleStar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        for(int i =0; i<b;i++) { //첫번째 for문이 행이 되기 때문에 두번째 입력값인 b를 기준으로 둔다.
        	for(int j =0; j<a;j++) { //두번째 for문은 열이 되기 때문에 첫번째 입력값 a만큼 반복한다.
        		System.out.print("*"); //a값은 줄바꿈 하면 안되기 때문에 println이 아니라 print를 사용한다.
        	}
        	System.out.println(); //한 행이 마무리 되면 한줄 띄우기
        }
	}

}
