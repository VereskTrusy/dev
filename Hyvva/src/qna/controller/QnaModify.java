package qna.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import file.FileUtil;
import qna.service.IQnaService;
import qna.service.QnaServiceImpl;
import util.ViewResolver;
import vo.Campaign.CampaignImgVo;
import vo.qna.AskVo;


@WebServlet("/qna/qnaModify.do")
public class QnaModify extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ask_board_no = request.getParameter("ask_board_no");
		
		IQnaService service = QnaServiceImpl.getInstance();
		AskVo askVo = service.selectDetail(ask_board_no);		
		
		request.setAttribute("askVo", askVo);
		
		
		request.getRequestDispatcher(ViewResolver.QnaView("qnaModify.jsp")).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, String[]> datas = request.getParameterMap();
		
		AskVo askVo = new AskVo();
		
		for (Map.Entry<String, String[]> entry : datas.entrySet()) {
	        String paramName = entry.getKey();
	        String[] paramValues = entry.getValue();
	        
	        // vo에 항목별로 담기
	        if(paramName.equals("ask_board_no")) askVo.setAsk_board_no(Integer.parseInt(String.join("", paramValues)));
			else if(paramName.equals("ask_board_title")) askVo.setAsk_board_title(String.join("", paramValues));
			else if(paramName.equals("ask_board_comment")) askVo.setAsk_board_comment(String.join("", paramValues)); 
		}
		
		IQnaService service = QnaServiceImpl.getInstance();
		service.updateBoard(askVo);
		
		response.sendRedirect(request.getContextPath() + "/qna/qnaDetail.do?ask_board_no=" + askVo.getAsk_board_no());
	}

}
