package sa47.team12.services;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import sa47.team12.model.CourseLecturer;
import sa47.team12.repo.CourseLecturerRepository;


@Service
public class CourseLecturerServiceImpl implements CourseLecturerService {
	
	@Resource
	private CourseLecturerRepository clRepository;

	@Override
	public ArrayList<CourseLecturer> findAllCourseLecturer() {
		// TODO Auto-generated method stub 
		return (ArrayList<CourseLecturer>) clRepository.findAll();
	}
	
	public ArrayList<CourseLecturer> findCourseTaughtbyLID(Integer lid) {
		
	return clRepository.findCourseTaughtbyLID(lid);
	
	}
	
	public ArrayList<CourseLecturer> findCourseEnrollmentbyLID(Integer lid) {
		
		return clRepository.findCourseEnrollmentbyLID(lid);
		
		}
	
	@Override
	@Transactional
	public CourseLecturer createCourseLecturer(CourseLecturer c)
	{
		return clRepository.saveAndFlush(c);
	}



}
