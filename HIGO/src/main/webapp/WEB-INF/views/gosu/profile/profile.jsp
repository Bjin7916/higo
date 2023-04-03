<%@page import="com.higo.member.MemberVO"%>
<%@page import="com.higo.gosu.GosuVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	MemberVO vo = (MemberVO) request.getAttribute("vo");
	GosuVO gv = (GosuVO) request.getAttribute("gv");
%>

<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=aeca1efe563f92e4748e0bd53d8657d0&libraries=services,clusterer,drawing"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>


<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<!-- START Profile_wrap -->
<div class="container profile_wrap section align-items-center mt-5 mx-auto">

	<!-- 고수 리뷰정보 -->
	<form action="${ pageContext.request.contextPath }/gosu/reviewInfo" method="post" name="review" class="my-5">
		<div class="review_wrap row justify-content">
			<div class="col-4" style="display: inline-block;">
				<a><img style="border-radius: 5px; width: 150px; height: 150px"
					alt="profile"
					src="${ pageContext.request.contextPath }/resources/images/gguk.jpg">
					<span class="bi bi-camera"></span>	
				</a>
				
			</div>
			<div class="mx-5 my-2 col-6" style="display: inline-block;">
				<div class="mx-4 my-2 " style="display: inline-block;">
					<div><p class="fs-2 fw-bold h3">리뷰평점 &nbsp;&nbsp;&nbsp;|</p></div>
					<div><p class="fw-semibold h3">&nbsp;&nbsp; ${ star_avg }</p></div>
				</div>
				<div class="mx-1 my-2" style="display: inline-block;">
					<div><p class="fs-2 fw-bold h3">리뷰수 &nbsp;&nbsp;&nbsp;|</p></div>
					<div><p class="fw-semibold h3">&nbsp;&nbsp; ${ review }</p></div>
				</div>
				<div class="mx-1 my-2" style="display: inline-block;">
					<div><p class="fs-2 fw-bold h3">고용수</p></div>
					<div><p class="fw-semibold h3">&nbsp;&nbsp; ${ hire }</p></div>
				</div>
			</div>
		</div>
	</form>

	<!-- 고수 기본정보 -->
	<form action="${ pageContext.request.contextPath }/gosu/gosuinfo" method="post" name="user_info" class="my-5">
		<div class="gosu-info row justify-content-between">
			<div class="col-8 my-3">
				<div class="text-wrap">
					<h4 class="text-start">
						<strong class="text-start">이름</strong>
					</h4>
				</div>
			</div>
			<div class="col-4">
				<input class="offset-md-8 mt-2 btn btn-success" id="name_btn" type="button" value="수정" onclick="userName()">
			</div>
			<div class="col-12 w-100 text-wrap">
				<input class="col-12 mb-5 border border-success" type="text" id="name" value="${vo.name }" disabled="disabled">
			</div>
		</div>
	</form>

	<!-- 대표서비스 -->
	<form action="${ pageContext.request.contextPath }/gosu/majorSvc" method="post" class="my-5">
		<div class="row justify-content-between">
			<div  class="col-8 my-3">
				<div>
					<h4>
						<strong>대표 서비스</strong>
					</h4>
				</div>
				<div class="col-12 w-100 text-wrap mb-5">
					<c:forEach var="i" items="${ major }">
						<div>${ i }</div>
					</c:forEach>
				</div>
			</div>
			<div class="col-4">
				<input class="offset-md-8 mt-2 btn btn-success" type="button" value="수정" onclick="">
			</div>
		</div>
	</form>

	<!-- 한줄소개 -->
	<form action="${ pageContext.request.contextPath }/gosu/intro" method="POST" id="introForm" class="my-5">
		<div class="row justify-content-between">
			<div class="col-8 my-3">
				<div class="text-wrap">
					<h4>
						<strong>한줄 소개</strong>
					</h4>
				</div>
			</div>
			<div class="col-4">
				<input class="offset-md-8 mt-2 btn btn-success" id="intro_btn" type="button" value="수정" onclick="reIntro()">
			</div>
			<div class="col-12 w-100 text-wrap">
				<input class="w-100 col-12 mb-5 border border-success" type="text" id="reintro" value="${ intro }" disabled="disabled">
			</div>
		</div>
	</form>

	<!-- 활동지역 -->
	<form action="${ pageContext.request.contextPath }/gosu/svcRange" method="post" name="range" class="my-5">
	<input type="hidden" id="km" name="km" value="" />
		<div class="row justify-content-between">
			<div class="col-8 my-3">
				<div>
					<h4>
						<strong>활동 지역</strong>
					</h4>
				</div>
			</div>
			<div class="col-4">
				<input class="offset-md-8 mt-2 btn btn-success" id="local_btn" type="button" value="수정" onclick="aaa()">
			</div>
			<div class="col-12 w-100">
				<input class="w-100 col-12 text-start mb-5 border border-success" type="text" id="actaddr" value="${ actaddr }" disabled="disabled">
			</div>
		</div>
	
	<!-- 서비스 범위 -->
	
		<div class="row justify-content-between" class="my-5">
			<div class="col-8 my-3">
				<h4 class="text-sm-start">
					<strong>이동 가능 거리</strong>
				</h4>
			</div>
			<div class="col-4">
				<input class="offset-md-8 mt-2 btn btn-success" id="saveus" type="button" value="수정" onclick="act_range()">
			</div>
			<div class="w-100 col-12">
				<input class="w-100 col-12 mb-3 border border-success" type="text" id="active_range" value="${ svc_range }" disabled="disabled">
			</div>
				
			<!-- 서비스 범위 지도 -->
			<div class="col-12 my-5">
				<div class="col-12 w-100" id="map" style="width: 664px; height: 350px"></div>
			</div>
			<div class="col-12 w-100" id="service-range" style="display: none">
				<div class="col-12 w-100">
					<div class="row justify-content-center m-2 radius1">	
						<div class="col-4">
							<button class="col-5 svc_range" name="radius" type="button" value="2">2Km</button>
						</div>
						<div class="col-4">
							<button class="col-5 svc_range" name="radius" type="button" value="5">5Km</button>
						</div>
						<div class="col-4">
							<button class="col-5 svc_range" name="radius" type="button" value="10">10Km</button>
						</div>
					</div>	
					<div class="row justify-content-center m-2 mb-5 radius1">	
						<div class="col-4">
							<button class="col-5 svc_range" name="radius" type="button" value="25">25Km</button>
						</div>
						<div class="col-4">
							<button class="col-5 svc_range" name="radius" type="button" value="50">50Km</button>
						</div>
						<div class="col-4">
							<button class="col-5 svc_range" name="radius" type="button" value="100">100Km</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
	
	
		


