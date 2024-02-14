package qna.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qna.service.IQnaService;
import qna.service.QnaServiceImpl;
import util.ViewResolver;
import vo.qna.AskVo;


@WebServlet("/qna/qnaWrite.do")
public class QnaWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user_id = request.getParameter("user_id");
		
		IQnaService service = QnaServiceImpl.getInstance();
		AskVo askVo = service.selectNickName(user_id);
		
		request.setAttribute("askVo", askVo);
		request.getRequestDispatcher(ViewResolver.QnaView("qnaForm.jsp")).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, String[]> datas = request.getParameterMap();
		
		AskVo askVo = new AskVo();
		
		for (Map.Entry<String, String[]> entry : datas.entrySet()) {
	        String paramName = entry.getKey();
	        String[] paramValues = entry.getValue();
	        
	        // vo에 항목별로 담기
	        if(paramName.equals("user_id")) askVo.setUser_id(String.join("", paramValues));
	        else if(paramName.equals("ask_board_title")) askVo.setAsk_board_title(String.join("", paramValues));
			else if(paramName.equals("ask_board_comment")) askVo.setAsk_board_comment(String.join("", paramValues)); 
		}
		
		IQnaService service = QnaServiceImpl.getInstance();
		service.insertBoard(askVo);
		
		response.sendRedirect(request.getContextPath() + "/qna/qnaList.do");
		
	}

}
