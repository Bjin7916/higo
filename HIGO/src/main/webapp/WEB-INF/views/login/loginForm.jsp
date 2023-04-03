<%@page import="com.higo.controller.MemberController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String id = (String)request.getAttribute("id");
 	Boolean check = (Boolean)request.getAttribute("check");
 	
 	System.out.print(check);
%>
<script type="text/javascript">
	function check(f){
		if(f.id.value == ""){
			alert("ID를 입력하십시오!");
			f.id.focus();
			return false;
		} else if(f.password.value == ""){
			alert("PW를 입력하십시오!");
			f.password.focus();
			return false;
		}
		return true;
	}
</script>

    
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
	<div align="center" class="container">
		<form action="${ pageContext.request.contextPath }/login/login" method="post" onsubmit="return check(this)">
			<table class="border border-info">
				<tr>
					<th>ID</th>
					<td><input type="text" name="id" value="<%=id %>"></td>
				</tr>
				<tr>
					<td>PW</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<th colspan="2" align="right">
						<span class="ckid">
							<%if(check) {%>
							<!-- true일 때 체크되어있게 -->
								<input type="checkbox" name="ckid" value="true" checked="checked">
							<%}else { %>
							<!-- false일 때 체크안되어있게 -->
								<input type="checkbox" name="ckid" value="true">
							<%} %>
							<font class="ckid_text">아이디 기억하기</font>
						</span>
						<input type="submit" value="Login">
					</th>
				</tr>
			</table>
		</form>
	</div>
	<a href="/MyHome2/login/findForm.do?mode=id">ID찾기</a> | 
	<a href="/MyHome2/login/findForm.do?mode=pw">PW찾기</a> 

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>























