package moim.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import moim.service.IMoimService;
import moim.service.MoimServiceImpl;
import vo.moim.MoimCalVo;

/**
 * Servlet implementation class SelectMoimCal
 */
@WebServlet("/selectMoimCal.do")
public class SelectMoimCal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(true);
		session.setAttribute("moimId", 4);
		
		int moimId = (int) session.getAttribute("moimId");		

		
		
		MoimCalVo vo = new MoimCalVo();
		vo.setMoim_id(moimId);
		
		List<MoimCalVo> list = new ArrayList<MoimCalVo>();
		IMoimService service = MoimServiceImpl.getInstance();
		list = service.selectMoimCal(vo);
		
		Gson gson = new Gson();
		JsonArray jsonArray = new JsonArray();
		
		for (MoimCalVo moimCal : list) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("m_cal_no", moimCal.getM_cal_no());
            jsonObject.addProperty("title", moimCal.getCal_title());
            jsonObject.addProperty("start", moimCal.getCal_date());
            System.out.println();
            jsonArray.add(jsonObject);
        }
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(new Gson().toJson(jsonArray));
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
