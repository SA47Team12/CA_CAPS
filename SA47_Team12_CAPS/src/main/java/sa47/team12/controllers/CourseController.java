package sa47.team12.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sa47.team12.services.CourseService;


@RequestMapping(value="/course")
@Controller
public class CourseController {
@Autowired
private CourseService cService;
/**
* DEPARTMENT CRUD OPERATIONS
* 
* @return
*/

@RequestMapping(value = "/list", method = RequestMethod.GET)
public ModelAndView ListStudentPage() {
ModelAndView mav = new ModelAndView("Courselist");
mav.addObject("course", cService.findAllCourse());
return mav;
}
}