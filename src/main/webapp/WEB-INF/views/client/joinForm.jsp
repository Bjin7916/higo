<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	function checkJoin(){
		if(document.join.id.value == ""){
			alert("아이디를 입력하십시오!");
		}else if(document.join.password.value == ""){
			alert("비밀번호를 입력하십시오!");
		}else if(document.join.repw.value == ""){
			alert("비밀번호확인을 입력하십시오!");
		}else if(document.join.name.value == ""){
			alert("이름을 입력하십시오!");
		}else if(document.join.email.value == ""){
			alert("이메일을 입력하십시오!");
		}else if(document.join.tel1.value == ""){
			alert("전화번호를 입력하십시오!");
		}else if(document.join.tel2.value == ""){
			alert("전화번호를 입력하십시오!");
		}else if(document.join.tel3.value == ""){
			alert("전화번호를 입력하십시오!");
		}else if(document.join.password.value != document.join.repw.value){
			alert("비밀번호가 일치하지 않습니다.");
		}else{
			document.join.submit();
		}
	}
</script>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<form action="${ pageContext.request.contextPath }/client/join" method="post" name = "join">
	<table>
		<tr>
			<td>ID</td>
			<td><input type="text" name = "id" autocomplete="on"></td>
		</tr>
		<tr>
			<td>PW</td>
			<td><input type="password" name = "password"></td>
		</tr>
		<tr>
			<td>rePW</td>
			<td><input type="password" name = "repw"></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><input type="text" name = "name"  autocomplete="off"></td>
		</tr>
		<tr>
			<td>E-Mail</td>
			<td><input type="text" name = "email"></td>
		</tr>
		<tr>
			<td>TEL</td>
			<td>
				<input type="text" size = "20" maxlength="20" name = "tel">
			</td>
		</tr>
		<tr>
			<td>주소</td>
			<td>
				<input type="text" size = "20" maxlength="20" name = "address">
			</td>
		</tr>
		<tr>
			<td>회원구분</td>
			<td>
				<select name="member_div">
					<option value="0">일반회원</option>
					<option value="1">고수회원</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>광고수신 동의</td>
			<td>
				<input type="checkbox" name="agree_ad" value="0" />동의
				<input type="checkbox" name="agree_ad" value="1" />미동의
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="Join" onclick="javascript:checkJoin()">
				<input type="button" value="Reset" onclick="document.join.reset()">
			</td>
		</tr>
	</table>
</form>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>











