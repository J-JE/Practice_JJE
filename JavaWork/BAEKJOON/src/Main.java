import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
	int A=sc.nextInt();
	String B=sc.next();
	
	char[]b=B.toCharArray();
	System.out.println((b[2]-'0')*A);
	System.out.println((b[1]-'0')*A);
	System.out.println((b[0]-'0')*A);
	System.out.println(Integer.parseInt(B)*A);
	sc.close();
	}
}
