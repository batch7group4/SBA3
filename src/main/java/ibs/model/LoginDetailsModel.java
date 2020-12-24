package ibs.model;

public class LoginDetailsModel{
	
	private Integer loginSeqId;
	
	private String userName;
	
	private String password; 
	private String role;

	public LoginDetailsModel() {
		super();
	}

	public LoginDetailsModel(Integer loginSeqId, String userName, String password, String role) {
		super();
		this.loginSeqId = loginSeqId;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public Integer getLoginSeqId() {
		return loginSeqId;
	}

	public void setLoginSeqId(Integer loginSeqId) {
		this.loginSeqId = loginSeqId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	
}
