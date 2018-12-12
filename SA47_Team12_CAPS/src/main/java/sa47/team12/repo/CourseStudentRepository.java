package sa47.team12.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import sa47.team12.model.CourseStudent;

public interface CourseStudentRepository extends JpaRepository<CourseStudent, Integer>{
	
	@Query("SELECT c from CourseStudent c WHERE c.course.courseId = 5101")
	ArrayList<CourseStudent> findStudentGradeByCourse(@Param("cid") Integer cid);

	
	
	
	@Modifying
	@Query("UPDATE CourseStudent cs SET cs.grade =:csgrade where cs.courseStudentId =:csid")
	void changeCourseStudent(@Param("csgrade")Float csgrade,@Param("csid")Integer csId);


}
