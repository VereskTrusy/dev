<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath() %>/js/jquery-3.7.1.min.js"></script>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">
	$(document).ready(function () {
		$("#sub").on('click', function() {
			$.ajax({
				url : '<%=request.getContextPath()%>/moimUserList.do',
				type : 'get',
				data : {
					moimId : "4"				
				},
				success : function (res) {
					code = "";
					for (var i = 0; i < res.length; i++) {
	                    var r = res[i];
  						code += '<p>' + r.userId + '</p><p>' + r.ent_date + '</p><button class="btn btn-success" type="button" onclick="submit()">수락</button>';
	                }
					
					$('.modal-body').html(code);
				},
				error : function () {
					console.log('Failed to fetch data from the server.');
				}
			})
		})
		
		
		
	});
	function submit() {
		
	}

</script>

</head>
<body>
<a href="<%=request.getContextPath()%>/moimList.do">모임 목록 메뉴</a>
<a href="<%=request.getContextPath()%>/insertMoim.do">모임 개최</a>
<a href="<%=request.getContextPath() %>/insertMoimCal.do">모임 일정 추가</a>
<a href="<%=request.getContextPath() %>/html/moimCalView.jsp">모임 일정 보기</a>
<br><br>
<div class="container mt-3">
  
  <button id="sub" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal">
    모임 참가자 수락
  </button>
</div>

<!-- The Modal -->
<div class="modal fade" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">모임 참가 신청자 목록</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>

</body>
</html>