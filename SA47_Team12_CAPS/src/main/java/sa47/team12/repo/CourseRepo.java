package sa47.team12.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sa47.team12.model.Course;


public interface CourseRepo extends JpaRepository<Course, Integer>{
	
	@Query("SELECT c from CourseStudent c WHERE c.studentId = :stuID AND c.grade >= 0")
	ArrayList<Course> listGrade(@Param("stuID") int stuID);

	@Query("SELECT c FROM Course c LEFT JOIN "
			+ "(SELECT cs FROM CourseStudent cs WHERE cs.studentId = :stuID AND cs.enrollmentStatus IN ('accepted','pending')) cs"
			+ "on c.courseId = cs.courseId WHERE cs.courseId IS NULL")
	ArrayList<Course> listUntakeCourses(@Param("stuID") int stuID);
}
