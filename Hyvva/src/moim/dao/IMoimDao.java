package moim.dao;

import java.util.List;

import vo.file.FileVo;
import vo.moim.AgeVo;
import vo.moim.AreaVo;
import vo.moim.EntryVo;
import vo.moim.MoimBoardImgVo;
import vo.moim.MoimBoardVo;
import vo.moim.MoimCalVo;
import vo.moim.MoimReportVo;
import vo.moim.MoimUserVo;
import vo.moim.MoimVo;

public interface IMoimDao {
	/**
	 * moim목록을 불러오는 메서드
	 * @return List<MoimVo>
	 */
	public List<MoimVo> moimList();
	
	/**
	 * age목록을 가져오는 메서드
	 * @return agevo
	 */
	public List<AgeVo> ageList();
	
	/**
	 * area목록을 가져오는 메서드
	 * @return areavo
	 */
	public List<AreaVo> areaList();
	
	/**
	 * 검색한 moim목록을 불러오는 메서드
	 * @param data 검색어
	 * @return List<MoimVo>
	 */
	public List<MoimVo> searchMoim(String data);
	
	/**
	 * 소모임 상세정보를 불러오는 메서드
	 * @param moimId
	 * @return MoimVo
	 */
	public MoimVo detailMoim(int moimId);
	
	/**
	 * 소모임 개최 메서드
	 * @param vo
	 * @return 성공하면 1 아니면 0
	 */
	public int insertMoim(MoimVo vo);
	
	/**
	 * 소모임 개최나 가입시 정보를 넣는 메서드
	 * @param userVo
	 * @return 성공하면 1 아니면 0
	 */
	public int insertMoimUser(MoimUserVo userVo);
	
	/**
	 * 소모임 활동 상태를 변경하는 메서드
	 * 가입 미승인시 N 승인하면 Y로 변경한다
	 * @param userVo
	 * @return 성공하면 1 아니면 0
	 */
	public int updateMoimAct(MoimUserVo userVo);
	
	/**
	 * 소모임 대표이미지 삽입 메서드
	 * @param fvo
	 * @return 성공하면 1 아니면 0
	 */
	public int insertIntroImg(FileVo fvo);
	
	
	/**
	 * 소모임 대표 이미지 업데이트
	 * @param fvo 
	 * @return 성공하면 1 아니면 0
	 */
	public int updateIntroImg(FileVo fvo);
	
	/**
	 * 소모임 일정 추가 메서드
	 * @param moimCalVo M_CAL_NO, MOIM_ID, CAL_TITLE, CAL_COMENT, CAL_DATE
	 * @return 성공하면 1 아니면 0
	 */
	public int insertMoimCal(MoimCalVo moimCalVo);
	
	/**
	 * 소모임 일정 수정 메서드
	 * @param moimCalVo 제목 내용 일자 수정
	 * @return 성공하면 1 아니면 0
	 */
	public int updateMoimCal(MoimCalVo moimCalVo);
	
	/**
	 * 소모임 일정 삭제
	 * @param moimCalVo
	 * @return 성공하면 1 아니면 0
	 */
	public int deleteMoimCal(MoimCalVo moimCalVo);
	
	/**
	 * 소모임 일정 보기
	 * @param moimCalVo 
	 * @return m_cal_no, cal_title, cal_date
	 */
	public List<MoimCalVo> selectMoimCal(MoimCalVo moimCalVo);
	
	/**
	 * 소모임 일정 상세보기
	 * @param moimCalVo
	 * @return
	 */
	public MoimCalVo detailMoimCal(MoimCalVo moimCalVo);
	
	/**
	 * 소모임 일정 참가자 추가
	 * @param entryVo
	 * @return
	 */
	public int insertEntry(EntryVo entryVo);
	
	/**
	 * 소모임 일정 참가자 삭제
	 * @param entryVo
	 * @return
	 */
	public int deleteEntry(EntryVo entryVo);
	
	/**
	 * 소모임 참가자 보기
	 * @param entryVo 
	 * @return 닉네임과 아이디 반환
	 */
	public List<EntryVo> selectEntry(EntryVo entryVo);
	
	/**
	 * 소모임 신고
	 * @param moimReportVo
	 * @return
	 */
	public int reportMoim(MoimReportVo moimReportVo);
	
	/**
	 * 소모임 게시판 작성
	 * @param moimBoardVo
	 * @return
	 */
	public int insertMoimBoard(MoimBoardVo moimBoardVo);
	
	/**
	 * 소모임 게시판 보기
	 * @param moimBoardVo
	 * @return
	 */
	public List<MoimBoardVo> selectMoimBoard(MoimBoardVo moimBoardVo);
	
	/**
	 * 소모임 게시판 상세보기
	 * @param moimBoardVo
	 * @return
	 */
	public MoimBoardVo detailMoimBoard(MoimBoardVo moimBoardVo);
	
	/**
	 * 소모임 게시판 수정
	 * @param moimBoardVo
	 * @return
	 */
	public int updateMoimBoard(MoimBoardVo moimBoardVo);
	
	/**
	 * 소모임 게시판 삭제
	 * @param moimBoardVo
	 * @return
	 */
	public int deleteMoimBoard(MoimBoardVo moimBoardVo);
	
	/**
	 * 소모임 작성시 이미지 추가
	 * @param moimBoardImgVo
	 * @return
	 */
	public int insertMoimBoardImg(MoimBoardImgVo moimBoardImgVo);
	
	/**
	 * 소모임 게시판 이미지 수정
	 * @param moimBoardImgVo
	 * @return
	 */
	public List<MoimBoardImgVo> selectMoimBoardImg(MoimBoardImgVo moimBoardImgVo);
	
	/**
	 * 소모임 신청자 리스트
	 * @param vo
	 * @return
	 */
	public List<MoimUserVo> moimUserList(MoimVo vo);
	
}
