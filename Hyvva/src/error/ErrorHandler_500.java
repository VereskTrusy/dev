package error;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ViewResolver;


@WebServlet("/erroHandler_500")
public class ErrorHandler_500 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(ViewResolver.ErrorView("error-500.html")).forward(request, response);
		//response.sendRedirect(ViewResolver.ErrorView("error-500.html"));
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
