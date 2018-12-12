//package sa47.team12.controllers;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//
//import sa47.team12.model.Administrator;
//import sa47.team12.model.Lecturer;
//import sa47.team12.model.Student;
//import sa47.team12.services.StudentService;
//
//@RequestMapping(value = "/home")
//@Controller
//public class CommentController {
//	@Autowired
//	private StudentService sService;
//	
//	@RequestMapping(value = "/studentlogin", method = RequestMethod.GET)
//	public String logic1(Model model) {
//		HashMap<String,Student> map = new HashMap<String,Student>();
//		map.put("role", new Student());
//		model.addAttribute("role", map);
//		return "studentlogin";
//	}
//	
//	@RequestMapping(value = "/lecturerlogin", method = RequestMethod.GET)
//	public String logic2(Model model) {
//		HashMap<String,Lecturer> map = new HashMap<String,Lecturer>();
//		map.put("role", new Lecturer());
//		model.addAttribute("role", map);
//		return "lecturerlogin";
//	}
//	
//	@RequestMapping(value = "/adminlogin", method = RequestMethod.GET)
//	public String logic3(Model model) {
//		HashMap<String,Administrator> map = new HashMap<String,Administrator>();
//		map.put("role", new Administrator());
//		model.addAttribute("role", map);
//		return "adminlogin";
//	}
//	
//	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
//	public ModelAndView authenticate(@ModelAttribute HashMap<String,?> map, HttpSession session, BindingResult result) {
//		ModelAndView mav = new ModelAndView("login");
//		if (result.hasErrors())
//			return mav;
//		UserSession us = new UserSession();
//		if (user.getName() != null && map.get("role").getPassword() != null) {
//			User u = uService.authenticate(user.getName(), user.getPassword());
//			us.setUser(u);
//			// PUT CODE FOR SETTING SESSION ID
//			us.setSessionId(session.getId());
//			us.setEmployee(eService.findEmployeeById(us.getUser().getEmployeeId()));
//			ArrayList<Employee> subordinates = eService.findSubordinates(us.getUser().getEmployeeId());
//			if (subordinates != null) {
//				us.setSubordinates(subordinates);
//
//			}
//			mav = new ModelAndView("redirect:/staff/history");
//		} else {
//			return mav;
//		}
//		session.setAttribute("USERSESSION", us);
//		return mav;
//	} 
//	
//}
