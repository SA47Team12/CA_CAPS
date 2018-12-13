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
import sa47.team12.exception.StudentNotFound;
import sa47.team12.model.Administrator;
import sa47.team12.model.Course;
import sa47.team12.model.CourseDetail;
import sa47.team12.model.CourseStudent;
import sa47.team12.model.Lecturer;
import sa47.team12.model.Student;
import sa47.team12.services.AdminService;
import sa47.team12.services.CourseDetailService;
import sa47.team12.services.CourseService;
import sa47.team12.services.CourseStudentService;
import sa47.team12.services.LecturerService;
import sa47.team12.services.StudentService;
import sa47.team12.validator.AdminValidator;
import sa47.team12.validator.LecturerValidator;
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
private AdminService aService;
@Autowired
private StudentValidator sValidator;
@Autowired
private AdminValidator aValidator;

@Autowired
private CourseDetailService cdService;

@InitBinder("student")
private void initStudentBinder(WebDataBinder binder)
{
	binder.addValidators(sValidator);
}

@Autowired
private LecturerValidator lValidator;

@InitBinder("lecturer")
private void initLecturerBinder(WebDataBinder binder)
{
	binder.addValidators(lValidator);
}

@InitBinder("administrator")
private void initAdministratorBinder(WebDataBinder binder)
{
	binder.addValidators(aValidator);
}
@Autowired
private LecturerService lService;

/**
* DEPARTMENT CRUD OPERATIONS
* 
* @return
*/

@RequestMapping(value = "/student/list", method = RequestMethod.GET)
public ModelAndView ListStudentPage() {
ModelAndView mav = new ModelAndView("Studentlist");
mav.addObject("students", sService.findAllStudent());
return mav;
}

@RequestMapping(value = "/student/create", method = RequestMethod.POST)
public ModelAndView createNewStudent(@ModelAttribute @Valid Student student, BindingResult result,
		final RedirectAttributes redirectAttributes){
		if (result.hasErrors())
			return new ModelAndView("StudentFormNew");
		ModelAndView mav = new ModelAndView();
		
		ArrayList<Student> stu=sService.findAllStudent();
		int size=stu.size();
		Integer id1=(Integer)stu.get(size-1).getStudentId();
		id1=id1+1;
		
		Student s = new Student();
		s.setStudentId(id1);
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
		mav.setViewName("redirect:/admin/student/list");
		return mav;
//	sService.updateStudent(student);
//	ModelAndView mav = new ModelAndView("redirect:/admin/list");
//	return mav;
}
 



@RequestMapping(value = "/student/create", method = RequestMethod.GET)
public ModelAndView newStudentPage1() {
	ModelAndView mav = new ModelAndView("StudentFormNew", "student", new Student());
	return mav;
}


@RequestMapping(value = "/student/edit/{id}", method = RequestMethod.GET)
public ModelAndView editStudentPage1(@PathVariable Integer id) {
	ModelAndView mav = new ModelAndView("StudentFormEdit");
	mav.addObject("student", sService.findStudent(id));
	return mav;
}

@RequestMapping(value = "/student/edit/{id}", method = RequestMethod.POST)
public ModelAndView editStudent(@ModelAttribute @Valid Student student,BindingResult result, @PathVariable Integer id,
		 final RedirectAttributes redirectAttributes)throws StudentNotFound
	{
	if (result.hasErrors())
	return new ModelAndView("StudentFormEdit");
	Student s = sService.findStudent(id);
	s.setAddress(student.getAddress());
	s.setEmail(student.getEmail());
	s.setFirstname(student.getFirstname());
	s.setLastname(student.getLastname());
	s.setGender(student.getGender());
	s.setPhone(student.getPhone());
	/*System.out.println("student"+student.toString());*/
	
	
	ModelAndView mav = new ModelAndView("redirect:/admin/student/list");
	sService.updateStudent(s);
	/*String message = "Student" + student.getStudentId() + " was successfully updated.";
	redirectAttributes.addFlashAttribute("message", message);*/
	return mav;
}

@RequestMapping(value = "/student/delete/{id}", method = RequestMethod.GET)
public ModelAndView deleteStudent(@PathVariable Integer id, final RedirectAttributes redirectAttributes)
		{
	Student student = sService.findStudent(id);
	sService.removeStudent(student);
	ModelAndView mav = new ModelAndView("redirect:/admin/student/list");
	return mav;
}


@RequestMapping(value = "/lecturer/list", method = RequestMethod.GET)
public ModelAndView ListLecturerPage() {
ModelAndView mav = new ModelAndView("Lecturerlist");
mav.addObject("lecturers", lService.findAllLecturers());
return mav;
}

@RequestMapping(value = "/lecturer/create", method = RequestMethod.POST)
public ModelAndView createNewLecturer(@ModelAttribute @Valid Lecturer lecturer, BindingResult result,
		final RedirectAttributes redirectAttributes){
		if (result.hasErrors())
			return new ModelAndView("LecturerFormNew");
	
	
		ArrayList<Lecturer> lect = lService.findAllLecturers();
		int lectsize = lect.size();
		Lecturer last = lect.get(lectsize -1);
		int id = last.getLecturerId()+1;
		
		Lecturer l = new Lecturer();
		l.setAddress(lecturer.getAddress());
		l.setEmail(lecturer.getEmail());
		l.setFirstname(lecturer.getFirstname());
		l.setLastname(lecturer.getLastname());
		l.setLecturerId(id);
		l.setPhone(lecturer.getPhone());
		l.setPassword(lecturer.getPassword());
		
		ModelAndView mav = new ModelAndView();

		lService.createLecturer(l);
		//String message = "New student " + student.getNric() + " was successfully created.";
		mav.setViewName("redirect:/admin/lecturer/list");
		return mav;
}
 



