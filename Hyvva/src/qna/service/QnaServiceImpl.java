package qna.service;

import java.util.List;

import qna.dao.IQnaDao;
import qna.dao.QnaDaoImpl;
import vo.common.PageVo;
import vo.qna.AskVo;

public class QnaServiceImpl implements IQnaService {
	
	private IQnaDao dao;
	
	private static IQnaService service;
	
	private QnaServiceImpl() {
		dao = QnaDaoImpl.getInstance();
	}
	
	public static IQnaService getInstance() {
		if(service == null) service = new QnaServiceImpl();
		return service;
	}
	
	// 임시 - 문의게시판 리스트
	@Override
	public List<AskVo> selectListAll() {
		return dao.selectListAll();
	}
	
	// 게시글 총 갯수 구하기
	@Override
	public int selectTotalCount(PageVo pageVo) {
		return dao.selectTotalCount(pageVo);
	}

	// 문의게시판 리스트
	@Override
	public List<AskVo> selectList(PageVo pageVo) {
		return dao.selectList(pageVo);
	}

	// 게시글 상세
	@Override
	public AskVo selectDetail(String ask_board_no) {
		return dao.selectDetail(ask_board_no);
	}

	// 게시글 수정
	@Override
	public int updateBoard(AskVo askVo) {
		return dao.updateBoard(askVo);
	}

	// 닉네임 조회
	@Override
	public AskVo selectNickName(String user_id) {
		return dao.selectNickName(user_id);
	}

	// 게시글 작성
	@Override
	public int insertBoard(AskVo askVo) {
		return dao.insertBoard(askVo);
	}

	
	
	

}
