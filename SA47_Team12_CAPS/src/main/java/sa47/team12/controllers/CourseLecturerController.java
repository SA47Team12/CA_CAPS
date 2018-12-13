package sa47.team12.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import sa47.team12.exception.GradeException;
import sa47.team12.model.CourseStudent;
import sa47.team12.model.Lecturer;
import sa47.team12.model.Student;
import sa47.team12.services.CourseLecturerService;
import sa47.team12.services.CourseStudentService;
import sa47.team12.services.LecturerService;
import sa47.team12.validator.LecturerValidator;



@RequestMapping(value="/courselecturer")
@Controller
public class CourseLecturerController {
	@Autowired
	private CourseLecturerService csService;
	
	@Autowired
	private CourseStudentService cstuService;
	
	@Autowired
	private LecturerService lecService;
	
	@Autowired
	private LecturerValidator lValidator;
	
	@InitBinder("lecturer")
	private void initUserBinder(WebDataBinder binder) {
		binder.addValidators(lValidator);
	} 
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
	
	@RequestMapping(value = "/findcourselist", method = RequestMethod.GET)
	public ModelAndView findCourseListByLecturer() {
	ModelAndView mav = new ModelAndView("CourseLecturerCourseList");
	mav.addObject("courselecturers", csService.findCourseTaughtbyLID(2005));
	return mav;
	}
	
	/*@RequestMapping(value = "/findstudentgrade", method = RequestMethod.GET)
	public ModelAndView findStudentGradeByCourse() {
	ModelAndView mav = new ModelAndView("CourseLecturerStudentGrade");
	mav.addObject("coursestudents", cstuService.findStudentGradeByCourse(5101));
	return mav;
	}*/
	
	@RequestMapping(value = "/findstudentgrade/{id}", method = RequestMethod.GET)
	public ModelAndView findStudentGradeByDesireCourse(@PathVariable String id) {
	ModelAndView mav = new ModelAndView("CourseLecturerStudentGrade");
	mav.addObject("coursestudents", cstuService.findStudentGradeByCourse(Integer.parseInt(id)));
	return mav;
	}
	
	@RequestMapping(value = "/editstudentgrade/{id}", method = RequestMethod.GET)
	public ModelAndView editUserPage(@PathVariable String id) {
		ModelAndView mav = new ModelAndView("EditCourseLecturerStudentGrade");
		CourseStudent courseStudent = cstuService.findCourseStudent(Integer.parseInt(id));
		mav.addObject("coursestudents", courseStudent);
		/*ArrayList<String> eidList = cstuService.findAllEmployeeIDs();
		mav.addObject("eidlist", eidList);*/
		return mav;
	}

	@RequestMapping(value = "/editstudentgrade/{id}", method = RequestMethod.POST)
	public ModelAndView editUser(@ModelAttribute @Valid CourseStudent coursestudents, BindingResult result, @PathVariable String id,
			final RedirectAttributes redirectAttributes)throws GradeException  {

		if (result.hasErrors())
			return new ModelAndView("EditCourseLecturerStudentGrade");
		ModelAndView mav = new ModelAndView("redirect:/courselecturer/findstudentgrade");

		Integer csId=coursestudents.getCourseStudentId();
		Float grade1=coursestudents.getGrade();
		CourseStudent courseStudent = cstuService.findCourseStudent(csId);
		courseStudent.setGrade(grade1);
    	cstuService.changeCourseStudent(courseStudent);
		String message = "The user " + coursestudents.getCourseStudentId() + " was successfully deleted.";
    	redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	//@PathVariable Integer ID
		@RequestMapping(value = "/profile", method = RequestMethod.GET)
		public ModelAndView lecturerInfoPage() {
			ModelAndView mav = new ModelAndView("lecturer_profile");
			Lecturer lecturer = lecService.findLecturerById(2001);
			mav.addObject("lecturer", lecturer);
			ArrayList<Lecturer> lectList = lecService.findAllLecturers();
			mav.addObject("lectlist", lectList);
			return mav;
		}
		
		//@PathVariable Integer ID
		@RequestMapping(value = "/profile/edit", method = RequestMethod.POST)
		public ModelAndView EditLecturerInfo(@ModelAttribute @Valid Lecturer lecturer, BindingResult result, 
		final RedirectAttributes redirectAttributes)throws GradeException  {
		
			if (result.hasErrors())
				return new ModelAndView("lecturer_profile");
			ModelAndView mav = new ModelAndView("redirect:/courselecturer/profile");
		
			String lecEmail=lecturer.getEmail();
			String lecPhone=lecturer.getPhone();
			String lecAddress=lecturer.getAddress();
			
			Lecturer lec = lecService.findLecturerById(2001);
			lec.setEmail(lecEmail);
			lec.setPhone(lecPhone);
			lec.setAddress(lecAddress);
			lecService.updateLecturer(lec);
			String message = "User was successfully updated.";
		
			redirectAttributes.addFlashAttribute("message", message);
			return mav;

		}
	
}
