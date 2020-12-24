package ibs.util;


import ibs.entities.LoginDetailsEntity;
import ibs.entities.RegistrationEntity;
import ibs.model.LoginDetailsModel;
import ibs.model.RegistrationModel;

public class EMParser {
	
	public static LoginDetailsEntity loginParse(LoginDetailsModel source) {
		LoginDetailsEntity loginObj = new LoginDetailsEntity();

		loginObj.setUserName(source.getUserName());
		loginObj.setPassword(source.getPassword());
		loginObj.setRole("Customer");
		
		return loginObj;
	}
	
	public static RegistrationModel parse(RegistrationEntity source) {
		RegistrationModel target = new RegistrationModel();
		target.setUserName(source.getUserName());
		target.setFullName(source.getFullName());
		target.setPassword(source.getPassword());
		target.setGender(source.getGender());
		target.setDateOfBirth(source.getDateOfBirth());
		target.setEmailId(source.getEmailId());
		target.setMobileNum(source.getMobileNum());
		target.setAddress(source.getAddress());
		target.setCity(source.getCity());
		target.setPinCode(source.getPinCode());
		target.setTypeOfAcctHolder(source.getTypeOfAcctHolder());
		target.setCustAcctType(source.getCustAcctType());
		target.setKycIdentityType(source.getKycIdentityType());
		target.setKycUploadInd(source.getKycUploadInd());
		
		return target;
	}
	
	public static RegistrationEntity parse(RegistrationModel source) {
		RegistrationEntity target = new RegistrationEntity();
		target.setUserName(source.getUserName());
		target.setFullName(source.getFullName());
		target.setPassword(source.getPassword());
		target.setGender(source.getGender());
		target.setDateOfBirth(source.getDateOfBirth());;
		target.setEmailId(source.getEmailId());
		target.setMobileNum(source.getMobileNum());
		target.setAddress(source.getAddress());
		target.setCity(source.getCity());
		target.setPinCode(source.getPinCode());
		target.setTypeOfAcctHolder(source.getTypeOfAcctHolder());
		target.setCustAcctType(source.getCustAcctType());
		target.setKycApprovalStatus("Open");
		target.setKycIdentityType(source.getKycIdentityType());
		target.setKycUploadDoc(source.getKycUploadDoc());
		target.setAdminCommentsKYC("User registered");
		if(source.getKycUploadDoc() != null) {
			target.setKycUploadInd("Y");		
		} else {
			target.setKycUploadInd("N");
		}
		
		return target;
	}
	
}


	/*
	 * public static ContactModel_Old parse(ContactEntity_Old source) {
	 * ContactModel_Old target = new ContactModel_Old();
	 * target.setContactId(source.getContactId());
	 * target.setFirstName(source.getFirstName());
	 * target.setLastNAme(source.getLastNAme());
	 * target.setContactDetails(parse(source.getContactDetails()));
	 * target.setAdbGroup(parse(source.getAdbGroup())); return target; }
	 * 
	 * public static ContactEntity_Old parse(ContactModel_Old source) {
	 * ContactEntity_Old target = new ContactEntity_Old();
	 * target.setContactId(source.getContactId());
	 * target.setFirstName(source.getFirstName());
	 * target.setLastNAme(source.getLastNAme());
	 * target.setContactDetails(parse(source.getContactDetails()));
	 * target.setAdbGroup(parse(source.getAdbGroup())); return target; }
	 * 
	 * public static AddressGroup_Old parse(AddressGroupModel_Old source) {
	 * AddressGroup_Old target = new AddressGroup_Old();
	 * target.setGroupId(source.getGroupId());
	 * target.setGroupTitle(source.getGroupTitle()); return target; }
	 * 
	 * public static AddressGroupModel_Old parse(AddressGroup_Old source) {
	 * AddressGroupModel_Old target = new AddressGroupModel_Old();
	 * target.setGroupId(source.getGroupId());
	 * target.setGroupTitle(source.getGroupTitle()); return target; }
	 */
