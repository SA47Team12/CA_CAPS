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

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView ListStudentPage() {
	ModelAndView mav = new ModelAndView("CourseLecturerlist");
	mav.addObject("courselecturers", csService.findAllCourseLecturer());
	return mav;
	}
}
