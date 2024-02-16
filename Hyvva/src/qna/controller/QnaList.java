package qna.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qna.service.IQnaService;
import qna.service.QnaServiceImpl;
import util.ViewResolver;
import vo.common.PageVo;
import vo.qna.AskVo;


@WebServlet("/qna/qnaList.do")
public class QnaList extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 검색구분, 검색어, 현재페이지번호 파라미터로 받기
		String searchGubun = "ask_board_title";
		if(null != request.getParameter("searchGubun")) {
			searchGubun = request.getParameter("searchGubun");
		}
		
		String searchText = "";
		if(null != request.getParameter("searchText")) {
			searchText = request.getParameter("searchText");
		}
		
		int currentPageNo = 1;
		if(null != request.getParameter("currentPageNo")) {
			currentPageNo = Integer.parseInt(request.getParameter("currentPageNo"));			
		}
		
		int currentPageArea = 1;
		if(null != request.getParameter("currentPageArea")) {
			currentPageArea = Integer.parseInt(request.getParameter("currentPageArea"));
		}
		
		
		// PageVo에 삽입
		PageVo pageVo = new PageVo();
		pageVo.setSearchGubun(searchGubun);
		pageVo.setSearchText(searchText);
		pageVo.setCurrentPageNo(currentPageNo);
		pageVo.setCurrentPageArea(currentPageArea);
		
		IQnaService service = QnaServiceImpl.getInstance();
		
		// 총 레코드 수 구하기
		int recordTotalCount = service.selectTotalCount(pageVo);
		pageVo.setRecordTotalCount(recordTotalCount);
		
		// 레코드 시작, 끝 번호 세팅
		pageVo.recordNoRangeSetting();
		
		// 페이지 총갯수 세팅 
		pageVo.pageTotalCountSetting();
		
		// 페이지 정보 구하기
		pageVo.pageNoRangeSetting();
		
		// 레코드 목록 구하기
		List<AskVo> qnaList = null;
		qnaList = service.selectList(pageVo);
		
		request.setAttribute("pageVo", pageVo);
		request.setAttribute("qnaList", qnaList);
		
		request.getRequestDispatcher(ViewResolver.QnaView("qnaList.jsp")).forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}


