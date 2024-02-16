package moim.service;

import java.util.List;

import moim.dao.IMoimDao;
import moim.dao.MoimDaoImpl;
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

public class MoimServiceImpl implements IMoimService {
	private IMoimDao dao;
	private static MoimServiceImpl instance = null;
	private MoimServiceImpl() {
		dao = MoimDaoImpl.getInstance();
	}
	public static MoimServiceImpl getInstance() {
		if(instance == null) instance = new MoimServiceImpl();
		return instance;
	}
	@Override
	public List<MoimVo> moimList() {
		
		return dao.moimList();
	}
	@Override
	public List<AgeVo> ageList() {
		
		return dao.ageList();
	}
	@Override
	public List<AreaVo> areaList() {
		// TODO Auto-generated method stub
		return dao.areaList();
	}
	@Override
	public List<MoimVo> searchMoim(String data) {
		// TODO Auto-generated method stub
		return dao.searchMoim(data);
	}
	@Override
	public MoimVo detailMoim(int moimId) {
		// TODO Auto-generated method stub
		return dao.detailMoim(moimId);
	}
	@Override
	public int insertMoim(MoimVo vo) {
		// TODO Auto-generated method stub
		return dao.insertMoim(vo);
	}
	@Override
	public int insertMoimUser(MoimUserVo userVo) {
		// TODO Auto-generated method stub
		return dao.insertMoimUser(userVo);
	}
	@Override
	public int updateMoimAct(MoimUserVo userVo) {
		// TODO Auto-generated method stub
		return dao.updateMoimAct(userVo);
	}
	@Override
	public int insertIntroImg(FileVo fvo) {
		// TODO Auto-generated method stub
		return dao.insertIntroImg(fvo);
	}
	@Override
	public int updateIntroImg(FileVo fvo) {
		// TODO Auto-generated method stub
		return dao.updateIntroImg(fvo);
	}
	@Override
	public int insertMoimCal(MoimCalVo moimCalVo) {
		// TODO Auto-generated method stub
		return dao.insertMoimCal(moimCalVo);
	}
	@Override
	public int updateMoimCal(MoimCalVo moimCalVo) {
		// TODO Auto-generated method stub
		return dao.updateMoimCal(moimCalVo);
	}
	@Override
	public int deleteMoimCal(MoimCalVo moimCalVo) {
		// TODO Auto-generated method stub
		return dao.deleteMoimCal(moimCalVo);
	}
	@Override
	public List<MoimCalVo> selectMoimCal(MoimCalVo moimCalVo) {
		// TODO Auto-generated method stub
		return dao.selectMoimCal(moimCalVo);
	}
	@Override
	public MoimCalVo detailMoimCal(MoimCalVo moimCalVo) {
		// TODO Auto-generated method stub
		return dao.detailMoimCal(moimCalVo);
	}
	@Override
	public int insertEntry(EntryVo entryVo) {
		// TODO Auto-generated method stub
		return dao.insertEntry(entryVo);
	}
	@Override
	public int deleteEntry(EntryVo entryVo) {
		// TODO Auto-generated method stub
		return dao.deleteEntry(entryVo);
	}
	@Override
	public List<EntryVo> selectEntry(EntryVo entryVo) {
		// TODO Auto-generated method stub
		return dao.selectEntry(entryVo);
	}
	@Override
	public int reportMoim(MoimReportVo moimReportVo) {
		// TODO Auto-generated method stub
		return dao.reportMoim(moimReportVo);
	}
	@Override
	public int insertMoimBoard(MoimBoardVo moimBoardVo) {
		// TODO Auto-generated method stub
		return dao.insertMoimBoard(moimBoardVo);
	}
	@Override
	public List<MoimBoardVo> selectMoimBoard(MoimBoardVo moimBoardVo) {
		// TODO Auto-generated method stub
		return dao.selectMoimBoard(moimBoardVo);
	}
	@Override
	public MoimBoardVo detailMoimBoard(MoimBoardVo moimBoardVo) {
		// TODO Auto-generated method stub
		return dao.detailMoimBoard(moimBoardVo);
	}
	@Override
	public int updateMoimBoard(MoimBoardVo moimBoardVo) {
		// TODO Auto-generated method stub
		return dao.updateMoimBoard(moimBoardVo);
	}
	@Override
	public int deleteMoimBoard(MoimBoardVo moimBoardVo) {
		// TODO Auto-generated method stub
		return dao.deleteMoimBoard(moimBoardVo);
	}
	@Override
	public int insertMoimBoardImg(MoimBoardImgVo moimBoardImgVo) {
		// TODO Auto-generated method stub
		return dao.insertMoimBoardImg(moimBoardImgVo);
	}
	@Override
	public List<MoimBoardImgVo> selectMoimBoardImg(MoimBoardImgVo moimBoardImgVo) {
		// TODO Auto-generated method stub
		return dao.selectMoimBoardImg(moimBoardImgVo);
	}
	@Override
	public List<MoimUserVo> moimUserList(MoimVo vo) {
		// TODO Auto-generated method stub
		return dao.moimUserList(vo);
	}

}
