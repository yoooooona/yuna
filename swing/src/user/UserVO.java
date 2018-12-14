package user;

import java.util.Vector;

//테이블하나의 행에 대응하는 값을 담기위한 객체
public class UserVO {
	private int no;
	private String name;
	private String birthday;
	private String address;

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "UserVO [no=" + no + ", name=" + name + ", birthday=" + birthday + ", address=" + address + "]";
	}
	

}
