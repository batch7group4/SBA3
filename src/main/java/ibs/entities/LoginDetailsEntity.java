package ibs.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LOGIN_USERS")
public class LoginDetailsEntity{
	
	@Id
	@Column(name="LOGIN_SEQ_ID")
	@GeneratedValue
	private Integer loginSeqId;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="PASSWORD")
	private String password; 
	
	@Column(name="ROLE")
	private String role;

	public LoginDetailsEntity() {
		super();
	}

	public LoginDetailsEntity(Integer loginSeqId, String userName, String password, String role) {
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
