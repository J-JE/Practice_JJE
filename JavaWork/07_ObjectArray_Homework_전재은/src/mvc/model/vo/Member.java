package mvc.model.vo;

public class Member {
	
	private String userld;
	private String userPwd;
	private String name;
	private int age;
	private char gender;
	private String email;

	public Member() {	}

	public Member(String userld, String userPwd, String name, int age, char gender, String email) {
		super();
		this.userld = userld;
		this.userPwd = userPwd;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.email = email;
	}

	public String getUserld() {
		return userld;
	}

	public void setUserld(String userld) {
		this.userld = userld;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String information() {
		return "Member [userld=" + userld + ", userPwd=" + userPwd + ", name=" + name + ", age=" + age + ", gender="
				+ gender + ", email=" + email + "]";
	}
	
	

}
