package com.hw3.view;

import java.util.Scanner;

import com.hw3.model.vo.Employee;

public class test {
	
	//스캐너타입의 변수 sc => 사용자가 입력하는 값을 받아올 변수
	private Scanner sc = new Scanner(System.in); 

	//기본 생성자 
	public test() {

	}
	
	public void mainMenu() {
		
		Employee emp = null;
		//emp는 null인 상태로 그 어떠한 값도 가지고 있지 않다. 기본값도 갖고있지 않은 상태임. 
		//이 상태로 아래 사원 프로그램의 메뉴중 2번이나 4번을 입력한다면 null포인터 에러가 날 것. 
		//null에러가 나는게 싫다면 사용자가 1번 정보입력을 먼저 수행하고 나머지 프로그램을 선택하거나
		//위 19행을 null 값으로 두지 않고 기본생성자(new Employee())를 이용해 기본값을 가진 객체를 생성해놓으면 됨.
		
		while(true) { //무한반복 
			
			System.out.println("====== 사원 정보 관리 프로그램 =====");
			System.out.println("1.새 사원 정보 입력");
			System.out.println("2.사원 정보 수정 ");
			System.out.println("3.사원 정보 삭제");
			System.out.println("4.사원 정보 출력");
			System.out.println("9.프로그램 종료");
			
			System.out.print("메뉴 번호 선택 : ");
			int num = sc.nextInt(); 
			sc.nextLine(); //엔터 제거
			
			switch(num) {
			case 1: 
				emp = inputEmployee(); 
				//null값이었던 emp 객체에 inputEmployee()를 실행한 결과를 담는다. 
				//이 때, emp 와  inputEmployee()의 반환형이 Employee 클래스형임을 잊지말것. 반드시 일치해야함.
				break; //switch 탈출(while 탈출 아님)
			case 2: 
				modifyEmployee(emp); 
				//modifyEmployee()는 매개변수가 있는 메소드로 매개변수로 Employee 타입의 객체를 넣어주어야 함. 
				//만약 위의 case1을 거쳤다면 정보가 들어있겠지만, 바로 case2로 들어왔다면 아무 정보도 없는상태에서 수정하려 하기 때문에 에러가 날것임. 
				//만약 에러가 나지 않게 하고싶다면 19행의 emp 객체의 값을 null이 아닌 기본값이라도 가진 생성자로 생성을 해주어야함. (Employee emp = new Employee() 이렇게)
				//그럼 모두 기본값이 들어간 객체가 생성이 되고, 내가 수정하고자 하는 부분이 수정이 될 것. 
				break; //switch 탈출(while 탈출 아님)
			case 3:
				System.out.println(emp.getEmpName() + "님의 정보를 삭제합니다."); //emp 객체의 이름을 얻어오는 메소드 getEmpName()를 사용해서 OO님의 정보를 삭제한다고 말해주기
				emp = null; 
				//case1,2를 거쳐서 정보가 들어가고 수정된 상태에서 객체에 null값을 넣어주면 그 정보들이 다 지워짐. (기본값의 객체로 남는것이 아닌 객체 자체가 사라져버려서, 출력시 null포인터에러)
				//참조변수인 emp의 값을 null로 지정하면 나중에 가비지 컬렉터가 자동으로 지워줌
				break;//switch 탈출(while 탈출 아님)
			case 4: 
				String info = emp.information(); //함수를 실행시킨 값을 info에 담는다 
				System.out.println(info); //info 출력 
				//여기서 헷갈렸음....
				//emp 객체를 이용해 information()을 실행하고 돌아와도 정보가 출력되지 않았다. 
				//-> 이유는 information() 메소드는 String 타입의 값을 반환을 해줄뿐 출력을 해주는 것이 아님! 
				//그러므로 information()를 통해 받아온 값을 변수 info에 담아준 후 출력을 해주고 끝낸다! (이 때 받아온 값을 담아줄 변수의 자료형은 반드시 반환값과 동일해야함)
				//또 다른 방법은 information() 메소드 내에서 출력을(System.out.println) 해주는 방법도 있음. 그럼 여기서 출력해주지 않아도 됨. 
				break; //switch 탈출(while 탈출 아님)
			case 9: 
				return; //이 메소드를 호출한 곳으로 돌아감(mainMenu() 메소드 벗어남) -> EmpTest()의 10행으로 감
			}
		}//while
			
	}//mainMenu()
	
