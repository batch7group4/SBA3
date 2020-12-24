package ibs.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import ibs.exception.BankException;

@ControllerAdvice
public class ExceptionsController {

	@ExceptionHandler(BankException.class)
	public ModelAndView handleException(BankException exp) {
		return new ModelAndView("error-page", "errMsg",exp.getMessage());
	}
}
