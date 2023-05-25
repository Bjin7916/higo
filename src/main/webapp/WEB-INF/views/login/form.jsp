<%@page import="com.higo.controller.MemberController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">
	function check(f){
		if(f.id.value == ""){
			alert("ID를 입력하십시오!");
			f.id.focus();
			return false;
		} else if(f.password.value == ""){
			alert("PW를 입력하십시오!");
			f.password.focus();
			return false;
		}
		return true;
	}
</script>

    
<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<div class="header text-center">
  <div class="container">
    <div class="row justify-content-center"">
      <div class="col-lg-9 mx-auto">
        <h1 class="mb-4"> LOGIN</h1>
        <ul class="list-inline">
          <li class="list-inline-item"><a class="text-default"
						href="${ pageContext.request.contextPath }">Home &nbsp; &nbsp;
							/</a></li>
          <li class="list-inline-item text-primary">LOGIN</li>
        </ul>
      </div>
    </div>
  </div>
</div>

<section class="section-sm">
  <div class="container">
    <div class="row">
      <div class="col-lg-8 mx-auto">
        
        <div class="content mb-5">
          <h2 id="we-would-love-to-hear-from-you">히든 고수를 찾아보세요 ! &hellip;.</h2>
          <p> 히든 고수를 찾을수도, 히든고수가 될 수도 있습니다 ! </p>
        </div>
        
        <form action="${ pageContext.request.contextPath }/login/check" method="post" onsubmit="return check(this)">
          <div class="form-group">
            <label for="name">ID</label>
            <input type="text" name="id" id="id" class="form-control" required>${id }
          </div>
          <div class="form-group">
            <label for="email">Password</label>
            <input type="password" name="password" id="password" class="form-control"  required>
          </div>
         	<span class="ckid">
         	<c:choose>
         	<c:when test="${check }">
         	<input type="checkbox" name="ckid" value="true" checked="checked">
         	</c:when>
         	<c:otherwise>
         	<input type="checkbox" name="ckid" value="true">
         	</c:otherwise>
         	</c:choose>
         	<font class="ckid_text">아이디 기억하기</font>
         	</span>
          <button type="submit" class="btn btn-primary">Login</button>
        </form>
      <a href="${ pageContext.request.contextPath }/login/findForm?mode=id">ID찾기</a> | 
	<a href="${ pageContext.request.contextPath }/login/findForm?mode=password">PW찾기</a> 
      </div>
    </div>
  </div>
</section>




<%@ include file="/WEB-INF/views/layout/footer.jsp" %>























