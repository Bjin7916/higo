<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<div class="author">
	<div class="container">
		<div class="row no-gutters justify-content-center">
			<div class="col-lg-3 col-md-4 mb-4 mb-md-0">
				
				<img class="author-image" src="https://www.gravatar.com/avatar/df5fe0c7d20b494dd2c68e0d8ef9bbf2?s=320&pg&d=identicon">
				
			</div>
			<div class="col-md-8 col-lg-6 text-center text-md-left">
				<h3 class="mb-2">${gvo.name }</h3>
					<strong class="mb-2 d-block">고용 수 : ${gvo.hire_cnt  }</strong>
					<strong class="mb-2 d-block">커리어 : ${gvo.career }</strong>
					<div class="content">
						<strong class="mb-2 d-block">${gvo.intro }</strong>
						<p>활동 지역 : ${gvo.actAddr }</p>
					</div>
					
					<a class="post-count mb-1" id="pick"><i class="ti-pencil-alt mr-2"></i>내 요청서 보기</a>
					<ul class="list-inline social-icons">
						<li class="list-inline-item"><a href="#"><i class="ti-facebook"></i></a></li>
						<li class="list-inline-item"><a href="#"><i class="ti-twitter-alt"></i></a></li>
						<li class="list-inline-item"><a href="#"><i class="ti-github"></i></a></li>
						<li class="list-inline-item"><a href="#"><i class="ti-link"></i></a></li>
					</ul>
			</div>
		</div>
	</div>
	
<section class="section-sm" id="post">
	<div class="container">
		<div class="row">
			
			<div class="col-lg-8 mx-auto">
				<article class="card mb-4">
					<div class="card-body">
						<h3 class="mb-3"><a class="post-title" href="#">${sub.subSvc_name }</a></h3>
						<ul class="card-meta list-inline">
							<li class="list-inline-item">
								견적 예상금액 : ${price }
							</li>
							<li class="list-inline-item">
								<i class="ti-calendar"></i>${options }?
							</li>
							<li class="list-inline-item">
								<ul class="card-meta-tag list-inline">
								<c:if test="${qStatus != 0 }">	
									<li class="list-inline-item"><a href="/higo/quote/receiveQuote?quote_seq=${quote_seq}&kind=3&gosu_seq=${gosu_seq }">거래하기</a></li>
									</c:if>
									<li class="list-inline-item"><a href="/higo/quote/receiveQuote?quote_seq=${quote_seq }&kind=2">삭제</a></li>
									<li class="list-inline-item"><a href="/higo/quote/receiveQuote?kind=1">목록</a></li>
								</ul>
							</li>
						</ul>
						<form action="#" name="form1" id="form1">
						<p>${vo.req_text }</p>
						</form>
					</div>
				</article>
			</div>
			
		</div>
	</div>
</section>


 <script type="text/javascript">
	$(document).ready(function(){
		
		$("#form1").hide();
		
		$("#pick").click(function(){
			$("#form1").toggle();
		});
	});


</script>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>
