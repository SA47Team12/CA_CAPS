package sa47.team12.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sa47.team12.model.CourseLecturer;;

public interface CourseLecturerRepository  extends JpaRepository<CourseLecturer, Integer>{
	
	@Query("SELECT c from CourseLecturer c WHERE c.lecturer.lecturerId = :lid")
	ArrayList<CourseLecturer> findCourseLecturerbyLID(@Param("lid") Integer lid);
	 
}
