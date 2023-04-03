<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="${ pageContext.request.contextPath }/resources/js/httpRequest.js"></script>

<script>
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
function checkAll() {
	if (!checkUserId(join.id.value)){
		return false;
	}
	if(!checkPassword(join.password.value,join.repw.value)){
		return false;
	}
	if(!checkName(join.name.value)){
		return false;
	}
	if(!checkMail(join.email.value)){
		return false;
	}
	if(!checkTel(join.tel.value)){
		return false;
	}
	
	return true;
}

// 공백확인 함수
function checkExistData(value, dataName){
	if(value == ""){
		alert(dataName + "입력해주세요!");
		return false;
	}
	return true;
}

function checkUserId(id){
	// id 입력확인
	if(!checkExistData(id, "아이디를"))
		return false;
	
	//아이디 정규식
	var idJ = /^[a-z0-9][a-z0-9_\-]{4,12}$/;
	if(!idJ.test(id)){
		alert("아이디는 영문 대소문자와 숫자 4~12자리로 입력해야합니다!");
		join.id.value ="";
		join.id.focus();
	}
	return true;  //확인 완
}

function checkPassword(password, repw) {
	
    //비밀번호가 입력되었는지 확인하기
    if (!checkExistData(password, "비밀번호를"))
         return false;    
    //비밀번호 확인이 입력되었는지 확인하기
    if (!checkExistData(repw, "비밀번호 확인을"))
        return false;
    
 	// 비밀번호 정규식
    var pwJ = /^[a-zA-z0-9]{4,12}$/; 
    if (!pwJ.test(password)) {
        alert("비밀번호는 영문 대소문자와 숫자 4~12자리로 입력해야합니다!");
        join.password.value = "";
        join.password.focus();
        return false;
    }

    //비밀번호와 비밀번호 확인이 맞지 않다면..
    if (password != repw) {
        alert("두 비밀번호가 맞지 않습니다.");
        join.password.value = "";
        join.repw.value = "";
        join.repw.focus();
        return false;
    }

    return true; //확인이 완료되었을 때
} 

function checkName(name){
	if(!checkExistData(name,"이름을"))
		return false;
	
	// 이름 정규식
	var nameJ = /^[가-힣]{2,4}|[a-zA-Z]{2,10}\s[a-zA-Z]{2,10}$/;
	if(!nameJ.test(name)){
		alert("이름이 올바르지 않습니다.");
		return false;
	}
	return true;
}

function checkMail(email){
	//email이 입력되었는지
	if(!checkExistData(email,"이메일을"))
		return false;
	
	// 이메일 검사 정규식
	var mailJ = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	if(!mailJ.test(email)) {
		alert("이메일 형식이 올바르지 않습니다!");
		join.email.value ="";
		join.email.foucs();
		return false;
	}
	return true; //확인이 완료되었을 때
}

function checkTel(tel){
	if(!checkExistData(tel,"전화번호를"))
		return false;
	
	// 휴대폰 번호 정규식
	var phoneJ = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/;
	if(!phoneJ.test(tel)){
		alert("전화번호가 올바르게 입력되지않았습니다");
		join.tel.value ="";
		join.tel.foucs();
		return false;
	}
	return true;
}
//중복확인
function checkId(){
	
	const id = document.getElementById("id");
	
	var idJ = /^(?=.*[a-z])[a-z0-9]{4,12}$/;
	
	if(id.value == ""){
		alert("아이디를 입력하십시오!");
		return; 
	}else if(!idJ.test(id.value)){
			alert("아이디는 영문 대소문자와 숫자 4~12자리로 입력해야합니다!");
			return;
	}
	
	
	
	var method = "POST";
	var param = "id=" + encodeURIComponent(id.value);
	var url = "${ pageContext.request.contextPath }/member/checkId"
	sendRequest(url,param,resultCheckId,method);
}

