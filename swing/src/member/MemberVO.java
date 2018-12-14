package member;

public class MemberVO {
	private int idx;
	private String name;
	private int age;
	private String gender;

	// setter, getter �����
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "MemberVO [idx=" + idx + ", name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
	
}	
