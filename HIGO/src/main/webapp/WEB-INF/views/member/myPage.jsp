<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file = "/WEB-INF/views/layout/header.jsp" %>
<div align="center">
	<table id="table">
		<tr>
			<td id="border">아아디</td>
			<td id="border">${vo.id }</td>
		</tr>
		<tr>
			<td id="border">비밀번호</td>
			<td id="border">${vo.password }</td>
		</tr>
		<tr>
			<td id="border">이름</td>
			<td id="border">${vo.name }</td>
		</tr>
		<tr>
			<td id="border">이메일</td>
			<td id="border">${vo.email }</td>
		</tr>
		<tr>
			<td id="border">전화번호</td>
			<td id="border">${vo.tel }</td>
		</tr>
		<tr>
			<td colspan="2" align="right"  id="border">
				<input type="button" value = "수정" onclick="location.href = '${ pageContext.request.contextPath }/member/updateform'">
				<input type="button" value = "회원탈퇴" onclick="location.href = '${ pageContext.request.contextPath }/member/deleteform'">
			</td>
		</tr>
	</table>
</div>
<%@include file = "/WEB-INF/views/layout/footer.jsp" %>