<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<div class="header text-center">
	<div class="container">
		<div class="row">
			<div class="col-lg-9 mx-auto">
				<h1 class="mb-4">아이디 / 비밀번호 찾기</h1>
				<ul class="list-inline">
					<li class="list-inline-item"><a class="text-default"
						href="${ pageContext.request.contextPath }">Home &nbsp; &nbsp;
							/</a></li>
					<li class="list-inline-item text-primary">forgot? ID or PW</li>
				</ul>
			</div>
		</div>
	</div>
</div>
<div class="content mb-5">
	<section class="section-sm">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 mx-auto">
					<c:choose>
						<c:when test="${!check}">
							<h2 id="we-would-love-to-hear-from-you">아이디 혹은 비밀번호를 찾지
								못하였습니다. &hellip;.</h2>
							<a href="${ pageContext.request.contextPath }/login/findForm?mode=id">ID찾기</a> | 
			<a href="${ pageContext.request.contextPath }/login/findForm?mode=password">PW찾기</a> |
			</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${param.mode == 'id' }">
									<h3>ID : ${id }</h3>
									<a href="${ pageContext.request.contextPath }/login/findForm?mode=password">PW찾기</a> | 
				</c:when>
								<c:otherwise>
									<h3>PW : ${password }</h3>
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
					<a href="${ pageContext.request.contextPath }/login/loginForm">Login</a>
				</div>
			</div>
		</div>
	</section>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>

