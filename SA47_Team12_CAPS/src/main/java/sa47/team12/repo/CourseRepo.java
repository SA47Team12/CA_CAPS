package sa47.team12.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sa47.team12.model.Course;


public interface CourseRepo extends JpaRepository<Course, Integer>{

//	@Query("SELECT c FROM Course c LEFT JOIN "
//			+ "(SELECT cs FROM CourseStudent cs WHERE cs.student.studentId = :stuID AND cs.enrollmentStatus IN ('accepted','pending')) css"
//			+ " ON c.courseId = css.course.courseId WHERE css.course.courseId IS NULL")
	
//	@Query("SELECT c FROM Course WHERE c.courseId NOT IN "
//			+ "(SELECT cs.course.courseId FROM CourseStudent cs WHERE cs.student.studentId = :stuID AND cs.enrollmentStatus IN ('accepted','pending'))")
//	ArrayList<Course> listUntakeCourses(@Param("stuID") Integer stuID);
}
