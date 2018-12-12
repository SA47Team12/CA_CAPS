package sa47.team12.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sa47.team12.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	/*
	 * @Query("SELECT c FROM Student c") ArrayList<String> findAllStudent();
	 */

	@Query("SELECT c from Course c WHERE not EXISTS "+
	"(SELECT cs FROM CourseStudent cs WHERE cs.student.studentId = :stuID AND cs.enrollmentStatus in ('accepted','pending') AND cs.course.courseId = c.courseId)")
	ArrayList<Course> listUntakeCourse(@Param("stuID") Integer stuID);
}