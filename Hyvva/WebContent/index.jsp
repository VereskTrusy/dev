<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jquery-3.7.1.min.js 버전 사용 -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript">

$(function(){
	let contextPath = "<%=request.getContextPath()%>"; // 경로
	
	location.href = contextPath + "/main.do";
});
</script>
</head>
<body>
</body>
</html>