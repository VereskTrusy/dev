
<%@page import="vo.qna.AskVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 게시판 수정페이지</title>
<!-- jquery-3.7.1.min.js 버전 사용 -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
$(function(){
	
	
	let contextPath = "<%=request.getContextPath()%>"; // 경로
	
	
	// 저장 버튼 클릭
	/* $('#qnaSaveBtn').on('submit', function(){
		location.href = contextPath + "/qna/qnaModify.do?ask_board_no=" + boardNo;
	}); */
	
	// 취소 버튼 클릭
	$('#qnaModifyBtn').on('click', function(){
		let boardNo = $('#boardNo').val(); // 게시글 번호
		location.href = contextPath + "/qna/qnaDetail.do?ask_board_no=" + boardNo;
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
<input type="hidden" id="boardNo" name="ask_board_no" value="<%= askVo.getAsk_board_no() %>">


<!-- <form method="post" enctype="multipart/form-data"> -->
	<form method="post">
	<input type="hidden" name="user_id" value="<%= askVo.getUser_id() %>">
	
	
	<!-- 상세내용 영역 start -->
	제목 : <input type="text" name="ask_board_title" value="<%= askVo.getAsk_board_title() %>"><br>
	<br>
	닉네임 : <%= askVo.getNick_name() %><br>
	글번호 : <%= askVo.getAsk_board_no() %><br>
	작성일 : <%= askVo.getAsk_board_date() %><br>
	<br>
	내용 : <textarea name="ask_board_comment" ><%= askVo.getAsk_board_comment() %></textarea><br>
	<!-- 상세내용 영역 end -->
	
	<!-- <input type="file" name="file" multiple> -->
	
	<br>
	
	<input type="submit" id="qnaSaveBtn" value="저장">
	<input type="button" id="qnaModifyBtn" value="취소">
</form>

</body>
</html>