package ibs.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import ibs.entities.CustAcctEntity;
import ibs.entities.LoginDetailsEntity;
import ibs.entities.RegistrationEntity;
import ibs.exception.BankException;
import ibs.model.LoginDetailsModel;
import ibs.model.RegistrationModel;
import ibs.repo.AdminRepo;
import ibs.repo.CustomerRepo;
import ibs.repo.LoginRepository;


@Service
public class AdminSvcImpl implements AdminService {
	
	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private LoginRepository loginRepo;
	
	@Autowired
	private CustomerRepo customerRepo;

	@Transactional
	@Override
	public LoginDetailsModel adminLogin(@Valid LoginDetailsModel loginUser) throws BankException {
		
		LoginDetailsModel loginInf = new LoginDetailsModel();
		if((loginRepo.existsByUserName(loginUser.getUserName())) && (loginUser.getRole().equalsIgnoreCase("admin"))) {
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
	
	
	private LoginDetailsEntity loginParse(LoginDetailsModel source) {
		LoginDetailsEntity loginObj = new LoginDetailsEntity();

		loginObj.setUserName(source.getUserName());
		loginObj.setPassword(source.getPassword());
		loginObj.setRole("Customer");
		
		return loginObj;
	}

	public List<RegistrationModel> getAllOpenReq() {
		List<RegistrationModel> obj1 = adminRepo.findAllByKycApprovalStatus("Open").stream().map(e -> openReqParse(e)).collect(Collectors.toList());
		return obj1;
	}
	
	public static RegistrationModel openReqParse(RegistrationEntity source) {
		RegistrationModel target = new RegistrationModel();
		
		target.setRegId(source.getRegId());
		target.setUserName(source.getUserName());
		target.setMobileNum(source.getMobileNum());
		target.setTypeOfAcctHolder(source.getTypeOfAcctHolder());
		target.setCustAcctType(source.getCustAcctType());
		
		return target;
	}

	@Modifying
	@Override
	public RegistrationModel approveAcct(long regId) {
		RegistrationEntity acctObj = getAcctInfo(regId);
		acctObj.setAdminCommentsKYC("Account approved by Admin");
		acctObj.setKycApprovalStatus("Approved");
		
        List<String> acctTypeList = Arrays.asList(acctObj.getCustAcctType().split(","));
	        
	        for (int i = 0; i < acctTypeList.size(); i++) {
	        	if(acctTypeList.get(i).equalsIgnoreCase("Savings Account")) {
	        		customerRepo.save(createSavingsAcct(acctObj));
	        	} else if (acctTypeList.get(i).equalsIgnoreCase("Fixed Deposit")) {
	        		customerRepo.save(createFixedDepositAcct(acctObj));
	        	} else if (acctTypeList.get(i).equalsIgnoreCase("Recurring Deposit")) {
	        		customerRepo.save(createRecurringDepositAcct(acctObj));
	        	}
	        }
		return null;
	}
	
	private CustAcctEntity createFixedDepositAcct(RegistrationEntity source) {
		CustAcctEntity newFDAcct = new CustAcctEntity();
		LocalDate date = LocalDate.now();
		newFDAcct.setAvailableBalance(500000);
		newFDAcct.setAcctStartDate(LocalDate.now());
		newFDAcct.setAcctCloseDate(date.plusYears(2));
		newFDAcct.setCustName(source.getFullName());
		newFDAcct.setRegId(source.getRegId());
		newFDAcct.setCustAcctNum(Long.parseLong(source.getRegId() + "102"));
		newFDAcct.setCustAcctStatus("Active");
		newFDAcct.setCustAcctType("Fixed Deposit");
		newFDAcct.setInterestRate(5.5);
		newFDAcct.setTenure("2 years");
		newFDAcct.setUserName(source.getUserName());
		
		return newFDAcct;
	}

	private CustAcctEntity createRecurringDepositAcct(RegistrationEntity source) {
		CustAcctEntity newRDAcct = new CustAcctEntity();
		LocalDate date = LocalDate.now();
		newRDAcct.setAvailableBalance(200000);
		newRDAcct.setAcctStartDate(LocalDate.now());
		newRDAcct.setAcctCloseDate(date.plusYears(2));
		newRDAcct.setCustName(source.getFullName());
		newRDAcct.setRegId(source.getRegId());
		newRDAcct.setCustAcctNum(Long.parseLong(source.getRegId() + "103"));
		newRDAcct.setCustAcctStatus("Active");
		newRDAcct.setCustAcctType("Recurring Deposit");
		newRDAcct.setInterestRate(5.1);
		newRDAcct.setTenure("2 years");
		newRDAcct.setUserName(source.getUserName());
		
		return newRDAcct;
	}

	private CustAcctEntity createSavingsAcct(RegistrationEntity source) {
		
		CustAcctEntity newSvngAcct = new CustAcctEntity();
		newSvngAcct.setAvailableBalance(434343.59);
		newSvngAcct.setAcctStartDate(LocalDate.now());
		newSvngAcct.setAcctCloseDate(LocalDate.of(2500,01,01));
		newSvngAcct.setCustName(source.getFullName());
		newSvngAcct.setRegId(source.getRegId());
		newSvngAcct.setCustAcctNum(Long.parseLong(source.getRegId() + "101"));
		newSvngAcct.setCustAcctStatus("Active");
		newSvngAcct.setCustAcctType("Savings Account");
		newSvngAcct.setInterestRate(4.0);
		newSvngAcct.setTenure("100 years");
		newSvngAcct.setUserName(source.getUserName());
		
		return newSvngAcct;

	}

	@Modifying
	@Override
	public RegistrationModel rejectAcct(long regId) {
		RegistrationEntity acctObj = getAcctInfo(regId);
		acctObj.setAdminCommentsKYC("Account rejected by Admin");
		acctObj.setKycApprovalStatus("Rejected");
		
		return rejectParse(adminRepo.save(acctObj));
	}
	
	private RegistrationModel rejectParse(RegistrationEntity reject) {
		RegistrationModel kycReject = new RegistrationModel();
		kycReject.setAdminCommentsKYC("Account rejected by Admin");
		kycReject.setKycApprovalStatus("Rejected");
		
		return kycReject;
	}

	private RegistrationEntity getAcctInfo(long regId) {
		return adminRepo.findById(regId).get();
	}

}
