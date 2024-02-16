<%@page import="vo.moim.AreaVo"%>
<%@page import="vo.moim.AgeVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath() %>/js/jquery-3.7.1.min.js"></script>
<%
	List<AgeVo> ageList = (List<AgeVo>)request.getAttribute("ageList");
	List<AreaVo> areaList = (List<AreaVo>)request.getAttribute("areaList");
	String id = (String)request.getAttribute("id");
%>
<script>
	
</script>
</head>
<body>
<form id="insert" action="<%=request.getContextPath()%>/insertMoim.do" method="post">
	<table border="1">
		<tr>
			<td>소모임 이름</td>
			<td><input type="text" name="moimName"></td>
		</tr>
		<tr>
			<td>연령조건</td>
			<td>
			<select name="age">
			<% for(AgeVo vo : ageList) {
				String ageId = vo.getAge_id();		
				String age = vo.getAge_con();
			%>
			<option value="<%= ageId%>"><%= age%></option>
			<% } %>
			</select>
			</td>
		</tr>
		<tr>
			<td>소모임 이름</td>
			<td><select name="area">
			<% for(AreaVo vo : areaList) {
				String areaId = vo.getArea_id();		
				String area = vo.getArea_con();
			%>
			<option value="<%= areaId%>"><%= area%></option>
			<% } %>
			</select>
			</td>
		</tr>
		<tr>
			<td>소모임 소개</td>
			<td><textarea id="content" rows="5" cols="50" name="content"></textarea>
		</tr>	
		<tr>
			<td colspan="2" style="text-align: center">
				<input id="sub" type="submit" value="제출">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>