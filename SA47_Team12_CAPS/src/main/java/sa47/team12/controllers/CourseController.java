package sa47.team12.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sa47.team12.model.CourseDetail;
import sa47.team12.model.Student;
import sa47.team12.services.CourseDetailService;
import sa47.team12.services.CourseService;


@RequestMapping(value = "/course")
@Controller
public class CourseController {
	@Autowired
	private CourseService cService;
	
	@Autowired
	private CourseDetailService cdService;


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
	
	@RequestMapping(value = "/coursedetails/create", method = RequestMethod.POST)
	public ModelAndView createNewCourseDetails(@ModelAttribute @Valid CourseDetail coursedetail, BindingResult result,
			final RedirectAttributes redirectAttributes){
			if (result.hasErrors())
				return new ModelAndView("CourseDetailsFormNew");
			ModelAndView mav = new ModelAndView();
			
			ArrayList<CourseDetail> cds=cdService.findAllCourseDetail();
			int size=cds.size();
			Integer id1=(Integer)cds.get(size-1).getCourseCode();
			id1=id1+1;
			
			CourseDetail cd = new CourseDetail();
			cd.setCourseCode(id1);;
			cd.setCredit(coursedetail.getCredit());;
			cd.setDescription(coursedetail.getDescription());
			cd.setDuration(coursedetail.getDuration());
			cd.setName(coursedetail.getName());	
			
			cdService.createCourseDetails(cd);
			mav.setViewName("redirect:/admin/listcoursedetail");
			return mav;
	}
	
	@RequestMapping(value = "/coursedetails/create", method = RequestMethod.GET)
	public ModelAndView newCourseDetailsPage() {
		ModelAndView mav = new ModelAndView("CourseDetailsFormNew", "CourseDetails", new CourseDetail());
		return mav;
	}
}