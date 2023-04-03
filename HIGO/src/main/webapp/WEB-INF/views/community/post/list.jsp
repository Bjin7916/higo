<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script>
	function check(f) {
		if(f.type.value == 'post_seq'){
			
			var num_pattern = /^[0-9]{1,20}$/;
			
			if(f.word.value=="" || !num_pattern.test(f.word.value)){
				alert("글번호를 입력하십시오!!!");
				return false;
			}
		}
		return true;
	}
</script>
   
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
	<c:set var="cpath" value="${ pageContext.request.contextPath }"/>
	<div class="header text-center">
	  <div class="container">
	    <div class="row">
	      <div class="col-lg-9 mx-auto">
	        <h1 class="mb-4"> 커뮤니티</h1>
	        <ul class="list-inline">
	         <li class="list-inline-item"><a class="text-default"
							href="${ pageContext.request.contextPath }">홈 &nbsp; &nbsp;
								/</a></li>
	          <li class="list-inline-item text-primary">커뮤니티</li>
	        </ul>
	      </div>
	    </div>
	  </div>
	</div>
		<div class="container">
	    <div class="row justify-content-center">
	      <div class="col-lg-8  mb-5 mb-lg-0">
		
 		<c:choose>
			<c:when test="${empty list }">
  <h2 class="h5 section-title"><span style="font-weight: bold;">작성한 글이 없습니다.</span></h2>
  </c:when>
  <c:otherwise>
  <h2 class="h5 section-title">Recent Post<c:if test="${!empty mlogin}">
					<span style="float: right;">
						<button class="btn btn-outline-primary"
							onclick="document.location.href='${ pageContext.request.contextPath }/post/writeForm'">글쓰기</button>
					</span>
				</c:if></h2>
			<hr>
	 <c:forEach var="vo" items="${list }">
	 <article class="card mb-4">
	    <div class="row card-body">
	      <div class="col-12">
	        <h3 class="post-title">${vo.post_title }</h3>
	        <ul class="card-meta list-inline">
	          <li class="list-inline-item">
	            <a class="card-meta-author">
	              <img src="${ pageContext.request.contextPath }/resources/images/kate-stone.jpg">
	              <span>${vo.id}</span>
	            </a>
	          </li>
	          <li class="list-inline-item">
	            <i class="ti-thumbs"></i>${vo.post_hit }
	          </li>
	          <li class="list-inline-item">
	            <i class="ti-calendar"></i><fmt:formatDate value="${vo.post_sysdate }" pattern="yyyy년 MM월 dd일"/>
	          </li>
	          <li class="list-inline-item">
	          <c:if test="${!empty mlogin }">
	            <ul class="card-meta-tag list-inline">
	              <li class="list-inline-item like-review"><i class="fa fa-heart"></i>${cvo.commLike_count }</li>
	            </ul>
	            </c:if>
	          </li>
	        </ul>
	        <p>${vo.post_content }</p>
	        <a href="${ pageContext.request.contextPath }/post/content/${vo.post_seq }" class="btn btn-outline-primary" >더 보기</a>
	        
	      </div>
	    </div>
	  </article>
	  </c:forEach>
	  </c:otherwise>
  </c:choose>
			<ul class="pagination row justify-content-center">
				<c:if test="${paging.prev }">
					<li class="page-item page-item active "><a
						href="${cpath }/post/list?page=${paging.begin - 1}"
						class="page-link">-- </a></li>
				</c:if>
				<c:forEach var="i" begin="${paging.begin }" end="${paging.end }"
					step="1">
					<c:choose>
						<c:when test="${i == paging.page }">
							<li class="page-item"><a href="#!" class="page-link">${i }</a>
							</li>
						</c:when>
						<c:otherwise>

							<li class="page-item"><a
								href="${cpath }/post/list?page=${i}" class="page-link">${i }</a>
							</li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${paging.next }">
					<li class="page-item"><a
						href="${cpath }/post/list?page=${paging.end + 1}"
						class="page-link">»</a></li>
				</c:if>
			</ul>
			
			</div>
			</div>
	</div>
	
	<script>
	
function commentComment(event,i){
		
		const a = Array.from(document.querySelectorAll('.commentInput'));
		
		a.forEach((element,idx) => idx == i ? element.style.cssText = 'display: block;' : element.style.cssText = 'display: none;' );
	
	}
	</script>
	
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>

