package user;

import java.util.Vector;

//���̺��ϳ��� �࿡ �����ϴ� ���� ������� ��ü
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
