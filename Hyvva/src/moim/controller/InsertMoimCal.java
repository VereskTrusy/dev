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
import vo.moim.MoimCalVo;

/**
 * Servlet implementation class InsertMoimCal
 */
@WebServlet("/insertMoimCal.do")
public class InsertMoimCal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession(true);
		session.setAttribute("id", "test1");
		session.setAttribute("moimId", "4");
		
		request.getRequestDispatcher("/html/insertMoimCalView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		MoimCalVo calVo = new MoimCalVo();
		
		String id = (String) request.getParameter("id");
		calVo.setMoim_id(Integer.parseInt(request.getParameter("moimId")));
		calVo.setCal_title((String) request.getParameter("title"));
		calVo.setCal_coment((String)request.getParameter("content"));
		calVo.setCal_date((String) request.getParameter("date"));
		calVo.setCal_place((String) request.getParameter("place"));
		calVo.setCal_addr1((String) request.getParameter("addr1"));
		calVo.setCal_addr2((String) request.getParameter("addr2"));
		
		IMoimService service = MoimServiceImpl.getInstance();
		
		int m_cal_no = service.insertMoimCal(calVo);
		
		//참가자 추가
		EntryVo entryVo = new EntryVo();
		entryVo.setUser_id(id);
		entryVo.setM_cal_no(m_cal_no);
		
		service.insertEntry(entryVo);
		
		request.getRequestDispatcher("/main.jsp").forward(request, response);
		
		
	}

}
