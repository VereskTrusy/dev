<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	String id = (String)session.getAttribute("id");
	String moimId = (String)session.getAttribute("moimId");
	out.print(id + " " + moimId);
%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>소모임 일정 추가</h1>
<form action="<%=request.getContextPath()%>/insertMoimCal.do" method="post">
	<input type="hidden" name="id" value="<%=id %>">
	<input type="hidden" name="moimId" value="<%=moimId %>">
	<table border="1">
		<tr>
			<td>소모임 제목</td>
			<td><input type="text" name="title">
		</tr>
		<tr>
			<td>소모임 내용</td>
			<td><input type="text" name="content">
		</tr>
		<tr>
			<td>일자</td>
			<td><input type="date" name="date">
		</tr>
		<tr>
			<td>장소</td>
			<td><input type="text" name="place">
		</tr>
		<tr>
			<td>주소</td>
			<td>
				<input type="text" id="sample5_address" placeholder="주소" name="addr1">
				<input type="button" onclick="sample5_execDaumPostcode()" value="주소 검색"><br>
				<div id="map" style="width:300px;height:300px;margin-top:10px;display:none"></div>
			</td>
		</tr>
		<tr>
			<td>상세주소</td>
			<td><input type="text" name="addr2">
		</tr>
		<tr>
			<td colsapn="2">
				<input type="submit" value="전송">
			</td>
		</tr>
	</table>

</form>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=db33fb53d9668f1ea0693bfabdbf7abd&libraries=services"></script>
<script>
    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
            center: new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
            level: 5 // 지도의 확대 레벨
        };

    //지도를 미리 생성
    var map = new daum.maps.Map(mapContainer, mapOption);
    //주소-좌표 변환 객체를 생성
    var geocoder = new daum.maps.services.Geocoder();
    //마커를 미리 생성
    var marker = new daum.maps.Marker({
        position: new daum.maps.LatLng(37.537187, 127.005476),
        map: map
    });


    function sample5_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                var addr = data.address; // 최종 주소 변수

                // 주소 정보를 해당 필드에 넣는다.
                document.getElementById("sample5_address").value = addr;
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
                        marker.setPosition(coords)
                    }
                });
            }
        }).open();
    }
</script>
</body>
</html>