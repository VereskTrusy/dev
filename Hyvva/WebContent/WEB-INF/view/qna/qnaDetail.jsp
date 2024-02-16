
<%@page import="vo.qna.AskVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 게시판 상세페이지</title>
<!-- jquery-3.7.1.min.js 버전 사용 -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.min.js"></script>
<!-- 외부 스크립트 추가 -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.serializejson.min.js"></script>
<script type="text/javascript">
$(function(){
	
	let ask_board_no = $('#ask_board_no').val(); // 게시글 번호
	let contextPath = "<%=request.getContextPath()%>"; // 경로
	
	// 수정 버튼 클릭
	$('#qnaModifyBtn').on('click', function(){
		location.href = contextPath + "/qna/qnaModify.do?ask_board_no=" + ask_board_no;
	});
	
	// 목록으로 버튼 클릭
	$('#qnaListBtn').on('click', function(){
		location.href = contextPath + "/qna/qnaList.do";
	});
	
	// 관리자인지 확인
	
	
	// 답변달기 버튼 이벤트
	$('#replyWriteBtn').on('click', function(){
		
		formData = $('#detailFrm').serializeJSON();
		
		console.log(formData);
		
		$.ajax({
			url : contextPath + "/qna/repleWrite.do",
			method : 'POST',
			data : JSON.stringify(formData),
			dataType : 'json',
			success : function(res) {
				alert("성공?");
			},
			error : function(xhr){
				alert('상태 : ' + xhr.stetus);
			}
		});
	});
});
</script>


<!-- 스크립트릿 영역 start-->
<%
	// 서블릿으로부터 데이터 전달 받기
	AskVo askVo = (AskVo) request.getAttribute("askVo");
%>
<!-- 스크립트릿 영역 end-->

</head>
<body>
<form id="detailFrm" action="<%= request.getContextPath() %>/>">
	<input type="hidden" id="ask_board_no" name="ask_board_no" value="<%= askVo.getAsk_board_no() %>">
	
	<!-- 상세내용 영역 start -->
	<div>
		아이디 : <%= askVo.getUser_id() %><br>
		닉네임 : <%= askVo.getNick_name() %><br>
		글번호 : <%= askVo.getAsk_board_no() %><br>
		제목 : <%= askVo.getAsk_board_title() %><br>
		내용 : <%= askVo.getAsk_board_comment() %><br>
		작성일 : <%= askVo.getAsk_board_date() %><br>
	</div>
	<!-- 상세내용 영역 end -->
	
	<br>
	
	<div id="replyListArea">
		<!-- 댓글 리스트 뿌려주기 -->
	</div>
<%
	if(true){ // 관리자 일 경우에만 활성화 되어야함
%>
	<div id="replyWriteArea">
		<div>
			<label>관리자 답변 : </label>
		</div>
		<div>
			<textarea id="ask_re_coment" name="ask_re_coment" rows="5" cols="50"></textarea>
			<button type="button" id="replyWriteBtn">답변달기</button>
		</div>
	</div>
<%
	}
%>
	<br>
	
	<input type="button" id="qnaModifyBtn" value="수정">
	<input type="button" id="qnaListBtn" value="목록으로">
</form>

</body>
</html>