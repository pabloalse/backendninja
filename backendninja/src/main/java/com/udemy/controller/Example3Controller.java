package com.udemy.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.model.Person;


@Controller
@RequestMapping("/example3")
public class Example3Controller {

	public final static Log LOGGER = LogFactory.getLog(Example3Controller.class);
	public final static String FORM_VIEW = "form";
	public final static String RESULT_VIEW = "result";
	
	@GetMapping("/showform")
	public String showForm(Model model){
		LOGGER.info("INFO TRACE");
		LOGGER.warn("WARNING TRACE");
		LOGGER.error("ERROR TRACE");
		LOGGER.debug("DEBUG TRACE");
		
		model.addAttribute("person", new Person());
		return FORM_VIEW;
	}
	
	@PostMapping("addperson")
	public ModelAndView addPerson(@Valid @ModelAttribute("person") Person personEntrada, BindingResult bindingResult){
		ModelAndView mav = new ModelAndView(); 
		if(bindingResult.hasErrors()){
			mav.setViewName(FORM_VIEW);
		}else{
			mav.setViewName(RESULT_VIEW);
			mav.addObject("person", personEntrada);
		}
		
		//LOGGER.info("METHOD: 'addperson' -- PARAMS: '" + personEntrada + "'");
		//LOGGER.info("TEMPLATE: '" + RESULT_VIEW + "' -- DATA: '" + personEntrada + "'");
		return mav;
	}
	
	/*redireccion para que no falle cuando solo llamas a /example3
	@GetMapping("/")
	public String redirect(){
		return "redirect:/example3/showform";
	}*/
	
	//redireccion 2
	@GetMapping("/")
	public RedirectView redirect(){
		return new RedirectView("/example3/showform");
		
	}
	
	
	
	
}
