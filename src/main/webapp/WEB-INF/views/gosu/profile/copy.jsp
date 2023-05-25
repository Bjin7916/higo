<%@page import="com.higo.gosu.GosuVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int review = (int)request.getAttribute("review");
	int star = (int)request.getAttribute("result");
	/* int hire = (int)request.getAttribute("hire"); */
	/* String major = (String)request.getAttribute("major"); */
	int svc_range = (int)request.getAttribute("svc_range");
	GosuVO gv = (GosuVO)request.getAttribute("gv");
%>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=aeca1efe563f92e4748e0bd53d8657d0&libraries=services,clusterer,drawing"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>


<%@ include file="/WEB-INF/views/layout/header.jsp" %>


	<div align="center" class="login_wrap">
	<form action="${ pageContext.request.contextPath }/gosu/profile" method="post" name="dtc">
		<input type="hidden" name="km" value="" />
	</form>
		<table>
			<tr>
				<td>
					<a><img style="border-radius:20px" width="40px" height="40px" alt="profile" src="${ pageContext.request.contextPath }/resources/images/upload/profile.png"></a>						
				</td>
				<td>리뷰 평점<br>${ result }</td>
				<td>리뷰수<br>${ review }</td> 
				<td>고용수<br><%-- ${ hire } --%></td>
			</tr>
			<tr>
				<th>
					<strong>이름</strong>
					<br><input type="text" id="togle" value="${login.name }" disabled="disabled">
				</th>
				<td><input type="button" value="수정" onclick="javascript:"></td>
			</tr>
			<tr>
				<td>
					<strong>대표 서비스</strong>
					<c:forEach var="i" items="${ major }">
						<br>${ i }
					</c:forEach>
				</td>
			</tr>
			<tr>
			
			</tr>
			<tr>
				<td><strong>한줄소개</strong><br></td>
				<td><input type="button" value="수정" onclick="javascript:"></td>
			</tr>
			<tr>
				<td><strong>활동 지역</strong><br><input type="text" id="active_range" disabled="disabled"></td>
				<td><input type="button" value="수정" onclick="jusoDaumPostcode()"></td>
			</tr>
			<tr>
				<td><strong>이동 가능 거리</strong>
					<br>${ svc_range }</td>
				<td><input class="re-save" id="saveus" type="button" value="수정" onclick="distance()"></td>
			</tr>
			<tr>
				<td>
					<div id="map" style="width:500px; height:200px"></div>
					<div class="save service-range" id="service-range" style="display:none">
						<div><button class="radius" type="button" value="2">2Km</button></div>
						<div><button class="radius" type="button" value="5">5Km</button></div>
						<div><button class="radius" type="button" value="10">10Km</button></div>
						<div><button class="radius" type="button" value="25">25Km</button></div>
						<div><button class="radius" type="button" value="50">50Km</button></div>
						<div><button class="radius" type="button" value="100">100Km</button></div>
						<div><button class="radius" type="button" value="전국">전국</button></div>
					</div>
				</td>
			</tr>
			<tr>
				<td><strong>직원수</strong><br></td>
				<td><input type="button" value="등록하기" onclick="javascript:"></td>
			</tr>
			<tr>
				<td><strong>사업자등록증 등록</strong>
				<br>허위정보에 대한 모든 책임은 본인에게 있습니다.</td>
				<td><input type="button" value="등록하기" onclick="javascript:"></td>
			</tr>
			<tr>
				<td><strong>자격증 및 기타 서류 등록</strong></td>
			</tr>
			<tr>
				<td><strong>제공 서비스</strong></td>
			</tr>
			<tr>
				<td><strong>고수 서비스 상세설명</strong></td>
				<td><input type="button" value="등록하기" onclick="javascript:"></td>
			</tr>
			<tr>
				<td><strong>경력</strong></td>
				<td><input type="button" value="수정" onclick="javascript:"></td>
			</tr>
			<tr>
				<td><strong>학력</strong></td>
				<td><input type="button" value="등록하기" onclick="javascript:"></td>
			</tr>
			<tr>
				<td><strong>포트폴리오</strong></td>
				<td><a href="${ pageContext.request.contextPath }/gosu/profile/portfolio">등록하기</a></td>
			</tr>
			<tr>
				<td><strong>사진 및 동영상</strong></td>
			</tr>
			<tr>
				<td><strong>질문답변</strong></td>
				<td><input type="button" value="등록하기" onclick="javascript:"></td>
			</tr>
		</table>
	</div>
	<script type="text/javascript">
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div
    mapOption = {
        center: new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
        level: 8 // 지도의 확대 레벨
    };

	//지도를 미리 생성
	var map = new daum.maps.Map(mapContainer, mapOption);
	//주소-좌표 변환 객체를 생성
	var geocoder = new kakao.maps.services.Geocoder();
	
    var mapTypeControl = new kakao.maps.MapTypeControl();

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



function jusoDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            var addr = data.address; // 최종 주소 변수

            // 주소 정보를 해당 필드에 넣는다.
            document.getElementById("active_range").value = addr;
            // 주소로 상세 정보를 검색
            geocoder.addressSearch(data.address, function(results, status) {
                // 정상적으로 검색이 완료됐으면
                if (status === daum.maps.services.Status.OK) {

                    var result = results[0]; //첫번째 결과의 값을 활용

                    // 해당 주소에 대한 좌표를 받아서
                    var coords = new daum.maps.LatLng(result.y, result.x);
                    // 지도를 보여준다.
                    mapContainer.style.display = "block";
                    map.relayout();
                    // 지도 중심을 변경한다.
                    map.setCenter(coords);
                    // 마커를 결과값으로 받은 위치로 옮긴다.
                    circle.setRadius(5000);
                    circle.setPosition(coords);
					circle.setMap(map);
                    circle.setZIndex(1);
                }
            });
        }
    }).open();
}

function distance(){
	if(document.getElementById('saveus').value == "수정"){
		document.getElementById('saveus').value = "저장";
		document.getElementById('service-range').style = 'display:inline-block';
	} else if(document.getElementById('saveus').value == "저장"){
		document.getElementById('saveus').value = "수정";
		document.getElementById('service-range').style = 'display:none';
		document.dtc.submit();
	}
}

$(function(){
	$(".radius").on("click", function(){
		$("input[name='km']").val($(this).val());
	})
})







	</script>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>