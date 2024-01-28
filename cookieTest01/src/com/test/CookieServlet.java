package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieServlet.do")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[CookieServlet] start");
		System.out.println("[CookieServlet] ContextPath :" + request.getContextPath());
		response.setCharacterEncoding("UTF-8"); // 한글도 입력 가능하게 하기
		PrintWriter out = response.getWriter();
		
		/* ID, password, rememberId checkbox 정보 받아오기 */
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String rememberId = request.getParameter("rememberId");
		
		/* ID, password, checkbox 정보 확인  */
		System.out.println("id : " + id);
		System.out.println("pass : " + pass);
		System.out.println("rememberId : " + rememberId);
		
		Cookie cookieId;
		Cookie cookieRememberId;
		
		
		/* ID 기억하기 체크박스에 체크여부에 따라 쿠키 저장 확인 */
		if(rememberId != null && id != null) {
			// ID 기억하기 체크박스에 체크되었을 때
			// 쿠키 생성 및 response에 쿠키추가
			cookieRememberId = new Cookie("rememberId", rememberId);
			cookieId = new Cookie("id", id);
			
			response.addCookie(cookieRememberId);
			response.addCookie(cookieId);
			
			System.out.println("[CookieServlet] add cookie :" );
		} else {
			// ID 기억하기 체크박스에 해제되었을 때
			// 쿠키 생성 및 쿠키 유효시간 0으로 적용해서 브라우저에서 삭제한다
			cookieRememberId = new Cookie("rememberId", rememberId);
			cookieId = new Cookie("id", id);
			
			response.addCookie(cookieRememberId);
			response.addCookie(cookieId);
			
			cookieRememberId.setMaxAge(0);
			cookieId.setMaxAge(0);
			
			response.addCookie(cookieRememberId);
			response.addCookie(cookieId);
			System.out.println("[CookieServlet] delete cookie");
		}
		
		/* ID, password 에 null 체크 반드시 하기 */
		if((id != null) && (pass != null)) {
			if("test".equals(id) && "1234".equals(pass)) {// 로그인 성공시
				System.out.println("[CookieServlet] Login success redirect cookieMain.jsp");
				
				// id 와 pass 가 일치하는 경우 cookieMain.jsp 로 이동
				response.sendRedirect("./test/cookieMain.jsp");
			} else { // 로그인 실패시
				System.out.println("[CookieServlet] Login fail redirect cookieLogin.jsp");
				
				// 로그인 실패시 바로 cookieLogin.jsp 으로 이동
				response.sendRedirect("./test/cookieLogin.jsp");
			}
		}
		
		System.out.println("[CookieServlet] end");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
