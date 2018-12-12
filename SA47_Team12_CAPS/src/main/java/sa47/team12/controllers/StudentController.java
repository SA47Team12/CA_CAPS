package sa47.team12.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sa47.team12.model.Course;
import sa47.team12.model.CourseStudent;
import sa47.team12.model.Student;
import sa47.team12.services.CourseService;
import sa47.team12.services.CourseStudentService;
import sa47.team12.services.StudentService;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
	@Autowired
	private CourseStudentService csService;
	
	@Autowired
	private CourseService cService;
	
	@Autowired
	private StudentService sService;
	
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
	
		CourseStudent cs = csService.findCSById(id);
		csService.removeCS(cs);
		ModelAndView mav = new ModelAndView("redirect:/student/enroll_status");
		
		String message = "The course application " + cs.getCourse().getCourseDetail().getName() + " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	 
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView StudentInfoPage(@PathVariable Integer stuID) {
		ModelAndView mav = new ModelAndView("student_profile");
		Student student = sService.findStudent(stuID);
		mav.addObject("student", student);
		return mav;
	}
	
	

}
