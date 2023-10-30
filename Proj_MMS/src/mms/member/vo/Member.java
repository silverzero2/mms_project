package mms.member.vo;
// 멤버의 정보 저장
public class Member {
	// 필드
	private int id;
	private String name;
	private String addr;
	private String nation;
	private String email;
	private int age;
	
	// 생성자
	public Member() {
	}
	
	public Member(int id, String name, String addr, String nation, String email, int age) {
		this.id = id;
		this.name = name;
		this.addr = addr;
		this.nation = nation;
		this.email = email;
		this.age = age;
	}

	// getter와 setter 메소드
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// ArrayList에서 보여주고자 하는 모습으로 오버라이딩
	@Override
	public String toString() {
		return "name = " + name + ", addr = " + addr + ", nation = " + nation + ", email = " + email
				+ ", age = " + age;
	}
	
	
	
}