function resultCheckId() {
	if(xhr.readyState == 4 && xhr.status == 200){
		
		var data = xhr.responseText;
		const check = document.getElementById("check");
		
		check.innerText = "";
		
		
		if(data == '사용 가능한 ID입니다'){
			check.style.cssText="color: blue; font-size: 10px;";
		}else{
			check.style.cssText="color: red; font-size: 10px;";				
		}
		
		check.innerText = data;
	}
	
}	
	
//이메일
function checkEmail(){
	
	const email = document.getElementById("email");
	
	var mailJ = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	
	if(email.value == ""){
		alert("이메일을 입력하십시오!");
		return; 
	}else if(!mailJ.test(email.value)){
			alert("이메일 형식이 올바르지 않습니다!");
			return;
	}
	
	
	
	var method = "POST";
	var param = "email=" + encodeURIComponent(email.value);
	var url = "${ pageContext.request.contextPath }/member/checkEmail"
	sendRequest(url,param,resultCheckEmail,method);
}

function resultCheckEmail() {
	if(xhr.readyState == 4 && xhr.status == 200){
		
		var data = xhr.responseText;
		const checkE = document.getElementById("checkE");
		
		checkE.innerText = "";
		
	
		if(data == '사용 가능한 Email입니다'){
			checkE.style.cssText="color: blue; font-size: 10px;";
		}else{
			checkE.style.cssText="color: red; font-size: 10px;";				
		}
		
		checkE.innerText = data;
	}	

}	
	
//전화번호
function checkTel(){
	
	const tel = document.getElementById("tel");
	
	var phoneJ =  /^((01[1|6|7|8|9])[1-9]+[0-9]{6,7})|(010[1-9][0-9]{7})$/;
	
	if(tel.value == ""){
		alert("전화번호를 입력하십시오!");
		return; 
	}else if(!phoneJ.test(tel.value)){
			alert("번호를 다시 입력해주세요!");
			return;
	}
	
	
	
	var method = "POST";
	var param = "tel=" + encodeURIComponent(tel.value);
	var url = "${ pageContext.request.contextPath }/member/checkTel"
	sendRequest(url,param,resultCheckTel,method);
}

function resultCheckTel() {
	if(xhr.readyState == 4 && xhr.status == 200){
		
		var data = xhr.responseText;
		const checkT = document.getElementById("checkT");
		
		checkT.innerText = "";
		
	
		if(data == '사용 가능한 번호입니다'){
			checkT.style.cssText="color: blue; font-size: 10px;";
		}else{
			checkT.style.cssText="color: red; font-size: 10px;";				
		}
		
		checkT.innerText = data;
	}	

}
	
	


function checkedChange() {
    if($(this).prop("checked")){
        $("label[for="+this.id+"]").text("동의되었습니다.");
        $("label[for="+this.id+"]").css("color","blue");
    }else{
        $("label[for="+this.id+"]").text("동의 해주시기 바랍니다.");
        $("label[for="+this.id+"]").css("color","red");
    }
}

</script>
	
<%@ include file="/WEB-INF/views/layout/header.jsp" %>


<div class="header text-center">
	<div class="container">
		<div class="row">
			<div class="col-lg-9 mx-auto">
				<h1 class="mb-4">welcome to SSAP GOSU Zone</h1>
				<ul class="list-inline">
					<li class="list-inline-item"><a class="text-default"
						href="${ pageContext.request.contextPath }">홈 &nbsp; &nbsp;
							/</a></li>
					<li class="list-inline-item text-primary">고수 가입</li>

				</ul>
			</div>
		</div>
	</div>

</div>

