<%@page import="vo.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.min.js"></script>

<script type="text/javascript">

$(function(){
<%-- 	$("#btnDelete").on("click", function(){
		var form = document.getElementById("boardForm");
		let board_no = $("#board_no").val();
		console.log(board_no);
		form.action = "<%=request.getContextPath()%>/boardDelete.do?"+ board_no=43;
		form.submit();
	}); --%>
	
	
	$("#btnList").on("click",function(){
		location.href = "<%=request.getContextPath()%>/boardList.do";
	});
	
	$("#btnUpdate").on("click",function(){
		var form = document.getElementById("boardForm")
		form.method = "GET";
		form.action = "<%=request.getContextPath()%>/boardUpdate.do";
		form.submit();
	})
	
});


</script>

</head>
<body>
<% BoardVO boardVo = (BoardVO)request.getAttribute("boardVo"); 

%>
<a href="<%=request.getContextPath() %>/view/board/boardList.jsp"></a>

<h2>게시물 상세 보기</h2>
<form name="boardForm" id="boardForm" action="<%= request.getContextPath()%>/boardDelete.do">
 <input type = "hidden" id="board_no" name="board_no" value="<%=boardVo.getBoard_no()%>">
 <table border="1">
 	<tr>
 	  <td>제목</td><td><%=boardVo.getBoard_title() %></td>
 	</tr>
 	
 	<tr>
 	  <td>작성자</td><td><%=boardVo.getUser_id()%></td>
 	</tr>
 	 
 	<tr>
 	  <td>조회수</td><td><%=boardVo.getBoard_hits() %></td>
 	</tr> 
 	
 	<tr>
 	  <td>내용</td><td><%=boardVo.getBoard_content()%></td>
 	</tr> 
 	
 	<tr>
 	<td colspan ="2" style="text-align:center;">
 		<input id ="btnUpdate" type="button" value="수정">  
 		<input id ="btnDelete" type="submit" value="삭제">  
 		<input type="button" id = "btnList" value="회원목록" ></td>
 	</tr>	  
 	
 
 </table>
 
 </form>
</body>
</html>