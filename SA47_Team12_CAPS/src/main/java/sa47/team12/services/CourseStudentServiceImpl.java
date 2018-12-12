package sa47.team12.services;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sa47.team12.model.Course;
import sa47.team12.model.CourseStudent;
import sa47.team12.repo.CourseRepo;
import sa47.team12.repo.CourseStuRepo;

@Service
public class CourseStudentServiceImpl implements CourseStudentService{
	 
	@Resource
	private CourseStuRepo csRepo;
	private CourseRepo cRepo;
	
//	@Override
//	@Transactional
//    public ArrayList<CourseStudent> findAll(){
//    	return (ArrayList<CourseStudent>)csRepo.findAll();
//    }
	
	@Override
	@Transactional
    public ArrayList<CourseStudent> listGrade(Integer stuID){
    	return csRepo.listGrade(stuID);
    }
	@Override
	@Transactional
	public ArrayList<CourseStudent> listCurrentCourse(Integer stuID){
		return csRepo.listCurrentCourse(stuID);
	}
	
	@Override
	@Transactional
	public ArrayList<CourseStudent> listPendingCourse(Integer stuID){
		return csRepo.listPendingCourse(stuID);
	}
	@Override
	@Transactional
	public ArrayList<CourseStudent> listRejectCourse(Integer stuID){
		return csRepo.listRejectCourse(stuID);
	}
	
//	@Override
//	@Transactional
//	public ArrayList<Course> listUntakeCourse(Integer stuID){
//		return cRepo.listUntakeCourses(stuID);
//	}

	@Override
	@Transactional
	public String calculateGPA(Integer stuID){
		Double sumGrade=(double) 0;
		Double sumCredit=(double) 0;
		for(CourseStudent c : listGrade(stuID)) {
			sumGrade += c.getCourse().getCourseDetail().getCredit()*c.getGrade();
			sumCredit += c.getCourse().getCourseDetail().getCredit();
		}
		NumberFormat formatter =  new DecimalFormat("#0.00");
		return formatter.format(sumGrade/sumCredit);
	}
	@Override
	@Transactional
	public CourseStudent findCSById(Integer csID){
		return csRepo.findOne(csID);
	}
	@Override
	@Transactional
	public void removeCS(CourseStudent cs){
		csRepo.delete(cs);
	}
}
