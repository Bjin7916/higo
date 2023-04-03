// Get the modal
var modal_box = document.getElementById('modal_box');
var join = document.getElementById('join');
var btn_cancel = document.getElementsByClassName("cancelbtn")[0];

join.onclick = function () {
	modal_box.style.display = 'block'
}
btn_cancel.onclick = function () {
	modal_box.style.display = 'none'
}

window.onclick = function (event) {
	if (event.target == modal_box) { //form 바깥을 클릭하면
		modal_box.style.display = "none";
	}
};

$(function () {
	$("button.ok").click(function () {
		let id = $("input[name=uname]").val();
		/* 6~20글자 영어, 숫자조합.  특수기호 불포함 */
		let idPat = /^[a-zA-Z0-9]{6,20}$/;
		let pw = $("input[name='psw']").val();
		/*최소 8 자, 하나 이상의 문자, 하나의 숫자 및 하나의 특수 문자 정규식*/
		let pwPat = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/;
		if (!idPat.test(id)) {
			alert("존재하지 않는 아이디 입니다. 아이디를 확인해 주세요");
			return false;}
		else if (!pwPat.test(pw)) {
			alert("비밀번호를 다시 확인해주세요");
			return false;
		} else {
			$("form.animate").submit();
		}
	
	})
	$("button.none").click(function () {
		alert("비회원요? 기깔나는 혜택을 드리고 싶은데요 ?!")
	})
})