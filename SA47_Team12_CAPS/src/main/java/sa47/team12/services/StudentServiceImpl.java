package sa47.team12.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sa47.team12.model.Student;
import sa47.team12.repo.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
 
	@Resource
	private StudentRepository stuRepository;

	/* (non-Javadoc)
	 * @see edu.iss.cats.service.EmployeeService#findEmployeesByManager(java.lang.String)
	 */
	@Override
	@Transactional
	public ArrayList<Student> findAllStudent() {
		return (ArrayList<Student>) stuRepository.findAll();
	}
	
	@Override
	@Transactional
	public Student findStudent(Integer id) {
		return (Student) stuRepository.findById(id).get();
	}
	@Override
	@Transactional
	public Student updateStudent(Student s)
	{
		return stuRepository.saveAndFlush(s);
	}
	
	@Override
	@Transactional
	public Student createStudent(Student s)
	{
		return stuRepository.saveAndFlush(s);
	}
	@Override
	@Transactional
	public void removeStudent(Student s)
	{
		stuRepository.delete(s);
	}

}