<%-- 	<!-- 직원수 -->
	<form action="${ pageContext.request.contextPath }/gosu/staff" method="post" name="">
		<div class="row justify-content-between">
			<div class="col-8">
				<div>
					<h4>
						<strong>직원수</strong>
					</h4>
				</div>
				<div class="col-4">
					<input class="offset-md-8 mt-2" id="staff" type="button" value="등록" onclick="staffInput()">
				</div>
			</div>
			<div class="col-4 w-100">
				<select class="mx-auto" id="staff_btn" name="staff_ctn" style="display: none">
					<option value="1" selected="selected">직원 1명(본인포함)</option>
					<option value="2">직원 2명</option>
					<option value="3">직원 3명</option>
					<option value="4">직원 4명</option>
					<option value="5">직원 5명</option>
					<option value="10">직원 10명</option>
					<option value="20">직원 20명</option>
					<option value="30">직원 30명</option>
					<option value="40">직원 40명</option>
					<option value="50">직원 50명</option>
				</select>
			</div>
		</div>
	</form> --%>

	<!-- 포트폴리오 -->
<%-- 	<form action="${ pageContext.request.contextPath }/gosu/profile/portfolio" method="post" name="folio">
		<div class="row justify-content-between">
			<div class="col-8">
				<div>
					<h4>
						<strong>포트폴리오</strong>
					</h4>
				</div>
			</div>
				<div class="col-4">
					<input class="offset-md-8 mt-2" type="button" value="등록" onclick="folio.submit()">
				</div>
				<div class="col-12 w-100">
					<input class="w-100 col-12 text-start mb-5" type="text" id="" value="" disabled="disabled">
				</div>
		</div>
	</form>

 --%>






































