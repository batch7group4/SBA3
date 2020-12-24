package ibs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibs.exception.BankException;
import ibs.model.LoginDetailsModel;
import ibs.model.RegistrationModel;
import ibs.repo.AdminRepo;
import ibs.repo.LoginRepository;
import ibs.repo.RegistrationRepo;
import ibs.util.EMParser;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationRepo regRepo;
	
	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private LoginRepository loginRepo;

	//public  add(RegistrationModel registeration) throws BankException {
		@Transactional
		@Override
		public RegistrationModel add(RegistrationModel newUser) throws BankException {
			
			LoginDetailsModel loginObj = new LoginDetailsModel();

			loginObj.setUserName(newUser.getUserName());
			loginObj.setPassword(newUser.getPassword());
			loginObj.setRole("Customer");
			
			if(adminRepo.existsByUserName(newUser.getUserName())) {
					throw new BankException("UserName "+newUser.getUserName()+" already exists");
			} else {
				if(adminRepo.existsByMobileNum(newUser.getMobileNum())) {
					throw new BankException("User already exists with same mobile #"+newUser.getMobileNum());
				}
			} 
			
			if (newUser!= null) {
				newUser =EMParser.parse(adminRepo.save(EMParser.parse(newUser)));
				loginRepo.save(EMParser.loginParse(loginObj));
				}
			return newUser;
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
