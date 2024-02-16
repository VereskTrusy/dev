package member.service;

import member.dao.IMemberDao;
import member.dao.MemberDaoImpl;
import vo.member.MemberVo;

public class MemberServiceImpl implements IMemberService{
	private static MemberServiceImpl instance = null;
	private IMemberDao dao;
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	public static MemberServiceImpl getInstance() {
		if(instance == null) instance = new MemberServiceImpl();
		return instance;
	}
	@Override
	public boolean loginMember(MemberVo vo) {
		
		return dao.loginMember(vo);
	}

}
