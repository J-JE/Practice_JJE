<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#updateForm input[type=text], #updateForm input[type=password], #updateForm input[type=email]{
		width:200px;
		margin:5px;
	}
	#updateForm tr>td:nth-child(1){text-align:right;}
</style>
</head>
<body>

	<jsp:include page="../common/menubar.jsp"/>
	
	<div class="outer">
		<br>
		<h1 align="center">마이페이지</h1>
		<br>
				
		<form id="updateForm" action="updateMember.do" method="post">
			
			<table align="center">
				<tr>
					<td>ID : </td>
					<td><input type="text" name="userId" value="${loginUser.userId}" readonly></td>
				</tr>
				<tr>
					<td>PWD : </td>
					<td><input type="password" name="userPwd" id="originPwd" value="${loginUser.userPwd}" readonly></td>
				</tr>
				<tr>
					<td>NAME : </td>
					<td><input type="text" name="userName" value="${loginUser.userName}" readonly></td>
				</tr>
				<tr>
					<td>EMAIL : </td>
					<td><input type="email" name="email" value="${loginUser.email}"></td>
				</tr>
				<tr>
					<td>BIRTHDAY : </td>
					<td><input type="text" name="birthday" placeholder="생년월일(6자리)" value="${loginUser.birthday}"></td>
				</tr>
				<tr>
					<td>GENDER : </td>
					<td><input type="text" name="birthday" value="${loginUser.gender}"></td>
				</tr>
				<tr>
					<td>PHONE : </td>
					<td><input type="text" name="phone" placeholder="(-포함)" value="${loginUser.phone}"></td>
				</tr>
				<tr>
					<td>ADDRESS : </td>
					<td><input type="text" name="address" value="${loginUser.address}"></td>
				</tr>
			</table>
			
			<br>
			<div class="btns" align="center">
				<button type="submit" id="updateBtn">수정하기</button>
				<button type="button" id="deleteBtn" onclick="deleteMember();">탈퇴하기</button>
			</div>
		</form>
		<br><br>
	</div>
	<script>
		function deleteMember(){
			var pwd = prompt("현재비밀번호를 입력하세요.");
			var op = $("#originPwd").val();
			
			if(op === pwd){ //originPwd값과 입력받은 pwd값이 같은 경우
				var val = confirm("정말로 탈퇴 하시겠습니까?"); //확인 창 띄워서 값을 받기
				
				if(val){ //updateForm의 action 속성 설정 후 submit으로 값 넘기기
					$("#updateForm").attr("action","deleteMember.do");
					$("#updateForm").submit();
				}else{
					alert("취소하였습니다.");
				}
			}
		}
	</script>