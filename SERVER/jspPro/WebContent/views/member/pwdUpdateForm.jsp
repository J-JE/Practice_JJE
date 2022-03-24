<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String msg = (String)request.getAttribute("msg"); //getAttribute로 msg값을 받아서 String에 초기화
	String sTag = (String)request.getAttribute("sTag");
	String originPwd = (String)session.getAttribute("originPwd");

%>
<!DOCTYPE html>
<!--	String originPwd = (String)request.getAttribute("originPwd"); 변경한 페스워드로 뜨게-->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	var msg="<%= msg %>";
	var sTag="<%= sTag %>";
	var originPwd = "<%= originPwd %>";
	$(function(){
		if(msg != "null"){
			
			alert(msg);
		}
		
		if(sTag == "Y"){
			
			opener.document.getElementById("originPwd").value = originPwd; //부모페이지의 originPwd값을 바뀐 pwd로 바꿈
			window.close();
		}
		
	})
	
</script>
</head>
<body>
	<b>비밀번호 변경</b>
	<br>
	
	<form id="updatePwdForm" action="<%= request.getContextPath() %>/updatePwdMember.do" method="post">
		<table>
			<tr>
				<td><label>현재 비밀번호</label>
				<td><input type="password" name="userPwd" id="userPwd"></td>
			</tr>
			<tr>
				<td><label>변경할 비밀번호</label></td>
				<td><input type="password" name="newPwd"></td>
			</tr>
			<tr>
				<td><label>변경할 비밀번호 확인</label></td>
				<td><input type="password" name="checkPwd"></td>
			</tr>
		</table>
		
		<br>
		<br>
		
		<div class="btns" align="center">
			<button  type="button" onclick="fnCheckPwd()">변경하기</button>
		</div>
	</form>
	<script>
		function fnCheckPwd(){
			var userPwd = $("#userPwd");
			var newPwd = $("input[name='newPwd']"); //
			var checkPwd = $("input[name='checkPwd']");
			
			if(userPwd.val().trim() === "" || newPwd.val().trim() === "" || checkPwd.val().trim() === ""){ //입력 값이 하나라도 비어있는 경우
				alert("비밀번호를 입력하세요") //경고창 출력
				return false; //false를 반환해서 submit안되게
			}
			
			if(newPwd.val() != checkPwd.val()){//두 값이 다른 경우
				alert("비밀번호가 다릅니다.") //경고창 출력
				checkPwd.val(''); //확인 칸 비우기
				checkPwd.focus(); //포커스 주기
				return false; //false값 반환
				
			}
			
			$("#updatePwdForm").submit(); //위의 if문을 다 통과한 경우 submit
		}
	</script>
</body>
</html>