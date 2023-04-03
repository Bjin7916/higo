<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>








<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<div class="section mt-5 mx-auto">
	<form>
		<div class="row justify-content-between">
			<div >
				<div class="mt-3">
					<div class="mt-3 start-0"><h3>포트폴리오 등록</h3></div>
				</div>
				<div class="mt-3">
					<div class="mt-3"><h4>필수정보*</h4></div>
				</div>
				<div class="mt-3">
					<div class="mt-3">서비스 종류</div>
				</div>
				<div class="mt-3">
					<div class="mt-3"><button type="button"></button></div>
				</div>
				<div class="mt-3">
					<div class="mt-3">대표이미지 등록</div>
				</div>
				<div class="mt-3">
					<div class="mt-3">상세이미지 등록</div>
				</div>
				<div class="mt-3">
					<div class="mt-3"><h4>상세 정보</h4></div>
				</div>
				<div class="mt-3">
					<div class="mt-3">지역 정보</div>
				</div>
				<div class="mt-3">
					<div class="mt-3">최종 금액</div>
				</div>
				<div class="mt-3">
					<div class="mt-3">작업 연도</div>
					<div class="mt-3">작업 소요기간</div>
				</div>
				<div class="mt-3">
					<div class="mt-3">
						<select style="widdiv: 200px">
							<option value="2022" selected="selected">2022
							<option value="2021">2021
							<option value="2020">2020
							<option value="2019">2019
							<option value="2018">2018
							<option value="2017">2017
							<option value="2016">2016
							<option value="2015">2015
							<option value="2014">2014
							<option value="2013">2013
							<option value="2012">2012
							<option value="2011">2011
							<option value="2010">2010
							<option value="2009">2009
							<option value="2008">2008
							<option value="2007">2007
							<option value="2006">2006
							<option value="2005">2005
							<option value="2004">2004
							<option value="2003">2003
							<option value="2002">2002
							<option value="2001">2001
							<option value="2000">2000
							<option value="1999">1999
							<option value="1998">1998
							<option value="1997">1997
							<option value="1996">1996
							<option value="1995">1995
							<option value="1994">1994
							<option value="1993">1993
							<option value="1992">1992
							<option value="1991">1991
							<option value="1990">1990
						</select>
					</div>
					<div class="mt-3">
						<input type="number" style="widdiv: 80px" min="0">
					</div>
					<div class="mt-3">
						<select>
							<option value="">시간 
							<option value="">일 
							<option value="">주
							<option value="">개월
						</select>
					</div>
				</div>
				<div class="mt-3">
					<div>상세 설명</div>
				</div>
				<div class="mt-3">
					<div class="mt-3"><textarea rows="4" cols="30"></textarea></div>
				</div>
				<div class="mt-3">
					<div class="mt-3" align="center"><input type="button" value="등록하기"></div>
				</div>
			</div>
		</div>
	</form>
</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>
