package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
	    HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false); // 기존 세션 반환, 없으면 null

        // 로그인 체크 로직
        boolean isLoggedIn = (session != null && session.getAttribute("user") != null);

        if (isLoggedIn) {
            // 로그인 되어 있으면 요청 계속 진행
        	filterChain.doFilter(request, response);
        } else {
            // 로그인 되어 있지 않으면 로그인 폼으로 리다이렉트
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.do");
        }
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

}
