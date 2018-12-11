package sa47.team12.services;

import java.util.ArrayList;

import javax.annotation.Resource;

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
	
	public ArrayList<CourseLecturer> findCourseLecturerbyLID(Integer lid) {
		
	return clRepository.findCourseLecturerbyLID(lid);
	
	}


}
