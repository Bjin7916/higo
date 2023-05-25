<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	function checkForm(){
		document.simple.submit();
	}

</script>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<div style="border:1px solid black">
      <!-- 고객정보 및 견적요청서 정보 보여주기 -->
         <table>
           <tr>
             <td>이미지</td>
             <td colspan="2">
               <table>
                  <tr>
                    <td>${memberVO.name}</td>
                  </tr>
                  <tr>
                    <td>${subSvcVO.subSvc_name }</td>
                  </tr>
                  <tr>
                    <td>윤수</td>
                  </tr>
               </table>            
             </td>
           </tr>
           <tr>
             <td>
               ${quoteReqVO.req_text }<br>
             </td>
           </tr>
         </table>
         <!-- 견적서 작성 -->
         <div>
           <input type="button" value="자주쓰는 견적" id="myQuote"><br>
           <input type="button" value="간편견적" id="simpleB">
           <input type="button" value="맞춤견적" id="optionB"><br>
           
           <form id="simple" name="simple" action="${ pageContext.request.contextPath }/match/quoteSend?kind=1" method="post">
             <input type="hidden" name="member_seq" value="${memberVO.member_seq }"/>
             <input type="hidden" name="quoteReq_seq" value="${quoteReqVO.quoteReq_seq }"/>
             금액 설정<br>
             <input type="radio" name="price_type" value="0">총 비용
             <input type="radio" name="price_type" value="1">시간 당
             <br>
             금액<br>
             <input type="number" name ="price"><br><br>
             견적 설명<br>
             <textarea cols="40" rows="8" name="quote_detail"></textarea><br><br>
             <input type="checkbox" name="chb">자주 쓰는 견적서에 추가<br><br>
             자주쓰는 견적 제목 : <input type="text" name="jaju"><br>
             <input type="button" value="견적서 보내기 1,000원" onclick="javascript:checkForm()">      
           </form>
           
           <form id="option" name="option" action="${ pageContext.request.contextPath }/match/quoteSend?kind=2" method="post">
             <input type="hidden" name="member_seq" value="${memberVO.member_seq }"/>
             <input type="hidden" name="quoteReq_seq" value="${quoteReqVO.quoteReq_seq }"/>
             고객에게 서비스 세부 가격이 담긴 견적을 보내보세요.<br>
             가격 옵션이 구체적일수록 고용 확률이 높아집니다.<br><hr><br><br>
             가격옵션1<br><br>
             옵션이름<br>
             <input type="text" class='option_name' name="option_name"><br><br>
             옵션금액<br>
             <input type="number" class="option_price" name ="option_price" value="0"><br><br>
             <input type="button" value="+ 가격 옵션 추가하기" id="add"><br><br>
             <input type="number" id="count" name ="count" value=1>옵션 추가 개수<br><br>
      
             견적설명<br>
             <textarea name="quote_detail" cols="40" rows="8"></textarea><br><br>
             <input type="button" value="견적서 미리보기"><br><br>
             <input type="button" value="견적서 보내기 1,000원" onclick="checkForm1()">
           </form>
           <form id="addQuote" name="addQuote" action="${ pageContext.request.contextPath }/match/myQuoteSend" method="post">
           		<c:forEach var="v" items="${myQuoteAdd }">
           			<input type="hidden" name="member_seq" value="${memberVO.member_seq }"/>
            		<input type="hidden" name="quoteReq_seq" value="${quoteReqVO.quoteReq_seq }"/>
           			<input type="hidden" value="${v.get('MYQUOTE_SEQ') }" name="myQuote_seq"/>
           			<input type="submit" value="${v.get('MYQUOTE_NAME') }" name="myQuote_name"/><br>
           		</c:forEach>
           </form>
           <br>
      
         
         </div>
      
      </div>
         
      <script type="text/javascript">
      
         function checkForm1(){
          
           document.option.submit();
         }
         
         $(document).ready(function(){
           
           $("#option").hide();
           $("#addQuote").hide();
           
           $("#simpleB").click(function(){
             $("#simple").show();
             $("#option").hide();
             $("#addQuote").hide();
           });
           $("#optionB").click(function(){
             $("#simple").hide();
             $("#option").show();
             $("#addQuote").hide();
           });
           $("#myQuote").click(function(){
        	   $("#addQuote").show();
        	   $("#simple").hide();
               $("#option").hide();
           });
           
           $("#add").click(function(){
             let count = Number($("#count").val()) + 1;
             $("#count").val(count) ;
             
             $("#option").append("<br>옵션이름<br><input type='text' name='option_name'><br><br>");
             $("#option").append("옵션금액<br><input type='number' name='option_price'><br><br>");
           });
      
         });
      </script>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>

























