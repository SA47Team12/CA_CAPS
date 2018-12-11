package sa47.team12.services;

import java.util.ArrayList;

import sa47.team12.model.Course;
import sa47.team12.model.CourseStudent;

public interface CourseStudentService {
	

   ArrayList<CourseStudent> listGrade(Integer stuID);
	
	ArrayList<CourseStudent> listCurrentCourse(Integer stuID);
	
	ArrayList<CourseStudent> listPendingCourse(Integer stuID);
	
	ArrayList<CourseStudent> listRejectCourse(Integer stuID);
	
//	ArrayList<Course> listUntakeCourse(Integer stuID);

	String calculateGPA(Integer stuID);
}
