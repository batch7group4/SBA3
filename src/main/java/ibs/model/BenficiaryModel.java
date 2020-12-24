package ibs.model;

public class BenficiaryModel{
	
	private long bnfcryId;
	
	private long custAcctNum;
	
	private long bnfcryAcctNum;
	
	private String bnfcryAcctName; 
	
	private String bnfcryBankName;

	private String bnfcryBankIfsc;

	private String bnfcryTxnType;
	
	private String bnfcryMblNum;

	public BenficiaryModel() {
		super();
	}

	public BenficiaryModel(long bnfcryId, long custAcctNum, long bnfcryAcctNum,
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
