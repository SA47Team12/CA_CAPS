package sa47.team12.services;

import java.util.ArrayList;

import sa47.team12.model.Lecturer;
import sa47.team12.model.Student;

public interface LecturerService {

	ArrayList<Lecturer> findAllLecturers();
	Lecturer findLecturerById(int lecturerid);
	ArrayList<Lecturer> findAllLecturer();
	Lecturer findLecturer(Integer id);
	Lecturer updateLecturer(Lecturer l);
	Lecturer createLecturer(Lecturer l);
	void removeLecturer(Lecturer l);
	ArrayList<Lecturer> findLecturersByCriteria(Lecturer l);

}