package ibs.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUST_BNFCRY")
public class BenficiaryEntity{
	
	@Id
	@Column(name="BNFCRY_ID")
	@GeneratedValue
	private long bnfcryId;
	
	@Column(name="CUST_ACCT_NUM")
	private long custAcctNum;
	
	@Column(name="BNFCRY_ACCT_NUM")
	private long bnfcryAcctNum;
	
	@Column(name="BNFCRY_ACCT_NAME")
	private String bnfcryAcctName; 
	
	@Column(name="BNFCRY_BANK_NAME")
	private String bnfcryBankName;

	@Column(name="BNFCRY_ACCT_IFSC")
	private String bnfcryBankIfsc;

	@Column(name="BNFCRY_TXN_TYP")
	private String bnfcryTxnType;
	
	@Column(name="BNFCRY_MOBILE_NUM")
	private String bnfcryMblNum;

	public BenficiaryEntity() {
		super();
	}

	public BenficiaryEntity(long bnfcryId, long custAcctNum, long bnfcryAcctNum,
			String bnfcryAcctName, String bnfcryBankName, String bnfcryBankIfsc, String bnfcryTxnType,
			String bnfcryMblNum) {
		super();
		this.bnfcryId = bnfcryId;
		this.custAcctNum = custAcctNum;
		this.bnfcryAcctNum = bnfcryAcctNum;
		this.bnfcryAcctName = bnfcryAcctName;
		this.bnfcryBankName = bnfcryBankName;
		this.bnfcryBankIfsc = bnfcryBankIfsc;
		this.bnfcryTxnType = bnfcryTxnType;
		this.bnfcryMblNum = bnfcryMblNum;
	}

	public long getCustAcctNum() {
		return custAcctNum;
	}

	public void setCustAcctNum(long custAcctNum) {
		this.custAcctNum = custAcctNum;
	}

	public long getBnfcryId() {
		return bnfcryId;
	}

	public void setBnfcryId(long bnfcryId) {
		this.bnfcryId = bnfcryId;
	}

	public long getBnfcryAcctNum() {
		return bnfcryAcctNum;
	}

	public void setBnfcryAcctNum(long bnfcryAcctNum) {
		this.bnfcryAcctNum = bnfcryAcctNum;
	}

	public String getBnfcryAcctName() {
		return bnfcryAcctName;
	}

	public void setBnfcryAcctName(String bnfcryAcctName) {
		this.bnfcryAcctName = bnfcryAcctName;
	}

	public String getBnfcryBankName() {
		return bnfcryBankName;
	}

	public void setBnfcryBankName(String bnfcryBankName) {
		this.bnfcryBankName = bnfcryBankName;
	}

	public String getBnfcryBankIfsc() {
		return bnfcryBankIfsc;
	}

	public void setBnfcryBankIfsc(String bnfcryBankIfsc) {
		this.bnfcryBankIfsc = bnfcryBankIfsc;
	}

	public String getBnfcryTxnType() {
		return bnfcryTxnType;
	}

	public void setBnfcryTxnType(String bnfcryTxnType) {
		this.bnfcryTxnType = bnfcryTxnType;
	}

	public String getBnfcryMblNum() {
		return bnfcryMblNum;
	}

	public void setBnfcryMblNum(String bnfcryMblNum) {
		this.bnfcryMblNum = bnfcryMblNum;
	}

		
	
	
	
	
}