</div>
<!-- END Profile_wrap -->


<script type="text/javascript">
	
	var level;
	var svc_range = $('#active_range').val();
    var actaddr = $('#actaddr').val();
    var coords;
    
/* 	var mapContainer = document.getElementById('map'), // 지도를 표시할 div
    mapOption = {
        center: new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
        level: level // 지도의 확대 레벨
    }; */

    console.log(svc_range);
    
    
    if(svc_range == 2){
    	level = 7;
    } else if(svc_range == 5){
    	level = 9;
    } else if(svc_range == 10){
    	level = 10;
    } else if(svc_range == 25){
    	level = 11;
    } else if(svc_range == 50){
    	level = 12;
    } else if(svc_range == 100){
    	level = 13;
    }
	
    $(function(){
    	console.log(actaddr);
       	console.log('실행');
       	
    	//주소-좌표 변환 객체를 생성
    	var geocoder = new kakao.maps.services.Geocoder();
    	
        var mapTypeControl = new kakao.maps.MapTypeControl();
       	

        // 주소로 상세 정보를 검색
        geocoder.addressSearch(actaddr, function(results, status) {
            // 정상적으로 검색이 완료됐으면
            if (status === kakao.maps.services.Status.OK) {
                var result = results[0]; //첫번째 결과의 값을 활용
				console.log("진행되고있누??");
                // 해당 주소에 대한 좌표를 받아서
                coords = new daum.maps.LatLng(result.y, result.x);
            	var mapContainer = document.getElementById('map'), // 지도를 표시할 div
                mapOption = {
                    center: coords, // 지도의 중심좌표
                    level: level // 지도의 확대 레벨
                };
            	console.log(coords);
            	console.log(level);
            	console.log(typeof(level));
            	
            }
            
         	//지도를 미리 생성
        	var map = new daum.maps.Map(mapContainer, mapOption);


            // 지도 오른쪽 위에 지도 타입 컨트롤이 표시되도록 지도에 컨트롤을 추가한다.
            map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

            // 아래와 같이 옵션을 입력하지 않아도 된다
            var zoomControl = new kakao.maps.ZoomControl();

            // 지도 오른쪽에 줌 컨트롤이 표시되도록 지도에 컨트롤을 추가한다.
            map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
            
            var options = {
            map: map, // drawing manager로 그리기 요소를 그릴 map 객체 
            drawingMode: [ // drawing manager로 제공할 그리기 요소 모드
                kakao.maps.drawing.OverlayType.MARKER,
                kakao.maps.drawing.OverlayType.POLYLINE,
                kakao.maps.drawing.OverlayType.RECTANGLE,
                kakao.maps.drawing.OverlayType.CIRCLE,
                kakao.maps.drawing.OverlayType.POLYGON
            ],
            guideTooltip: ['draw', 'drag', 'edit'], // 사용자에게 제공할 그리기 가이드 툴팁
            circleOptions: {
                draggable: true,
                removable: true,
                editable: true,
                strokeColor: 'RED',
                fillColor: 'RED',
                fillOpacity: 0.5
        	    }
        	};
            
            var circle = new kakao.maps.Circle({
                map: map,
                radius: 50,
                strokeWeight: 2,
                strokeColor: 'RED',
                strokeOpacity: 0.8,
                strokeStyle: 'solid',
                fillColor: 'RED',
                fillOpacity: 0.5, 
            });
            map.relayout();
            // 지도 중심을 변경한다.
            map.setCenter(coords);
            // 마커를 결과값으로 받은 위치로 옮긴다.
            circle.setRadius(svc_range * 1000);
            circle.setPosition(coords);
    		circle.setMap(map);
            circle.setZIndex(1);
            console.log(level);
            
            
            
        })

    });
	

	                    
	                    
	                    
	                    

 





