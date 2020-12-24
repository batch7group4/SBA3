package ibs.service;

import javax.validation.Valid;

import ibs.exception.BankException;
import ibs.model.LoginDetailsModel;
import ibs.model.RegistrationModel;

public interface AdminService {

	LoginDetailsModel adminLogin(@Valid LoginDetailsModel loginUser) throws BankException;

	RegistrationModel approveAcct(long regId);

	RegistrationModel rejectAcct(long regId);
	
	/*
	 * KycDetailsDto register(KycDetailsDto regAcct) throws IBSException; //
	 * Approve/reject registration & send mail accordingly CustomerAccountDto
	 * createCustomerId(CustomerAccountDto custAcct) throws IBSException;
	 * ServiceProviderDto createServiceProviderId(ServiceProviderDto svcAcct) throws
	 * IBSException;
	 * 
	 * @Override
	 * 
	 * 
	 * CustomerTransactionsDto chkCustStatement(CustomerTransactionsDto custAcct)
	 * throws IBSException; CustomerTransactionsDto
	 * fundDepositEntry(CustomerTransactionsDto custAcct) throws IBSException;
	 * 
	 * LoginDataDto adminLogin(LoginDataDto loginUser) throws IBSException;
	 * 
	 * KycDetailsDto rejectAcct(long regId) throws IBSException; KycDetailsDto
	 * approveAcct(long regId) throws IBSException;
	 */
	
	
}
