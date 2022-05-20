package test.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class report {
	
	public int[] solution() {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report= {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k=2;
		int[] answer = {};
		
		
		/*return 하는 배열은 id_list에 담긴 id 순서대로 각 유저가 받은 결과 메일 수를 담으면 됩니다.
		→ 리턴 배열을 유저아이디 배열 길이로 설정*/
		answer = new int[id_list.length];//최종적으로 [2,1,1,0]의 결과가 나와야 한다.
		
		
		/*피신고인 : 신고인 형식의 리스트가 필요하다. → Map을 사용하자
		신고 한 사람은 여러명일 수 있다. → Set을 사용하자
		( 주의. 한 유저가 같은 유저를 여러번 신고할 수 없다.)*/
		//피신고인 ID : key, 신고인들 Id : value 
		//한 유저가 같은 유저를 여러번 신고할 수 없기 때문에 value는 중복이 불가능한 Set타입을 사용
		//[피신고인ID, [신고인ID]]
		Map<String, HashSet<String>> idMap= new HashMap<>(); 

		//피신고인 ID :key, 신고된 횟수 : value
		//[피신고인ID, 보낼 메일 수]
		Map<String, Integer> mailMap = new HashMap<>();

		for (int i = 0; i < id_list.length; i++) { //유저 목록만큼 for문 반복
			String id= id_list[i]; //id ="유저 ID"
			idMap.put(id, new HashSet<>());  //신고인 ID, 피신고인 ID 형태로 초기화
			mailMap .put(id, 0); //일단 0으로 초기화
		}
		
		
		/*report = "신고인ID 피신고인ID” → 공백으로 구분됨 → split()함수를 사용해 나누자
		→ 나눈 값은 Map을 사용하자*/
		for (String r : report) { //report for문 반복
			String[] str = r.split(" "); //신고인, 피신고인 구분
			String id1 = str[0]; //앞에 오는 것 : 신고인ID
			String id2 = str[1]; //뒤에 오는 것 : 피신고인ID
			idMap.get(id1).add(id2); //피신고인 ID를 value 배열에 추가
		}
		
		
		/*피신고인의 신고받은 수가 k 이상이면 신고인에게 메일을 보내야 함
		→idMap의 신고인 수 만큼 for문을 돌려서 그 수가 k보다 큰 경우
		→ 신고인이 담긴 HashSet의 크기만큼 다시 for문을 돌려서 mailMap에 카운트를 하자
		keySet  : Value를 얻고자 할때 Set인 키들을 뽑아와서 Set 형에 담아서 출력*/
		for (String id : idMap.keySet()) { //사용자가 4명이기 때문에 4번 반복된다.
			//keySet : 키값만 필요한 경우 사용하는 메소드
				
				//idMap의 신고자를 user에 담기(if문에서 사용하기 쉽게)
				HashSet<String> user = idMap.get(id); //사용자를 신고한 사람을 user에 초기화

				if (user.size() >= k) { // 신고된 횟수(신고자 수)가 K 이상일 때
				//ex. neo=[muzi, frodo], rodo=[muzi, apeach]
					
					for (String userId : user) { //신고자 숫자만큼 mainMap의 값에 1씩 추가 하기
						//key : 신고자ID(String), value : 신고자가 신고한 사람이 총 신고 당한 횟수(Integer)
						//key : muzi, frodo, apeach
						//value : muzi=2, frodo=1, apeach=1
						mailMap.put(userId, mailMap.get(userId)+1);
					}
				}//if
			}
		
		
		/*신고자가 신고한 피신고인이 2번이상 신고당해 정지당한 경우
		해당 신고자에게 메일을 수신해야 한다.
		for문을 사용해 mailMap의 결과를 answer에 담기*/
		for (int i = 0; i < id_list.length; i++) { //유저 수만큼 반복하면서
			answer[i] = mailMap.get(id_list[i]); //int형 배열인 aswer에 mailMap의 값 담기
			System.out.println("b : "+answer[i]);
		}
		
		return answer;
	}
			
}
