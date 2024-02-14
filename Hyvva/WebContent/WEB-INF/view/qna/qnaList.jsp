<%@page import="vo.common.PageVo"%>
<%@page import="vo.qna.AskVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의게시판 목록 페이지</title>

<!-- jquery-3.7.1.min.js 버전 사용 -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.min.js"></script>

<script type="text/javascript">
// 로드 후 실행
$(function(){ 
	qnaWriteContextPath = "<%=request.getContextPath()%>/qna/qnaWrite.do";
	qnaListContextPath = "<%=request.getContextPath()%>/qna/qnaList.do";
	
	
	$('#writeBtn').on('click', function(){
		// 지금은 걍 유저아이디 던져주고 login -> 세션에서 가져 올 수 있을때 적용 할것
		location.href = qnaWriteContextPath + "?user_id=" + "test1";
	});
	
	// 검색 버튼
	$('#searchBtn').on('click', function(){
		let searchGubun = $('#searchGubun option:selected').val();
		let searchText = $('#searchText').val();
		
		location.href = qnaListContextPath + 
			"?searchGubun=" + searchGubun + "&searchText=" + searchText + "&currentPageNo=1";
	});
	
	// 페이지 다음 버튼 클릭
	$('#nextBtn').on('click', function(){
		let searchGubun = $('#searchGubun option:selected').val();
		let searchText = $('#searchText').val();

		let currentPageNo = 0;
		let currentPageArea = Number($('input[name=currentPageArea]').val());
		let endPageNo = Number($('input[name=endPageNo]').val());
		
		currentPageArea = currentPageArea+1; // 보여질 페이지구역번호 증가
		currentPageNo = endPageNo+1;
		
		let text = qnaListContextPath 
			+ "?searchGubun=" + searchGubun + "&searchText=" + searchText + "&currentPageNo=" + currentPageNo + "&currentPageArea=" + currentPageArea;
		location.href = text;
	});
	
	// 페이지 이전 버튼 클릭
	$('#prevBtn').on('click', function(){
		let searchGubun = $('#searchGubun option:selected').val();
		let searchText = $('#searchText').val();

		let currentPageNo = 0;
		let currentPageArea = Number($('input[name=currentPageArea]').val());
		let startPageNo = Number($('input[name=startPageNo]').val());
		let pageViewSize = Number($('input[name=pageViewSize]').val());
		
		if(currentPageArea != 1){
			currentPageArea = currentPageArea - 1; // 보여질 페이지구역번호 감소
			currentPageNo = startPageNo - pageViewSize;
		} else {
			currentPageArea = 1;
			currentPageNo = 1;
		}
		
		let text = qnaListContextPath 
			+ "?searchGubun=" + searchGubun + "&searchText=" + searchText + "&currentPageNo=" + currentPageNo + "&currentPageArea=" + currentPageArea;
		location.href = text;
	});
	
});

// 페이지 번호 클릭 펑션
function pagenation(no){
	let searchGubun = $('#searchGubun option:selected').val();
	let searchText = $('#searchText').val();
	let currentPageArea = Number($('input[name=currentPageArea]').val());
	
	location.href = qnaListContextPath 
	+ "?searchGubun=" + searchGubun + "&searchText=" + searchText + "&currentPageNo=" + no + "&currentPageArea=" + currentPageArea;
}
</script>

<%
	// 회원 리스트 가져오기
	List<AskVo> qnaList = (List<AskVo>) request.getAttribute("qnaList");
	
	// 페이징 정보 가져오기
	PageVo pageVo = (PageVo) request.getAttribute("pageVo");
%>

</head>
<body>
<form action="#" name="listFrm">
	<input type="hidden" name="currentPageNo" value="<%=pageVo.getCurrentPageNo()%>">
	<input type="hidden" name="currentPageArea" value="<%=pageVo.getCurrentPageArea()%>">
	<input type="hidden" name="startPageNo" value="<%=pageVo.getStartPageNo()%>">
	<input type="hidden" name="endPageNo" value="<%=pageVo.getEndPageNo()%>">
	<input type="hidden" name="pageViewSize" value="<%=pageVo.getPageViewSize()%>">
	

	<!-- search_area start -->
	<div>
		<select id="searchGubun">
			<option value="ask_board_title"   <%=pageVo.getSearchGubun().equals("ask_board_title") ? "selected" : "" %>>문의제목</option>	
			<option value="ask_board_comment" <%=pageVo.getSearchGubun().equals("ask_board_comment") ? "selected" : "" %>>문의내용</option>
			<option value="ask_board_no"      <%=pageVo.getSearchGubun().equals("ask_board_no") ? "selected" : "" %>>문의번호</option>
			<option value="nick_name"         <%=pageVo.getSearchGubun().equals("nick_name") ? "selected" : "" %>>닉네임</option>
		</select>
		<input type="text" id="searchText" value="<%=pageVo.getSearchText()%>" placeholder="검색어 입력">
		<input type="button" id="searchBtn" value="검색">
		
		<!-- 글작성 버튼 -->
		<button type="button" id="writeBtn" >문의작성</button>
	</div>
	<!-- search_area end -->
	
	조회된 결과 수 : <%= pageVo.getRecordTotalCount()%> 건<br>
	
	<br><br>
	
	<!-- QnA List start -->
	<table border="1">
		<thead>
			<tr>
				<th style="width: 100px; height: 20px;">문의번호</th>
				<th style="width: 200px; height: 20px;">제목</th>
				<th style="width: 100px; height: 20px;">닉네임</th>
				<th style="width: 100px; height: 20px;">작성일</th>
			</tr>
		</thead>
		<tbody >
	<%
	if(qnaList == null || qnaList.size() == 0){
	%>
			<tr><td  colspan="5" style="text-align: center">조회된 QnA가 없습니다.</td></tr>
	<%
	} else {
		for(AskVo item : qnaList){
	%>
			<tr>
				<td><%= item.getAsk_board_no() %></td>
				<td><a href="<%= request.getContextPath() %>/qna/qnaDetail.do?ask_board_no=<%= item.getAsk_board_no() %>"><%= item.getAsk_board_title() %></a></td>
				<td><%= item.getNick_name() %></td>
				<td><%= item.getAsk_board_date() %></td>
			</tr>
	<%
		}
	}
	%>
		</tbody>
	</table>
	<!-- QnA List end -->
	
	<br><br>
	
	<!-- Page List start -->
	<div id="pageList_Area">
		<button type="button" id="prevBtn" <%=(pageVo.getCurrentPageArea() == 1) ? "disabled" : "enable"%>>이전</button>
		
	<% for(int i = pageVo.getStartPageNo(); i <= pageVo.getEndPageNo(); i++) { %>
		<a class="pageNo" href="#" onclick="pagenation(<%=i%>)"> [<%= i %>] </a>
	<% } %>
	
		<button type="button" id="nextBtn" <%=(pageVo.getCurrentPageArea()*pageVo.getPageViewSize() > pageVo.getPageTotalCount()) ? "disabled" : "enable"%>>다음</button>
	</div>
	<!-- Page List end -->
	
	
</form>
</body>
</html>