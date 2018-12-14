package member.vo;

public class MemberVO {
	private String userid;
	private String password;
	private String name;
	private String gender;
	private String email;
	
	public boolean password_equalTo(String password) {
		return this.password.equals(password);
	}
	
	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", password=" + password + ", name=" + name + ", gender=" + gender
				+ ", email=" + email + "]";
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//getter,setter,toString
	
	
}
