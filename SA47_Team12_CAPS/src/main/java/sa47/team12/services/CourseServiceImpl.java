package sa47.team12.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sa47.team12.model.Course;
import sa47.team12.model.CourseStudent;
import sa47.team12.repo.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
 
	@Resource
	private CourseRepository cRepository;

	/* (non-Javadoc)
	 * @see edu.iss.cats.service.EmployeeService#findEmployeesByManager(java.lang.String)
	 */
	@Override 
	@Transactional
	public ArrayList<Course> findAllCourse() {
		return (ArrayList<Course>) cRepository.findAll();
	}

	@Override
	public ArrayList<Course> listUntakeCourse(Integer stuID) {
		return cRepository.listUntakeCourse(stuID);
	}
	@Override
	@Transactional
	public Course UpdateCourse(Course c) {
		// TODO Auto-generated method stub
		return cRepository.saveAndFlush(c);
	}
	
	@Override
	@Transactional
	public Course findById(Integer id){
		return cRepository.findById(id).get();
	}
	
	@Override
	@Transactional
	public Course createCourse(Course c)
	{
		return cRepository.saveAndFlush(c);
	}

}