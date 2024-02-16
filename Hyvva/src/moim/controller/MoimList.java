package moim.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import moim.service.IMoimService;
import moim.service.MoimServiceImpl;
import vo.moim.MoimVo;

/**
 * Servlet implementation class MoimList
 */
@WebServlet("/moimList.do")
public class MoimList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		IMoimService service = MoimServiceImpl.getInstance();
		
		List<MoimVo> moimList = service.moimList();
		
		request.setAttribute("moimList", moimList);
		
		request.getRequestDispatcher("/html/moimListView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
