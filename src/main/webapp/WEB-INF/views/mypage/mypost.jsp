<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<div class="header text-center">
  <div class="container">
    <div class="row">
      <div class="col-lg-9 mx-auto">
        <h1 class="mb-4"> 마이페이지</h1>
        <ul class="list-inline">
         <li class="list-inline-item"><a class="text-default"
						href="${ pageContext.request.contextPath }">홈 &nbsp; &nbsp;
							/</a></li>
          <li class="list-inline-item text-primary">마이페이지</li>
        </ul>
      </div>
    </div>
  </div>
</div>

<h2>숨고생활 작성글/댓글</h2>
<!-- mouseover -->
<form id="mPost" name="category" style="display: block;">
	<h3>작성 글</h3>
	<c:forEach var="i" items="${mPList }">
		<a href="${ pageContext.request.contextPath }/post/content/${i.get('POST_SEQ') }">${i.get("POST_TITLE") }</a><br>
	</c:forEach>
</form>



<h3 id="mComm" name="category">작성 댓글</h3>



<%@ include file="/WEB-INF/views/layout/footer.jsp"%>