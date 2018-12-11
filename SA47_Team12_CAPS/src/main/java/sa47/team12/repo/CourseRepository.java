package sa47.team12.repo;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sa47.team12.model.Course;

public interface CourseRepository extends JpaRepository <Course, Integer>{
	
	@Query ("Select * from Course")
	ArrayList<Course> findAllCourses();
	
	@Query("Select c from Course c where c.course_id= :cid")
	ArrayList<Course> findCoursesbyCID(@Param("cid") String cid);

	@Query("Select c from Course c where c.start_date BETWEEN STARTDATE AND ENDDATE")
	ArrayList<Course> findCoursesbyDate(@Param("STARTDATE") Date STARTDATE, @Param("ENDDATE") Date ENDDATE);

	

}