$(function(){
	$(".svc_range").on("click", function(){
		$("input[name='km']").val($(this).val());
	})
})




// user 이름 수정
function userName(){
	const target = document.getElementById('name');
	if(document.getElementById('name_btn').value == "수정"){
		document.getElementById('name').focus();
		document.getElementById('name_btn').value = "저장";
		target.disabled = false;
		
	} else if(document.getElementById('name_btn').value == "저장"){
		
		// AJAX
 		var httpRequest;
		// input 태그에 입력된 intro 데이터 가져옴
		var name = document.getElementById('name').value;
		
		var param = "name=" + encodeURIComponent(name);
		httpRequest = new XMLHttpRequest();
		
		httpRequest.onreadystatechange = () => {
			console.log(httpRequest.readyState + "    " +  XMLHttpRequest.DONE + "    " +  httpRequest.status);
			
			if(httpRequest.readyState === XMLHttpRequest.DONE){
				if(httpRequest.status === 200){
					var result = httpRequest.response;
					// 응답받은 intro 데이터를 넣어줌
					document.getElementById('name').innerText = result.name;
					document.getElementById('name_btn').value = "수정";
					target.disabled = true;
				} else{
					console.log(name);
					alert('Request Error!');
				}
			}
		}
		httpRequest.open('POST', '/higo/gosu/gosuinfo');
		httpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		httpRequest.send(param);
	}
}


// 한줄소개  수정
function reIntro() {
  	const target = document.getElementById('reintro');
	if(document.getElementById('intro_btn').value == "수정"){
		document.getElementById('intro_btn').value = "저장";
		target.disabled = false;
		
	} else if(document.getElementById('intro_btn').value == "저장"){
		
		// AJAX
 		var httpRequest;
		// input 태그에 입력된 intro 데이터 가져옴
		var intro = document.getElementById('reintro').value;
		
		var param = "intro=" + encodeURIComponent(intro);
		httpRequest = new XMLHttpRequest();
		
		httpRequest.onreadystatechange = () => {
			console.log(param);
			if(httpRequest.readyState === XMLHttpRequest.DONE){
				if(httpRequest.status === 200){
					var result = httpRequest.response;
					// 응답받은 intro 데이터를 넣어줌
					document.getElementById('reintro').innerText = result.intro;
					document.getElementById('intro_btn').value = "수정";
					target.disabled = true;
				} else{
					alert('Request Error!');
				}
			}
		}
		
		httpRequest.open('POST', '/higo/gosu/intro');
		httpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		httpRequest.send(param);
		
	}
}
	
	
	
// 직원수 등록
function staffInput(){
	if(document.getElementById('staff').value == "등록"){
		document.getElementById('staff').value = "저장";
		document.getElementById('staff_btn').style = 'display:float';
	} else if(document.getElementById('staff').value == "저장"){
		document.getElementById('staff').value = "등록";
		document.getElementById('staff_btn').style = 'display:none';
	}
}


// 
/* function (){
	if(document.getElementById('staff').value == "등록하기"){
		document.getElementById('staff').value = "저장";
		document.getElementById('staff_btn').style = 'display:float';
	} else if(document.getElementById('staff').value == "저장"){
		document.getElementById('staff').value = "등록하기";
		document.getElementById('staff_btn').style = 'display:none';
	}
} */

