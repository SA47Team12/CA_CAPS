package sa47.team12.services;

import java.util.ArrayList;

import sa47.team12.model.CourseLecturer;


public interface CourseLecturerService {
	ArrayList<CourseLecturer> findAllCourseLecturer();
	
	ArrayList<CourseLecturer> findCourseTaughtbyLID(Integer lid);
	 
	ArrayList<CourseLecturer> findCourseEnrollmentbyLID(Integer lid);
}
