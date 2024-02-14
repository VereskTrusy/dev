package qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qna.service.IQnaService;
import qna.service.QnaServiceImpl;
import util.ViewResolver;
import vo.qna.AskVo;

@WebServlet("/qna/qnaDetail.do")
public class QnaDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ask_board_no = request.getParameter("ask_board_no");
		
		IQnaService service = QnaServiceImpl.getInstance();
		AskVo askVo = service.selectDetail(ask_board_no);
		
		request.setAttribute("askVo", askVo);
		
		
		request.getRequestDispatcher(ViewResolver.QnaView("qnaDetail.jsp")).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
