package sa47.team12.services;

import java.util.ArrayList;

import sa47.team12.model.Student;

public interface StudentService {

	ArrayList<Student> findAllStudent();
	Student findStudent(Integer id);
	Student updateStudent(Student s);
	Student createStudent(Student s);
	void removeStudent(Student s);
}