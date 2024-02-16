<%@page import="vo.moim.MoimCalVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.css">
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.min.js"></script>	
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/locales-all.js"></script>

<script src='<%= request.getContextPath() %>/dist/index.global.js'></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="<%=request.getContextPath() %>/js/jquery-3.7.1.min.js"></script>

<script>
document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
    var currentMonth;
    var calendar;

    // 함수 내부에서 초기화되는 이벤트 배열
    //var events = [];

    // selectCalList 함수 수정
    function selectCalList() {
        $.ajax({
            url: '<%=request.getContextPath()%>/selectMoimCal.do',
            type: 'GET',
            data: {
                currentMonth: currentMonth
            },
            async: false,
            success: function (response) {
            	var events = [];
            	/* code = ""; */
                // 서버에서 받은 데이터(response)를 이벤트 객체로 변환하여 배열에 추가
                for (var i = 0; i < response.length; i++) {
                    var res = response[i];
                    var event = {
                        title: res.title,
                        start: res.start
                    };
                    /* code += '<option id="' + res.m_cal_no + '">' + res.start + '</option>';      */             
                    events.push(event);
                }
                /* $("#date").html(code); */
                console.log('Events:', events); // 콘솔 로그로 이벤트 확인
                initializeFullCalendar(events);
            },
            error: function () {
                // 에러 처리
                console.log('Failed to fetch data from the server.');
            }
        });
    }
    
    selectCalList()
    // FullCalendar 초기화 함수
    function initializeFullCalendar(event111) {
//     	events = []; // 날짜가 변경되면 events 배열 초기화
//         selectCalList(); // 새로운 데이터로 events 배열 채우기
        calendar = new FullCalendar.Calendar(calendarEl, {
            initialView: 'dayGridMonth',
            headerToolbar: {
                start: 'prev next today',
                center: 'title',
                end: 'dayGridMonth,dayGridWeek,dayGridDay'
            },
            titleFormat: function (date) {
                return date.date.year + '년 ' + (parseInt(date.date.month) + 1) + '월';
            },
            selectable: true,
            droppable: true,
            navLinks: true,
            editable: true,
            nowIndicator: true,
            locale: 'ko',
            events: event111, // 초기화 시 events 배열 사용
            datesSet: function (info) {
                currentMonth = info.view.title;               
                calendar.refetchEvents(); // FullCalendar에 이벤트 업데이트
                
            }
        });

        calendar.render();
    }

    // FullCalendar 초기화 함수 호출
    initializeFullCalendar();

    // select 요소의 값이 변경될 때 이벤트 처리
    $("#date").on('change', function () {
        // 선택된 옵션의 값 가져오기
        var selectedOptionValue = $("#date option:selected").attr("id");
        fetchDataFromServer(selectedOptionValue);
    });

    // Ajax로 데이터를 가져와서 모달 내용을 업데이트하는 함수
    function fetchDataFromServer(calendarValue) {
        $.ajax({
            url: '<%=request.getContextPath()%>/detailMoimCal.do',
            type: 'GET',
            data: {
                m_cal_no: calendarValue,
                currentMonth: currentMonth
            },
            success: function (response) {
                // 서버에서 받은 데이터로 모달 내용 업데이트
                $("#moimTitle").html(response.title);
                $("#moimContent").html(response.content);
                $("#moimAddr1").html(response.addr1);
                $("#moimAddr2").html(response.addr2);
            },
            error: function () {
                // 에러 처리
                console.log('Failed to fetch data from the server.');
            }
        });
    }

    // 초기 데이터 로딩
    selectCalList();

    // 데이터 업데이트 버튼 클릭 시 selectCalList 호출
    $("#entry").on('click', function () {
    	var selectedOptionValue = $("#date option:selected").attr("id");
        fetchDataFromServer(selectedOptionValue);
    });
    
    $("#ent").on('click', function () {
    	var sel = $("#date option:selected").attr("id");
    	var xhr = new XMLHttpRequest();
    	var servletUrl = "<%=request.getContextPath()%>/insertEntry.do";
    	xhr.open("GET", servletUrl + "?sel=" + encodeURIComponent(sel), true);
    	xhr.send();
    });
    
});
</script>
<style type="text/css">


  html, body {
    
    font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
    font-size: 14px;
  }

  #calendar-container {
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
  }

  .fc-header-toolbar {
    /*
    the calendar will be butting up against the edges,
    but let's scoot in the header's buttons
    */
    padding-top: 1em;
    padding-left: 1em;
    padding-right: 1em;
  }


</style>
</head>
<body>
<div id='calendar'></div>
<br><br>
 <button id="entry" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal">
    참가신청
  </button>
</div>

<!-- The Modal -->
<div class="modal" id="myModal">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">참가 신청</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <div class="container mt-3">
        <table>
        	<tr>
        		<td>소모임 날짜</td>
        		<td>
	        		<select class="form-select" id="date" name="date">	        		
				    </select>
        		</td>
       		</tr>
       		<tr>
                   <td>소모임 제목</td>
                   <td id="moimTitle"></td>
             </tr>
             <tr>
                 <td>소모임 내용</td>
                 <td id="moimContent"></td>
             </tr>
             
             <tr>
                 <td>소모임 주소</td>
                 <td id="moimAddr1"></td>
             </tr>
             <tr>
             	<td>소모임 상세주소</td>
             	<td id="moimAddr2"></td>
             </tr>
        </table>
        
        </div>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
       <button id="ent" type="button" class="btn btn-success" data-bs-dismiss="modal">참가신청</button>
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>
</body>
</html>