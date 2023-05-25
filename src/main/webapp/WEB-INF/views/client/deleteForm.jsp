<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript">
	function check(){
		if(document.del.password.value == ""){
			alert("비밀번호를 입력하십시오!!!");
		}else{
			document.del.submit();
		}
	}
</script>
    
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<div align="center">
	<form action="/myhome/member/delete" method="post" name = "del">
		<table border="1">
			<tr>
				<td>${ login.id }님의 비밀번호 확인</td>
				<td>
					<input type="password" name="password" placeholder="비밀번호 확인">
				</td> 
			</tr>
			<tr>
				<td colspan="2" align="right">
					<button type="button" onclick="javascript:check()">확인</button>					
					<button type="button" onclick="location.href='${ pageContext.request.contextPath }/member/myPage'">취소</button>					
				</td>
			</tr>
		</table>
	</form>
</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>