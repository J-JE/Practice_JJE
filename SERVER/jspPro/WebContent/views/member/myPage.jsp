<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member m =(Member)request.getAttribute("loginUser"); //getAttribute로 넘어옴 -> 형변환, m에 저장
	String userId = m.getUserId(); //m에서 Id값 가져오기 (get...)
	String userPwd = m.getUserPwd();
	String userName = m.getUserName(); //Name까지는 필수값임
	String phone = m.getPhone() != null ? m.getPhone() : ""; //값이 없을수도 있기 때문에 삼항 연산자를 사용, 값이 없다면 ""공백으로 선언
	String email = m.getEmail() != null ? m.getEmail() : "";
	String address = m.getAddress() != null ? m.getAddress() : "";
	String originPwd = (String)session.getAttribute("originPwd"); //LoginServlet에서 받아뒀던 originPwd를 불러와서 형변환 후 객체 -> deleteMember()에서 사용됨
	
	String[] checkedInterest = new String[6]; //Interest값은 객체로 저장됨, interest가 저장될 객체배열을 먼저 선언
	if(m.getInterest() !=null){ //getInterest가 null이 아닐 때
		String[] interests = m.getInterest().split(","); //회원가입 할 때 interest를 ","와 join했기 때문에 split으로 ","으로 구분해서 객체배열에 저장
		
		for(int i = 0; i< interests.length; i++){ //interest가 들어있는 객체 배열을 for문을 돌리면서
			switch(interests[i]){ //interests의 i번째 인덱스값이 case와 일치 할 때
			case "운동" : checkedInterest[0] = "checked"; break; //checkedInterest[0]값을 checked로 저장 -> 화면에 취미 박스가 체크됨
			case "등산" : checkedInterest[1] = "checked"; break;
			case "낚시" : checkedInterest[2] = "checked"; break;
			case "요리" : checkedInterest[3] = "checked"; break;
			case "게임" : checkedInterest[4] = "checked"; break;
			case "기타" : checkedInterest[5] = "checked"; break;
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer{
		background:black;
		width:600px;
		height:500px;
		margin-top:50px;
		margin-left:auto;
		margin-right:auto;
		color:white;
	}
	#updateForm{
		/* border:1px solid white; */
		width:100%;
		margin-left:auto;
		margin-right:auto;
	}
	#updateForm td:nth-child(1){text-align:right;}
	#updateForm input{margin:3px;}
	
	#joinBtn{background:yellowgreen;}
	#goMain{background:orangered;}
</style>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>

	<div class="outer">
		<br>
		
		<h2 align="center">마이페이지</h2>
		<input type="text" id = "originPwd" name ="originPwd" value="<%=originPwd %>" readonly>
		<form id="updateForm" action="<%=request.getContextPath() %>/updateMember.do" method="post">
		<!-- submit 버튼을 누르면 input에 들어있는 값들이 /updateMember.do로 넘어가게 된다.-->
			<table>
				<tr>
					<td width="200px">* 아이디</td>
					<td><input type="text" maxlength="13" name="userId" value = "<%= userId %>" readonly></td>
					
				</tr>
				
				<tr>
					<td>* 이름</td>
					<td><input type="text" maxlength="5" name="userName" value = "<%= userName %>" required></td>
					<td></td>
				</tr>
				<tr>
					<td>연락처</td>
					<td><input type="tel" maxlength="11" name="phone" value = "<%= phone %>" placeholder="(-없이)01012345678"></td>
					<td></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email" value = "<%= email %>"></td>
					<td></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address" value = "<%= address %>" ></td>
					<td></td>
				</tr>
				<tr>
					<td>관심분야</td>
					<td>
						<input type="checkbox" id="sports" name="interest" value="운동" <%= checkedInterest[0] %>>
						<label for="sports">운동</label>
						
						<input type="checkbox" id="climbing" name="interest" value="등산" <%= checkedInterest[1] %>>
						<label for="climbing">등산</label>
						
						<input type="checkbox" id="fishing" name="interest" value="낚시" <%= checkedInterest[2] %>>
						<label for="fishing">낚시</label>
						
						<input type="checkbox" id="cooking" name="interest" value="요리" <%= checkedInterest[3] %>>
						<label for="cooking">요리</label>
						
						<input type="checkbox" id="game" name="interest" value="게임" <%= checkedInterest[4] %>>
						<label for="game">게임</label>
						
						<input type="checkbox" id="etc" name="interest" value="기타" <%= checkedInterest[5] %>>
						<label for="etc">기타</label>
					</td>
					<td></td>
				</tr>
			</table>
			<br>
			
			<div class="btns" align="center">
				<button type="submit" id="updateBtn">수정하기</button>
				
				<button type="button" id = "pwdUpdateBtn" onclick="updatePwd();">비밀번호 변경</button>
				<button type="button" id = "deleteBtn" onclick="deleteMember();">탈퇴하기</button>
				
			</div>
		</form>
	</div>
	<script>
		function updatePwd(){
			window.open("<%= request.getContextPath()%>/updatePwdForm.do","비밀번호 변경창 ","width=500, height=300")
			//새 창 띄우기
		}

		function deleteMember(){
			var pwd = prompt("현재비밀번호를 입력하세요.");
			var op = $("#originPwd").val();
			
			if(op === pwd){ //originPwd값과 입력받은 pwd값이 같은 경우
				var val = confirm("정말로 탈퇴 하시겠습니까?"); //확인 창 띄워서 값을 받기
				
				if(val){ //updateForm의 action 속성 설정 후 submit으로 값 넘기기
					$("#updateForm").attr("action","<%=request.getContextPath()%>/deleteMember.do");
					$("#updateForm").submit();
				}else{
					alert("취소하였습니다.");
				}
			}
		}
	</script>