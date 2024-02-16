package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import vo.board.BoardVO;


@WebServlet("/boardUpdate.do")
public class BoardUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String boardno = request.getParameter("board_no");
		
		IBoardService service = BoardServiceImpl.getInstance();
		
		BoardVO boardVo = service.getBoard(Integer.parseInt(boardno));
		
		request.setAttribute("boardVo", boardVo);
		request.getRequestDispatcher("/WEB-INF/view/board/boardUpdateForm.jsp")
		.forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_content");
		
		
		BoardVO boardVo = new BoardVO();
		boardVo.setBoard_title(board_title);
		boardVo.setBoard_content(board_content);
		boardVo.setBoard_no(board_no);
		
		IBoardService service = BoardServiceImpl.getInstance();
		service.updateBoard(boardVo);
		
		response.sendRedirect(request.getContextPath()+"/boardList.do");
		
	}

}
