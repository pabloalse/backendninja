package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("example4")
public class Example4Controller {

	public final static String ERROR_404 = "404";
	public final static String ERROR_500 = "500";
	
	@GetMapping("/error404")
	public ModelAndView errorMessage (){
		return new ModelAndView(ERROR_404);
		
	}
	
	@GetMapping("/error500")
	public ModelAndView errorMessage2 (){
		return new ModelAndView(ERROR_500);
		
	}
	
	
	
}
