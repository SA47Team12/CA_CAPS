package sa47.team12.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sa47.team12.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	/*
	 * @Query("SELECT c FROM Student c") ArrayList<String> findAllStudent();
	 */

}