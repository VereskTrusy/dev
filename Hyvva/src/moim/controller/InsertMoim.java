package moim.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import moim.service.IMoimService;
import moim.service.MoimServiceImpl;
import vo.moim.AgeVo;
import vo.moim.AreaVo;
import vo.moim.MoimUserVo;
import vo.moim.MoimVo;

/**
 * Servlet implementation class InsertMoim
 */
@WebServlet("/insertMoim.do")
public class InsertMoim extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession(true);
		session.setAttribute("id", "test1");
		IMoimService service = MoimServiceImpl.getInstance();
		
		List<AgeVo> ageList = service.ageList();
		List<AreaVo> areaList = service.areaList();
		
		request.setAttribute("ageList", ageList);
		request.setAttribute("areaList", areaList);
		
		request.getRequestDispatcher("/html/InsertMoimView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(true);
		String id = (String) session.getAttribute("id");
		
		String moimName = request.getParameter("moimName");
		String age = request.getParameter("age");
		String area = request.getParameter("area");
		String content = request.getParameter("content");
		
		MoimVo vo = new MoimVo();
		
		vo.setMoim_name(moimName);
		vo.setAge_id(age);
		vo.setArea_id(area);
		vo.setMoim_intro(content);
		
		IMoimService service = MoimServiceImpl.getInstance();
		int moimId = service.insertMoim(vo);
		
		MoimUserVo userVo = new MoimUserVo();
		userVo.setMoim_id(moimId);
		userVo.setUser_id(id);
		userVo.setAct_yn("Y");
		userVo.setLeader("Y");
		
		service.insertMoimUser(userVo);
		
		request.getRequestDispatcher("/moimList.do").forward(request, response);
	
	}

}
