<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<form id = "boardInsert" method = "post" action = "<%=request.getContextPath() %>/boardInsert.do">
	<table border="1">
		<tr>
		 <td>작성자</td>
		   <td>
		     <input type = "text" name="user_id" id = "user_id" >		   
		   </td>
		</tr>
	
	
		<tr>
		 <td>제목</td>
		   <td>
		     <input type = "text" name="board_title" id = "board_title">		   
		   </td>
		</tr>
		
		<tr>
		 <td>내용</td>
		   <td>
		     <input type = "text" name="board_content" id = "board_content">		   
		   </td>
		</tr>
		
		
		
		<tr>
		  <td colspan="2" style="text-align:center;">
		    <input type="submit" id= "boardInsert" value="저장">
		  </td>  
		</tr>
	</table>
	

</form>
</body>
</html>