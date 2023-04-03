<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>

	<!-- start of banner -->
	<div class="banner text-center">
		<div class="container">
			<div class="row">
				<div class="col-lg-9 mx-auto">
					<h1 class="mb-5">
						<br> 원하는 서비스를 찾아보세요!
					</h1>
					<ul class="list-inline widget-list-inline">
					<c:forEach var="i" items="${mlist }">
						<li class="list-inline-item"><a href="${ pageContext.request.contextPath }/quote/middleSvc?majorSvc=${i.get('MAJORSVC_SEQ')}">${i.get('MAJORSVC_NAME')}</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>	
	
	
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>