@RequestMapping(value = "/lecturer/create", method = RequestMethod.GET)
public ModelAndView newStudentPage() {
	ModelAndView mav = new ModelAndView("LecturerFormNew", "lecturer", new Lecturer());
	return mav;
}


@RequestMapping(value = "/lecturer/edit/{lecturerid}", method = RequestMethod.GET)
public ModelAndView editStudentPage(@PathVariable Integer lecturerid) {
	ModelAndView mav = new ModelAndView("LecturerFormEdit");
	mav.addObject("lecturer", lService.findLecturerById(lecturerid));
	return mav;
}

@RequestMapping(value = "/lecturer/edit/{lecturerid}", method = RequestMethod.POST)
public ModelAndView editLecturer(@ModelAttribute @Valid Lecturer lecturer,BindingResult result, @PathVariable Integer lecturerid,
		 final RedirectAttributes redirectAttributes)
	{
	/*System.out.println("lecturer"+lecturer.toString());*/
	if (result.hasErrors())
		return new ModelAndView("LecturerFormEdit");
	Lecturer l = lService.findLecturer(lecturerid);
	l.setAddress(lecturer.getAddress());
	l.setEmail(lecturer.getEmail());
	l.setFirstname(lecturer.getFirstname());
	l.setLastname(lecturer.getLastname());
	l.setPhone(lecturer.getPhone());
	
	ModelAndView mav = new ModelAndView("redirect:/admin/lecturer/list");
	lService.updateLecturer(l);
	/*String message = "Student" + student.getStudentId() + " was successfully updated.";
	redirectAttributes.addFlashAttribute("message", message);*/
	return mav;
}

@RequestMapping(value = "/lecturer/delete/{lecturerid}", method = RequestMethod.GET)
public ModelAndView deleteLecturer(@PathVariable Integer lecturerid, final RedirectAttributes redirectAttributes)
		{
	Lecturer lecturer = lService.findLecturerById(lecturerid);
	lService.removeLecturer(lecturer);
	ModelAndView mav = new ModelAndView("redirect:/admin/lecturer/list");
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

//Create Course Start


@RequestMapping(value = "/listcoursedetail", method = RequestMethod.GET)
public ModelAndView ListCourseDetailPage() {
ModelAndView mav = new ModelAndView("ListCourseDetail");
mav.addObject("coursedetails", cdService.findAllCourseDetail());
return mav;
}



@RequestMapping(value = "/createcourse/{id}", method = RequestMethod.GET)
public ModelAndView newCoursePage(@PathVariable String id) {
ModelAndView mav = new ModelAndView("CourseFormNew");
Course c=new Course();
CourseDetail cd= cdService.findCourseDetail(Integer.parseInt(id));
c.setCourseDetail(cd);
mav.addObject("course",c);
return mav;
}

@RequestMapping(value = "/createcourse", method = RequestMethod.POST)
public ModelAndView createNewCourse(@ModelAttribute @Valid Course course, BindingResult result,
		final RedirectAttributes redirectAttributes){
		if (result.hasErrors())
			return new ModelAndView("CourseFormNew");
		ModelAndView mav = new ModelAndView();
		
		Integer courseCode=course.getCourseDetail().getCourseCode();
		
		CourseDetail cd= cdService.findCourseDetail(courseCode);
		
		 
		
		Course c = new Course();
		
		ArrayList<Course> co=cService.findAllCourse();
		int size=co.size();
		Integer id1=(Integer)co.get(size-1).getCourseId();
		id1=id1+1;
		
		
		
		Integer id=5120;
		c.setCourseId(id1);
		c.setCapacity(course.getCapacity());
		//c.setStartDate(date);
		c.setCurrentEnrollment(30);
		c.setCourseDetail(cd);
		
		
		cService.createCourse(c);
		//String message = "New student " + student.getNric() + " was successfully created.";
		mav.setViewName("redirect:/admin/listcoursedetail");
		return mav;
//	sService.updateStudent(student);
//	ModelAndView mav = new ModelAndView("redirect:/admin/list");
//	return mav;
}

//Create Course Finish

//@PathVariable Integer ID
		@RequestMapping(value = "/profile", method = RequestMethod.GET)
		public ModelAndView adminInfoPage() {
			ModelAndView mav = new ModelAndView("admin_profile");
			Administrator administrator = aService.findAdministrator(1001);
			mav.addObject("administrator", administrator);
			ArrayList<Administrator> aList = aService.findAllAdministrator();
			mav.addObject("alist", aList);
			return mav;
		}
		
		//@PathVariable Integer ID
		@RequestMapping(value = "/profile/edit", method = RequestMethod.POST)
		public ModelAndView EditadminInfo(@ModelAttribute @Valid Administrator administrator, BindingResult result, 
		final RedirectAttributes redirectAttributes)throws GradeException  {
		
			if (result.hasErrors())
				return new ModelAndView("admin_profile");
			ModelAndView mav = new ModelAndView("redirect:/admin/profile");
		
			String adminEmail=administrator.getEmail();
			String adminPhone=administrator.getPhone();
			String adminAddress=administrator.getAddress();
			
			Administrator admin = aService.findAdministrator(1001);
			admin.setEmail(adminEmail);
			admin.setPhone(adminPhone);
			admin.setAddress(adminAddress);
			aService.updateAdministrator(admin);
			String message = "User was successfully updated.";
		
			redirectAttributes.addFlashAttribute("message", message);
			return mav;

		}
	

}