	//반환타입이 Employee 클래스인 메소드(메인메뉴 1번 입력시 여기로 옴)
	public Employee inputEmployee() { 
		//새 사원 정보를 입력하는 기능의 메소드  
		
		System.out.print("이름 : ");
		String empName = sc.nextLine();
		
		System.out.print("부서명 : ");
		String dept = sc.nextLine();
		
		System.out.print("직급 : ");
		String job = sc.nextLine();
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		sc.nextLine(); //엔터제거(뒤에 성별 nextLine())
		
		System.out.print("성별 : ");
		char gender = sc.nextLine().toUpperCase().charAt(0);
		
		System.out.print("급여 : ");
		int salary = sc.nextInt();
		
		System.out.print("보너스 포인트 : ");
		double bonusPoint = sc.nextDouble();
		
		sc.nextLine(); //엔터제거(뒤에 전화번호 nextLine())
		
		System.out.print("전화번호 : ");
		String phone= sc.nextLine();
		
		System.out.print("주소 : ");
		String address = sc.nextLine();
		
		Employee emp1 = new Employee(empName, dept, job, age, gender, salary, bonusPoint, phone, address);
		//위에서 받아놓은 데이터들을 -> Employee 클래스의 매개변수가 있는 생성자로 생성하여 emp1 이라는 객체에 담는다
		
		return emp1; // 그 객체를 반환해준다 -> 어디로? -> return이니 이 함수 inputEmployee()를 호출한 그곳으로 -> mainMenu()의 switch문의 case1의 36행으로. 
		
	}//inputEmployee()

	//반환이 없는 메소드 (메인메뉴 2번 입력시 여기로 옴)
	public void modifyEmployee(Employee emp) { 
		//매개변수(객체 emp)가 있는 이유 : 이 메소드는 정보를 수정해주는 기능이 있는 메소드 이다. 
		//그럼 정보를 가진 객체가 필요하다 
		//받아온 객체 emp를 갖고 Employee 클래스에 있는 메소드()들에 접근을 할 수가 있음을 알 것.
		
		while(true) {//무한반복 
			
			System.out.println("==== 사원 정보 수정 메뉴 ====");
			System.out.println("1.이름 변경");
			System.out.println("2.급여 변경");
			System.out.println("3.부서 변경");
			System.out.println("4.직급 변경");
			System.out.println("9.이전 메뉴로");
			
			System.out.print("번호 입력 : ");
			int num = sc.nextInt();
			sc.nextLine(); //엔터제거(뒤에 nextLine())
			
			switch(num) {
			case 1: 
				System.out.print("변경할 이름 : ");
				String reName = sc.nextLine();
				emp.setEmpName(reName); 
				//Employee 클래스의 setEmpName() 메소드는 매개변수를 필요로하므로 여기서 매개변수를 넣어준다. 
				//이 때 넣어주는 매개변수(String 타입의 값)로 이름이 수정(초기화)이 되도록 setEmpName()안에 구현이 되어있다. 
				break;
			case 2:
				System.out.print("변경할 급여 : ");
				int reSalary = sc.nextInt();
				emp.setSalary(reSalary);
				sc.nextLine(); //엔터제거(뒤에 nextLine())
				break;
			case 3: 
				System.out.print("변경할 부서 : ");
				String reDept = sc.nextLine();
				emp.setDept(reDept);
				break;
			case 4: 
				System.out.print("변경할 직급 : ");
				String rejob = sc.nextLine();
				emp.setJob(rejob);
				break;
			case 9:
				System.out.print("이전 메뉴로 돌아갑니다.");
				return; //return 이므로 이 메소드 modifyEmployee()를 호출한 곳으로 돌아감 -> mainMenu() 메소드의 case2의 41행
			}//switch
			
		}//while
		
	}//modifyEmployee()

}//EmpMenu