<section class="section-sm">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 mx-auto">
				<form action="${ pageContext.request.contextPath }/gosu/join" method="post" name="join" onsubmit="return checkAll()">
						<c:if test="${empty mlogin }">
							<div class="form-group">
								<label for="id">아이디</label> <input type="text" id ="id"name="id"
									 class="id_input form-control">
						<button type="button" onclick="checkId()">중복확인</button><br>
						<span id="check"></span>
							</div>
							<div class="form-group">
								<label for="password">비밀번호</label> <input type="password"
									name="password"  class="form-control">
							</div>
							<div class="form-group">
								<label for="password">비밀번호 확인</label>
								<input type="password" name="repw" class="form-control">
							</div>
							<div class="form-group">
								<label for="name">이름</label> <input type="text"
									name="name" class="form-control">
							</div>
							<div class="form-group">
								<label for="email">이메일</label> <input type="text"
									name="email" class="form-control">
							</div>
							<div class="form-group">
								<label for="tel">전화번호</label> <input type="text"
									name="tel" class="form-control">
							</div>
						</c:if>
						<c:if test="${!empty mlogin	}">
						<input type ="hidden" name="member_seq" value="${mlogin }">
						</c:if>
						<!-- 서비스 범위 -->
	
			<div class="form-group">
				<label for="svc_range">이동 가능 거리</label>
				</div>
			<!-- 서비스 범위 지도 -->
			<div class="col-12 w-100" id="service-range" >
				<div class="col-12 w-100">
					<div class="row justify-content-center m-2 radius1">	
						<div class="col-4">
							<button class="col-5 svc_range km" name="svc_range" type="button" value="2">2Km</button>
						</div>
						<div class="col-4">
							<button class="col-5 svc_range km" name="svc_range" type="button" value="5">5Km</button>
						</div>
						<div class="col-4">
							<button class="col-5 svc_range km" name="svc_range" type="button" value="10">10Km</button>
						</div> 
					</div>	
					<div class="row justify-content-center m-2 mb-5 radius1">	
						<div class="col-4">
							<button class="col-5 svc_range km" name="svc_range" type="button" value="25" >25Km</button>
						</div>
						<div class="col-4">
							<button class="col-5 svc_range km" name="svc_range" type="button" value="50">50Km</button>
						</div>
						<div class="col-4">
							<button class="col-5 svc_range km" name="svc_range" type="button" value="100">100Km</button>
						</div>
					</div>
				</div>
			</div>
	
						<div class="form-group">
								<label for="intro">고수의 한줄 소개</label>
								 <input type="text"
									name="intro" class="form-control">
							</div>
							<div class="form-group">
								<label for="actAddr">활동지역</label> 
								<input type="text" id ="actAddr_input" name="actAddr" class="form-control" readonly = "readonly">
								<input type="button"  class="actAddr_button" onclick="daum_address()" value="주소찾기">
							</div>
							<div class="form-group">
								<label for="svc_range">활동반경</label> 
								<input type="text" name="svc_range" class="form-control">
							</div>
							
		<fieldset class="fieldarea f2">
			<legend><span>이용</span>약관</legend>
				<label for="agreement1"><input id="agreement1" type="checkbox" onclick="checkedChange" name="ad_agree"> 아래 사항에 동의 합니다.</label>
			<p class="agreeText">
				<span>
				<textarea id="text1" readonly>
					이용약관
				</textarea></span>
			</p>
		</fieldset>
							<div class="join_button_wrap">
							<input type="submit" class="join_button" value="가입하기">
							</div>
					</form>
			</div>
		</div>
	</div>
</section>

<script>

$(function(){
	$(".svc_range").on("click", function(){
		$("input[name='km']").val($(this).val());
	})
})

// ================================ 지도 활동범위 ==================================
	
var km = document.getElementsByClassName("km");

function act_range(event) {
      console.log(event.target);
      // console.log(this);
      // 콘솔창을 보면 둘다 동일한 값이 나온다

      console.log(event.target.classList);

      if (event.target.classList[1] === "btn btn-info") {
        event.target.classList.remove("btn btn-info");
      } else {
        for (var i = 0; i < km.length; i++) {
          km[i].classList.remove("btn btn-info");
        }

        event.target.classList.add("btn btn-info");
		}

    function init() {
      for (var i = 0; i < km.length; i++) {
        km[i].addEventListener("click", handleClick);
      }
    }
    init();
}
.

    

</script>

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>







