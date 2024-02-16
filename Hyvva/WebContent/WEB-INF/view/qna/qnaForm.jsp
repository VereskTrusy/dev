<%@page import="vo.qna.AskVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta http-equiv="imagetoolbar" content="no">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="format-detection" content="telephone=no">
  <meta name="title" content="웹사이트">
  <meta name="description" content="웹사이트입니다.">
  <meta name="keywords" content="키워드,키워드,키워드">
  <meta property="og:title" content="웹사이트">
  <meta property="og:description" content="웹사이트입니다">
  <meta property="og:image" content="https://웹사이트/images/opengraph.png">
  <meta property="og:url" content="https://웹사이트">
  <title>온라인문의 | 휘바</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/setting.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/plugin.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/template.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/common.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">
  
<!-- jquery-3.7.1.min.js 버전 사용 -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
$(function(){
	
	
	let contextPath = "<%=request.getContextPath()%>"; // 경로
		
	// 취소 버튼 클릭
	$('#cancelBtn').on('click', function(){
		location.href = contextPath + "/qna/qnaList.do";
	});
});
</script>
<%
	// 서블릿으로부터 데이터 전달 받기
	AskVo askVo = (AskVo) request.getAttribute("askVo");
%>
</head>

<body>
  <!-- [S]personal-LILSCvgU3P -->
  <header class="personal-LILSCvgU3P" data-bid="RILsCWlP40">
    <div class="header-container container-lg">
      <div class="header-left">
        <h1 class="header-title">
          <a href="javascript:void(0)">
            <img src="/api/download/8875bd611d9d4e09adaeec30f715546d" alt="">
          </a>
        </h1>
      </div>
      <div class="header-center">
        <ul class="header-member">
          <li>
            <a href="javascript:void(0)">로그인</a>
          </li>
          <li>
            <a href="javascript:void(0)">회원가입</a>
          </li>
        </ul>
        <ul class="header-gnblist">
          <li class="header-gnbitem">
            <a class="header-gnblink" href="javascript:void(0)">
              <span>캠페인</span>
            </a>
            <ul class="header-sublist">
              <li class="header-subitem">
                <a class="header-sublink" href="javascript:void(0)">
                  <span>캠페인 안내</span>
                </a>
              </li>
            </ul>
          </li>
          <li class="header-gnbitem">
            <a class="header-gnblink" href="javascript:void(0)">
              <span>굿즈</span>
            </a>
            <ul class="header-sublist">
              <li class="header-subitem">
                <a class="header-sublink" href="javascript:void(0)">
                  <span>상품페이지</span>
                </a>
              </li>
            </ul>
          </li>
          <li class="header-gnbitem">
            <a class="header-gnblink" href="javascript:void(0)">
              <span>소모임</span>
            </a>
            <ul class="header-sublist">
              <li class="header-subitem">
                <a class="header-sublink" href="javascript:void(0)">
                  <span>소모임 찾기</span>
                </a>
              </li>
            </ul>
          </li>
          <li class="header-gnbitem">
            <a class="header-gnblink" href="javascript:void(0)">
              <span>커뮤니티</span>
            </a>
            <ul class="header-sublist">
              <li class="header-subitem">
                <a class="header-sublink" href="javascript:void(0)">
                  <span>공지사항</span>
                </a>
              </li>
              <li class="header-subitem">
                <a class="header-sublink" href="javascript:void(0)">
                  <span>문의게시판</span>
                </a>
              </li>
              <li class="header-subitem">
                <a class="header-sublink" href="javascript:void(0)">
                  <span>회원게시판</span>
                </a>
              </li>
            </ul>
          </li>
        </ul>
      </div>
      <div class="header-right">
        <div class="header-utils">
          <a href="javascript:void(0);" class="btn-user header-utils-btn">
            <img src="../resources/icons/ico_user_white.svg" alt="유저 아이콘">
          </a>
          <button class="btn-allmenu header-utils-btn">
            <img src="../resources/icons/ico_menu_white.svg" alt="PC메뉴">
          </button>
          <button class="btn-momenu header-utils-btn">
            <img src="../resources/icons/ico_menu_white.svg" alt="모바일메뉴">
          </button>
          <button class="btn-moclose header-utils-btn">
            <img src="../resources/icons/ico_close_white.svg" alt="닫기">
          </button>
        </div>
      </div>
    </div>
    <div class="header-fullmenu fullmenu-right">
      <div class="fullmenu-wrapper">
        <div class="fullmenu-head">
          <h4 class="fullmenu-title">
            <a href="javascript:void(0)">
              <img src="../medias/6065718841674e699d0dba91ada8ce8a.png" alt="">
            </a>
          </h4>
          <ul class="fullmenu-member">
            <li>
              <a href="javascript:void(0)">로그인</a>
            </li>
            <li>
              <a href="javascript:void(0)">회원가입</a>
            </li>
          </ul>
        </div>
        <ul class="fullmenu-gnblist">
          <li class="fullmenu-gnbitem">
            <a class="fullmenu-gnblink" href="javascript:void(0)">
              <span>캠페인</span>
            </a>
            <ul class="fullmenu-sublist">
              <li class="fullmenu-subitem">
                <a class="fullmenu-sublink" href="javascript:void(0)">
                  <span>캠페인안내</span>
                </a>
              </li>
            </ul>
          </li>
          <li class="fullmenu-gnbitem">
            <a class="fullmenu-gnblink" href="javascript:void(0)">
              <span>굿즈</span>
            </a>
            <ul class="fullmenu-sublist">
              <li class="fullmenu-subitem">
                <a class="fullmenu-sublink" href="javascript:void(0)">
                  <span>상품페이지</span>
                </a>
              </li>
            </ul>
          </li>
          <li class="fullmenu-gnbitem">
            <a class="fullmenu-gnblink" href="javascript:void(0)">
              <span>소모임</span>
            </a>
            <ul class="fullmenu-sublist">
              <li class="fullmenu-subitem">
                <a class="fullmenu-sublink" href="javascript:void(0)">
                  <span>소모임찾기</span>
                </a>
              </li>
            </ul>
          </li>
          <li class="fullmenu-gnbitem">
            <a class="fullmenu-gnblink" href="javascript:void(0)">
              <span>커뮤니티</span>
            </a>
            <ul class="fullmenu-sublist">
              <li class="fullmenu-subitem">
                <a class="fullmenu-sublink" href="javascript:void(0)">
                  <span>공지사항</span>
                </a>
              </li>
              <li class="fullmenu-subitem">
                <a class="fullmenu-sublink" href="javascript:void(0)">
                  <span>문의사항</span>
                </a>
              </li>
              <li class="fullmenu-subitem">
                <a class="fullmenu-sublink" href="javascript:void(0)">
                  <span>회원게시판</span>
                </a>
              </li>
            </ul>
          </li>
          <li class="fullmenu-gnbitem">
            <a class="fullmenu-gnblink" href="javascript:void(0)">
              <span>마이페이지</span>
            </a>
          </li>
        </ul>
      </div>
      <button class="fullmenu-close">
        <img src="../resources/icons/ico_close_white.svg" alt="닫기">
      </button>
    </div>
  </header>
  <!-- [E]personal-LILSCvgU3P -->
  <main class="th-layout-main ">
    <!-- [S]personal-FSLSCvN6Lw -->
    <div class="personal-FSLSCvN6Lw" id="" data-bid="zBlscwLMVt">
      <div class="contents-inner">
        <div class="contents-container container-md">
          <div class="textset">
            <p class="textset-name">문의 게시판</p>
            <h2 class="textset-tit">Q&amp;A</h2>
          </div>
        </div>
      </div>
    </div>
    <!-- [E]personal-FSLSCvN6Lw -->
    <!-- [S]glamping-N43 -->
    <div class="glamping-N43" data-bid="drLscWBoUu">
      <div class="contents-inner">
        <form class="contents-container container-md" method="post"><!-- 폼 시작 -->
          <h2 class="contents-tit">정보입력</h2>
          <div class="contents-group">
            <div class="form-wrap">
              <h6 class="form-tit">제목 <span>*</span>
              </h6>
              <div class="inputset inputset-round">
                <input type="text" id="ask_board_title" name="ask_board_title" class="inputset-input form-control" aria-label="내용" required="">
              </div>
            </div>
            <div class="form-wrap">
              <h6 class="form-tit">닉네임
              </h6>
              <div class="inputset inputset-round">
                <input type="text" value="<%= askVo.getNick_name() %>" disabled class="inputset-input form-control" aria-label="닉네임" />
              </div>
            </div>
            <div class="form-wrap">
              <h6 class="form-tit">문의내용 <span>*</span>
              </h6>
              <div class="inputset inputset-round">
                <textarea class="inputset-textarea form-control" id="ask_board_comment" name="ask_board_comment" required=""></textarea>
                <div class="inputset-langth">
                  <span class="inputset-count">0</span>
                  <span class="inputset-total">/4000 Byte</span>
                </div>
              </div>
            </div>
          </div>
          <div class="contents-btn-group">
            <!-- <a href="javascript:void(0);" class="btnset btnset-round">문의완료</a> -->
            <input type="submit" id="WriteBtn" value="저장" class="btnset btnset-round">
            <!-- <a href="javascript:void(0);" class="btnset btnset-line btnset-round">취소하기</a> -->
            <input type="button" id="cancelBtn" value="취소" class="btnset btnset-line btnset-round">
          </div>
        </form><!-- 폼 종료 -->
      </div>
    </div>
    <!-- [E]glamping-N43 -->
  </main>
  <!-- [S]personal-eOLsCvEiv0 -->
  <footer class="personal-eOLsCvEiv0" data-bid="CElSCwltGe">
    <div class="footer-container">
      <img class="footer-backimg img-pc" src="/api/download/9658c0a6e33d4115b7f46bab7d01aee0" alt="">
      <img class="footer-backimg img-mobile" src="../resources/images/img_footer_mobile.png" alt="모바일 푸터 비주얼">
      <div class="footer-body container-md">
        <h2 class="footer-logo">
          <a href="javascript:void(0)">
            <img src="../medias/c28aa0a120bd4966b92c484224532645.png" alt="">
          </a>
        </h2>
        <ul class="footer-menulist">
          <li class="footer-menuitem">
            <a href="javascript:void(0)">
              <span>소모임</span>
            </a>
            <ul class="footer-sublist">
              <li class="footer-subitem">
                <a href="javascript:void(0)">
                  <span contenteditable="true">소모임 찾기</span>
                </a>
              </li>
            </ul>
          </li>
          <li class="footer-menuitem">
            <a href="javascript:void(0)">
              <span>커뮤니티</span>
            </a>
            <ul class="footer-sublist">
              <li class="footer-subitem">
                <a href="javascript:void(0)">
                  <span>공지사항</span>
                </a>
              </li>
              <li class="footer-subitem">
                <a href="javascript:void(0)">
                  <span>문의게시판</span>
                </a>
              </li>
              <li class="footer-subitem">
                <a href="javascript:void(0)">
                  <span>회원게시판​<br></span>
                </a>
              </li>
            </ul>
          </li>
        </ul>
        <ul class="footer-menugroup">
          <li class="footer-menulink">
            <a href="javascript:void(0)">
              <span>이용약관</span>
            </a>
          </li>
          <li class="footer-menulink">
            <a href="javascript:void(0)">
              <span>개인정보처리방침</span>
            </a>
          </li>
        </ul>
        <div class="footer-txtgroup">
          <div class="footer-txt">
            <p>대전광역시 중구 계룡로 846 4층</p>
            <p>
              <span>T. 000-0000-0000</span>
              <span>E. help@openfield.co.kr</span>
            </p>
          </div>
          <div class="footer-txt">
            <p>2024 BY HYVVA​<br></p>
          </div>
        </div>
      </div>
    </div>
  </footer>
  <!-- [E]personal-eOLsCvEiv0 -->
  <script src="../resources/js/setting.js"></script>
  <script src="../resources/js/plugin.js"></script>
  <script src="../resources/js/template.js"></script>
  <script src="../resources/js/common.js"></script>
  <script src="../resources/js/script.js"></script>
</body>
</html>