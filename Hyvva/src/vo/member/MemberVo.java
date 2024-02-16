package vo.member;

public class MemberVo {
	 private String user_id;
	 private String user_pass;
	 private String user_name;
	 private String phone;
	 private String nick_name;
	 private String email;
	 private String birth;
	 private String post_no;
	 private String addr;
	 private String detail_addr;
	 private String mileage;
	 private String alam_yn;
	 private String create_date;
	 private String update_date;
	 private String del_yn;
	 private String user_img;
	 
	 
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pass() {
		return user_pass;
	}
	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPost_no() {
		return post_no;
	}
	public void setPost_no(String post_no) {
		this.post_no = post_no;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getDetail_addr() {
		return detail_addr;
	}
	public void setDetail_addr(String detail_addr) {
		this.detail_addr = detail_addr;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	public String getAlam_yn() {
		return alam_yn;
	}
	public void setAlam_yn(String alam_yn) {
		this.alam_yn = alam_yn;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	public String getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}
	public String getUser_img() {
		return user_img;
	}
	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}
	
	@Override
	public String toString() {
		return "MemberVo [user_id=" + user_id + ", user_pass=" + user_pass + ", user_name=" + user_name + ", phone="
				+ phone + ", nick_name=" + nick_name + ", email=" + email + ", birth=" + birth + ", post_no=" + post_no
				+ ", addr=" + addr + ", detail_addr=" + detail_addr + ", mileage=" + mileage + ", alam_yn=" + alam_yn
				+ ", create_date=" + create_date + ", update_date=" + update_date + ", del_yn=" + del_yn + ", user_img="
				+ user_img + "]";
	}
	 
	 
	 
}
