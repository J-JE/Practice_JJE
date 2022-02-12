package mvc.model.vo;


public class Member {
	
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String citizenNo;
	private double height;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	public Member(String memberId, String memberPwd, String memberName, String citizenNo, double height) {
		this.memberId=memberId; //까먹지 말고 입력하기...
		this.memberPwd=memberPwd;
		this.memberName=memberName;
		this.citizenNo=citizenNo;
		this.height=height;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPw(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getCitizenNo() {
		return citizenNo;
	}

	public void setCitizenNo(String citizenNo) {
		this.citizenNo = citizenNo;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public String information() {
		return "id : "+memberId+", pwd : "+memberPwd+", 이름 : "+ memberName+", 주민번호 : "+citizenNo+", 키 : "+height;
	}

	
}
