package ibs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class HomeController {
	
	@GetMapping({ "", "/", "/home" })
	
	public ModelAndView homeAction() {
		System.out.println("hello");
		ModelAndView mv = null;
		mv = new ModelAndView("index.jsp");
		return mv;
	}
		



}
