<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/style.css">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<!-- summernot를 위해서 추가해야 할 부분... -->
<script type="text/javascript" src="${ pageContext.request.contextPath }/resources/summernote/summernote-lite.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/resources/summernote/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/summernote/summernote-lite.css">

<title>HIGO</title> 
</head>
<body>
	<div align ="center">
	<header>
		<div class="logo">
			<a href= "${ pageContext.request.contextPath }">HIGO</a>
		</div>
		<c:if test="${mlogin != null}">
		<input type="hidden" value="${mlogin }">
		</c:if>
		<c:if test="${glogin != null }">
		<input type="hidden" value="${glogin }">
		</c:if>
		<a href="${ pageContext.request.contextPath }/matching/main">고수매칭</a>
		<a href="${ pageContext.request.contextPath }/searching">고수찾기</a>
		<a href="${ pageContext.request.contextPath }/post/list">community</a>
		<c:if test="${member_div == 0} ">
		<a href="${ pageContext.request.contextPath }/post/list">받은견적</a>
		</c:if>
		<c:if test="${member_div == 1 }">
		<a href="${ pageContext.request.contextPath }/post/list">받은요청</a>
		</c:if>
		<c:choose>
		<c:when test="${mlogin == null}">
		<a href="${ pageContext.request.contextPath }/login/loginForm">Login</a>
		<a href="${ pageContext.request.contextPath }/member/joinForm">Join</a>
		</c:when>
		<c:otherwise>
		<a href="${ pageContext.request.contextPath }/mypage/main">mypage</a>
		<a href="${ pageContext.request.contextPath }/login/logout">Logout</a>
		</c:otherwise>
		</c:choose>
		<br>
		<br>
		<input type="button" value="레슨" onclick="location.href='/higo/quote/middleSvc?majorSvc=1'">
		<input type="button" value="홈/리빙" onclick="location.href='/higo/quote/middleSvc?majorSvc=2'">
		<input type="button" value="이벤트" onclick="location.href='/higo/quote/middleSvc?majorSvc=3'">
		<input type="button" value="비지니스" onclick="location.href='/higo/quote/middleSvc?majorSvc=4'">
		<input type="button" value="디자인/개발" onclick="location.href='/higo/quote/middleSvc?majorSvc=5'">
		<input type="button" value="건강/미용" onclick="location.href='/higo/quote/middleSvc?majorSvc=6'">
		<input type="button" value="알바" onclick="location.href='/higo/quote/middleSvc?majorSvc=7'">
		<input type="button" value="기타" onclick="location.href='/higo/quote/middleSvc?majorSvc=8'">
	</header>
	<div class="main">
	
	