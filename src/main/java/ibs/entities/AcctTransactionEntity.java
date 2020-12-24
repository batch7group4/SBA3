package ibs.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ACCT_TXNS")
public class AcctTransactionEntity{
	
	@Id
	@Column(name="TXN_ID")
	@GeneratedValue
	private long txnId;
	
	@Column(name="FROM_ACCT_NUM")
	private long fromAcct; 
	
	@Column(name="TO_ACCT_NUM")
	private long toAcct;
	
	@Column(name="TXN_AMT")
	private double amount;
	
	@Column(name="TXN_COMMENTS")
	private String remarks;

	@Column(name="TXN_DATE")
	private Date txnDate;
	
	@Column(name="CUST_ACCT_NUM")
	private long custAcctNum;
	
		public AcctTransactionEntity() {
			super();
		}

		public AcctTransactionEntity(long txnId, long fromAcct, long toAcct, double amount, String remarks, Date txnDate, long custAcctNum) {
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

		public long getCustAcctNum() {
			return custAcctNum;
		}

		public void setCustAcctNum(long custAcctNum) {
			this.custAcctNum = custAcctNum;
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
