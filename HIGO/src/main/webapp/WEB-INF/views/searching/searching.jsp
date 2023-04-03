<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<div class="header text-center">
  <div class="container">
    <div class="row">
      <div class="col-lg-9 mx-auto">
        <h1 class="mb-4"> ${middle.get("MIDDLESVC_NAME") }</h1>
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

<div>
	<c:choose>
		<c:when test="${kind == 1 }">
			<c:forEach var="i" items="${majorSvc }">
				<form name="major" action="${ pageContext.request.contextPath }/gosu/searching?kind=2" method="post">
					<input type="hidden" name="majorSvc" value="${i.get('MAJORSVC_SEQ') }"/>
					<input class="matching" type="submit" value="선택">${i.get('MAJORSVC_NAME') }
				</form>
			</c:forEach>
		</c:when>
	
		<c:when test="${kind == 2 }">
			<c:forEach var="i" items="${middleSvc }">
				<form name="middle" action="${ pageContext.request.contextPath }/gosu/searching?kind=3" method="post">
					<input type="hidden" name="middleSvc" value="${i.get('MIDDLESVC_SEQ') }"/>
					${i.get('MIDDLESVC_NAME') }<input type="submit" value="선택">
				</form>
			</c:forEach>
		</c:when>
		
		<c:when test="${kind == 3 }">
			<c:forEach var="i" items="${subSvc }">
				<form name="sub" action="${ pageContext.request.contextPath }/gosu/searchingMain" method="post">
					<input type="hidden" name="subSvc" value="${i.get('SUBSVC_SEQ') }"/>
					${i.get('SUBSVC_NAME') }<input type="submit" value="선택">
				</form>
			</c:forEach>
		</c:when>
	</c:choose>


</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>  
