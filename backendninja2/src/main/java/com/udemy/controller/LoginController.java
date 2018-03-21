package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.udemy.constant.ViewConstant;

@Controller
public class LoginController {

	private static final Log LOG = LogFactory.getLog(LoginController.class);
	
	@GetMapping("/login")
	public String showLoginForm(Model model,
		@RequestParam(name="error", required=false)String error,
		@RequestParam(name="logout", required=false)String logout){
		LOG.info("METHOD: showLoginForm() -- PARAMS: error = " + error + ", logout: " + logout);
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		LOG.info("Returning to login View");
		return ViewConstant.LOGIN;
	}
		
	@GetMapping({"/loginsuccess", "/"})
	public String loginCheck(){
		LOG.info("Returning to contacts View");
		LOG.info("Redirect to login error");
		return "redirect:/contacts/showcontacts";	
	}
	
	
}	
