package moim.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import moim.service.IMoimService;
import moim.service.MoimServiceImpl;
import vo.moim.MoimCalVo;

/**
 * Servlet implementation class DetailMoimCal
 */
@WebServlet("/detailMoimCal.do")
public class DetailMoimCal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int m_cal_no = Integer.parseInt(request.getParameter("m_cal_no"));

		MoimCalVo vo = new MoimCalVo();
		vo.setM_cal_no(m_cal_no);
		
		IMoimService service = MoimServiceImpl.getInstance();
		vo = service.detailMoimCal(vo);
		
		
		JsonObject jsonResponse = new JsonObject();
        jsonResponse.addProperty("title", vo.getCal_title());
        jsonResponse.addProperty("content", vo.getCal_coment());
        jsonResponse.addProperty("addr1", vo.getCal_addr1());
        jsonResponse.addProperty("addr2", vo.getCal_addr2());
        
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(new Gson().toJson(jsonResponse));
        out.flush();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
