package member.dao;

import org.apache.ibatis.session.SqlSession;

import util.mybatisUtil;
import vo.member.MemberVo;

public class MemberDaoImpl implements IMemberDao{
	private static MemberDaoImpl instance = null;
	private MemberDaoImpl() {}
	public static MemberDaoImpl getInstance() {
		if(instance == null) instance = new MemberDaoImpl();
		return instance;
	}
	@Override
	public boolean loginMember(MemberVo vo) {
		boolean loginChk = false;
		SqlSession session = null;
		int cnt = 0;
		try {
			session = mybatisUtil.getSqlSession();
			
			cnt = session.selectOne("member.loginMember", vo);
			if(cnt > 0) loginChk = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return loginChk;
	}
	
	
}
