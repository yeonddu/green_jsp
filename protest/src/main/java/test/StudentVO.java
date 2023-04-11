package test;


public class StudentVO {
	String id;
	String userName;
	String univ;
	String birth;
	String email;
	
	public StudentVO() {
		System.out.println("StudentVo °´Ã¼ »ý¼º");
	}
	
	public StudentVO(String userName, String univ, String birth, String email) {
		this.userName = userName;
		this.univ = univ;
		this.birth = birth;
		this.email = email;
	}
	public StudentVO(String id, String userName, String univ, String birth, String email) {
		this.id = id;
		this.userName = userName;
		this.univ = univ;
		this.birth = birth;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUniv() {
		return univ;
	}

	public void setUniv(String univ) {
		this.univ = univ;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
}
