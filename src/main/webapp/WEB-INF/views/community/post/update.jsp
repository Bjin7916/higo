<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<script type="text/javascript">
	function checkUpdate() {
		const u = document.getElementById("u");
		
		
		formData = new FormData(u);

		if(document.update.post_title.value == ""){
			alert("제목을 입력하십시오!");
			return;
		}else if(document.update.post_content.value == ""){
			alert("내용을 입력하십시오!")
			return;
		}


		var appendTag = "";		
		for(var i = 0; i<jsonArray.length; i++){
		    var str = jsonArray[i];
		    
		    // str의 값 : common/getImg.do?savedFileName=bc395afe-2324-438d-ae68-1a0a75d0a431.png 
		    // '='를 기준으로 자른다.
		    var result = str.toString().split('=');
		    var newInput = document.createElement('input');
		    newInput.setAttribute("type","hidden");
		    newInput.setAttribute("name","fileList");
		    newInput.setAttribute("value",result[1]);
		    //appendTag+='<input type="hidden" name="fileList" value="' + result[i] + '">'
		    // result[1] : bc395afe-2324-438d-ae68-1a0a75d0a431.png
		    u.appendChild(newInput);
		}
		
		//console.log(u);
		document.update.submit();
	}
</script>
<%@include file = "/WEB-INF/views/layout/header.jsp" %>
	<c:set var="cpath" value="${ pageContext.request.contextPath }"/>
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

<div align="center">
	<form action="${ pageContext.request.contextPath }/post/update" method="post" id="u" name = "update" enctype="multipart/form-data">
		<input type="hidden" name="post_seq" value="${vo.post_seq }">
		<table class = "postTable">
			<tr>
				<th width="60">제목</th>
				<td><input type="text" value="${vo.post_title }" name = "post_title" size = "53"></td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea class="summernote" rows="15" cols="65" name = "post_content">${vo.post_content }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="file" name = "photo" size = "400">
				</td>
			</tr>
		</table><br>
		<div class = "btnBox">
			<input type="button" value="수정" onclick="javascript:checkUpdate()">
		</div><br>
	</form>
</div>
<script type="text/javascript">
function textEdit(){
	   jsonArray = [];
	   $('.summernote').summernote({
	         height: 500,                 // 에디터 높이
	         minHeight: null,             // 최소 높이
	         maxHeight: null,             // 최대 높이
	         focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
	         lang: "ko-KR",					// 한글 설정
	        toolbar: [
	           // [groupName, [list of button]]
	           ['fontname', ['fontname']],
	           ['fontsize', ['fontsize']],
	           ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
	           ['color', ['forecolor','color']],
	           ['table', ['table']],
	           ['para', ['ul', 'ol', 'paragraph']],
	           ['height', ['height']],
	           ['insert',['picture','link','video']],
	           ['view', ['fullscreen', 'help']]
	         ],
	       fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
	       fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72'],
	       callbacks: {
	         onImageUpload : function(files){
	        	   console.log("onImageUpload", JSON.stringify(files));
	               // 파일 업로드(다중업로드를 위해 반복문 사용)
	               for (var i = files.length - 1; i >= 0; i--) {
	                   uploadSummernoteImageFile(files[i], this);
	               }
	          }
	    } 
	 });

	   $('.summernote').summernote('fontSize', '24');

	   function uploadSummernoteImageFile(file, el) {
	       var data = new FormData();	
	       data.append("file",file);
	           $.ajax({
	             url: '${ pageContext.request.contextPath }/summer_image',
	             type: "POST",
	             enctype: 'multipart/form-data',
	             data: data,
	             cache: false,
	             contentType : false,
	             processData : false,
	             success : function(data) {
	                       var json = JSON.parse(data);
	                       console.log(json);
	                       $(el).summernote('editor.insertImage',json["url"]);
	                           jsonArray.push(json["url"]);
	                           jsonFn(jsonArray);
	                   },
	                   error : function(e) {
	                       console.log(e);
	                   }
	               });
	           }

	}

	function jsonFn(jsonArray){
		console.log(jsonArray);
	}

	$(document).ready(textEdit());
</script>
<%@include file = "/WEB-INF/views/layout/footer.jsp" %>