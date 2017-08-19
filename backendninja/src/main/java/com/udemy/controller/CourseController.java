package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.entity.Course;
import com.udemy.services.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

	private static final String COURSES_VIEW = "courses";
	private static final Log LOG = LogFactory.getLog(CourseController.class);
	
	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;
	
	@GetMapping("/listCourses")
	public ModelAndView listAllCourses() {
		LOG.info("Call: " + "listAllCourses()");
		ModelAndView mov = new ModelAndView(COURSES_VIEW);
		mov.addObject("course", new Course());
		mov.addObject("courses", courseService.listAllCourses());
		return mov;
	}

	@PostMapping("/addcourse")
	public String addCourse(@ModelAttribute("course")Course course){
		LOG.info("Call: " + "addCourse()" + "-- Param: " + course.toString());
		courseService.addCourse(course);
		return "redirect:/courses/listCourses";
	}
	
}