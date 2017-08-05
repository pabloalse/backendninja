package com.udemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.udemy.services.EjercicioServicio;


@Controller
@RequestMapping("/ejercicio")
public class Ejercicio {

	@Autowired
	@Qualifier("EjercicioServico")
	EjercicioServicio ejercicioServicio;
	
	
	@GetMapping("/getBikes")
	public String getBikes(){
		
		return "redirect:/ejercicio/getCars";
	}
	
	@GetMapping("/getCars")
	public String getCars(){
		
		ejercicioServicio.getLoggs();
		return "HelloWorld";
	}
	
	
	
	
	
}
