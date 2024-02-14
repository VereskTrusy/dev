package util;

public class ViewResolver {
	
	
	// QnA 메뉴 관련
	public static String QnaView(String jspFileName) {
		return "/WEB-INF/view/qna/" + jspFileName;
	}
	
	
	// 공지사항 메뉴 관련
	public static String NoticeView(String jspFileName) {
		return "/WEB-INF/view/notice/" + jspFileName;
	}
	
	// 캠페인 메뉴 관련
	public static String CampaignView(String jspFileName) {
		return "/WEB-INF/view/campaign/" + jspFileName;
	}
	
	// 에러페이지 메뉴 관련
	public static String ErrorView(String jspFileName) {
		return "/errorPage/" + jspFileName;
	}
	
	/* 로그인 페이지 이동 테스트용 (기능없음) */
	public static String LoginView(String jspFileName) {
		return "/WEB-INF/view/login/" + jspFileName;
	}
}
