package moim.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import moim.service.IMoimService;
import moim.service.MoimServiceImpl;
import vo.moim.MoimCalVo;
import vo.moim.MoimUserVo;
import vo.moim.MoimVo;

/**
 * Servlet implementation class MoimUserList
 */
@WebServlet("/moimUserList.do")
public class MoimUserList extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int moimId = Integer.parseInt(request.getParameter("moimId"));
		MoimVo vo = new MoimVo();
		vo.setMoim_id(moimId);
		IMoimService service = MoimServiceImpl.getInstance();
		List<MoimUserVo> list = service.moimUserList(vo);
		
		Gson gson = new Gson();
		JsonArray jsonArray = new JsonArray();
		
		for (MoimUserVo moimCal : list) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("userId", moimCal.getUser_id());
            jsonObject.addProperty("ent_date", moimCal.getEnt_date());
            System.out.println(moimCal.getEnt_date());
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
