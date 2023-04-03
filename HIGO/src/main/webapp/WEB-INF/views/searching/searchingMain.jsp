<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<div class="header text-center">
  <div class="container">
    <div class="row">
      <div class="col-lg-9 mx-auto">
        <h1 class="mb-4"> ${majorSvc }</h1>
        <ul class="list-inline">
         <li class="list-inline-item"><a class="text-default"
						href="${ pageContext.request.contextPath }">홈 &nbsp; &nbsp;
							/</a></li>
          <li class="list-inline-item text-primary">고수매칭</li>
        </ul>
      </div>
    </div>
  </div>
</div>
<br>
<br>
<br>
<br>
<br>
<br>
	<c:choose>
		<c:when test="${gvo != null }">
			<c:forEach var="i" items="${gvo }" varStatus="aStatus">
			<c:set var="s" value="${aStatus.index }"/>
				<table border="1px solid black">
					<form action="#">
						<tr>
							<td>${memName.get(s) }</td>
						</tr>
						<tr>
							<td>${i.get("INTRO") }</td>
						</tr>
						<tr>
							<td>${i.get("STAR_AVG") }</td>
						</tr>
						<tr>
							<td>${i.get("HIRE_CNT") }</td>
						</tr>
					</form>
				</table>
			</c:forEach>
		</c:when>
		<c:otherwise>
			원하는 고수가 없습니다.
		</c:otherwise>
	</c:choose>
	
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>