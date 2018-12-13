package sa47.team12.services;

import java.util.ArrayList;

import sa47.team12.model.Course;
import sa47.team12.model.CourseStudent;

public interface CourseStudentService {
	
 
   ArrayList<CourseStudent> listGrade(Integer stuID);
	
	ArrayList<CourseStudent> listCurrentCourse(Integer stuID);
	
	ArrayList<CourseStudent> listPendingCourse(Integer stuID);
	
	ArrayList<CourseStudent> listRejectCourse(Integer stuID);
	
	String calculateGPA(Integer stuID);
	
	CourseStudent findCSById(Integer csID);
	

	//void removeCS(CourseStudent cs);
	
	ArrayList<CourseStudent> findAll();

	
CourseStudent findCourseStudent(Integer courseStudentId);
	
	
	ArrayList<CourseStudent> findStudentGradeByCourse(Integer cid);
	
	void changeCourseStudent(CourseStudent courseStudent);
	
	//void removeCS(CourseStudent cs);
	void deleteCS(Integer ID);
	
	ArrayList<CourseStudent> listAppliedCourse();
	
	CourseStudent updateRecord(CourseStudent cs);
	
    CourseStudent enrollCourse(CourseStudent cs);
}
