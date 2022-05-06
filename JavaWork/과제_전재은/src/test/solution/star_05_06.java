package test.solution;

import java.util.Scanner;

public class star_05_06 {
	public star_05_06() {
		// TODO Auto-generated constructor stub
	}
	
	public void solution() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        for(int i =0; i<b;i++) {
        	for(int j =0; j<a;j++) {
        		System.out.print("*");
        	}
        	System.out.println();
        }
	}
}
