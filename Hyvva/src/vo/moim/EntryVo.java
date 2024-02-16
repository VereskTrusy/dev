package vo.moim;

public class EntryVo {
	private int m_cal_no;
	private String user_id;
	private String nick_name;
	private String cerated_at;
	
	
	
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public int getM_cal_no() {
		return m_cal_no;
	}
	public void setM_cal_no(int m_cal_no) {
		this.m_cal_no = m_cal_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getCerated_at() {
		return cerated_at;
	}
	public void setCerated_at(String cerated_at) {
		this.cerated_at = cerated_at;
	}
	
	
}
