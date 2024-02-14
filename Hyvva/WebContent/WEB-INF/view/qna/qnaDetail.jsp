
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
<script type="text/javascript">
$(function(){
	
	let boardNo = $('#boardNo').val(); // 게시글 번호
	let contextPath = "<%=request.getContextPath()%>"; // 경로
	
	// 수정 버튼 클릭
	$('#qnaModifyBtn').on('click', function(){
		location.href = contextPath + "/qna/qnaModify.do?ask_board_no=" + boardNo;
	});
	
	// 목록으로 버튼 클릭
	$('#qnaListBtn').on('click', function(){
		location.href = contextPath + "/qna/qnaList.do";
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
<form action="<%= request.getContextPath() %>/>">
	<input type="hidden" id="boardNo" value="<%= askVo.getAsk_board_no() %>">
	
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
	
	<div id="reply"></div>
	
	<br>
	
	<input type="button" id="qnaModifyBtn" value="수정">
	<input type="button" id="qnaListBtn" value="목록으로">
</form>

</body>
</html>