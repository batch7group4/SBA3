package ibs.service;

import java.util.List;

import ibs.exception.BankException;
import ibs.model.AcctTransactionModel;
import ibs.model.BenficiaryModel;
import ibs.model.CustAcctModel;
import ibs.model.LoginDetailsModel;
import ibs.model.RegistrationModel;

public interface UserService {

	RegistrationModel add(RegistrationModel registeration) throws BankException;
	RegistrationModel get(long registerationId) throws BankException;	
	List<RegistrationModel> getAll() throws BankException;
	LoginDetailsModel userLogin(LoginDetailsModel loginUser) throws BankException;
	BenficiaryModel addBeneficiary(BenficiaryModel custBnfcryAcct, String userName) throws BankException;
	List<CustAcctModel> getCustomerData(String userName);
	CustAcctModel updateCustBal(AcctTransactionModel txnObj);
	List<AcctTransactionModel> getAccountStatement(String userName);
	
	
}
