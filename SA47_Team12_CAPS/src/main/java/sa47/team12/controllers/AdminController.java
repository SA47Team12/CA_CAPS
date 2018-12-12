package sa47.team12.controllers;


import java.util.List;

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
import sa47.team12.model.Course;
import sa47.team12.model.CourseStudent;
import sa47.team12.model.Lecturer;
import sa47.team12.model.Student;
import sa47.team12.services.CourseService;
import sa47.team12.services.CourseStudentService;
import sa47.team12.services.LecturerService;
import sa47.team12.services.StudentService;
import sa47.team12.validator.StudentValidator;




@RequestMapping(value="/admin")
@Controller
public class AdminController {
@Autowired
private StudentService sService;
@Autowired
private CourseStudentService csService;
@Autowired
private CourseService cService;
@Autowired
private StudentValidator sValidator;

@Autowired
private LecturerService lService;

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
		if (result.hasErrors())
			return new ModelAndView("StudentFormNew");
		ModelAndView mav = new ModelAndView();
		
		Student s = new Student();
		s.setAddress(student.getAddress());
		s.setEmail(student.getEmail());
		s.setFirstname(student.getFirstname());
		s.setLastname(student.getLastname());
		s.setGender(student.getGender());
		s.setPhone(student.getPhone());
		s.setPassword(student.getPassword());
		
		
		
		/*s.setCourseStudents(cs);*/
		sService.createStudent(s);
		//String message = "New student " + student.getNric() + " was successfully created.";
		mav.setViewName("redirect:/admin/list");
		return mav;
//	sService.updateStudent(student);
//	ModelAndView mav = new ModelAndView("redirect:/admin/list");
//	return mav;
}
 



@RequestMapping(value = "/create", method = RequestMethod.GET)
public ModelAndView newStudentPage1() {
	ModelAndView mav = new ModelAndView("StudentFormNew", "student", new Student());
	return mav;
}


@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
public ModelAndView editStudentPage1(@PathVariable Integer id) {
	ModelAndView mav = new ModelAndView("StudentFormEdit");
	mav.addObject("student", sService.findStudent(id));
	return mav;
}

@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
public ModelAndView editStudent(@ModelAttribute @Valid Student student,BindingResult result, @PathVariable Integer id,
		 final RedirectAttributes redirectAttributes)throws StudentNotFound
	{
	Student s = sService.findStudent(id);
	s.setAddress(student.getAddress());
	s.setEmail(student.getEmail());
	s.setFirstname(student.getFirstname());
	s.setLastname(student.getLastname());
	s.setGender(student.getGender());
	s.setPhone(student.getPhone());
	/*System.out.println("student"+student.toString());*/
	/*if (result.hasErrors())
		return new ModelAndView("StudentFormEdit");*/
	
	ModelAndView mav = new ModelAndView("redirect:/admin/list");
	sService.updateStudent(s);
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


@RequestMapping(value = "/llist", method = RequestMethod.GET)
public ModelAndView ListLecturerPage() {
ModelAndView mav = new ModelAndView("Lecturerlist");
mav.addObject("lecturers", lService.findAllLecturers());
return mav;
}

@RequestMapping(value = "/lcreate", method = RequestMethod.POST)
public ModelAndView createNewLecturer(@ModelAttribute @Valid Lecturer lecturer, BindingResult result,
		final RedirectAttributes redirectAttributes){
		/*if (result.hasErrors())
			return new ModelAndView("StudentFormNew");*/
		ModelAndView mav = new ModelAndView();

		//sService.createStudent(student);
		//String message = "New student " + student.getNric() + " was successfully created.";
		mav.setViewName("redirect:/admin/llist");
		return mav;
//	sService.updateStudent(student);
//	ModelAndView mav = new ModelAndView("redirect:/admin/list");
//	return mav;
}
 



@RequestMapping(value = "/lcreate", method = RequestMethod.GET)
public ModelAndView newStudentPage() {
	ModelAndView mav = new ModelAndView("LceturerFormNew", "lecturer", new Lecturer());
	return mav;
}


@RequestMapping(value = "/ledit/{lecturerid}", method = RequestMethod.GET)
public ModelAndView editStudentPage(@PathVariable Integer lecturerid) {
	ModelAndView mav = new ModelAndView("LecturerFormEdit");
	mav.addObject("lecturer", lService.findLecturerById(lecturerid));
	return mav;
}

@RequestMapping(value = "/ledit/{lecturerid}", method = RequestMethod.POST)
public ModelAndView editLecturer(@ModelAttribute @Valid Lecturer lecturer,BindingResult result, @PathVariable Integer lecturerid,
		 final RedirectAttributes redirectAttributes)
	{
	System.out.println("lecturer"+lecturer.toString());
	if (result.hasErrors())
		return new ModelAndView("LecturerFormEdit");
	
	ModelAndView mav = new ModelAndView("redirect:/admin/llist");
	/*sService.updateStudent(student);*/
	/*String message = "Student" + student.getStudentId() + " was successfully updated.";
	redirectAttributes.addFlashAttribute("message", message);*/
	return mav;
}

@RequestMapping(value = "/ldelete/{lecturerid}", method = RequestMethod.GET)
public ModelAndView deleteLecturer(@PathVariable Integer lecturerid, final RedirectAttributes redirectAttributes)
		{
	Lecturer lecturer = lService.findLecturerById(lecturerid);
	lService.removeLecturer(lecturer);
	ModelAndView mav = new ModelAndView("redirect:/admin/llist");
	return mav;
}

@RequestMapping(value = "/enrollment", method = RequestMethod.GET)
public ModelAndView ListPendingPage() {
ModelAndView mav = new ModelAndView("Enrollment");
mav.addObject("students",csService.listAppliedCourse() );
return mav;
}

@RequestMapping(value = "/accept/{id}", method = RequestMethod.GET)
public ModelAndView approveStudent(@PathVariable Integer id, final RedirectAttributes redirectAttributes)
		{
	CourseStudent cs = csService.findCourseStudent(id);
	cs.setEnrollmentStatus("accepted");
	
	Course c = cs.getCourse();
	int cap = c.getCurrentEnrollment();
	c.setCurrentEnrollment(cap+1);
	
	csService.updateRecord(cs);
	cService.UpdateCourse(c);
	
	ModelAndView mav = new ModelAndView("redirect:/admin/enrollment");
	return mav;
}


@RequestMapping(value = "/reject/{id}", method = RequestMethod.GET)
public ModelAndView rejectStudent(@PathVariable Integer id, final RedirectAttributes redirectAttributes)
		{
	CourseStudent cs = csService.findCourseStudent(id);
	cs.setEnrollmentStatus("rejected");
	
	csService.updateRecord(cs);
	ModelAndView mav = new ModelAndView("redirect:/admin/enrollment");
	return mav;
}

}