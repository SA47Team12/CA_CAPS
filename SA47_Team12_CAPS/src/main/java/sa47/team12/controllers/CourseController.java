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

import sa47.team12.model.Course;

import sa47.team12.services.CourseService;

@RequestMapping(value = "/course")
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

	@RequestMapping(value = "/display/{courseId}", method = RequestMethod.GET)
	public ModelAndView searchCoursePage(@PathVariable Integer courseId) {
		ModelAndView mav = new ModelAndView("CourseSearchResult");
		mav.addObject("course", cService.findById(courseId));
		return mav;
	}

	@RequestMapping(value = "/display", method = RequestMethod.POST)
	public ModelAndView editDepartment(@ModelAttribute @Valid Course course, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView();
// int c = course.getCourseId();
		ModelAndView mav = new ModelAndView("redirect:/course/display/${course.getCourseId()}");

		mav.addObject("course", new Course());
		String message = "Search successfully";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
}