//활동지역
function juso() {
    var svc_range = $('#active_range').val();
    var actaddr = $('#actaddr').val();
    var km = $('#km').val();
    var data = { "svc_range" : svc_range, "actaddr" : actaddr,"km" : km};
	
	new daum.Postcode({
	       oncomplete: function(data) {
	
	//주소-좌표 변환 객체를 생성
	var geocoder = new kakao.maps.services.Geocoder();
 	var mapTypeControl = new kakao.maps.MapTypeControl();
 	
 	var actaddr = data.address;
 	document.getElementById("actaddr").value = actaddr;
	
	// 주소로 상세 정보를 검색
	geocoder.addressSearch(actaddr, function(results, status) {
    // 정상적으로 검색이 완료됐으면
    if (status === kakao.maps.services.Status.OK) {
    	var local = results[0]; //첫번째 결과의 값을 활용
		console.log("진행되고있??");
        // 해당 주소에 대한 좌표를 받아서
        coords = new daum.maps.LatLng(local.y, local.x);
     	var mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
	        center: coords, // 지도의 중심좌표
	        level: level // 지도의 확대 레벨
        };
     	console.log(coords);
     	console.log(level);
     	console.log(typeof(level));
     	
     }
     
  	//지도를 미리 생성
 	var map = new daum.maps.Map(mapContainer, mapOption);

    // 지도 오른쪽 위에 지도 타입 컨트롤이 표시되도록 지도에 컨트롤을 추가한다.
    map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

    // 아래와 같이 옵션을 입력하지 않아도 된다
    var zoomControl = new kakao.maps.ZoomControl();

    // 지도 오른쪽에 줌 컨트롤이 표시되도록 지도에 컨트롤을 추가한다.
    map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
     
    var options = {
    map: map, // drawing manager로 그리기 요소를 그릴 map 객체 
    drawingMode: [ // drawing manager로 제공할 그리기 요소 모드
         kakao.maps.drawing.OverlayType.MARKER,
         kakao.maps.drawing.OverlayType.POLYLINE,
         kakao.maps.drawing.OverlayType.RECTANGLE,
         kakao.maps.drawing.OverlayType.CIRCLE,
         kakao.maps.drawing.OverlayType.POLYGON
    ]};
     
    var circle = new kakao.maps.Circle({
         map: map,
         radius: 50,
         strokeWeight: 2,
         strokeColor: 'RED',
         strokeOpacity: 0.8,
         strokeStyle: 'solid',
         fillColor: 'RED',
         fillOpacity: 0.5, 
    });
    map.relayout();
    // 지도 중심을 변경한다.
    map.setCenter(coords);
    // 마커를 결과값으로 받은 위치로 옮긴다.
    circle.setRadius(svc_range * 1000);
    circle.setPosition(coords);
	circle.setMap(map);
    circle.setZIndex(1);
    console.log("범위 수정5" +level);
 	})
		}
	}).open();
}



/* function aaa (){
    var svc_range = $('#active_range').val();
    var actaddr = $('#actaddr').val();
    var km = $('#km').val();
    var data = { "svc_range" : svc_range, "actaddr" : actaddr,"km" : km};
    
	if($('#local_btn').val() == "수정"){
		juso();
	} 
		$.ajax({
		        type: "POST",
		        url : "/higo/gosu/local",
		        contentType: 'application/json',
		        data: JSON.stringify(data),
		        success: function(result){
		        	
		        }
		}).send(JSON.stringify(data));
		
	console.log("Point_1");
} */

