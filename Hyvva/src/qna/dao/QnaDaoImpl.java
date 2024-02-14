package qna.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import util.mybatisUtil;
import vo.common.PageVo;
import vo.qna.AskVo;

public class QnaDaoImpl implements IQnaDao {
	private static IQnaDao dao;
	
	private QnaDaoImpl() {}
	
	public static IQnaDao getInstance() {
		if(dao == null) dao = new QnaDaoImpl();
		return dao;
	}

	// 임시 - 문의게시판 리스트
	@Override
	public List<AskVo> selectListAll() {
		SqlSession session = null;
		List<AskVo> list = null;
		
		try {
			
			session = mybatisUtil.getSqlSession();
			list = session.selectList("ask.selectDemoList");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return list;
	}

	// 게시글 총 갯수 구하기
	@Override
	public int selectTotalCount(PageVo pageVo) {
		SqlSession session = null;
		int totalCount = 0;
		
		try {
			
			session = mybatisUtil.getSqlSession();
			totalCount = session.selectOne("ask.selectTotalCount", pageVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		
		return totalCount;
	}

	// 게시판 리스트 
	@Override
	public List<AskVo> selectList(PageVo pageVo) {
		SqlSession session = null;
		List<AskVo> list = null;
		
		try {
			session = mybatisUtil.getSqlSession();
			list = session.selectList("ask.selectBoardList", pageVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		
		return list;
	}

	// 게시글 상세
	@Override
	public AskVo selectDetail(String ask_board_no) {
		AskVo askVo = null;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();
			askVo = session.selectOne("ask.selectDetail", ask_board_no);
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if(session != null) session.close();
		}
		
		return askVo;
	}
	
	// 게시글 수정
	@Override
	public int updateBoard(AskVo askVo) {
		SqlSession session = null;
		int updateResult = 0;
		
		try {
			session = mybatisUtil.getSqlSession();
			updateResult = session.update("ask.updateBoard", askVo);
			
			session.commit();
			return updateResult;
			
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return updateResult;
	}

	// 닉네임 조회
	@Override
	public AskVo selectNickName(String user_id) {
		SqlSession session = null;
		AskVo askVo = null;
		
		try {
			
			session = mybatisUtil.getSqlSession();
			askVo = session.selectOne("ask.selectNickName", user_id);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return askVo;
	}
	
	// 게시글 작성
	@Override
	public int insertBoard(AskVo askVo) {
		SqlSession session = null;
		int insertResult = 0;
		
		try {
			session = mybatisUtil.getSqlSession();
			insertResult = session.insert("ask.insertBoard", askVo);
			
			session.commit();
			return insertResult;
			
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return insertResult;
	}
	
}
