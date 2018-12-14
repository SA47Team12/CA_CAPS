package sa47.team12.controllers;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;
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


import sa47.team12.model.Course;
import sa47.team12.model.CourseDetail;
import sa47.team12.model.CourseLecturer;
import sa47.team12.model.CourseStudent;
import sa47.team12.model.Lecturer;
import sa47.team12.model.Student;
import sa47.team12.services.CourseLecturerService;
import sa47.team12.services.CourseService;
import sa47.team12.services.CourseStudentService;
import sa47.team12.services.LecturerService;
import sa47.team12.services.StudentService;

@RequestMapping(value="/admin/assignlecturer")
@Controller
public class AdminAssignCourseLecturerController {
	
	
	
	@Autowired
	private CourseStudentService csService;
	
	@Autowired
	private LecturerService lecService;
	
	@Autowired
	private CourseService cService;
	
	@Autowired
	private StudentService sService;
	
	@Autowired
	private CourseLecturerService clService;
	
	@InitBinder

    public void initBinder(WebDataBinder binder) {

        CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);

        binder.registerCustomEditor(Date.class, editor);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView ListLecturerPage() {
	ModelAndView mav = new ModelAndView("AssignLecturerList");
	mav.addObject("lecturers", lecService.findAllLecturers());
	return mav;
	}
	
	@RequestMapping(value = "/courselist/{id}", method = RequestMethod.GET)
	public ModelAndView ListofCourse(@PathVariable Integer id, HttpSession session, final RedirectAttributes redirectAttributes)
			{
		Lecturer lecturer=lecService.findLecturer(id);
		
		ModelAndView mav = new ModelAndView("assigncourselecturer");
		AssignCourseLectureSession coulec = new AssignCourseLectureSession();
		
		coulec.setSessionLecturerID(id);
		
		ArrayList<Course> courses = cService.findAllCourse();
		mav.addObject("courses", courses);
		
		
		session.setAttribute("ASSIGNLECTURERSESSION", coulec);
		return mav;
	}
	
	
	
		
		
		
		//@PathVariable Integer stuID
		@RequestMapping(value = "/courselistnew/{id}", method = RequestMethod.POST)
		public ModelAndView EnrollCourse(@PathVariable Integer id,HttpSession session){
			
			AssignCourseLectureSession us = (AssignCourseLectureSession) session.getAttribute("ASSIGNLECTURERSESSION");
			//System.out.println(us.getSessionLecturerID().toString());
			
			Integer lecturerid=us.getSessionLecturerID();
			
		    Course c = cService.findById(id);
		    //Student s = sService.findStudent(3002);
		    Lecturer lecturer=lecService.findLecturer(lecturerid);
			//CourseStudent cs = new CourseStudent();
		    
		    
		    ArrayList<CourseLecturer> cllist=clService.findAllCourseLecturer();
			int size=cllist.size();
			Integer id1=(Integer)cllist.get(size-1).getCourseLecturerId();
			id1=id1+1;
		    
		    
		    
		    
			CourseLecturer cl=new CourseLecturer();
			cl.setCourseLecturerId(id1);
			cl.setCourse(c);
			cl.setLecturer(lecturer);
			
			ModelAndView mav = new ModelAndView("CourseLecturerFormNew");
			
			mav.addObject("courselecturer",cl);
			return mav;
		   
			
			
		}
		

		
		
		@RequestMapping(value = "/createcourselecturer", method = RequestMethod.POST)
		public ModelAndView createNewCourseLecturer(@ModelAttribute @Valid CourseLecturer courselecturer, BindingResult result,
				final RedirectAttributes redirectAttributes){
				
				
				
				Integer courseID=courselecturer.getCourse().getCourseId();
				Integer lecturerID=courselecturer.getLecturer().getLecturerId();
				
				Integer courselecturerId=courselecturer.getCourseLecturerId();
				
				//Integer courseCode=courselecturer.getCourseDetail().getCourseCode();
				
				Course course= cService.findById(courseID);
				Lecturer lecturer=lecService.findLecturerById(lecturerID);
				
				CourseLecturer cl=new CourseLecturer();
				cl.setCourseLecturerId(courselecturerId);
				cl.setCourse(course);
				cl.setLecturer(lecturer);
				cl.setScheduleStartdate(courselecturer.getScheduleStartdate());
				cl.setScheduleEnddate(courselecturer.getScheduleEnddate());
				
				 
				clService.createCourseLecturer(cl);
				
				ModelAndView mav = new ModelAndView();
				mav.setViewName("redirect:/admin/assignlecturer/list");
				return mav;

		}




		
	
	
}
