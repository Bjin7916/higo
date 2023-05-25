<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
 <div align="center">
	<table id="table">
		<c:choose>
			<c:when test="${login.member_div == 0}">
				<tr>
					<td>
						<a href="${ pageContext.request.contextPath }">쿠폰함</a>
					</td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<td>히고캐시</td>
				</tr>
				<tr>
					<td>
						<a href="${ pageContext.request.contextPath }">스토어</a>
					</td>
				</tr>
				<tr>
					<td>
						<a href="${ pageContext.request.contextPath }">충전/사용 내역</a>
					</td>
				</tr>
			</c:otherwise>
		</c:choose>
		<tr>
			<td id="border">이름</td>
			<td id="border">${login.name } 고객님</td>
		</tr>
		<tr>
			<td id="border">아이디</td>
			<td id="border">${login.id }</td>
		</tr>
		<tr>
			<td id="border">이메일</td>
			<td id="border">${login.email }</td>
		</tr>
		<tr>
			<td id="border">전화번호</td>
			<td id="border">${login.tel }</td>
		</tr>
		<tr>
			<td id="border">커뮤니티</td>
			<td id="border">
				<a href="${ pageContext.request.contextPath }/commu/mylist">히고생활 작성글/댓글</a>
			</td>
		</tr>
		<tr>
			<td id="border">설정</td>
			<td id="border">
				<a href="${ pageContext.request.contextPath }/userSet/alert">알림</a>
				<a href="${ pageContext.request.contextPath }/userSet/notice">공지사항</a>
				<a href="${ pageContext.request.contextPath }/userSet/guide">히고 안내</a>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right"  id="border">
				<input type="button" value = "수정" onclick="location.href = '${ pageContext.request.contextPath }/member/update'">
				<input type="button" value = "회원탈퇴" onclick="location.href = '${ pageContext.request.contextPath }/member/deleteForm'">
			</td>
		</tr>
	</table>
</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>
    
    
    
    
    
    
    
    
    
    
    
    