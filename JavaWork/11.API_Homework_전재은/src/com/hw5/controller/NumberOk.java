package com.hw5.controller;

import java.util.Scanner;

public class NumberOk {
	Scanner sc = new Scanner(System.in);
	private int ran;
	
	public NumberOk() {
	}
	
	public void numGame() {
		/*사용자에게 숫자를 입력 받고 입력 받은 숫자가 임의의 난수와 비교 했을 때 작은지 큰지,
		 * 몇 번 만에 맞추는지, 맞추면 계속 할지 끝낼지 묻는 메소드*/
		Scanner sc = new Scanner(System.in);
		int random = (int)(Math.random()*100+1);
		int count =0;
		
		while(true) {
			
			System.out.println("1부터 100 사이의 정수를 하나 입력하세요 : ");
			int num = sc.nextInt();
			
			System.out.println(random);
			
			if(num>random) {
				System.out.println(num+"보다 작습다."+(++count)+"번째 실패!!");
			}else if(num<random) {
				System.out.println(num+"보다 큽니다."+(++count)+"번째 실패!!");
			}else {
				System.out.println((++count)+"번 만에 맞췄습니다!");
				return;
			}
		
		}
	}
	
	public void numGame_김태훈() {
	    Scanner sc = new Scanner(System.in);
	    int cnt = 0;

	    ran =(int)(Math.random()*100+1);
	    System.out.println(ran);

	    while(true) {
	        System.out.println("1부터 100 사이의 정수를 하나 입력하세요 :");
	        int i = sc.nextInt();
	        sc.nextLine();
	        if(i > ran) {
	            cnt++;
	            System.out.println(i+"보다 작습니다"+cnt+"번째 실패");

	        }else if(i < ran) {
	            cnt++;
	            System.out.println(i+"보다 큽니다"+cnt+"번째 실패");
	        }else {
	            System.out.println(cnt+"번 만에 맞췄습니다");
	            System.out.println("계속 하시겠습니까?(y/n)");
	            String str = sc.nextLine();

	            if(str.equalsIgnoreCase("y")) {
	                    System.out.println("새로운 게임을 시작합니다");
	                    continue;
	                }else if(str.equalsIgnoreCase("n")) {
	                    System.out.println("게임을 종료합니다.");
	                    return;
	               } else{
	                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
	                    continue;
	                           }


	            }
	        }

	    }
	
	public void NumberOK_공구민() {
        // TODO Auto-generated constructor stub
        Scanner sc = new Scanner(System.in);

        ran = (int)(Math.random() * 100 +1);

        System.out.println(ran);

        int count =0;
        while(true) {

            System.out.println("1 부터 100 사이의 정수를하나 입력하세요 : ");
            int num = sc.nextInt();
            sc.nextLine();

            if(ran > num) {
                count++;
                System.out.println(num + "보다 큽니다" +count + "번째 실패");
            }else if(ran < num) {
                count++;
                System.out.println(num + "보다 작습니다" +count + "번째 실패");
            }else {
                count++;
                System.out.println(count + " 번만에 맞췄습니다.");

                while(true) {
                    System.out.println("계속 하시겠습니까(y/n) ");
                    String str = sc.nextLine();
                    if(str.equalsIgnoreCase("y")) {
                        System.out.println("새로운 게임을 시작합니다.");
                        break;
                    }else if(str.equalsIgnoreCase("n")) {
                        System.out.println("게임을 종료합니다.");
                        return;
                    }else {
                        System.out.println("잘못입력했습니다.");
                        continue;
                    }
                }
            }
        }
	}
	
	public void numGame_김재호() {

        int count = 0; //몇번만에 맞히는지 확인하기 위한 변수 

        ran = (int)(Math.random() * 100 + 1); 


        while(true) {

            System.out.println("값 :" +ran);
            System.out.print("1부터 100 사이의 정수를 하나 입력하세요 : ");
            int num = sc.nextInt(); 
            sc.nextLine();

            if(num == ran) { 
                count++;
                System.out.println(count + "번 만에 맞췄습니다!");
                return; //이 메소드를 호출한 곳으로(Run 클래스로 갈 것임)
            }else {
                count++; 

                if(num > ran) {
                    System.out.print(num + "보다 작습니다! ");
                }else {
                    System.out.print(num + "보다 큽니다! ");
                }

                System.out.println(count + "번째 실패!!");
            }
            while(true) {

                System.out.println("계속 하시겠습니까?(y/n)");
//                str = sc.nextLine(); 

//                if(str.equalsIgnoreCase("y")) {
                    System.out.println("새로운 게임을 시작합니다!");
//                    no.numGame(); //다시 게임으로
//                }else if(str.equalsIgnoreCase("n")) { 
                    System.out.println("게임을 종료합니다.");
                    break; //반복문(while) 탈출
//                }else {
//                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
//                    continue; //다시 반복으로
                }
            }
        }

}