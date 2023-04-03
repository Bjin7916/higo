<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
	function notice(){
		window.alert("서비스 준비중입니다.")
	}
	
	function change(){
		document.change.submit();
	}
</script>
<!--
 // WEBSITE: https://themefisher.com
 // TWITTER: https://twitter.com/themefisher
 // FACEBOOK: https://www.facebook.com/themefisher
 // GITHUB: https://github.com/themefisher/
-->

<head>
<meta charset="utf-8">
<script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>

<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<!-- summernote를 위해서 추가해야 할 부분 -->
<script type="text/javascript" src="${ pageContext.request.contextPath }/resources/summernote/summernote-lite.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/resources/summernote/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/summernote/summernote-lite.css">
<title>Hidden Gosu</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="description" content="This is meta description">
<meta name="author" content="Themefisher">
<meta name="generator" content="Hugo 0.74.3" />
<!-- theme meta -->
<meta name="theme-name" content="reader" />

<!-- plugins -->
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/plugins/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/plugins/themify-icons/themify-icons.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/plugins/slick/slick.css">

<!-- Main Stylesheet -->
<link rel="stylesheet" href="${ pageContext.request.contextPath }\resources\css\style.css" media="screen">

<!--Favicon-->
<link rel="shortcut icon" href="${ pageContext.request.contextPath }/resources/images/favicon.png" type="image/x-icon">
<link rel="icon" href="${ pageContext.request.contextPath }/resources/images/favicon.png" type="image/x-icon">

<meta property="og:title" content="Reader | Hugo Personal Blog Template" />
<meta property="og:description" content="This is meta description" />
<meta property="og:type" content="website" />
<meta property="og:url" content="" />
<meta property="og:updated_time" content="2020-03-15T15:40:24+06:00" />
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="${ pageContext.request.contextPath }/resources/js/httpRequest.js"></script>
</head>
<body>
	<!-- navigation -->
	<header class="navigation fixed-top nav-bg">
		<div class="container">
			<nav class="navbar navbar-expand-lg navbar-white">
				<a class="navbar-brand order-1" href="${ pageContext.request.contextPath }">
					<img class="img-fluid" width="150px" src="${ pageContext.request.contextPath }/resources/images/logos/logo.png" alt="LOGO" id="logos">
				</a>
				<div class="collapse navbar-collapse text-center order-lg-2 order-3" id="navigation">
					<ul class="navbar-nav mx-auto">
						<li class="nav-item">
							<a class="nav-link" href="${ pageContext.request.contextPath }/matching/main">고수매칭</a>
						</li>
						
						<li class="nav-item">
							<a class="nav-link" href="${ pageContext.request.contextPath }/gosu/searching?kind=1">고수찾기</a>
						</li>

						<li class="nav-item">
							<a class="nav-link" href="#" onclick="javascript:notice()">마켓</a>
						</li>

						<li class="nav-item dropdown">
							<a class="nav-link" href="${ pageContext.request.contextPath }/post/list" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 커뮤니티 <i class="ti-angle-down ml-1"></i></a>
							<div class="dropdown-menu">

								<a class="dropdown-item" href="${ pageContext.request.contextPath }/post/list">전체</a> 
								<%-- <a class="dropdown-item" href="${ pageContext.request.contextPath }/post/list">궁금해요</a> 
								<a class="dropdown-item" href="${ pageContext.request.contextPath }">얼마에요</a>
								<a class="dropdown-item" href="${ pageContext.request.contextPath }">고수찾아요</a> 
								<a class="dropdown-item" href="${ pageContext.request.contextPath }">함께해요</a>
								<a class="dropdown-item" href="${ pageContext.request.contextPath }">고수소식</a> --%>

							</div></li>
<%-- 
						<li class="nav-item">
							<a class="nav-link" href="${ pageContext.request.contextPath }">고객지원</a>
						</li> --%>
					</ul>
				</div>

				<div class="order-2 order-lg-3 d-flex align-items-center">
					<c:choose>
						<c:when test="${empty login}">
							<ul class="loginForm">
								<li class="nav-item loginForm">
									<a class="nav-link" href="${ pageContext.request.contextPath }/login/loginForm">로그인</a>
								</li>
								<li class="nav-item loginForm">
									<a class="nav-link" href="${ pageContext.request.contextPath }/member/joinForm">회원가입</a>
								</li>
								<c:if test="${empty login }">
								<li class="nav-item loginForm">
									<a class="nav-link" href="${ pageContext.request.contextPath }/gosu/joinForm">고수가입</a>
								</li>
								</c:if>
							</ul>
						</c:when>
							<c:otherwise>
							<ul class="loginForm">
							<c:if test="${status == 0 }">
								<li class="nav-item loginForm">
									<a class="nav-link" id="nav-right" href="${ pageContext.request.contextPath }/quote/receiveQuote?kind=1">받은견적</a>
								</li>
								</c:if>
							</ul>
							<ul class="loginForm">
							<c:if test="${status== 1 }">
								<li class="nav-item loginForm">
									<a class="nav-link" id="nav-right" href="${ pageContext.request.contextPath }/quote/receiveRequestQuote">받은요청</a>
								</li>
								<%-- <li class="nav-item loginForm">
									<a class="nav-link" id="nav-right" href="${ pageContext.request.contextPath }">바로견적</a>
								</li> --%>
								<li class="nav-item loginForm">
									<a class="nav-link" id="nav-right" href="${ pageContext.request.contextPath }/gosu/profile">프로필</a>
								</li>
								</c:if>
							</ul>
						
							<ul class="loginForm">
								<li class="nav-item dropdown">
									<a class="nav-link" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> ${login.name }님 <i class="ti-angle-down ml-1"></i></a>
									<div class="dropdown-menu">
										<a class="dropdown-item" href="#">${login.name}님</a> 
										<a class="dropdown-item" href="${ pageContext.request.contextPath }/mypage/main">마이페이지</a> 

									<c:if test="${status ==0}">
										<a class="dropdown-item" href="${ pageContext.request.contextPath }/quote/receiveRequestQuote">받은견적</a>
										<form action="${ pageContext.request.contextPath }/change?status=1" name="change" method="POST">
												<a class="dropdown-item" href="${ pageContext.request.contextPath }/change?status=1">고수전환</a> 
										</form>
									</c:if> 
									<c:if test="${status == 1}">
									<a class="dropdown-item" href="${ pageContext.request.contextPath }/quote/receiveRequestQuote">받은요청</a>
										<form action="${ pageContext.request.contextPath }/change?status=0" name="change" method="POST">
												<a class="dropdown-item" href="${ pageContext.request.contextPath }/change?status=0" >고객전환</a> 
										</form>
										</c:if>
								
										<a class="dropdown-item" href="${ pageContext.request.contextPath }/login/logout">로그아웃</a> 
									</div>
								</li>
								
							</ul>
							</c:otherwise>
						</c:choose>
				</div>
			</nav>
		</div>
	</header>
	<!-- /navigation -->
	<!-- start of banner -->


