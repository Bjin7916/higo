<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="${ pageContext.request.contextPath }/resources/js/httpRequest.js"></script>

<script>

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
	if(!checkedChange(join.ad_agree.value)){
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
				<h1 class="mb-4">회원 가입</h1>
				<ul class="list-inline">
					<li class="list-inline-item"><a class="text-default"
						href="${ pageContext.request.contextPath }">Home &nbsp; &nbsp;
							/</a></li>
					<li class="list-inline-item text-primary">MEMBER JOIN</li>

				</ul>
			</div>
		</div>
	</div>

</div>

<section class="section-sm">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 mx-auto">
		<form action="${ pageContext.request.contextPath }/member/join"
			method="post" name="join" onsubmit="return checkAll()">
			<div class="form-group">
				<div class="id_wrap">
					<label for="id">아이디</label> <input type="text" id ="id"name="id"
									 class="id_input form-control">
						<button type="button" onclick="checkId()">중복확인</button><br>
						<span id="check"></span>
				</div>
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
				
		<fieldset class="fieldarea f2">
			<legend><span>이용약관</legend>
				<label for="agreement1"><input id="agreement1" type="checkbox" onclick="checkedChange" name="ad_agree"> 아래 사항에 동의 합니다.</label>
			<p class="agreeText">
				<span>
				<textarea id="text1" readonly class="w-100" style="height: 200px">
					이용약관
					
					제 1 조 (목 적)
이 약관은 이용자가 주식회사 브레이브모바일(이하 “회사”)이 운영하는 인터넷 서비스 사이트(이하 “사이트” 또는 “숨고”)를 통해 제공하는 인터넷 전자상거래 관련 서비스(이하 “서비스”)와 관련하여 회사와 이용자의 권리, 의무, 책임사항을 규정함을 목적으로 합니다. 또한 본 약관은 유무선 PC통신, 태블릿 PC, 스마트폰(아이폰, 안드로이드폰 등) 어플리케이션 및 모바일웹 등을 이용하는 전자상거래 등에 대해서도 그 성질에 반하지 않는 한 준용됩니다.
본 약관이 규정한 내용 이외의 회사와 이용자 간의 권리, 의무 및 책임사항에 관하여서는 전기통신사업법 기타 대한민국의 관련 법령과 상관습에 의합니다.
제 2 조 (정 의)
이 약관에서 사용하는 용어의 정의는 다음과 같습니다.

회사가 운영하는 사이트는 아래와 같습니다.
soomgo.com, 추후 회사에서 공지하고 제공하는 기타 웹사이트, 스마트폰 및 이동통신기기를 통해 제공되는 모바일 어플리케이션 포함
이용자: 숨고에 접속하여 이 약관에 따라 서비스를 받는 회원 및 비회원을 말합니다.
회원: 본 약관에 따라 회사와 서비스 이용계약을 체결하고 회원 아이디(ID)를 부여받아 회사가 제공하는 서비스를 이용하는 개인을 말합니다. 회원은 이용하는 서비스에 따라 고객과 고수 회원으로 나누어집니다.
고객: 회사에 개인정보를 제공하여 회원등록을 한 자로서, 회사와 서비스 이용계약을 체결하고 회원 아이디(ID)를 부여 받아 사이트 내에 게시된 광고를 열람하거나 요청서를 작성하고 고수 회원에게 요청서를 보내거나 마켓 상품을 구매하는 등 원하는 용역의 고수를 찾기 위해 사이트를 계속적으로 이용할 수 있는 자를 말합니다.
고수 회원: 회사에 개인정보를 제공하여 회원등록을 한 자로서, 회사와 서비스 이용계약을 체결하고 회원 아이디(ID)를 부여 받아 숨고 캐시를 구매하여 고객에게 견적을 보내거나 마켓 상품을 등록하여 판매하는 등 고객을 찾기 위한 서비스를 계속적으로 이용할 수 있는 자를 말합니다.
요청서: 요청자가 원하는 용역에 대한 구체적인 정보를 담고 있는 서비스 요청서입니다.
견적(견적서): 고수 회원이 자신이 제공할 수 있는 용역에 관하여 요청자에게 보낼 수 있는 용역 금액 및 내용에 대한 요약본입니다.
숨고 캐시: 회원이 견적 발송, 즉 서비스를 사용하기 위해 구매하는 사이버 머니를 의미합니다. 숨고 캐시는 충전 캐시와 보너스 캐시로 구성되며, 숨고 캐시의 사용 순서는 회사가 정하는 정책에 따릅니다.
충전 캐시 : 회원이 결제한 금액과 동일한 양으로 충전되는 캐시이며, 환불이 가능합니다.
보너스 캐시: 충전 캐시 구매에 대한 혜택으로 회사에서 무상으로 제공하는 사이버 포인트 개념으로, 충전 캐시와 마찬가지로 견적 발송 등 서비스내에서 사용할 수 있습니다. 보너스 캐시는 환불이 불가합니다.
콘텐츠(Contents): 회사가 숨고에서 제공하는 정보, 요청서 작성, 견적 작성, 요청서 수신, 견적 수신, 프로그램 등 부호ㆍ문자ㆍ도형ㆍ색채ㆍ음성ㆍ음향ㆍ이미지ㆍ영상 및 복합체의 정보나 자료를 의미합니다.
회원 아이디(이하 “ID”): 회원의 식별과 회원의 서비스 이용을 위하여 회원이 선정하고 회사가 승인하는 문자 또는 숫자의 조합을 말합니다.
비밀번호(Password): 이용자가 등록회원과 동일인인지 신원을 확인하고, 회원의 통신상 개인정보를 보호하기 위하여 회원이 정한 문자와 숫자의 조합을 말합니다.
비회원: 회원에 가입하지 않고 서비스를 이용하는 자로 숨고 이용자 및 정보의 수신을 위해 전자우편 및 SMS 서비스를 온라인 또는 서면으로 신청한 자를 지칭합니다.
회원 탈퇴: 회원이 이용계약을 종료시키는 행위를 말합니다.
뉴스레터(Newsletter): 회사가 보내는 숨고 소식이 담긴 이메일을 의미합니다.
숨고페이 안전결제 서비스 (이하 "숨고페이")는 회원 상호 간 안전하고 용이한 금전 거래를 위해 회사가 결제대금예치업자를 통하여 제공하는 결제 서비스를 의미합니다.
인터랙션 : 회원간의 채팅, 전화 등 숨고에서 제공하는 방식을 통해 상호작용 할 수 있는 행위를 의미 합니다.
마켓 : 고수 회원이 자신이 제공할 수 있는 유형의 제품 또는 무형의 용역에 대한 금액과 내용을 회사가 제공하는 일정한 양식에 따라 회사의 사이트에 등록하고, 고객이 정해진 금액을 결제하여 고수 회원으로부터 유형의 제품 또는 무형의 용역을 제공 받는 형태의 서비스를 말합니다.
게시물 : 회원이 숨고 상에 게시 또는 등록하는 부호(URL 포함), 문자, 이미지, 사진, 동영상, 음성, 파일 등을 말합니다.
제 3 조 (약관의 명시, 효력 및 개정)
회사는 이 약관의 내용과 주소지, 관리자의 성명, 개인정보보호 담당자의 성명, 연락처(전화, 팩스, 전자우편 주소 등) 등을 이용자가 알 수 있도록 숨고의 초기 서비스 화면에 게시합니다. 다만, 약관의 구체적 내용은 이용자가 연결화면을 통하여 볼 수 있습니다.
이 약관은 그 내용을 숨고에 게시하거나 이메일 등 기타의 방법으로 회원에게 공지함으로써 효력이 발생합니다.
서비스 이용 시 화면에서 제시되는 경고 메시지의 효력은 본 약관의 효력과 동일합니다.
회사는 약관의 규제에 관한 법률, 전자거래기본법, 전자서명법, 정보통신망 이용촉진 및 정보 보호 등에 관한 법률 기타 관련 법령을 위배하지 않는 범위 내에서 약관을 변경할 수 있습니다.
회사는 약관이 변경되는 경우에는 적용일자 및 변경사유를 명시하여 현행약관과 함께 숨고의 초기 서비스 화면 또는 팝업화면으로 적용일자의 7일 이전부터 적용일 후 상당한 기간 동안 게시합니다. 다만, 회원의 권리, 의무에 중대한 영향을 미칠 수 있는 변경 및 개정의 경우에는 적용일자 30일 전부터 이메일을 통하여 개별 공지하도록 합니다.
회원은 개정되는 약관의 전체 또는 일부 내용에 동의하지 않을 수 있습니다. 회원이 본 약관의 변경에 대하여 동의하지 않는 경우 회원탈퇴를 통해 이용계약을 해지할 수 있습니다.
회사가 약관 변경의 공지를 통해 개정된 약관의 적용일자로부터 7일(회원에게 불리하거나 중대한 사항의 변경인 경우에는 30일)내에 이용자가 동의하지 않는다는 의사를 표시하지 아니하면 약관에 동의한 것으로 본다는 내용을 명확하게 함께 고지하였음에도, 회원이 동의하지 않는다는 의사를 표시하지 않는 경우 회사는 회원이 적용 시행일자로부터 약관의 변경에 동의한 것으로 간주합니다.
제 4 조 (약관 외 준칙)
이 약관은 회사가 제공하는 개별서비스에 관한 이용안내(이하 ‘서비스 별 안내’라 합니다)와 함께 적용합니다.
이 약관에 명시되지 않은 사항에 대해서는 전기통신사업법, 전자거래기본법, 정보통신망법, 학원법, 기타 관련법령 및 서비스 별 안내의 규정에 의합니다.
제 2 장 서비스 이용 계약
제 5 조 (이용 계약의 성립)
이용 계약은 서비스 이용 희망자의 이 약관에 대해 동의한다는 의사표시와 이용 신청에 대한 회사의 승낙으로 성립됩니다.
이 약관에 대한 동의는 이용 신청 당시 서비스 이용 희망자의 이용약관의 확인과 명시적 의사표시를 통해 성립됩니다.
이용 계약은 만 14세 이상의 개인 또는 기업(개인사업자 및 법인사업자 등)이 할 수 있습니다. 타인의 정보를 도용하여 회원으로 가입한 자는 회사가 제공하는 서비스를 이용할 수 없으며, 이용하여서도 안 됩니다.
제 6 조 (회원가입 및 승낙)
회원가입은 회원이 되고자 하는 이용자(이하 “가입신청자”)가 약관의 내용에 동의를 하고, 회사가 정한 가입 양식에 따라 회원정보(이용자ID), 비밀번호, 주소, 연락처 등)를 기입하여 회원가입신청을 하고 회사가 이러한 신청에 대하여 승인함으로써 체결됩니다.
이용자의 회원가입신청에 대하여 회사가 승낙한 경우, 회사는 회원 ID/Password와 기타 회사가 필요하다고 인정하는 내용을 이용자에게 통지합니다.
회사는 이용자의 신청에 대해서 회원가입을 승낙하는 것을 원칙으로 합니다. 다만, 다음 각 호에 해당하는 신청에 대하여는 승인을 하지 아니할 수 있습니다.
본인 실명이 아니거나 다른 사람의 명의를 사용하여 신청하였을 때
서비스 이용 계약 신청서의 내용을 허위로 기재하였을 때
사회의 안녕과 질서 혹은 미풍양속을 저해할 목적으로 신청하였을 때
부정한 용도로 본 서비스를 이용하고자 하는 경우
영리를 추구할 목적으로 본 서비스를 이용하고자 하는 경우
본 서비스와 경쟁관계에 있는 이용자가 신청하는 경우
기타 이용신청자의 귀책사유로 이용승낙이 곤란한 경우
회사는 서비스 이용신청이 다음 각 호에 해당하는 경우에는 그 신청에 대하여 승낙 제한사유가 해소될 때까지 승낙을 유보할 수 있습니다.
회사가 설비의 여유가 없는 경우
회사의 기술상 지장이 있는 경우
기타 회사의 귀책사유로 이용승낙이 곤란한 경우
제 7 조 (서비스 이용)
회원은 사이트를 통한 회원가입 시 발급된 ID 하나로 제1장 제2조 1항에 명시된 모든 사이트에 자동 가입되며, 해당 서비스를 이용할 수 있습니다. 단, 일부 사이트의 특정 서비스는 별도의 가입절차를 통하여 이용할 수 있으며, 이 경우 해당 사이트의 이용 시에는 해당 사이트의 특정서비스에 대한 이용약관이 이 약관보다 우선 적용됩니다.
회원의 최초 서비스 이용신청 이후 사이트가 늘어난 경우에도 신규 사이트의 이용약관에서 달리 명시되지 않는 한 제1항의 내용이 마찬가지로 적용됩니다. 이 경우 회사는 신규 사이트의 서비스 개시 일자, 회원자동가입 사실 기타 관련 정보를 그 개시일 7일 이전부터 개시 일까지 각 사이트에 공지하거나, 또는 그 개시일 7일 이전까지 이메일 통지 등으로 각 회원에게 개별 통지합니다.
숨고 서비스 이용은 사이트의 업무상 또는 기술상 특별한 지장이 없는 한 연중무휴, 1일 24시간을 원칙으로 합니다.
회사가 숨고에서 제공하는 서비스는 기본적으로 무료입니다. 단, 별도로 고수 회원이 고객에게 견적을 보내는 등 일부 특정 서비스를 이용하기 위해서는 회사로부터 구매하거나 무상으로 제공받은 숨고 캐시를 사용하여야만 해당 서비스를 이용 가능합니다.
유료서비스 이용 요금 및 결제 방식은 해당 서비스에 명시되어 있는 규정에 따릅니다.
회사는 통신판매중개업자로서 서비스 요금이 무료인 서비스와 일부 유료서비스 이용과 관련하여 이용자들 사이에서 발생한 거래와 관련된 손해에 대해서는 회사에 고의 또는 중대한 과실이 있는 경우를 제외하고는 책임을 지지 않습니다.
제 3 장 서비스 제공 및 변경
제 8 조 (서비스 내용)
회사가 제공하는 서비스의 내용은 다음과 같습니다.

