package sa47.team12.services;

import java.util.ArrayList;

import sa47.team12.model.CourseDetail;
import sa47.team12.model.CourseStudent;


public interface CourseDetailService {
	ArrayList<CourseDetail> findAllCourseDetail();
	
	ArrayList<Integer> findAllCourseDetailCode();
	
	CourseDetail findCourseDetail(Integer courseDetailId);
	
	CourseDetail createCourseDetails(CourseDetail courseDetail);
}
