package sa47.team12.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sa47.team12.model.Lecturer;
import sa47.team12.model.Student;
import sa47.team12.repo.LecturerRepository;

@Service
public class LecturerServiceImpl implements LecturerService {

	@Resource
	LecturerRepository lrepos;

	/*
	 * (non-Javadoc)
	 * 
	 * @see sg.iss.demo.services.LecturerService#findAllLecturers()
	 */
	@Override
	@Transactional
	public ArrayList<Lecturer> findAllLecturers() {
		return (ArrayList<Lecturer>) lrepos.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sg.iss.demo.services.LecturerService#findLecturerById()
	 */
	@Override
	@Transactional
	public Lecturer findLecturerById(int lecturerid) {
		return (Lecturer) lrepos.findById(lecturerid).get();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sg.iss.demo.services.LecturerService#findLecturersByCriteria()
	 */
	@Override
	@Transactional
	public ArrayList<Lecturer> findLecturersByCriteria(Lecturer l) {
		
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sg.iss.demo.services.LecturerService#createLecturer(sg.iss.demo.model.
	 * Lecturer)
	 */
	@Override
	@Transactional
	public Lecturer createLecturer(Lecturer l) {
		return lrepos.saveAndFlush(l);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sg.iss.demo.services.LecturerService#updateLecturer(sg.iss.demo.model.
	 * Lecturer)
	 */
	@Override
	@Transactional
	public Lecturer updateLecturer(Lecturer l) {
		return lrepos.saveAndFlush(l);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sg.iss.demo.services.LecturerService#removeLecturer(sg.iss.demo.model.
	 * Lecturer)
	 */
	@Override
	@Transactional
	public void removeLecturer(Lecturer l) {
		lrepos.delete(l);
	}

	@Override
	public ArrayList<Lecturer> findAllLecturer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lecturer findLecturer(Integer id) {
		// TODO Auto-generated method stub
		return (Lecturer) lrepos.findById(id).get();
	}

}
