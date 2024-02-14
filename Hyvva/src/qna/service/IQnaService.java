package qna.service;

import java.util.List;

import vo.common.PageVo;
import vo.qna.AskVo;

public interface IQnaService {
	
	// 임시 - 문의게시판 리스트
	public List<AskVo> selectListAll();
	
	// 게시글 총 갯수 구하기
	public int selectTotalCount(PageVo pageVo);
	
	// 게시글 리스트
	public List<AskVo> selectList(PageVo pageVo);
	
	// 게시글 상세
	public AskVo selectDetail(String ask_board_no);
	
	// 게시글 수정
	public int updateBoard(AskVo askVo);
	
	// 닉네임 조회
	public AskVo selectNickName(String user_id);
	
	// 게시글 작성
	public int insertBoard(AskVo askVo);
}
