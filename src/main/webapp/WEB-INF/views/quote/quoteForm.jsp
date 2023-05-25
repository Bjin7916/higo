<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<script type="text/javascript">
	function permisson(){
		
		
		document.allow.submit();
	}	
</script>
    
    
    
    
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<div>
	<form action="${ pageContext.request.contextPath }/quote/quote" name="allow" method="post">
		<table>
			<tr>
				<th><h3>견적서</h3></th>
			</tr>
			<tr>
				<td>견적서 받아라</td>
			</tr>
			<tr>
				<td>
					<input type="button" onclick="javascript:permission">
				</td>
			</tr>
		</table>
	</form>
</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>