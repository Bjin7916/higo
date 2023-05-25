<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<h2> 충전/사용내역</h2>  <h5>캐시 안내</h5>

<div class="cList">
<h4>보유캐시 : ${tc}캐시</h4>
<h4>충전캐시 : ${bc}캐시</h4>
<h4>보너스캐시 : ${c} 캐시</h4>



<c:forEach var="i" items="${cvo }">
<h4>충전캐시 : <fmt:formatNumber value="${i.get('CHARGE_CASH')}" pattern="#,###"/>캐시</h4>
<h4>보너스캐시 :<fmt:formatNumber value="${i.get('BONUS_CASH') }" pattern="#,###"/>캐시</h4>
<h4>충전일자 : <fmt:formatDate value="${i.get('CHARGE_DATE') }" pattern="yyyy년 MM월 dd일"/></h4>
<hr>
</c:forEach>
<select name ="">


</select>
</div>






<%@ include file="/WEB-INF/views/layout/footer.jsp"%>