package moim.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import moim.service.IMoimService;
import moim.service.MoimServiceImpl;
import vo.moim.EntryVo;

/**
 * Servlet implementation class InsertEntry
 */
@WebServlet("/insertEntry.do")
public class InsertEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		session.setAttribute("id", "test2");
		String userId = (String) session.getAttribute("id");
		int sel = Integer.parseInt(request.getParameter("sel"));
		EntryVo vo = new EntryVo();
		vo.setM_cal_no(sel);
		vo.setUser_id(userId);
		
		IMoimService service = MoimServiceImpl.getInstance();
		service.insertEntry(vo);
		
		request.getRequestDispatcher("/html/moimCalView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
