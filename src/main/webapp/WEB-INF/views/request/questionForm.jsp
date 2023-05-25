<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	function check() {
		//let req_text="";
		let Answer = document.getElementsByName("Answer");
		let AnswerT = document.getElementById("AnswerT");
		const req_text = document.getElementById("req_text");
		let que_text = document.getElementById("que_text");
		
		
		
		req_text.value = "";	
		
		if(que_text.value != null){
			
		req_text.value += "Q. " + que_text.value;
		req_text.value += "\n";
		}
		
		for(let i = 0; i < Answer.length; i++){
			if(Answer[i].checked){
				req_text.value += " --> " + Answer[i].value;
				req_text.value += ","
			}
		}
		if(AnswerT != null){
			req_text.value += AnswerT.value;
			req_text.value += ","
			AnswerT.value = "";
		}
		//alert(AnswerT);
		
		if(document.input.Answer == false){
			alert("값을 체크해주세요");
			return false;
		} else if(document.input.AnswerT == false){
			alert("값을 체크해주세요");
			return false;
		} else {
			
			document.input.submit();
		}
		
	}
</script>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
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

<div style="border:1px solid:black">
		<form action="/higo/quote/questionForm?subSvc=${subSvc_seq}&count=${count }" name="input" method="post">
		<input type="hidden" id="req_text" name="req_text">
		<input type="hidden" id="que_text" value="${questionVO.get('QUESTION')}">
			질문 : ${questionVO.get('QUESTION')}<br>
			질문순서 : ${questionVO.get('QUESTION_STEP')}<br>
			답변타입 : ${questionVO.get("ANWTYPE_SEQ") }<br>
			<br>
			<c:forEach var="answer" items="${answerVO }" varStatus="aStatus">
				
				<c:if test="${answer.get('QUESTION_SEQ') eq count}"> 
					<c:choose>
						<c:when test="${questionVO.get('ANWTYPE_SEQ') eq 1}">
							<input type="radio" name="Answer" value="${answer.get('ANW') }" />
							<label>${answer.get("ANW") }<br></label>						
						</c:when>
						
						<c:when test="${questionVO.get('ANWTYPE_SEQ') eq 2}">
       					<input type="checkbox" name="Answer" value="${answer.get('ANW') }" />
						<label>${answer.get("ANW") }<br></label>				
						</c:when>
						
						<c:when test="${questionVO.get('ANWTYPE_SEQ') eq 3}">
							<input type="text" name="AnswerT" id="AnswerT"/>
						</c:when>
						<c:otherwise>
							<input type="radio" name="Answer"/>
							<label>${answer.get("ANW") }<br></label>
						</c:otherwise>
					</c:choose>
					
				</c:if>
			</c:forEach>
			<input type="button" value="다음" onclick="javascript:check()">
			
		</form>
</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>
