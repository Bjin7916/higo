<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/layout/header.jsp" %>
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

<div class="py-4"></div>
<section class="section">
  <div class="container">
    <div class="row justify-content-center">
      <div class=" col-lg-9   mb-5 mb-lg-0">
        <article>
          <div class="post-slider mb-4">
            <img src="${ pageContext.request.contextPath }/resources/images/gosu.jpg" class="card-img" alt="post-thumb">
          </div>
          <h1 class="h2">${vo.post_title } </h1>
          <ul class="card-meta my-3 list-inline">
            <li class="list-inline-item">
              <a href="author-single.html" class="card-meta-author">
                <img src="${ pageContext.request.contextPath }/resources/images/john-doe.jpg">
                <span>${vo.id }</span>
              </a>
            </li>
            <li class="list-inline-item">
              <i class="ti-timer"></i> hit' ${vo.post_hit }
            </li>
            <li class="list-inline-item">
              <i class="ti-calendar"></i>${vo.post_sysdate }
            </li>
            <li class="list-inline-item">
              <ul class="card-meta-tag list-inline">
                   	<c:if test="${!empty mlogin }">
                <li class="list-inline-item like-review"><a href="${ pageContext.request.contextPath }/like/Postlike?seq=${vo.post_seq }"><i class="fa fa-heart"></i>${like }${cvo.commLike_count }</a></li>
                <li class="list-inline-item"><a href="${ pageContext.request.contextPath }/post/updateForm?seq=${vo.post_seq}&mode=update">수정</a></li>
                <li class="list-inline-item"><a href="javascript:deleteAction()">삭제</a></li>
                </c:if>
              </ul>
            </li>
          </ul>
          <div class="content"><p>${vo.post_content }</p> </div>
          <hr>
				<c:choose>
					<c:when test="${empty files }">
						<i class="fas fa-save"></i> 첨부된 파일이 없습니다.	
					</c:when>
					<c:otherwise>
						첨부파일<br>
						<c:forEach var="f" items="${files}" varStatus="i">
							${i.count }. <a href="${pageContext.request.contextPath }/post/download/${vo.post_seq}?fn=${f.fileName}" download>${f.fileName }</a><br>
						</c:forEach>
					</c:otherwise>
				</c:choose>
        </article>
        <div class="mt-5">
            <div class="mb-5 border-top mt-4 pt-5">
               <h3 class="mb-4">Comments</h3>
                  <form action="${ pageContext.request.contextPath }/comment/writeComment?post_seq=${vo.post_seq}" method="post" name="writeCoComment"> 
               <div class="media d-block d-sm-flex mb-4 pb-4">
                  <a class="d-inline-block mr-2 mb-3 mb-md-0" href="#">
                  <img src="${ pageContext.request.contextPath }/resources/images/post/user-01.jpg" class="mr-3 rounded-circle" alt="">
                  </a>
                  	<c:if test="${!empty mlogin }">
                  <input type="text" name="comm_content" size="60">
                  <input class="btn btn-primary ml-2 mb-1" type="button" value="댓글쓰기" onclick="checkWriteComment()">
                  </c:if>
	                  <input type="hidden" name="comm_content" id="comm_content">
						<input type="hidden" name="comm_seq" id="comm_seq">
						<c:forEach var="cvo" items="${list }" varStatus="i">
					<div>
                  <div class="media-body">
                     <a href="#!" class="h4 d-inline-block mb-3">${vo.id}</a>
                     <p>${cvo.comm_content }</p>
                     <span class="text-black-800 mr-3 font-weight-600">${cvo.comm_sysdate }</span>
                     <a class="text-primary font-weight-600 commentContent" onclick="commentComment(event,${i.index})">Reply</a>
                  </div>
               </div>
               <div class="media d-block d-sm-flex">
                  <div class="d-inline-block mr-2 mb-3 mb-md-0" href="#">
                     <img class="mr-3" src="${ pageContext.request.contextPath }/resources/images/post/arrow.png" alt="">
                     <a href="#!"><img src="${ pageContext.request.contextPath }/resources/images/post/user-02.jpg" class="mr-3 rounded-circle" alt=""></a>
                  </div>
                  <div class="media-body">
                     <div class="commentInput" style="display: none;">
                     <input type="text" name="comm" id="comm_content${i.index}" size="60">
                     <a class="text-primary font-weight-600" onclick="checkWritecommentComment(${i.index},${cvo.comm_seq})">Reply</a>
                     </div>
                  </div>
					</div>
                  </c:forEach>
</div>
               </form>
               </div>
            </div>
          
      </div>

		</div>

        
    </div>
</section>
  </div>


	<script type="text/javascript">
	function deleteAction() {
		var check = confirm("삭제 하시겠습니까?");
		
		if(!check){
			return;
		}
		
		location.href = '${ pageContext.request.contextPath }/post/delete?seq=${vo.post_seq}';
	}
	
	function checkWriteComment() {
		if(document.writeComment.comm_content.value == ""){
			alert("댓글내용을 입력하십시오!1");
		}else{
			document.writeComment.submit();
		}
	
		
	}
	
	function checkWritecommentComment(i,seq){
		
		//console.log(seq);
		
		if(document.getElementById('comm_content' + i).value == ""){
			alert("댓글내용을 입력하십시오22!");
		}else{
			document.getElementById('comm_content').value = document.getElementById('comm_content' + i).value;
			document.getElementById('comm_seq').value = seq;
			document.writeCoComment.submit();
		}
	}
	
	function commentComment(event,i){
		
		const a = Array.from(document.querySelectorAll('.commentInput'));
		
		a.forEach((element,idx) => idx == i ? element.style.cssText = 'display: block;' : element.style.cssText = 'display: none;' );
	
	}
	</script>
	<%@ include file="/WEB-INF/views/layout/footer.jsp" %>