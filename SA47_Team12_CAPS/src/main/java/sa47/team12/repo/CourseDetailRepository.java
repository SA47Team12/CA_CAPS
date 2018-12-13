package sa47.team12.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sa47.team12.model.CourseDetail;


public interface CourseDetailRepository extends JpaRepository<CourseDetail, Integer>{

	@Query("SELECT DISTINCT e.courseCode FROM CourseDetail e")
	ArrayList<Integer> findAllCourseDetailCode();
}
