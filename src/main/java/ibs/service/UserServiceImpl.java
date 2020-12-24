package ibs.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ibs.entities.AcctTransactionEntity;
import ibs.entities.BenficiaryEntity;
import ibs.entities.CustAcctEntity;
import ibs.exception.BankException;
import ibs.model.AccountStatementModel;
import ibs.model.AcctTransactionModel;
import ibs.model.BenficiaryModel;
import ibs.model.CustAcctModel;
import ibs.model.RegistrationModel;
import ibs.model.LoginDetailsModel;
import ibs.repo.CustomerBenRepo;
import ibs.repo.CustomerRepo;
import ibs.repo.LoginRepository;
import ibs.repo.RegistrationRepo;
import ibs.repo.TransactionsRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RegistrationRepo regRepo;
	
	@Autowired
	private LoginRepository loginRepo;
	
	@Autowired
	private CustomerBenRepo benfRepo;
	
	@Autowired
	private TransactionsRepo txnRepo;
	
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public LoginDetailsModel userLogin(LoginDetailsModel loginUser) throws BankException {
		
		LoginDetailsModel loginInf = new LoginDetailsModel();
		if((loginRepo.existsByUserName(loginUser.getUserName())) && (loginUser.getRole().equalsIgnoreCase("customer"))) {
			loginInf = getLoginData(loginUser.getUserName());
			if((loginInf.getUserName().equalsIgnoreCase(loginUser.getUserName())) && (loginInf.getPassword().equalsIgnoreCase(loginUser.getPassword()))) {
				System.out.println("user name password match");
			} else {
				throw new BankException("Invalid Credentials !! ");
			}
		} else {
			throw new BankException("User doesn't exist");
		}
		return loginUser;
	}
	
	
	private LoginDetailsModel getLoginData(String userName) {
		LoginDetailsModel loginObj = new LoginDetailsModel();

		loginObj.setUserName(loginRepo.findByUserName(userName).getUserName());
		loginObj.setPassword(loginRepo.findByUserName(userName).getPassword());
		loginObj.setRole(loginRepo.findByUserName(userName).getRole());
		return loginObj;
	}

	@Transactional
	@Override
	public BenficiaryModel addBeneficiary(BenficiaryModel custBnfcryAcct, String userName) throws BankException {
		List<CustAcctEntity> custAcct = customerRepo.findByUserName(userName);
		
		long custAcctNum = 0;
		for (int i = 0;i<custAcct.size();i++) {
			if(custAcct.get(i).getCustAcctType().equalsIgnoreCase("Savings Account")) {
				custAcctNum = custAcct.get(i).getCustAcctNum();
		}
		}
		return bnfParse(benfRepo.save(bnfParse(custBnfcryAcct,custAcctNum)));
		
	}
	
	private BenficiaryModel bnfParse(BenficiaryEntity source) {
		BenficiaryModel target = new BenficiaryModel();
		target.setBnfcryAcctNum(source.getBnfcryAcctNum());
		target.setCustAcctNum(source.getCustAcctNum());
		target.setBnfcryAcctName(source.getBnfcryAcctName());
		target.setBnfcryBankName(source.getBnfcryBankName());
		target.setBnfcryBankIfsc(source.getBnfcryBankIfsc());
		target.setBnfcryMblNum(source.getBnfcryMblNum());
		target.setBnfcryTxnType("IMPS");
		
		return target;
	}
	
	private BenficiaryEntity bnfParse(BenficiaryModel source , long custAcctNum) {
		BenficiaryEntity target = new BenficiaryEntity();
		target.setBnfcryAcctNum(source.getBnfcryAcctNum());
		target.setCustAcctNum(custAcctNum);
		target.setBnfcryAcctName(source.getBnfcryAcctName());
		target.setBnfcryBankName(source.getBnfcryBankName());
		target.setBnfcryBankIfsc(source.getBnfcryBankIfsc());
		target.setBnfcryMblNum(source.getBnfcryMblNum());
		target.setBnfcryTxnType("IMPS");
		
		return target;
	}

	
	@Override
	public List<CustAcctModel> getCustomerData(String userName) {
		List<CustAcctEntity> c1 = customerRepo.findByUserName(userName);
		
		List<CustAcctModel> custObj1 = c1.stream().map(e -> custDataParse(e)).collect(Collectors.toList());
		
		return custObj1;
	}
	
	private CustAcctModel custDataParse(CustAcctEntity source) {
		CustAcctModel target = new CustAcctModel();
		
		target.setUserName(source.getUserName());
		target.setCustAcctNum(source.getCustAcctNum());
		target.setAvailableBalance(source.getAvailableBalance());
		target.setAcctStartDate(source.getAcctStartDate());
		target.setAcctCloseDate(source.getAcctCloseDate());
		target.setCustName(source.getCustName());
		target.setTenure(source.getTenure());
		target.setCustAcctStatus(source.getCustAcctStatus());
		target.setCustAcctType(source.getCustAcctType());
		target.setInterestRate(source.getInterestRate());
		target.setRegId(source.getRegId()); 
		
		return target;
	}

	
	public List<CustAcctModel> getSavingsAcctInfo(List<CustAcctModel> custAcct1) {
		List<CustAcctModel> custAcct = custAcct1;
		for(int i =0;i<custAcct.size();i++) {
			if((custAcct.get(i).getCustAcctType()).equalsIgnoreCase("Recurring Deposit")) {
				custAcct.remove(i);
			} 
		}
		for(int i =0;i<custAcct.size();i++) {
			if((custAcct.get(i).getCustAcctType()).equalsIgnoreCase("Fixed Deposit")) {
				custAcct.remove(i);
			}
		}
		
		return custAcct;
	}
	
	public CustAcctEntity getSavingsAcctData(List<CustAcctEntity> custAcct1) {
		List<CustAcctEntity> custAcct = custAcct1;
		for(int i =0;i<custAcct.size();i++) {
			if((custAcct.get(i).getCustAcctType()).equalsIgnoreCase("Recurring Deposit")) {
				custAcct.remove(i);
			} 
		}
		for(int i =0;i<custAcct.size();i++) {
			if((custAcct.get(i).getCustAcctType()).equalsIgnoreCase("Fixed Deposit")) {
				custAcct.remove(i);
			}
		}
		
		System.out.println("custAcct.size() "+custAcct.size());
		for(int i =0;i<custAcct.size();i++) {
			System.out.println("***"+custAcct.get(i).getCustAcctType());
		}
		CustAcctEntity custAcct2 = custAcct.get(0);
		
		return custAcct2;
	}
	

	public List<BenficiaryModel> getListOfBnfcry(@Valid String userName) {
		List<CustAcctEntity> custAcct = customerRepo.findByUserName(userName);
		
		long custAcctNum = 0;
		for (int i = 0;i<custAcct.size();i++) {
			if(custAcct.get(i).getCustAcctType().equalsIgnoreCase("Savings Account")) {
				custAcctNum = custAcct.get(i).getCustAcctNum();
		}
		}
		List<BenficiaryEntity> b1 = benfRepo.findByCustAcctNum(custAcctNum);
		return b1.stream().map(e -> bnfcryParse(e)).collect(Collectors.toList());
	}


	private BenficiaryModel bnfcryParse(BenficiaryEntity source) {
		BenficiaryModel target = new BenficiaryModel();
		
		target.setBnfcryId(source.getBnfcryId());
		target.setBnfcryAcctNum(source.getBnfcryAcctNum());
		target.setBnfcryAcctName(source.getBnfcryAcctName());
		target.setBnfcryBankName(source.getBnfcryBankName());
		target.setBnfcryBankIfsc(source.getBnfcryBankIfsc());
		target.setBnfcryMblNum(source.getBnfcryMblNum());
		target.setCustAcctNum(source.getCustAcctNum());
		return target;
	}


	public AcctTransactionModel transferFunds(@Valid AcctTransactionModel transferObj) throws BankException{
		System.out.println("transferObj.getFromAcct()"+transferObj.getFromAcct());
		
			double existingBal = getSavingsAcctData(customerRepo.findByCustAcctNum(transferObj.getFromAcct())).getAvailableBalance();
			
			if (transferObj.getAmount() > existingBal ) {
				throw new BankException("Transaction Amount cannot be greater that your current account balance !! ");
			}
			
			AcctTransactionModel txnObj = txnParse(txnRepo.save(txnParse(transferObj)));
			updateCustBal(txnObj);
		return txnObj;
	}

	@Modifying
	@Override
	public CustAcctModel updateCustBal(AcctTransactionModel txnObj) {
		List<CustAcctEntity> custAcct1 = customerRepo.findByCustAcctNum(txnObj.getFromAcct());
		CustAcctEntity custAcct = getSavingsAcctData(custAcct1);
		double prevBal = custAcct.getAvailableBalance();
		double newBal = prevBal - txnObj.getAmount();
		System.out.println("in update cust bal "+newBal+" "+prevBal);
		custAcct.setAvailableBalance(newBal);
		
		return updateParse(customerRepo.save(custAcct));
	}

	private CustAcctModel updateParse(CustAcctEntity custAcct) {
		CustAcctModel updCust = new CustAcctModel();
		updCust.setAvailableBalance(custAcct.getAvailableBalance());
		//System.out.println("in updateParse "+updCust.getAvailableBalance());

		return updCust;
	}
	
	private AcctTransactionEntity txnParse(@Valid AcctTransactionModel source) {
		AcctTransactionEntity target = new AcctTransactionEntity();
		
		target.setFromAcct(source.getFromAcct());
		target.setToAcct(source.getToAcct());
		target.setAmount(source.getAmount());
		target.setRemarks(source.getRemarks());
		target.setTxnDate(new Date());
		target.setCustAcctNum(source.getFromAcct());
		return target;
	}
	
	private AcctTransactionModel txnParse(@Valid AcctTransactionEntity source) {
		AcctTransactionModel target = new AcctTransactionModel();
		
		target.setFromAcct(source.getFromAcct());
		target.setToAcct(source.getToAcct());
		target.setAmount(source.getAmount());
		target.setRemarks(source.getRemarks());
		target.setCustAcctNum(source.getFromAcct());
		return target;
	}

	@Override
	public List<AcctTransactionModel> getAccountStatement(String userName) {
		long custNum = getSavingsAcctData(customerRepo.findByUserName(userName)).getCustAcctNum();
		
		//List<AcctTransactionModel> custTxnObj = custTxnRepo.getTxnData(custNum);
		
		return txnRepo.findByCustAcctNum(custNum).stream().map(e -> custTxnParse(e)).collect(Collectors.toList());
	}

	private AcctTransactionModel custTxnParse(AcctTransactionEntity source) {
		AcctTransactionModel target = new AcctTransactionModel();
		
		target.setTxnId(source.getTxnId());
		target.setFromAcct(source.getFromAcct());
		target.setToAcct(source.getToAcct());
		target.setAmount(source.getAmount());
		target.setRemarks(source.getRemarks());
		target.setTxnDate(source.getTxnDate());
		
		return target;
	}

	public List<AcctTransactionModel> getFilteredStatement(AccountStatementModel filterStmtData) throws ParseException {
		
		List<AcctTransactionModel> txnObj = txnRepo.findByCustAcctNum(filterStmtData.getCustAcctNum()).stream().map(e -> custTxnParse(e)).collect(Collectors.toList());
			
		return txnObj;
	}


	@Override
	public RegistrationModel add(RegistrationModel registeration) throws BankException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public RegistrationModel get(long registerationId) throws BankException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<RegistrationModel> getAll() throws BankException {
		// TODO Auto-generated method stub
		return null;
	}

}