고객에게 고수 회원의 견적 정보 제공
고객의 요청서를 고수 회원에게 제공
고수 회원에게 마켓 상품 등록 및 판매 수단 제공
고객에게 마켓 상품 구매 중개
숨고캐시 판매
기타 관련 부수적 서비스
제 9 조 (정보의 제공 및 광고의 게재)
회사는 회원에게 서비스 이용에 필요하다고 인정되는 각종 정보에 대해서 사이트 및 이메일, SMS, DM 발송 등 각종 매체에 게재하는 방법 등으로 회원에게 제공할 수 있습니다.
회사는 서비스 개선 및 소개 등을 목적으로 회원의 동의 하에 추가적인 개인정보를 요청할 수 있습니다.
회사는 서비스의 운용과 관련하여 사이트, 이메일, SMS, DM 등에 광고 등을 게재할 수 있습니다.
제 10 조 (서비스 제공의 제한 및 중단)
회사는 정기점검, 보수, 교체 등 회사가 필요한 경우 및 부득이한 사유로 인하여 서비스 이용에 지장이 있는 경우에는 서비스의 이용의 전부 또는 일부를 제한하거나 일시 중단할 수 있습니다.
전시, 사변, 천재지변 또는 이에 준하는 국가 비상사태가 발생하거나 발생할 우려가 있는 경우와 정전, 서비스 이용 폭주 등으로 정상적인 서비스가 불가능한 경우 등 기타 불가항력적인 사유가 있는 경우에는 서비스 이용의 전부 또는 일부를 제한하거나 중지할 수 있습니다.
제1항에 의한 서비스 중단의 경우에는 사이트는 회원에게 제11조의 방법으로 통지를 합니다. 단, 사이트가 통제할 수 없는 사유로 인한 서비스 중단으로 사전 통지가 불가능한 경우에는 그러하지 아니합니다.
회사는 제1항의 사유로 서비스의 제공이 일시적으로 중단됨으로 인하여 이용자 또는 제3자가 입은 손해에 대하여 배상합니다. 단, 회사의 고의 또는 과실이 없음을 입증하는 경우에는 그러하지 아니합니다.
제 11 조 (회원에 대한 통지)
회사가 회원에 대한 통지를 하는 경우에는 회원이 서비스 이용 신청 시 사이트 화면 또는 회원가입 시 제출한 이메일 주소로 할 수 있습니다.
회사는 불특정 다수 회원에 대한 통지의 경우 7일 이상 사이트 상에 게시함으로써 개별 통지에 갈음할 수 있습니다.
제 12 조 (회원탈퇴 및 자격상실)
회원이 이용계약을 해지하고자 하는 때에는 회원 본인이 숨고 내의 메뉴 또는 전화 등의 방법을 이용하여 가입해지를 신청할 수 있으며, 회사는 즉시 회원 탈퇴 처리를 합니다.
회원 탈퇴가 이루어짐과 동시에 서비스 이용과 관련된 모든 정보는 삭제됩니다. 이로 인해 발생하는 불이익에 대한 책임은 회원 본인에게 있습니다.
회원이 다음 각 호의 사유에 해당하는 경우, 회사는 회원의 회원자격을 적절한 방법으로 제한 및 정지, 상실 시킬 수 있습니다.
가입 신청 시에 허위 내용을 등록한 경우
다른 사람의 ‘서비스’이용을 방해하거나 그 정보를 도용하는 등 전자거래질서를 위협하는 경우
서비스를 이용하여 법령과 본 약관이 금지하거나 공서양속에 반하는 행위를 하는 경우
제1호 내지 제3호 기타 부정한 방법으로 숨고 캐시를 적립, 사용한 경우
영리목적으로 개인 휴대폰 번호 혹은 개인 홈페이지, SNS 주소 등을 노출하여 우회거래를 유도한 경우
커뮤니티에서 불건전 게시물을 상습적으로 게시하거나, 유사 게시물을 지속적으로 게시한 경우
숨고페이 또는 마켓에서 허위매매·매매조작행위 등 부정 결제 행위를 행하는 경우
회사가 회원 자격을 제한ㆍ정지 시킨 후, 동일한 행위가 2회 이상 반복되거나 10일 이내에 그 사유가 시정되지 아니하는 경우
회사가 회원자격을 상실시키는 경우에는 회원등록을 말소합니다. 이 경우 회원에게 이를 통지하고, 회원등록 말소 전에 소명할 기회를 부여합니다.
제 4 장 숨고 캐시 사용 및 보상
제 13 조 (숨고 캐시 사용 및 보상)
숨고 캐시는 회사가 제공하는 서비스를 사용할 때 지불 수단으로 이용될 수 있습니다.
숨고 캐시는 보상이 필요할 경우 숨고 서비스 내에서 유료 결제 서비스마다 보상 정책에 대한 안내를 할 수 있습니다.
제 14 조 (견적 발생 비용)
고수 회원은 고객이 작성한 요청서를 열람하고, 고객에게 자신이 제공할 수 있는 용역에 대한 견적을 발송할 수 있습니다. 고객이 작성한 요청서의 유효기간은 48시간이며, 해당 시간 내에 견적을 발송할 수 있습니다.
견적 발송은 유료이며, 고수 회원은 회사가 제시하는 견적 발송 서비스 대금을 결제하고 견적 발송 서비스를 이용할 수 있습니다. 견적 발송에 대한 대금은 숨고 캐시로 지급하여야 합니다.
견적 발송 서비스 대금은 고수 회원과 고객 간 원활하고 정확한 매칭을 위하여 서비스의 종류, 지역, 고객의 요청서 밀집도 등 제반 조건에 따라 차등 산정됩니다. 회사는 고수 회원이 각 견적을 발송하기 전에 지불하여야 하는 대금을 확인할 수 있도록 사전 고지합니다. 이를 확인하지 아니하고 견적을 발송함으로써 고수 회원에게 발생한 손해에 대하여는 회사가 책임을 지지 아니합니다.
제 15 조 (미확인 견적 건에 대한 보상)
견적이 발송된 이후 48시간동안 해당 견적에 대해 고객이 아무런 반응이 없을 경우 (①견적이 전달된 채팅방에 입장하지 않았을 때, ②받은 견적에서 고수프로필을 열람하지 않았을 때를 의미합니다), 고수 회원은 견적 발송에 지급된 비용을 보너스 캐시로 보상받을 수 있습니다.
				</textarea></span>
			</p>
		</fieldset>
				<div class="join_button_wrap">
					<input type="submit" class="join_button" value="가입하기">
				</div>
			</div>
		</form>
			</div>
		</div>
	</div>
</section>

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>







