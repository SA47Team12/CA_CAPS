package sa47.team12.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sa47.team12.model.Course;
import sa47.team12.model.CourseStudent;
import sa47.team12.model.Student;
import sa47.team12.services.CourseStudentService;
import sa47.team12.services.StudentService;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
	@Autowired
	private CourseStudentService csService;
	
	@Autowired
	private StudentService sService;
	
	//@PathVariable Integer stuID
	@RequestMapping(value = "/grade", method = RequestMethod.GET)
	public ModelAndView GradePage() {
		ModelAndView mav = new ModelAndView("student-grade");
		ArrayList<CourseStudent> courses = csService.findAll();
		//String GPA = csService.calculateGPA(3002);
		mav.addObject("GPA", 3.2);
		mav.addObject("courses", courses);
		return mav;
	}
	
//	@RequestMapping(value = "/currentcourses", method = RequestMethod.GET)
//	public ModelAndView curCoursePage(@PathVariable Integer stuID) {
//		ModelAndView mav = new ModelAndView("student-current-course");
//		ArrayList<CourseStudent> courses = csService.listCurrentCourse(stuID);
//		mav.addObject("courses", courses);
//		return mav;
//	}
//	
//	@RequestMapping(value = "/enroll", method = RequestMethod.GET)
//	public ModelAndView EnrollCoursePage(@PathVariable Integer stuID) {
//		ModelAndView mav = new ModelAndView("student-enroll");
//		ArrayList<Course> courses = csService.listUntakeCourse(stuID);
//		mav.addObject("courses", courses);
//		return mav;
//	}
//	
//	@RequestMapping(value = "/enroll_status", method = RequestMethod.GET)
//	public ModelAndView editCoursePage(@PathVariable Integer stuID) {
//		ModelAndView mav = new ModelAndView("student-enroll-status");
//		ArrayList<CourseStudent> pendcourses = csService.listPendingCourse(stuID);
//		ArrayList<CourseStudent> rejectcourses = csService.listRejectCourse(stuID);
//		mav.addObject("pcourses", pendcourses);
//		mav.addObject("rcourses", rejectcourses);
//		return mav;
//	}
//	
//	@RequestMapping(value = "/profile", method = RequestMethod.GET)
//	public ModelAndView StudentInfoPage(@PathVariable Integer stuID) {
//		ModelAndView mav = new ModelAndView("student-profile");
//		Student student = sService.findStudent(stuID);
//		mav.addObject("student", student);
//		return mav;
//	}

}
