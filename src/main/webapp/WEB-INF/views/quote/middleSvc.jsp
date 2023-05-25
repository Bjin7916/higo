<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<div class="container">
    <div class="section text-center">
    	<div>
	        <h1 class="mb-4"> ${item.get("majorSvc_name") }</h1>
	        <ul class="list-inline">
	        	<li class="list-inline-item">
	        		<a class="text-default" href="${ pageContext.request.contextPath }">홈 &nbsp; &nbsp; /</a>
	        	</li>
	        	<li class="list-inline-item text-primary">커뮤니티</li>
	        </ul>
        </div>
    </div>



<!-- 큰 테이블 -->

<div class="container row justify-content-center">
<c:forEach var="item" items="${middleSvcVO }">	
		<!-- 중 카테고리 테이블 -->
	<div class="section">	
		<table class="col-4">
			<tr>
				<td>${item.get("middleSvc_name") }</td>	
				<td>${item.get("middleSvc_seq") }</td>	
			</tr>
			<tr>
				<!-- 소 카테고리 테이블 -->
				
			</tr>
		</table>
	</div>
		<br>
</c:forEach>
	
	<c:forEach var="item" items="${SubSvcVO }">
		<table>
			<tr>
				<td>이름 : ${item.get("subSvc_name") }</td>
				<td>중 : ${item.get("middleSvc_seq") }</td>
			<!--	<td>소 : ${item.get("subSvc_seq") }</td>-->
			</tr>
		</table>
	</c:forEach>
</div>	
	
				  <!-- Basic Modal -->
	              <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#basicModal">
	                Basic Modal
	              </button>
	              <div class="modal fade" id="basicModal" tabindex="-1">
	                <div class="modal-dialog">
	                  <div class="modal-content">
	                    <div class="modal-header">
	                      <h5 class="modal-title">Basic Modal</h5>
	                      <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	                    </div>
	                    <div class="modal-body">
	                      Non omnis incidunt qui sed occaecati magni asperiores est mollitia. Soluta at et reprehenderit. Placeat autem numquam et fuga numquam. Tempora in facere consequatur sit dolor ipsum. Consequatur nemo amet incidunt est facilis. Dolorem neque recusandae quo sit molestias sint dignissimos.
	                    </div>
	                    <div class="modal-footer">
	                      <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
	                      <button type="button" class="btn btn-primary">Save changes</button>
	                    </div>
	                  </div>
	                </div>
	              </div><!-- End Basic Modal-->
</div>	
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>















