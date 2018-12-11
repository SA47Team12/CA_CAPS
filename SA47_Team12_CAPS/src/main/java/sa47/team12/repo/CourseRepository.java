package sa47.team12.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sa47.team12.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	/*
	 * @Query("SELECT c FROM Student c") ArrayList<String> findAllStudent();
	 */

}