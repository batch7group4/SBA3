package ibs.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ibs.exception.BankException;
import ibs.model.AccountStatementModel;
import ibs.model.AcctTransactionModel;
import ibs.model.BenficiaryModel;
import ibs.model.CustAcctModel;
import ibs.model.LoginDetailsModel;
import ibs.service.AdminSvcImpl;
import ibs.service.UserServiceImpl;


@Controller
public class UserController {

	@Autowired
	private UserServiceImpl userImpl;
	
	@Autowired
	private AdminSvcImpl adminSerImpl;
	
	@PostMapping("/login")
	public ModelAndView loginAction(@ModelAttribute("login") @Valid LoginDetailsModel loginUser, BindingResult result) throws BankException {

		ModelAndView mv = null;
		List<CustAcctModel> custData = null;
		System.out.println(loginUser.getUserName()+" , "+loginUser.getPassword()+" , "+loginUser.getRole());
		if (result.hasErrors()) {
			mv = new ModelAndView("login_form_page.jsp", "loginUser", loginUser);
		} else {
			if((loginUser.getRole()).equalsIgnoreCase("admin")) {
				System.out.println("In admin");
				adminSerImpl.adminLogin(loginUser);
				mv = new ModelAndView("redirect:/AdminHome.jsp");
				
			} else {
				System.out.println("In customer");
				userImpl.userLogin(loginUser);
				custData = userImpl.getCustomerData(loginUser.getUserName());
				mv = new ModelAndView("account_summary_page.jsp", "savingsData", custData);
			}
			mv.addObject("loginUser", loginUser);
			mv.addObject("userName", loginUser.getUserName());
		}
		return mv;
	}
	
	@GetMapping("/acctSummary")
	public ModelAndView acctSummaryAction(@RequestParam("userName") @Valid String userName) throws BankException {
		ModelAndView mv = null;
		List<CustAcctModel> custAcct = userImpl.getCustomerData(userName);
		mv = new ModelAndView("account_summary_page.jsp", "savingsData", custAcct);
		mv.addObject("userName", userName);
		return mv;
	}
	

	@GetMapping("/addBnfPage")
	public ModelAndView addBnfPage(@RequestParam("userName") String userName) throws BankException {
		ModelAndView mv = null;
		mv = new ModelAndView("add_beneficiary_page.jsp", "userName", userName);
		mv.addObject("userName", userName);
		return mv;
	}
	
	@GetMapping("/transfer")
	public ModelAndView trasferForm(@RequestParam("userName") String userName) throws BankException {
		ModelAndView mv = null;
		mv = new ModelAndView("account_transaction_page.jsp","bncfryList",userImpl.getListOfBnfcry(userName));
		mv.addObject("fromCustAcctNum", userImpl.getListOfBnfcry(userName).get(0).getCustAcctNum());
		mv.addObject("userName", userName);
		return mv;
	}

	
	  @PostMapping("/transferFunds") public ModelAndView transferFunds(@ModelAttribute("transfer") @Valid AcctTransactionModel transferObj, @RequestParam("userName") String userName) throws BankException
	  { 
		  ModelAndView mv = null; 
		  userImpl.transferFunds(transferObj); 
		  mv = new ModelAndView("/viewbenf.jsp","bncfryList",userImpl.getListOfBnfcry(userName)); 
		  mv.addObject("userName", userName); 
		  return mv; 
		}
	 
	  
	@GetMapping("/viewBnfcry")
	public ModelAndView fundsTransferHome(@ModelAttribute("viewBnfcry") @RequestParam("userName") @Valid String userName) throws BankException {
		System.out.println("In controller");
		ModelAndView mv = null;
		mv = new ModelAndView("/viewbenf.jsp","bncfryList",userImpl.getListOfBnfcry(userName));

		mv.addObject("userName", userName);
		return mv;
	}
	
	@GetMapping("/transferFunds1")
	public ModelAndView transferFunds(@RequestParam("userName") String userName) throws BankException {
		ModelAndView mv = null;
			mv = new ModelAndView("/fundsTransfer.jsp","bncfryList",userImpl.getListOfBnfcry(userName));
			mv.addObject("fromCustAcctNum",userImpl.getListOfBnfcry(userName).get(0).getCustAcctNum());
			mv.addObject("userName", userName);
		return mv;
	}
	
	@GetMapping("/acctStmt")
	public ModelAndView acctStmt(@RequestParam("userName") String userName) throws BankException {
		ModelAndView mv = null;
			mv = new ModelAndView("/account_statement_page.jsp","acctStmt",userImpl.getAccountStatement(userName));
			mv.addObject("custAcctNum",userImpl.getCustomerData(userName).get(0).getCustAcctNum());
			mv.addObject("userName", userName);
		return mv;
	}
	
	@GetMapping("/filterStmt")
	public ModelAndView filterAcctStmt(@ModelAttribute("filterStmt") @Valid AccountStatementModel filterStmtData) throws BankException, ParseException {
		ModelAndView mv = null;
		System.out.println(filterStmtData.getCustAcctNum());
		System.out.println(filterStmtData.getStartDate());
		System.out.println(filterStmtData.getEndDate());
		System.out.println(filterStmtData.getUserName());
		
			mv = new ModelAndView("/accountStatement.jsp","acctStmt",userImpl.getFilteredStatement(filterStmtData));
//			mv.addObject("custAcctNum",userImpl.getCustomerData(userName).get(0).getCustAcctNum());
			mv.addObject("userName", filterStmtData.getUserName());
			mv.addObject("custAcctNum", filterStmtData.getCustAcctNum());
			mv.addObject("userName", filterStmtData.getUserName());
		return mv;
	}

	
	@PostMapping("/addBnfcry")
	public ModelAndView addBnfcry(@ModelAttribute("addBnf") @Valid BenficiaryModel addBnfcry, @RequestParam("userName")  String userName, 
														BindingResult result) throws BankException {
		ModelAndView mv = null;
		userImpl.addBeneficiary(addBnfcry,userName);
		List<BenficiaryModel> benList = userImpl.getListOfBnfcry(userName);
		mv = new ModelAndView("/viewbenf.jsp","bncfryList",benList);
		mv.addObject("userName", userName);
		return mv;
	}
	
	public static String from(BindingResult result) {
		StringBuilder sb = new StringBuilder();
		
		for(ObjectError err : result.getAllErrors()) {
			sb.append(err.getDefaultMessage()+",");
		}
		
		return sb.toString();
	} 
}
