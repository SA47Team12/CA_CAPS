package sa47.team12.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sa47.team12.services.CourseLecturerService;
import sa47.team12.services.StudentService;

@RequestMapping(value="/courselecturer")
@Controller
public class CourseLecturerController {
	@Autowired
	private CourseLecturerService csService;
	/**
	* DEPARTMENT CRUD OPERATIONS
	* 
	* @return
	*/
     
	@RequestMapping(value = "/findcoursetaught", method = RequestMethod.GET)
	public ModelAndView findCourseTaught() {
	ModelAndView mav = new ModelAndView("CourseLecturerTaughtlist");
	mav.addObject("courselecturers", csService.findCourseTaughtbyLID(2005));
	return mav;
	}
	
	@RequestMapping(value = "/findcourseenrollment", method = RequestMethod.GET)
	public ModelAndView findCourseEnrollment() {
	ModelAndView mav = new ModelAndView("CourseLecturerEnrollmentlist");
	mav.addObject("courselecturers", csService.findCourseEnrollmentbyLID(2005));
	return mav;
	}
	
	
	
}
