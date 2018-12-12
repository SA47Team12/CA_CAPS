package sa47.team12.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sa47.team12.exception.StudentNotFound;
import sa47.team12.model.Student;
import sa47.team12.services.StudentService;
import sa47.team12.validator.StudentValidator;



@RequestMapping(value="/admin")
@Controller
public class AdminController {
@Autowired
private StudentService sService;
@Autowired
private StudentValidator sValidator;
/**
* DEPARTMENT CRUD OPERATIONS
* 
* @return
*/

@RequestMapping(value = "/list", method = RequestMethod.GET)
public ModelAndView ListStudentPage() {
ModelAndView mav = new ModelAndView("Studentlist");
mav.addObject("students", sService.findAllStudent());
return mav;
}

@RequestMapping(value = "/create", method = RequestMethod.POST)
public ModelAndView createNewStudent(@ModelAttribute @Valid Student student, BindingResult result,
		final RedirectAttributes redirectAttributes){
		/*if (result.hasErrors())
			return new ModelAndView("StudentFormNew");*/
		ModelAndView mav = new ModelAndView();

		//sService.createStudent(student);
		//String message = "New student " + student.getNric() + " was successfully created.";
		mav.setViewName("redirect:/admin/list");
		return mav;
//	sService.updateStudent(student);
//	ModelAndView mav = new ModelAndView("redirect:/admin/list");
//	return mav;
}
 



@RequestMapping(value = "/create", method = RequestMethod.GET)
public ModelAndView newStudentPage() {
	ModelAndView mav = new ModelAndView("StudentFormNew", "student", new Student());
	return mav;
}


@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
public ModelAndView editStudentPage(@PathVariable Integer id) {
	ModelAndView mav = new ModelAndView("StudentFormEdit");
	mav.addObject("student", sService.findStudent(id));
	return mav;
}

@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
public ModelAndView editStudent(@ModelAttribute @Valid Student student, @PathVariable Integer id,
		BindingResult result, final RedirectAttributes redirectAttributes)throws StudentNotFound
	{
	System.out.println("student"+student.toString());
	if (result.hasErrors())
		return new ModelAndView("StudentFormEdit");
	
	ModelAndView mav = new ModelAndView("redirect:/admin/list");
	/*sService.updateStudent(student);*/
	/*String message = "Student" + student.getStudentId() + " was successfully updated.";
	redirectAttributes.addFlashAttribute("message", message);*/
	return mav;
}

@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
public ModelAndView deleteStudent(@PathVariable Integer id, final RedirectAttributes redirectAttributes)
		{
	Student student = sService.findStudent(id);
	sService.removeStudent(student);
	ModelAndView mav = new ModelAndView("redirect:/admin/list");
	return mav;
}
}