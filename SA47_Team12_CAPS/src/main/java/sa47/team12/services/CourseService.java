package sa47.team12.services;

import java.util.ArrayList;

import sa47.team12.model.Course;

public interface CourseService {
 
	ArrayList<Course> findAllCourse();
	ArrayList<Course> listUntakeCourse(Integer stuID);

}