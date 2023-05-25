<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	function check(){
		if(document.update.password.value == ""){
			alert("비밀번호를 입력하십시오!");
		}else if(document.update.name.value == ""){
			alert("이름을 입력하십시오!");
		}else if(document.update.email.value == ""){
			alert("이메일을 입력하십시오!");
		}else if(document.update.tel.value == ""){
			alert("전화번호를 입력하십시오!");
		}else if(document.update.intro.value == ""){
			alert("한줄소개를 입력하십시오!");
		}else if(document.update.actAddr.value == ""){
			alert("활동지역을 입력하십시오!");
		}else if(document.update.svc_range.value == ""){
			alert("활동반경을 입력하십시오!");
		}else{
			document.update.submit();
		}
	}
	function daum_address(){
		  new daum.Postcode({
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

	            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	            var addr = ''; // 주소 변수
	            var extraAddr = ''; // 참고항목 변수

	            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                addr = data.roadAddress;
	            } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                addr = data.jibunAddress;
	            }

	            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
	            if(data.userSelectedType === 'R'){
	                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                    extraAddr += data.bname;
	                }
	                // 건물명이 있고, 공동주택일 경우 추가한다.
	                if(data.buildingName !== '' && data.apartment === 'Y'){
	                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                }
	                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                if(extraAddr !== ''){
	                    extraAddr = ' (' + extraAddr + ')';
	                }
	                //주소변수 문자열과 참고항목 문자열 합치기
	                addr += extraAddr;
	                
	            } else {
	               addr += ' ';
	            }

	            // 우편번호와 주소 정보를 해당 필드에 넣는다.
	            document.getElementById('actAddr_input').value = addr;

	          
	        }
	    }).open();
		
	}
</script>
<%@include file = "/WEB-INF/views/layout/header.jsp" %>
 	<div align="center">
 		<form action="${ pageContext.request.contextPath }/gosu/update" method="post" name = "update">
 			<table id="table">
			 	<tr>
			 		<td id="border">비밀번호</td>
			 		<td id="border"><input type="text" name = "password" value="${mvo.password }"></td>
			 	</tr>
			 	<tr>
			 		<td id="border">이름</td>
			 		<td id="border"><input type="text" name = "name" value="${mvo.name }"></td>
			 	</tr>
			 	<tr>
			 		<td id="border">이메일</td>
			 		<td id="border"><input type="text" name = "email" value="${mvo.email }"></td>
			 	</tr>
			 	 <tr>
			 		<td id="border">전화번호</td>
			 		<td id="border"><input type="text" name = "tel" value="${mvo.tel }"></td>
			 	</tr>
			 	 <tr>
			 		<td id="border">한줄소개</td>
			 		<td id="border"><input type="text" name = "intro" value="${vo.intro }"></td>
			 	</tr>
			 	 <tr>
			 		<td id="border">활동지역</td>
			 		<td id="border"><input type="text" name = "actAddr" id="actAddr_input" value="${vo.actAddr }" readonly = "readonly"></td>
			 		<td><input type="button" class="actAddr_button" onclick="daum_address()" value="주소찾기"></td>
			 	</tr>
			 	
			 	<tr>
			 		<td id="border">활동반경</td>
			 		<td id="border"><input type="text" name = "sve_range" value="${vo.svc_range }"></td>
			 	</tr>
			 	<tr>
			 		<td colspan="2" align="right" id="border">
			 			<input type="button" value = "수정" onclick="javascript:check()">
			 			<input type="button" value = "돌아가기" onclick="location.href='${ pageContext.request.contextPath }/gosu/mypage'">
			 		</td>
			 	</tr>
			 </table>	
 	</form>
 	</div>
<%@include file = "/WEB-INF/views/layout/footer.jsp" %>