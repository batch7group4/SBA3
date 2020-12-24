package ibs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ibs.exception.BankException;
import ibs.model.RegistrationModel;
import ibs.service.AdminSvcImpl;

@Controller
@RequestMapping
public class AdminController  {

	@Autowired
	private AdminSvcImpl adminSerImpl;
	
	@GetMapping(value = "/openRequests")
	public ModelAndView newOpenAccounts() throws BankException {
		
		ModelAndView mv = null;
		List<RegistrationModel> allOpenReq = adminSerImpl.getAllOpenReq();
		mv = new ModelAndView("redirect:/adminAllOpenRequests.jsp");
		mv.addObject("allOpenRequests", allOpenReq);
		mv = new ModelAndView("/OpenReq.jsp","allOpenRequests",allOpenReq);
		return mv;
	}

	@GetMapping("/approve")
	public ModelAndView approveAction(@RequestParam("regId") long regId) throws BankException {
		ModelAndView mv = null;
		mv = new ModelAndView("/OpenReq.jsp","allOpenRequests",adminSerImpl.approveAcct(regId));
		String rejectAcct = "Reg Id " +regId + " is approved !!";
		mv.addObject("approvalStatus", rejectAcct);
		mv.addObject("allOpenRequests", adminSerImpl.getAllOpenReq());
		return mv;
	}
	
	@GetMapping("/reject")
	public ModelAndView rejectAction(@RequestParam("regId") long regId) throws BankException {
		ModelAndView mv = null;
		mv = new ModelAndView("OpenReq.jsp","allOpenRequests",adminSerImpl.rejectAcct(regId));
		String rejectAcct = "Reg Id " +regId + " is rejected !!";
		mv.addObject("approvalStatus", rejectAcct);
		mv.addObject("allOpenRequests", adminSerImpl.getAllOpenReq());
		return mv;
	}
	
//	@PostMapping("/getCustomerStatement")
//	public ModelAndView registerAction(@ModelAttribute("register") @Valid RegistrationModel newUser, BindingResult result) throws BankException {
//		
//		return mv;
//	}
//	
//	@PostMapping("/checkTransactions")
//	public ModelAndView registerAction(@ModelAttribute("register") @Valid RegistrationModel newUser, BindingResult result) throws BankException {
//		
//		return mv;
//	}
}
