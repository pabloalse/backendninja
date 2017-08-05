package com.udemy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.component.ExampleComponent;
import com.udemy.model.Person;
import com.udemy.services.ExampleService;

@Controller
@RequestMapping("/say")
public class HelloWorldController {

	public static String HELLO_WORLD_VIEW = "HelloWorld";

	@Autowired //indica a Spring que vamos a inyectar un componente que se encuentra en su memoria
	@Qualifier("exampleComponent") // nombre del bean que queremos obtener
	private ExampleComponent exampleComponent;
	
	
	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;


	
	// Primera forma de llamar a una vista
	@RequestMapping(value = "sayString", method = RequestMethod.GET)
	public String helloWorld() {
		return "HelloWorld";

	}

	// Segunda forma de llamar a una vista. Util para pocos datos o redirecciones.
	@RequestMapping(value = "sayMAV", method = RequestMethod.GET)
	public ModelAndView MAV() {
		return new ModelAndView("HelloWorld");

	}

	/*
	 * Tercera forma de llamar a una vista. Util para insetar muchos datos
	 * 
	 * @GetMapping("/helloworldGetMapping") 
	 * public String helloWorldGetMapping(Model model){ 
	 * 		model.addAttribute("person", new Person("pablo",40)); 
	 * 		return HELLO_WORLD_VIEW;
	 * }
	 * 
	 * //Segunda forma de llamar a una vista. Util para pocos datos o redirecciones.
	 * 
	 * @GetMapping("/helloworldGetMappingMAV2") 
	 * public ModelAndView MAV2(){
	 * 		ModelAndView mov = new ModelAndView("HelloWorld");
	 * 		mov.addObject("person", new Person("Juan",42));
	 * 		return mov;
	 * }
	 */

	// Cuarte forma de llamar a una vista. Para enviar una lista
	@GetMapping("/helloworldGetMapping")
	public String helloWorldGetMapping(Model model) {
		exampleComponent.sayHello();
		model.addAttribute("people", exampleService.getListPeople());
		return HELLO_WORLD_VIEW;

	}

	// Segunda forma de llamar a una vista. Para enviar una lista
	@GetMapping("/helloworldGetMappingMAV2")
	public ModelAndView MAV2() {
		ModelAndView mov = new ModelAndView("HelloWorld");
		mov.addObject("people", exampleService.getListPeople());
		return mov;

	}

	private List<Person> getPeople() {
		List<Person> people = new ArrayList<>();
		people.add(new Person("pablo", 40));
		people.add(new Person("Juan", 42));
		people.add(new Person("Miki", 34));
		people.add(new Person("Alvaro", 44));
		return people;
	}

}
