package sa47.team12.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sa47.team12.model.CourseStudent;


public interface CourseStuRepo extends JpaRepository<CourseStudent, Integer>{

	@Query("SELECT c FROM CourseStudent c WHERE c.student.studentId = :stuID AND c.grade >= 0")
	ArrayList<CourseStudent> listGrade(@Param("stuID") Integer stuID);
	
	
	
	@Query("SELECT c FROM CourseStudent c WHERE c.student.studentId = :stuID AND c.grade < 0 AND c.enrollmentStatus='accepted'")
	ArrayList<CourseStudent> listCurrentCourse(@Param("stuID") Integer stuID);
	
//	@Query("SELECT c from CourseStudent c WHERE c.studentId = :stuID AND c.enrollmentStatus IN ('pending','rejected')")
//	ArrayList<CourseStudent> listCourse(@Param("stuID") int stuID);
	
	@Query("SELECT c FROM CourseStudent c WHERE c.student.studentId = :stuID AND c.enrollmentStatus = 'pending'")
	ArrayList<CourseStudent> listPendingCourse(@Param("stuID") Integer stuID);
	
	@Query("SELECT c from CourseStudent c WHERE c.student.studentId = :stuID AND c.enrollmentStatus = 'rejected'")
	ArrayList<CourseStudent> listRejectCourse(@Param("stuID") Integer stuID);


}
