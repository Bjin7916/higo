<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	
</script>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<div class="header text-center">
  <div class="container">
    <div class="row">
      <div class="col-lg-9 mx-auto">
        <h1 class="mb-4"> 받은 견적서</h1>
        <ul class="list-inline">
         <li class="list-inline-item"><a class="text-default"
						href="${ pageContext.request.contextPath }">홈 &nbsp; &nbsp;
							/</a></li>
          <li class="list-inline-item text-primary">받은 견적</li>
        </ul>
      </div>
    </div>
  </div>
</div>

<section class="section">
  <div class="container">
    <div class="row justify-content-center">
     <c:choose>	
		<c:when test="${qvo.size() != 0}">
			<c:forEach var="i" items="${qvo }" varStatus="statusS">
			
					<c:if test="${i.get('QSTATUS') != 0 }">
						<form action="/higo/quote/receiveQuoteDetail?qStatus=1" name="input" method="post">
							<input type="hidden" name="quote_seq" value="${i.get('QUOTE_SEQ') }"/>
							<c:set var="a" value="${statusS.index }"/>
							<input type="hidden" value="${i.get('QUOTEREQ_SEQ') }" name="quoteReq_seq">
							<input type="hidden" value="${i.get('OPTIONS') }" name="options">
							<input type="hidden" value="${i.get('GOSU_SEQ') }" name="gosu_seq">
							<input type="hidden" value="${i.get('PRICE') }" name="price">		
      <div class="col-lg-10">
        <article class="card mb-4">
          <div class="row card-body">
            <div class="col-md-4 mb-4 mb-md-0">
              <div class="post-slider slider-sm slick-initialized slick-slider"><button type="button" class="prevArrow slick-arrow" style=""><i class="ti-angle-left"></i></button>
                <div class="slick-list draggable"><div class="slick-track" style="opacity: 1; width: 1100px; transform: translate3d(-440px, 0px, 0px);"><img src="images/post/post-1.jpg" class="card-img slick-slide slick-cloned" alt="post-thumb" style="height: 200px; object-fit: cover; width: 220px;" data-slick-index="-1" aria-hidden="true" tabindex="-1"><img src="images/post/post-10.jpg" class="card-img slick-slide" alt="post-thumb" style="height: 200px; object-fit: cover; width: 220px;" data-slick-index="0" aria-hidden="true" tabindex="-1"><img src="images/post/post-1.jpg" class="card-img slick-slide slick-current slick-active" alt="post-thumb" style="height: 200px; object-fit: cover; width: 220px;" data-slick-index="1" aria-hidden="false" tabindex="0"><img src="images/post/post-10.jpg" class="card-img slick-slide slick-cloned" alt="post-thumb" style="height: 200px; object-fit: cover; width: 220px;" data-slick-index="2" aria-hidden="true" tabindex="-1"><img src="images/post/post-1.jpg" class="card-img slick-slide slick-cloned" alt="post-thumb" style="height: 200px; object-fit: cover; width: 220px;" data-slick-index="3" aria-hidden="true" tabindex="-1"></div></div>
                
              <button type="button" class="nextArrow slick-arrow" style=""><i class="ti-angle-right"></i></button></div>
            </div>
            <div class="col-md-8">
               <h3 class="h3 mb-5">${subSvcName[a] }</h3>
              <ul class="card-meta list-inline">
                <li class="list-inline-item">
                  <a href="author-single.html" class="card-meta-author">
                    <img src="images/john-doe.jpg" alt="John Doe">
                    <span>${gosu_id }</span>
                  </a>
                </li>
                <li class="list-inline-item">
                  <i class="ti-timer"></i><mark>거래 완료</mark>
                </li>
                <li class="list-inline-item">
                   <i class="ti-calendar"></i><fmt:formatDate value="${i.get('SEND_DATE') }" pattern="yyyy년 MM월 dd일"/>
                </li>
              </ul>
              <p>${i.get('QUOTE_DETAIL') }</p>
           <input type="submit" onclick="javascript:submit()" class="btn btn-outline-primary" value="견적서 보기">
            </div>
          </div>
        </article>
      </div>
     </form>
    </c:if>
    <c:if test="${i.get('QSTATUS') == 0 }">
						<form action="/higo/quote/receiveQuoteDetail?qStatus=0" name="input" method="post">
							<input type="hidden" name="quote_seq" value="${i.get('QUOTE_SEQ') }"/>
							<c:set var="a" value="${statusS.index }"/>
							<input type="hidden" value="${i.get('QUOTEREQ_SEQ') }" name="quoteReq_seq">
							<input type="hidden" value="${i.get('OPTIONS') }" name="options">
							<input type="hidden" value="${i.get('GOSU_SEQ') }" name="gosu_seq">
							<input type="hidden" value="${i.get('PRICE') }" name="price">
							
      <div class="col-lg-10">
        <article class="card mb-4">
          <div class="row card-body">
            <div class="col-md-4 mb-4 mb-md-0">
              <div class="post-slider slider-sm slick-initialized slick-slider"><button type="button" class="prevArrow slick-arrow" style=""><i class="ti-angle-left"></i></button>
                <div class="slick-list draggable"><div class="slick-track" style="opacity: 1; width: 1100px; transform: translate3d(-440px, 0px, 0px);"><img src="images/post/post-1.jpg" class="card-img slick-slide slick-cloned" alt="post-thumb" style="height: 200px; object-fit: cover; width: 220px;" data-slick-index="-1" aria-hidden="true" tabindex="-1"><img src="images/post/post-10.jpg" class="card-img slick-slide" alt="post-thumb" style="height: 200px; object-fit: cover; width: 220px;" data-slick-index="0" aria-hidden="true" tabindex="-1"><img src="images/post/post-1.jpg" class="card-img slick-slide slick-current slick-active" alt="post-thumb" style="height: 200px; object-fit: cover; width: 220px;" data-slick-index="1" aria-hidden="false" tabindex="0"><img src="images/post/post-10.jpg" class="card-img slick-slide slick-cloned" alt="post-thumb" style="height: 200px; object-fit: cover; width: 220px;" data-slick-index="2" aria-hidden="true" tabindex="-1"><img src="images/post/post-1.jpg" class="card-img slick-slide slick-cloned" alt="post-thumb" style="height: 200px; object-fit: cover; width: 220px;" data-slick-index="3" aria-hidden="true" tabindex="-1"></div></div>
                
              <button type="button" class="nextArrow slick-arrow" style=""><i class="ti-angle-right"></i></button></div>
            </div>
            <div class="col-md-8">
              <h3 class="h3 mb-5">${subSvcName[a] }</h3>
              <ul class="card-meta list-inline">
                <li class="list-inline-item">
                  <a href="author-single.html" class="card-meta-author">
                    <img src="images/john-doe.jpg" alt="John Doe">
                    <span>${gosu_id }</span>
                  </a>
                </li>
                <li class="list-inline-item">
                  <i class="ti-timer"></i><mark>대기 중</mark>
                </li>
                <li class="list-inline-item">
                  <i class="ti-calendar"></i><fmt:formatDate value="${i.get('SEND_DATE') }" pattern="yyyy년 MM월 dd일"/>
                </li>
                <li class="list-inline-item">
                </li>
              </ul>
              <p>${i.get('QUOTE_DETAIL') }</p>
              <input type="submit" onclick="javascript:submit()" class="btn btn-outline-primary" value="견적서 보기">
            </div>
          </div>
        </article>
      </div>
     </form>
    </c:if>
    </c:forEach>
    </c:when>
    <c:otherwise>
     아무것도 없다....
    </c:otherwise>
    </c:choose>					
</div>
</div>
</section>

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>