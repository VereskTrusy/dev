<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-3.7.1.min.js"></script>
<script type="text/javascript"></script>
</head>
<body>
<%
// Cookie
Cookie[] cookies = request.getCookies();
String id = null;
String rememberId = null;

if((cookies != null) && (cookies.length > 0)){
	System.out.println("[cookieLogin] cookies.length : " + cookies.length);
	for(int i = 0; i < cookies.length; i++){
		if(cookies[i].getName().equals("rememberId") && cookies[i].getValue().equals("keep")){
			rememberId = cookies[i].getValue(); 
		}
		if(cookies[i].getName().equals("id")){
			id = cookies[i].getValue();
		}
	}
}

%>

<form action="<%=request.getContextPath()%>/cookieServlet.do" method="get">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" value=<%=(id != null ? id : "")%>></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="pass"></td>
		</tr>
	</table>
	<input type="checkbox" id="rememberId" name="rememberId" value="keep"
		<%=((rememberId != null) ? "checked=\"checked\"" : "" )%>>아이디 기억하기
	<input type="submit" id="smBtn">
</form>
</body>
</html>