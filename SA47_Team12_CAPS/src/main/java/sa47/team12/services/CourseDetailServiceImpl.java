package sa47.team12.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sa47.team12.model.CourseDetail;
import sa47.team12.model.CourseStudent;
import sa47.team12.model.Student;
import sa47.team12.repo.CourseDetailRepository;
import sa47.team12.repo.CourseLecturerRepository;


@Service
public class CourseDetailServiceImpl implements CourseDetailService {
	
	@Resource
	private CourseDetailRepository cdRepository;
	
	public ArrayList<CourseDetail> findAllCourseDetail(){
		return (ArrayList<CourseDetail>) cdRepository.findAll();
	}
	
	public ArrayList<Integer> findAllCourseDetailCode()
	{
		return cdRepository.findAllCourseDetailCode();
	}

	public CourseDetail findCourseDetail(Integer courseDetailId){
		return (CourseDetail)cdRepository.findById(courseDetailId).get();
	}
	
	
	
}
