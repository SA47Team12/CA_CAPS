package sa47.team12.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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
import sa47.team12.model.Course;
import sa47.team12.model.CourseStudent;
import sa47.team12.model.Lecturer;
import sa47.team12.model.Student;
import sa47.team12.services.CourseService;
import sa47.team12.services.CourseStudentService;
import sa47.team12.services.StudentService;
import sa47.team12.validator.StudentValidator;
 
@Controller
@RequestMapping(value = "/student")
public class StudentController {
	@Autowired
	private CourseStudentService csService;
	
	@Autowired
	private CourseService cService;
	
	@Autowired
	private StudentService sService;
	
	@Autowired
	private StudentValidator sValidator;
	
	@InitBinder("student")
	private void initUserBinder(WebDataBinder binder) {
		binder.addValidators(sValidator);
	} 
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
	    binder.registerCustomEditor(Date.class, editor);
	}
	//@PathVariable Integer stuID
	@RequestMapping(value = "/grade", method = RequestMethod.GET)
	public ModelAndView GradePage() {
		ModelAndView mav = new ModelAndView("student_grade");
		ArrayList<CourseStudent> courses = csService.listGrade(3002);
		String GPA = csService.calculateGPA(3002);
		mav.addObject("GPA", GPA);
		mav.addObject("courses", courses);
		return mav;
	}
	//@PathVariable Integer stuID
	@RequestMapping(value = "/currentcourses", method = RequestMethod.GET)
	public ModelAndView curCoursePage() {
		ModelAndView mav = new ModelAndView("student_current_course");
		ArrayList<CourseStudent> courses = csService.listCurrentCourse(3002);
		mav.addObject("courses", courses);
		return mav;
	}
	//@PathVariable Integer stuID
	@RequestMapping(value = "/enroll", method = RequestMethod.GET)
	public ModelAndView EnrollCoursePage() {
		ModelAndView mav = new ModelAndView("student_enroll");
		ArrayList<Course> courses = cService.listUntakeCourse(3002);
		mav.addObject("courses", courses);
		return mav;
	}
	
	@RequestMapping(value = "/enroll/create", method = RequestMethod.GET)
	public ModelAndView EnrollCourse() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	//@PathVariable Integer stuID
	@RequestMapping(value = "/enroll/create/{id}", method = RequestMethod.POST)
	public ModelAndView EnrollCourse(@PathVariable Integer id
//			final RedirectAttributes redirectAttributes
			){
		
	    Course c = cService.findById(id);
	    Student s = sService.findStudent(3002);
		CourseStudent cs = new CourseStudent();
		
		ArrayList<CourseStudent> cstu = csService.findAll();
		int csSize = cstu.size();
		CourseStudent last = cstu.get(csSize -1);
		int newId = last.getCourseStudentId()+1;
		
	    cs.setCourse(c);
	    cs.setCourseStudentId(newId);
	    cs.setEnrollmentStatus("pending");
	    cs.setGrade(-1);
	    cs.setStudent(s);
		csService.enrollCourse(cs);
		ModelAndView mav = new ModelAndView("redirect:/student/enroll");
//		String message = "The course application " + cs.getCourse().getCourseDetail().getName() + " was successfully deleted.";
//
//		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	
	
	//@PathVariable Integer stuID
	@RequestMapping(value = "/enroll_status", method = RequestMethod.GET)
	public ModelAndView editCoursePage() {
		ModelAndView mav = new ModelAndView("student_enroll_status");
		ArrayList<CourseStudent> pendcourses = csService.listPendingCourse(3002);
		ArrayList<CourseStudent> rejectcourses = csService.listRejectCourse(3002);
		mav.addObject("pcourses", pendcourses);
		mav.addObject("rcourses", rejectcourses);
		return mav;
	}
	
	@RequestMapping(value="/enroll_status/delete/{id}", method = RequestMethod.GET)
	public ModelAndView DeletePendCourse(@PathVariable Integer id, final RedirectAttributes redirectAttributes){
				ModelAndView mav = new ModelAndView("redirect:/student/enroll_status");
		CourseStudent cs = csService.findCSById(id);
		csService.deleteCS(id);
		//csService.removeCS(cs);
		
		String message = "The course application " + cs.getCourse().getCourseDetail().getName() + " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	//@PathVariable Integer stuID
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView StudentInfoPage() {
		ModelAndView mav = new ModelAndView("student_profile");
		Student student = sService.findStudent(3004);
		mav.addObject("student", student);
		ArrayList<Student> stList = sService.findAllStudent();
		mav.addObject("stlist", stList);
		return mav;
	}
	
	//@PathVariable Integer stuID
	@RequestMapping(value = "/profile/edit", method = RequestMethod.POST)
	public ModelAndView EditStudentInfo(@ModelAttribute @Valid Student student, BindingResult result, 
	final RedirectAttributes redirectAttributes)throws GradeException  {
	
		if (result.hasErrors())
			return new ModelAndView("student_profile");
		
		ModelAndView mav = new ModelAndView("redirect:/student/profile");
		
		String stuEmail=student.getEmail();
		String stuPhone=student.getPhone();
		String stuAddress=student.getAddress();
		Date stuDob=student.getDob();
		String stuPass=student.getPassword();
		Student stu = sService.findStudent(3004);
		stu.setEmail(stuEmail);
		stu.setPhone(stuPhone);
		stu.setAddress(stuAddress);
		stu.setDob(stuDob);
		stu.setPassword(stuPass);
		
		sService.updateStudent(stu);
		String message = "User was successfully updated.";
		redirectAttributes.addFlashAttribute("message", message);
		return mav;

	}



}
