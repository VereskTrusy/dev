package moim.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import util.mybatisUtil;
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

public class MoimDaoImpl implements IMoimDao{

	private static MoimDaoImpl instance = null;
	private MoimDaoImpl() {}
	
	public static MoimDaoImpl getInstance() {
		if(instance == null) instance = new MoimDaoImpl();
		return instance;
	}
	
	@Override
	public List<MoimVo> moimList() {
		List<MoimVo> moimList = null;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();
			
			moimList = new ArrayList<MoimVo>();
			
			moimList = session.selectList("moim.moimList");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return moimList;
	}

	@Override
	public List<AgeVo> ageList() {
		List<AgeVo> ageList = null;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();
			
			ageList = new ArrayList<AgeVo>();
			
			ageList = session.selectList("age.ageList");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return ageList;
	}

	@Override
	public List<AreaVo> areaList() {
		List<AreaVo> areaList = null;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();
			
			areaList = new ArrayList<AreaVo>();
			
			areaList = session.selectList("area.areaList");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return areaList;
	}

	@Override
	public List<MoimVo> searchMoim(String data) {
		List<MoimVo> moimList = null;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();
			
			moimList = new ArrayList<MoimVo>();
			
			moimList = session.selectList("moim.searchMoim", data);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return moimList;
	}

	@Override
	public MoimVo detailMoim(int moimId) {
		MoimVo moim = null;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();		
			
			moim = session.selectOne("moim.detailMoim", moimId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return moim;
	}

	@Override
	public int insertMoim(MoimVo vo) {
		int cnt = 0;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();		
			
			cnt = session.insert("moim.insertMoim", vo);
			
			if(cnt > 0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return vo.getMoim_id();
	}

	@Override
	public int insertMoimUser(MoimUserVo userVo) {
		int cnt = 0;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();		
			
			cnt = session.insert("moim.insertMoimUser", userVo);
			if(cnt > 0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return cnt;
	}

	@Override
	public int updateMoimAct(MoimUserVo userVo) {
		int cnt = 0;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();		
			
			cnt = session.update("moim.updateMoimAct", userVo);
			if(cnt > 0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return cnt;
	}

	@Override
	public int insertIntroImg(FileVo fvo) {
		int cnt = 0;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();		
			
			cnt = session.insert("moim.insertIntroImg", fvo);
			if(cnt > 0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return cnt;
	}

	@Override
	public int updateIntroImg(FileVo fvo) {
		int cnt = 0;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();		
			
			cnt = session.update("moim.updateIntroImg", fvo);
			if(cnt > 0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return cnt;
	}

	@Override
	public int insertMoimCal(MoimCalVo moimCalVo) {
		int cnt = 0;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();		
			
			cnt = session.insert("moim.insertMoimCal", moimCalVo);
			if(cnt > 0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return moimCalVo.getM_cal_no();
	}

	@Override
	public int updateMoimCal(MoimCalVo moimCalVo) {
		int cnt = 0;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();		
			
			cnt = session.update("moim.updateMoimCal", moimCalVo);
			if(cnt > 0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return cnt;
	}

	@Override
	public int deleteMoimCal(MoimCalVo moimCalVo) {
		int cnt = 0;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();		
			
			cnt = session.delete("moim.deleteMoimCal", moimCalVo);
			if(cnt > 0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return cnt;
	}

	@Override
	public List<MoimCalVo> selectMoimCal(MoimCalVo moimCalVo) {
		List<MoimCalVo> list = null;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();		
			list = new ArrayList<MoimCalVo>();
			list = session.selectList("moim.selectMoimCal", moimCalVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return list;
	}

	@Override
	public MoimCalVo detailMoimCal(MoimCalVo moimCalVo) {
		MoimCalVo vo = null;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();		
			
			vo = session.selectOne("moim.detailMoimCal", moimCalVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return vo;
	}

	@Override
	public int insertEntry(EntryVo entryVo) {
		int cnt = 0;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();		
			
			cnt = session.insert("moim.insertEntry", entryVo);
			if(cnt > 0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return cnt;
	}

	@Override
	public int deleteEntry(EntryVo entryVo) {
		int cnt = 0;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();		
			
			cnt = session.delete("moim.deleteEntry", entryVo);
			if(cnt > 0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return cnt;
	}

	@Override
	public List<EntryVo> selectEntry(EntryVo entryVo) {
		List<EntryVo> list = null;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();		
			list = new ArrayList<EntryVo>();
			list = session.selectList("moim.selectEntry", entryVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return list;
	}

	@Override
	public int reportMoim(MoimReportVo moimReportVo) {
		int cnt = 0;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();		
			
			cnt = session.insert("moim.reportMoim", moimReportVo);
			if(cnt > 0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return cnt;
	}

	@Override
	public int insertMoimBoard(MoimBoardVo moimBoardVo) {
		int cnt = 0;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();		
			
			cnt = session.insert("moim.insertMoimBoard", moimBoardVo);
			if(cnt > 0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return cnt;
	}

	@Override
	public List<MoimBoardVo> selectMoimBoard(MoimBoardVo moimBoardVo) {
		List<MoimBoardVo> list = null;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();		
			list = new ArrayList<MoimBoardVo>();
			list = session.selectList("moim.selectMoimBoard", moimBoardVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return list;
	}

	@Override
	public MoimBoardVo detailMoimBoard(MoimBoardVo moimBoardVo) {
		MoimBoardVo vo = null;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();		
			
			vo = session.selectOne("moim.detailMoimBoard", moimBoardVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return vo;
	}

	@Override
	public int updateMoimBoard(MoimBoardVo moimBoardVo) {
		int cnt = 0;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();		
			
			cnt = session.update("moim.updateMoimBoard", moimBoardVo);
			if(cnt > 0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return cnt;
	}

	@Override
	public int deleteMoimBoard(MoimBoardVo moimBoardVo) {
		int cnt = 0;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();		
			
			cnt = session.update("moim.deleteMoimBoard", moimBoardVo);
			if(cnt > 0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return cnt;
	}

	@Override
	public int insertMoimBoardImg(MoimBoardImgVo moimBoardImgVo) {
		int cnt = 0;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();		
			
			cnt = session.insert("moim.insertMoimBoardImg", moimBoardImgVo);
			if(cnt > 0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return cnt;
	}

	@Override
	public List<MoimBoardImgVo> selectMoimBoardImg(MoimBoardImgVo moimBoardImgVo) {
		List<MoimBoardImgVo> list = null;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();		
			list = new ArrayList<MoimBoardImgVo>();
			list = session.selectList("moim.selectMoimBoardImg", moimBoardImgVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return list;
	}

	@Override
	public List<MoimUserVo> moimUserList(MoimVo vo) {
		List<MoimUserVo> list = null;
		SqlSession session = null;
		
		try {
			session = mybatisUtil.getSqlSession();		
			list = new ArrayList<MoimUserVo>();
			list = session.selectList("moim.moimUserList", vo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return list;
	}

}
