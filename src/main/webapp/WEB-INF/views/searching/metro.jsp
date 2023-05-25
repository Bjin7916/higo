<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<section class="section pb-0">
  <div class="container">
    <div class="row">
      <div class="col-lg-4 mb-5">
        <h2 class="h5 section-title">${metro_name }</h2>
        <article class="card">
          <div class="post-slider slider-sm">
            <img src="${ pageContext.request.contextPath }/resources/images/post/post-1.jpg" class="card-img-top" alt="post-thumb">
          </div>
          
          <div class="card-body">
            <h3 class="h4 mb-3"><a class="post-title" href="post-details.html">Use apples to give your bakes caramel and a moist texture</a></h3>
            <ul class="card-meta list-inline">
              <li class="list-inline-item">
                <a href="author-single.html" class="card-meta-author">
                  <img src="${ pageContext.request.contextPath }/resources/images/john-doe.jpg">
                  <span>Charls Xaviar</span>
                </a>
              </li>
              <li class="list-inline-item">
                <i class="ti-timer"></i>2 Min To Read
              </li>
              <li class="list-inline-item">
                <i class="ti-calendar"></i>14 jan, 2020
              </li>
              <li class="list-inline-item">
                <ul class="card-meta-tag list-inline">
                  <li class="list-inline-item"><a href="tags.html">Color</a></li>
                  <li class="list-inline-item"><a href="tags.html">Recipe</a></li>
                  <li class="list-inline-item"><a href="tags.html">Fish</a></li>
                </ul>
              </li>
            </ul>
            <p>It’s no secret that the digital industry is booming. From exciting startups to …</p>
            <a href="post-details.html" class="btn btn-outline-primary">Read More</a>
          </div>
        </article>
      </div>

<aside class="col-lg-4 @@sidebar">
 <div class="widget widget-categories">
    <h4 class="widget-title">
    <span>${vo }</span></h4>
    <ul class="list-unstyled widget-list">
    <c:forEach var="i" items="${lvo }" begin="1" end="5">
      <li><a href="${ pageContext.request.contextPath }/metro?metro_seq=${i.get('SUBSVC_SEQ')}" class="d-flex">${i.get('SUBSVC_NAME')}<small class="ml-auto">(4)</small></a></li>
      </c:forEach>
    </ul>
  </div>
</aside>
</div>
</div>
</section>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>