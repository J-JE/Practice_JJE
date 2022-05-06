package test.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {

	public int[] solution() {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report= {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k=2;
		////////////
		
/*		//신고자 ID와 신고된 유저 ID를 담을 Map객체 [신고된ID, [신고한ID]
		Map<String, HashSet<String>> map = new HashMap<>(); 
		//[신고된Id, 메일 수]
		Map<String, Integer> mailMap = new HashMap<>(); 

		for (int i = 0; i < id_list.length; i++) { //유저 목록만큼 for문 반복
			String id= id_list[i]; //id에 "유저 ID" 담기

		//HashSet에는 중복데이터가 없기 때문에 한 사람이 같은 사람을 여러번 신고해도 담기지 않음
			map.put(id, new HashSet<>()); 
			mailMap.put(id, i);
		}
	    
		int[] answer = {123};
		System.out.println(answer[0]);
		return answer;*/
		
		
		int[] answer = {};
        answer = new int[id_list.length];

        
	    /*
	     * key 는 유저ID
	     * value 는 신고한 유저ID의 set 을 가진 map
	     * 동일한 유저ID에 대한 신고횟수는 1회로 처리하기 때문에 중복 허용을 하지 않는 set 을 value 로 사용
	     * */
		Map<String, HashSet<String>> reportedMap = new HashMap<>(); // [신고된ID, [신고한ID]]
		Map<String, Integer> answerMap = new HashMap<>(); // [신고된Id, 메일 수]
	
		
		/* 1. Map 초기화 */
		for (int i = 0; i < id_list.length; i++) {
			HashSet<String> reportingId = new HashSet<>(); // 신고한ID
			reportedMap.put(id_list[i], reportingId); // 유저ID, 신고한ID 초기 세팅
			answerMap.put(id_list[i], 0);  // 메일 수는 모두 0 으로 초기화
		}
		System.out.println("[STEP 1] reportedMap : " + reportedMap);
		System.out.println("[STEP 1] answerMap : " + answerMap);
	
		
		/*
		 * 2. 신고 기록 세팅 report 는 "신고한ID 신고된ID" 로 구성됨
		 */
		for (String s : report) {
			String[] reportStr = s.split(" ");
			String reportingID = reportStr[0]; // 신고한ID
			String reportedID = reportStr[1]; // 신고된ID
			reportedMap.get(reportedID).add(reportingID); // 신고된ID 를 key 값으로 신고한ID 배열을 value 로 새팅
		}
		System.out.println("[STEP 2] reportedMap 에 신고 기록 세팅 : " + reportedMap);
	
		
		/*
		 * 3. 유저가 받은 이용 정지 결과 메일 세팅
		 */
		for (String reportedUser : reportedMap.keySet()) { // reportedUser 는 신고된ID유저
			HashSet<String> userForSend = reportedMap.get(reportedUser); // reportedUser(신고된유저)를 신고한 유저
			System.out.println("reportedMap.keySet()"+userForSend);
			if (userForSend.size() >= k) { // 신고된 횟수가 K번 이상일 경우
				for (String userId : userForSend) {
					answerMap.put(userId, answerMap.get(userId) + 1); // answerMap 에 신고된Id 별 메일 수 넣기
				}
			}
		}
		System.out.println("[STEP 3] answerMap 에 메일 수 세팅 : " + answerMap);
	
		
		/*
		 * 4. 유저ID 별 받은 메일 수를 answer 에 세팅
		 */
		for (int i = 0; i < id_list.length; i++) {
			answer[i] = answerMap.get(id_list[i]);
			System.out.println("[STEP 4] answer : " + answer[i]);
		}
		return answer;
	}
		
}
