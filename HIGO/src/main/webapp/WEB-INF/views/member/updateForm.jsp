<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	function check(){
		if(document.update.password.value == ""){
			alert("비밀번호를 입력하십시오!");
		}else if(document.update.name.value == ""){
			alert("이름을 입력하십시오!");
		}else if(document.update.email.value == ""){
			alert("이메일을 입력하십시오!");
		}else if(document.update.tel.value == ""){
			alert("전화번호를 입력하십시오!");
		}else{
			document.update.submit();
		}
	}
</script>
<%@include file = "/WEB-INF/views/layout/header.jsp" %>
 	<div align="center">
 		<form action="${ pageContext.request.contextPath }/member/update" method="post" name = "update">
 			<table id="table">
			 	<tr>
			 		<td id="border">비밀번호</td>
			 		<td id="border"><input type="text" name = "password" value="${mvo.password }"></td>
			 	</tr>
			 	<tr>
			 		<td id="border">이름</td>
			 		<td id="border"><input type="text" name = "name" value="${mvo.name }"></td>
			 	</tr>
			 	<tr>
			 		<td id="border">이메일</td>
			 		<td id="border"><input type="text" name = "email" value="${mvo.email }"></td>
			 	</tr>
			 	 	<tr>
			 		<td id="border">전화번호</td>
			 		<td id="border"><input type="text" name = "tel" value="${mvo.tel }"></td>
						
					
			 	</tr>
			 	<tr>
			 		<td colspan="2" align="right" id="border">
			 			<input type="button" value = "수정" onclick="javascript:check()">
			 			<input type="button" value = "돌아가기" onclick="location.href='${ pageContext.request.contextPath }/member/mypage'">
			 		</td>
			 	</tr>
			 </table>	
 	</form>
 	</div>
<%@include file = "/WEB-INF/views/layout/footer.jsp" %>