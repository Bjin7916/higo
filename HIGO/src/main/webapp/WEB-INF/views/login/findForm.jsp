<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
function check(){
	if(document.find.id.value == ""){
		alert("아이디를 입력하십시오!");
		return false;
	}
	if(document.find.password.value == ""){
		alert("비밀번호를 입력하십시오!");
		return false;
	}
	if(document.find.email.value == ""){
		alert("이메일을 입력하십시오!");
		return false;
	}
	if(document.find.tel.value == ""){
		alert("전화번호를 입력하십시오!");
		return false;
	}
	return true;
}
</script>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>


<div class="header text-center">
	<div class="container">
		<div class="row">
			<div class="col-lg-9 mx-auto">
				<h1 class="mb-4">아이디 / 비밀번호 찾기</h1>
				<ul class="list-inline">
					<li class="list-inline-item"><a class="text-default"
						href="${ pageContext.request.contextPath }">Home &nbsp; &nbsp;
							/</a></li>
					<li class="list-inline-item text-primary">forgot? ID or PW</li>
				</ul>
			</div>
		</div>
	</div>
</div>

<section class="section-sm">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 mx-auto">
				<form action="${ pageContext.request.contextPath }/login/find"
					onsubmit="return check();" method="post" name="find">
					<c:choose>
						<c:when test="${param.mode == 'id' }">
							<div class="form-group">
								<label for="name">ID찾기</label> <input type="hidden" name="mode"
									value="id" class="form-control">
							</div>
						</c:when>
						<c:otherwise>
							<div class="form-group">
								<label for="email">Password찾기</label> <input type="hidden"
									name="mode" value="password" class="form-control">
							</div>
						</c:otherwise>
					</c:choose>
					<c:if test="${param.mode =='password'}">
						<div class="form-group">
							<label for="name">ID</label> <input type="text" name="id" id="id"
								class="form-control">
						</div>
					</c:if>
					<div class="form-group">
						<label for="name">TEL</label> <input type="text" name="tel"
							id="tel" placeholder="'-'포함 입력" class="form-control">
					</div>
					<div class="form-group">
						<label for="name">E-MAIL</label> <input type="text" name="email"
							id="email" class="form-control">
					</div>

					<input type="submit" class="btn btn-primary" value="입력"> <input
						type="button" class="btn btn-primary" value="재입력"
						onclick="document.find.reset()">
				</form>

			</div>
		</div>
	</div>
</section>


<%@ include file="/WEB-INF/views/layout/footer.jsp"%>



