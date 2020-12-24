package ibs.service;

import java.util.List;

import ibs.exception.BankException;
import ibs.model.LoginDetailsModel;
import ibs.model.RegistrationModel;

public interface RegistrationService {

	RegistrationModel get(long registerationId) throws BankException;	
	List<RegistrationModel> getAll() throws BankException;
	RegistrationModel add(RegistrationModel newUser) throws BankException;
	
}