// ================================ 활동 지역 =====================================
function aaa (){
    var svc_range = $('#active_range').val();
    var actaddr = $('#actaddr').val();
    var km = $('#km').val();
    var data = { "svc_range" : svc_range, "actaddr" : actaddr,"km" : km};
	
    if($('#local_btn').val() == "수정"){
    	$('#local_btn').val("저장");
    	juso();
		
	} else if($('#local_btn').val() == "저장"){
		$('#local_btn').val("수정");
		
		$.ajax({
	        type: "POST",
	        url : "/higo/gosu/local",
	        contentType: 'application/json',
	        data: JSON.stringify(data),
	        success: function(result){
	        	//주소-좌표 변환 객체를 생성
	        	var geocoder = new kakao.maps.services.Geocoder();
	        	
	            var mapTypeControl = new kakao.maps.MapTypeControl();
	           	

	            // 주소로 상세 정보를 검색
	            geocoder.addressSearch(actaddr, function(results, status) {
	                // 정상적으로 검색이 완료됐으면
	                if (status === kakao.maps.services.Status.OK) {
	                    var local = results[0]; //첫번째 결과의 값을 활용
	    				console.log("진행되고있누??");
	                    // 해당 주소에 대한 좌표를 받아서
	                    coords = new daum.maps.LatLng(local.y, local.x);
	                	var mapContainer = document.getElementById('map'), // 지도를 표시할 div
	                    mapOption = {
	                        center: coords, // 지도의 중심좌표
	                        level: level // 지도의 확대 레벨
	                    };
	                	console.log(coords);
	                	console.log(level);
	                	console.log(typeof(level));
	                	
	                }
	                
	             	//지도를 미리 생성
	            	var map = new daum.maps.Map(mapContainer, mapOption);

	                // 지도 오른쪽 위에 지도 타입 컨트롤이 표시되도록 지도에 컨트롤을 추가한다.
	                map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

	                // 아래와 같이 옵션을 입력하지 않아도 된다
	                var zoomControl = new kakao.maps.ZoomControl();

	                // 지도 오른쪽에 줌 컨트롤이 표시되도록 지도에 컨트롤을 추가한다.
	                map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
	                
	                var options = {
	                map: map, // drawing manager로 그리기 요소를 그릴 map 객체 
	                drawingMode: [ // drawing manager로 제공할 그리기 요소 모드
	                    kakao.maps.drawing.OverlayType.MARKER,
	                    kakao.maps.drawing.OverlayType.POLYLINE,
	                    kakao.maps.drawing.OverlayType.RECTANGLE,
	                    kakao.maps.drawing.OverlayType.CIRCLE,
	                    kakao.maps.drawing.OverlayType.POLYGON
	                ],
	                guideTooltip: ['draw', 'drag', 'edit'], // 사용자에게 제공할 그리기 가이드 툴팁
	                circleOptions: {
	                    draggable: true,
	                    removable: true,
	                    editable: true,
	                    strokeColor: 'RED',
	                    fillColor: 'RED',
	                    fillOpacity: 0.5
	            	    }
	            	};
	                
	                var circle = new kakao.maps.Circle({
	                    map: map,
	                    radius: 50,
	                    strokeWeight: 2,
	                    strokeColor: 'RED',
	                    strokeOpacity: 0.8,
	                    strokeStyle: 'solid',
	                    fillColor: 'RED',
	                    fillOpacity: 0.5, 
	                });
	                map.relayout();
	                // 지도 중심을 변경한다.
	                map.setCenter(coords);
	                // 마커를 결과값으로 받은 위치로 옮긴다.
	                circle.setRadius(svc_range * 1000);
	                circle.setPosition(coords);
	        		circle.setMap(map);
	                circle.setZIndex(1);
	                console.log("범위 수정" +level);
	                
	            })
	        }
	 	});
	}
    
    console.log(JSON.stringify(data));
    
}



