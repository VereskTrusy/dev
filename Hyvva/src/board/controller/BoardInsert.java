package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import vo.board.BoardVO;


@WebServlet("/boardInsert.do")
public class BoardInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/board/boardInsert.jsp")
		.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	request.setCharacterEncoding("utf-8");
	
	
	
	String user_id = request.getParameter("user_id");
	String board_title = request.getParameter("board_title");
	String board_content = request.getParameter("board_content");
	
	
	BoardVO boardVo = new BoardVO();
	
	boardVo.setUser_id(user_id);
	boardVo.setBoard_title(board_title);
	boardVo.setBoard_content(board_content);
	
	
	
	IBoardService service = BoardServiceImpl.getInstance();
	service.insertBoard(boardVo);
	
	response.sendRedirect(request.getContextPath()+"/boardList.do");
	    
	
		
	}

}
