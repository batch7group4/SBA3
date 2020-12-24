package ibs.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CUST_ACCT")
public class CustAcctEntity{
	
	@Id
	@Column(name="UCI")
	@GeneratedValue
	private long uci;
	@Column(name="USER_NAME")
	private String userName;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name="AVLBL_BAL")
	private double availableBalance;
	
	public double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}
	@Column(name="REG_ID")
	private long regId;
	
	
	@Column(name="ACCT_NUM")
	private long custAcctNum;
	
	@Column(name="CUST_NM")
	private String custName; 
	
	@Column(name="CUST_ACCT_TYP")
	private String custAcctType;

	@Column(name="AVL_BAL")
	private double avlBal;
	
	@Column(name="ACCT_ST_DT")
	private LocalDate acctStartDate;
	
	@Column(name="ACCT_CLS_DT")
	private LocalDate acctCloseDate;
	
	
	@Column(name="INTR_RT")
	private double interestRate;
	
	@Column(name="TENURE")
	private String tenure;
	
	@Column(name="ACCT_STATUS")
	private String custAcctStatus;

	public CustAcctEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustAcctEntity(long uci, long regId, long custAcctNum, String custName,
			String custAcctType, double avlBal, LocalDate acctStartDate, LocalDate acctCloseDate, 
			double interestRate, String tenure, String custAcctStatus) {
		super();
		this.uci = uci;
		this.regId = regId;
		this.custAcctNum = custAcctNum;
		this.custName = custName;
		this.custAcctType = custAcctType;
		this.avlBal = avlBal;
		this.acctStartDate = acctStartDate;
		this.acctCloseDate = acctCloseDate;
		this.interestRate = interestRate;
		this.tenure = tenure;
		this.custAcctStatus = custAcctStatus;
	}
	
	public long getRegId() {
		return regId;
	}

	public void setRegId(long regId) {
		this.regId = regId;
	}


	public long getUci() {
		return uci;
	}

	public void setUci(long uci) {
		this.uci = uci;
	}


	public long getCustAcctNum() {
		return custAcctNum;
	}

	public void setCustAcctNum(long custAcctNum) {
		this.custAcctNum = custAcctNum;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustAcctType() {
		return custAcctType;
	}

	public void setCustAcctType(String custAcctType) {
		this.custAcctType = custAcctType;
	}

	public double getAvlBal() {
		return avlBal;
	}

	public void setAvlBal(double avlBal) {
		this.avlBal = avlBal;
	}

	public LocalDate getAcctStartDate() {
		return acctStartDate;
	}

	public void setAcctStartDate(LocalDate acctStartDate) {
		this.acctStartDate = acctStartDate;
	}

	public LocalDate getAcctCloseDate() {
		return acctCloseDate;
	}

	public void setAcctCloseDate(LocalDate acctCloseDate) {
		this.acctCloseDate = acctCloseDate;
	}



	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public String getTenure() {
		return tenure;
	}

	public void setTenure(String tenure) {
		this.tenure = tenure;
	}

	public String getCustAcctStatus() {
		return custAcctStatus;
	}

	public void setCustAcctStatus(String custAcctStatus) {
		this.custAcctStatus = custAcctStatus;
	}

	

	}