// ================================ 지도 활동범위 ==================================
function act_range(){
    var svc_range = $('#active_range').val();
    var actaddr = $('#actaddr').val();
    var km = $('#km').val();
    var data = { "svc_range" : svc_range, "actaddr" : actaddr,"km" : km};
	
	if($('#saveus').val() == "수정"){
		$('#saveus').val("저장");
	    $('#service-range').css('display', 'block');
		
	} else if($('#saveus').val() == "저장"){
		$('#service-range').css('display', 'none');
		$('#active_range').val(km);
		$('#saveus').val("수정");
		
		$.ajax({
	        type: "POST",
	        url : "/higo/gosu/localRange",
	        contentType: 'application/json',
	        data: JSON.stringify(data),
	        success: function(result){
	        	//주소-좌표 변환 객체를 생성
	        	var geocoder = new kakao.maps.services.Geocoder();
	        	
	            var mapTypeControl = new kakao.maps.MapTypeControl();
	           	

	            // 주소로 상세 정보를 검색
	            geocoder.addressSearch(actaddr, function(results, status) {
	                // 정상적으로 검색이 완료됐으면
	                if (status === kakao.maps.services.Status.OK) {
	                    var local = results[0]; //첫번째 결과의 값을 활용
	    				console.log("진행되고있누??");
	                    // 해당 주소에 대한 좌표를 받아서
	                    coords = new daum.maps.LatLng(local.y, local.x);
	                	var mapContainer = document.getElementById('map'), // 지도를 표시할 div
	                    mapOption = {
	                        center: coords, // 지도의 중심좌표
	                        level: level // 지도의 확대 레벨
	                    };
	                	console.log(coords);
	                	console.log(level);
	                	console.log(typeof(level));
	                	
	                }
	                
	             	//지도를 미리 생성
	            	var map = new daum.maps.Map(mapContainer, mapOption);

	                // 지도 오른쪽 위에 지도 타입 컨트롤이 표시되도록 지도에 컨트롤을 추가한다.
	                map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

	                // 아래와 같이 옵션을 입력하지 않아도 된다
	                var zoomControl = new kakao.maps.ZoomControl();

	                // 지도 오른쪽에 줌 컨트롤이 표시되도록 지도에 컨트롤을 추가한다.
	                map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
	                
	                var options = {
	                map: map, // drawing manager로 그리기 요소를 그릴 map 객체 
	                drawingMode: [ // drawing manager로 제공할 그리기 요소 모드
	                    kakao.maps.drawing.OverlayType.MARKER,
	                    kakao.maps.drawing.OverlayType.POLYLINE,
	                    kakao.maps.drawing.OverlayType.RECTANGLE,
	                    kakao.maps.drawing.OverlayType.CIRCLE,
	                    kakao.maps.drawing.OverlayType.POLYGON
	                ],
	                guideTooltip: ['draw', 'drag', 'edit'], // 사용자에게 제공할 그리기 가이드 툴팁
	                circleOptions: {
	                    draggable: true,
	                    removable: true,
	                    editable: true,
	                    strokeColor: 'RED',
	                    fillColor: 'RED',
	                    fillOpacity: 0.5
	            	    }
	            	};
	                
	                var circle = new kakao.maps.Circle({
	                    map: map,
	                    radius: 50,
	                    strokeWeight: 2,
	                    strokeColor: 'RED',
	                    strokeOpacity: 0.8,
	                    strokeStyle: 'solid',
	                    fillColor: 'RED',
	                    fillOpacity: 0.5, 
	                });
	                map.relayout();
	                // 지도 중심을 변경한다.
	                map.setCenter(coords);
	                // 마커를 결과값으로 받은 위치로 옮긴다.
	                circle.setRadius(svc_range * 1000);
	                circle.setPosition(coords);
	        		circle.setMap(map);
	                circle.setZIndex(1);
	                console.log("범위 수정" +level);
	                
	            })
	        }
	 	});
	}
    
    console.log(JSON.stringify(data));
    
}

	




// 화면 로딩 처리 
$(function(){ //처음 호출시 로딩화면 화면크기에 맞춰서 위치조절	
	var loadingHeight = $(document).height();
	var loadingWidth  = window.document.body.clientWidth;
	$('#loading').css({
		'width' : loadingWidth,
		'height': loadingHeight,
		'opacity' :'0.3'
	});
})


function DetailData(carNo,entrDt,entrTm,parkProcNo) {
	var patientId = $("#parkProcNo").val();    	

	$.ajax({
		type : "POST",
		url : "/higo/gosu/profile",
		dataType : "json",
		contentType: 'application/x-www-form-urlencoded; charset=UTF-8',	
		data : {				
			"carNo" : carNo,
			"entrDt" : entrDt,
			"entrTm" : entrTm,
			"parkProcNo" : parkProcNo,
			"patientId" : patientId    
		},
		async : true,
		success : function(data) { //데이터 처리구간
			$("#jsonDt").val(JSON.stringify(data));
			$("#frmAjax").submit();
		},
		error: function (request, status, error){
			console.log(request);
			console.log(status);
			console.log(error);
		},beforeSend:function(){
			$('.wrap-loading').removeClass('display-none'); //호출시
			$('#loading').show();	//로딩화면 호출
		},complete:function(){ //종료 
			$('.wrap-loading').addClass('display-none');
			$('#loading').hide();	//로딩화면 종료
		}
	});
} 


</script>
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>




































