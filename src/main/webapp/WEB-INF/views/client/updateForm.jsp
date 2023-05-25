<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<div align="center">
	<table id="table">
		<tr>
			<td id="border">번호</td>
			<td id="border">${ login.no }</td>
		</tr>
		<tr>
			<td id="border">아이디</td>
			<td id="border">${ login.id }</td>
		</tr>
		<tr>
			<td id="border">이름</td>
			<td id="border">${ login.name }</td>
		</tr>
		<tr>
			<td id="border">이메일</td>
			<td id="border"><input type="text" value="${ login.email }" name="email"></td>
		</tr>
		<tr>
			<td id="border">전화번호</td>
			<td id="border">
				<select name="tel1">
					<option value="010" selected>010</option> 
					<option value="011">011</option> 
					<option value="016">016</option>
				</select>
				 - <input type="text" size="5" maxlength="4" value="${ login.tel2 }" name="tel2">  
				 - <input type="text" size="5" maxlength="4" value="${ login.tel3 }" name="tel3">  
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right"  id="border">
				<input type="button" value = "수정" onclick="location.href ='${ pageContext.request.contextPath }/member/updateForm'">
				<input type="button" value = "회원탈퇴" onclick="location.href = '${ pageContext.request.contextPath }/member/deleteForm'">
			</td>
		</tr>
	</table>
</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>


