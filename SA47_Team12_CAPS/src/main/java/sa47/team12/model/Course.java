package sa47.team12.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the course database table.
 * 
 */
@Entity
@NamedQuery(name="Course.findAll", query="SELECT c FROM Course c")
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//GenerationType.IDENTITY means this field will be auto-incremented and will get assigned an id automatically whenever we save a new order.
	@Column(name="course_id")
	private int courseId;

	private int capacity;

	@Column(name="current_enrollment")
	private int currentEnrollment;

	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;

	//bi-directional many-to-one association to CourseDetail
	@ManyToOne
	@JoinColumn(name="code")
	private CourseDetail courseDetail;

//	//bi-directional many-to-one association to CourseLecturer
	@OneToMany(mappedBy="course")
	private List<CourseLecturer> courseLecturers;

	//bi-directional many-to-one association to CourseStudent
	@OneToMany(mappedBy="course")
	private List<CourseStudent> courseStudents;

	public Course() {
	}

	public int getCourseId() {
		return this.courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getCurrentEnrollment() {
		return this.currentEnrollment;
	}

	public void setCurrentEnrollment(int currentEnrollment) {
		this.currentEnrollment = currentEnrollment;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public CourseDetail getCourseDetail() {
		return this.courseDetail;
	}

	public void setCourseDetail(CourseDetail courseDetail) {
		this.courseDetail = courseDetail;
	}

	public List<CourseLecturer> getCourseLecturers() {
		return this.courseLecturers;
	}

	public void setCourseLecturers(List<CourseLecturer> courseLecturers) {
		this.courseLecturers = courseLecturers;
	}

	public CourseLecturer addCourseLecturer(CourseLecturer courseLecturer) {
		getCourseLecturers().add(courseLecturer);
		courseLecturer.setCourse(this);

		return courseLecturer;
	}

	public CourseLecturer removeCourseLecturer(CourseLecturer courseLecturer) {
		getCourseLecturers().remove(courseLecturer);
		courseLecturer.setCourse(null);

		return courseLecturer;
	}

	public List<CourseStudent> getCourseStudents() {
		return this.courseStudents;
	}

	public void setCourseStudents(List<CourseStudent> courseStudents) {
		this.courseStudents = courseStudents;
	}

	public CourseStudent addCourseStudent(CourseStudent courseStudent) {
		getCourseStudents().add(courseStudent);
		courseStudent.setCourse(this);

		return courseStudent;
	}

	public CourseStudent removeCourseStudent(CourseStudent courseStudent) {
		getCourseStudents().remove(courseStudent);
		courseStudent.setCourse(null);

		return courseStudent;
	}

}