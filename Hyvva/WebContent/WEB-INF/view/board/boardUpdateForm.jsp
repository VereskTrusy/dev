<%@page import="vo.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	BoardVO boardVo = (BoardVO)request.getAttribute("boardVo");
%>

<h2>게시물 수정 폼</h2>

<form action="<%=request.getContextPath()%>/boardUpdate.do"
      method="post">
  <input type="hidden" name="board_no" value="<%=boardVo.getBoard_no() %>">
  
  <table border="1">
  
  	
  	<tr>
  		<td>게시판 제목</td>
  		<td><input type="text" name="board_title" value="<%=boardVo.getBoard_title() %>"></td>
  	</tr>
  	
  	<tr>
  		<td>게시판 내용</td>
  		<td><input type="text" name="board_content" value="<%=boardVo.getBoard_content() %>"></td>
  	</tr>
  	
  	<tr>
		<td colspan="2" style="text-align:center;">
			<input type="submit" value="저장"> <input type="reset" value="취소"> 
			
	</tr>
  	
  </table>    
      
</form>

</body>
</html>