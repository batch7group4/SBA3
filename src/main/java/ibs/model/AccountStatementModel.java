package ibs.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class AccountStatementModel{
	
	private String startDate;
	private String endDate;
	private long custAcctNum;
	private String userName;
	
	public AccountStatementModel() {
		super();
	}

	public AccountStatementModel(String startDate, String endDate, long custAcctNum,String userName) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.custAcctNum = custAcctNum;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public long getCustAcctNum() {
		return custAcctNum;
	}

	public void setCustAcctNum(long custAcctNum) {
		this.custAcctNum = custAcctNum;
	}

	
	
		
}
