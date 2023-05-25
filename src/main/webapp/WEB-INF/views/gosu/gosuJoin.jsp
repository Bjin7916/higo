<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<!-- 컨테이너 -->
<div class="section container">
	<!-- 배너 -->
	<div class="banner">
		<!-- 메인서비스 선택 -->
		<div class="select-svc ">
			<ul class="col-12 row justify-content-center list-unstyled">
				<li class="col-md-1 ml-3 w-12 p-1 text-center">
					<a href="${ pageContext.request.contextPath }/gosu/allService">
						<img class="col-12" src="${ pageContext.request.contextPath }/resources/images/sommgo/gosujoin/lesson.svg">
					</a>레슨
				</li>
				<li class="col-md-1 ml-3 w-12 p-1 text-center">
					<a href="${ pageContext.request.contextPath }/gosu/allService">
						<img class="col-12" src="${ pageContext.request.contextPath }/resources/images/sommgo/gosujoin/">
					</a>홈/리빙
				</li>
				<li class="col-md-1 ml-3 w-12 p-1 text-center">
					<a href="${ pageContext.request.contextPath }/gosu/allService">
						<img class="col-12" src="${ pageContext.request.contextPath }/resources/images/sommgo/gosujoin/">
					</a>이벤트
				</li>
				<li class="col-md-1 ml-3 w-12 p-1 text-center">
					<a href="${ pageContext.request.contextPath }/gosu/allService">
						<img class="col-12" src="${ pageContext.request.contextPath }/resources/images/sommgo/gosujoin/">
					</a>비즈니스
				</li>
				<li class="col-md-1 ml-3 w-12 p-1 text-center">
					<a href="${ pageContext.request.contextPath }/gosu/allService">
						<img class="col-12" src="${ pageContext.request.contextPath }/resources/images/sommgo/gosujoin/">
					</a>디자인/개발
				</li>
				<li class="col-md-1 ml-3 w-12 p-1 text-center">
					<a href="${ pageContext.request.contextPath }/gosu/allService">
						<img class="col-12" src="${ pageContext.request.contextPath }/resources/images/sommgo/gosujoin/">
					</a>건강/미용
				</li>
				<li class="col-md-1 ml-3 w-12 p-1 text-center">
					<a>
						<img class="col-12" src="${ pageContext.request.contextPath }/resources/images/sommgo/gosujoin/">
					</a>알바
				</li>
				<li class="col-md-1 ml-3 w-12 p-1 text-center">
					<a href="${ pageContext.request.contextPath }/gosu/allService">
						<img class="col-12" src="${ pageContext.request.contextPath }/resources/images/sommgo/gosujoin/">
					</a>기타
				</li>
			</ul>
		</div>
	</div>
</div>


<%@ include file="/WEB-INF/views/layout/footer.jsp"%>