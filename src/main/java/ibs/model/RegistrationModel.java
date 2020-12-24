package ibs.model;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class RegistrationModel{

	private long regId;
	
	private String userName; 
	
	private String fullName;
	
	private String password;
	
	private String Gender;
	@DateTimeFormat(iso=ISO.DATE)
	private Date dateOfBirth;
	
	private String emailId;
	
	private String mobileNum;
	
	private String address;
	
	private String city;
	
	private int pinCode;
	
	private String typeOfAcctHolder;
	
	private String custAcctType; 
	
	private String kycIdentityType; 
	
	private String kycUploadInd; 
	
	private String adminCommentsKYC;
	
	private String kycApprovalStatus;
	
	private String kycUploadDoc;

	
	
	public RegistrationModel() {
		super();
	}



	public RegistrationModel(long regId, String userName, String fullName, String password, String gender, Date dateOfBirth,
			String emailId, String mobileNum, String address, String city, int pinCode, String typeOfAcctHolder,
			String custAcctType, String kycIdentityType, String kycUploadInd, String adminCommentsKYC,
			String kycApprovalStatus, String kycUploadDoc) {
		super();
		this.regId = regId;
		this.userName = userName;
		this.fullName = fullName;
		this.password = password;
		Gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.emailId = emailId;
		this.mobileNum = mobileNum;
		this.address = address;
		this.city = city;
		this.pinCode = pinCode;
		this.typeOfAcctHolder = typeOfAcctHolder;
		this.custAcctType = custAcctType;
		this.kycIdentityType = kycIdentityType;
		this.kycUploadInd = kycUploadInd;
		this.adminCommentsKYC = adminCommentsKYC;
		this.kycApprovalStatus = kycApprovalStatus;
		this.kycUploadDoc = kycUploadDoc;
	}



	public long getRegId() {
		return regId;
	}



	public void setRegId(long regId) {
		this.regId = regId;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getFullName() {
		return fullName;
	}



	public void setFullName(String fullName) {
		this.fullName = fullName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getGender() {
		return Gender;
	}



	public void setGender(String gender) {
		Gender = gender;
	}



	public Date getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public String getMobileNum() {
		return mobileNum;
	}



	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public int getPinCode() {
		return pinCode;
	}



	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}



	public String getTypeOfAcctHolder() {
		return typeOfAcctHolder;
	}



	public void setTypeOfAcctHolder(String typeOfAcctHolder) {
		this.typeOfAcctHolder = typeOfAcctHolder;
	}



	public String getCustAcctType() {
		return custAcctType;
	}



	public void setCustAcctType(String custAcctType) {
		this.custAcctType = custAcctType;
	}



	public String getKycIdentityType() {
		return kycIdentityType;
	}



	public void setKycIdentityType(String kycIdentityType) {
		this.kycIdentityType = kycIdentityType;
	}



	public String getKycUploadInd() {
		return kycUploadInd;
	}



	public void setKycUploadInd(String kycUploadInd) {
		this.kycUploadInd = kycUploadInd;
	}



	public String getAdminCommentsKYC() {
		return adminCommentsKYC;
	}



	public void setAdminCommentsKYC(String adminCommentsKYC) {
		this.adminCommentsKYC = adminCommentsKYC;
	}



	public String getKycApprovalStatus() {
		return kycApprovalStatus;
	}



	public void setKycApprovalStatus(String kycApprovalStatus) {
		this.kycApprovalStatus = kycApprovalStatus;
	}



	public String getKycUploadDoc() {
		return kycUploadDoc;
	}



	public void setKycUploadDoc(String kycUploadDoc) {
		this.kycUploadDoc = kycUploadDoc;
	}

	
	
	
	}
