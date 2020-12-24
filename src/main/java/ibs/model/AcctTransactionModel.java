package ibs.model;
import java.util.Date;

public class AcctTransactionModel{
	
	private long txnId;
	private long fromAcct; 
	private long toAcct;
	private double amount;
	private String remarks;
	private Date txnDate;
	private long custAcctNum;
	
	public AcctTransactionModel() {
		super();
	}

	public AcctTransactionModel(long txnId, long fromAcct, long toAcct, double amount, String remarks, Date txnDate , long custAcctNum) {
		super();
		this.txnId = txnId;
		this.fromAcct = fromAcct;
		this.toAcct = toAcct;
		this.amount = amount;
		this.remarks = remarks;
		this.txnDate = txnDate;
	}

	public long getTxnId() {
		return txnId;
	}

	public void setTxnId(long txnId) {
		this.txnId = txnId;
	}

	public long getFromAcct() {
		return fromAcct;
	}

	public void setFromAcct(long fromAcct) {
		this.fromAcct = fromAcct;
	}

	public long getToAcct() {
		return toAcct;
	}

	public void setToAcct(long toAcct) {
		this.toAcct = toAcct;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public long getCustAcctNum() {
		return custAcctNum;
	}

	public void setCustAcctNum(long custAcctNum) {
		this.custAcctNum = custAcctNum;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(Date txnDate) {
		this.txnDate = txnDate;
	}

		
}
