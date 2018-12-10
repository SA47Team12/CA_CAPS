package sa47.team12.model;

import java.io.Serializable;
import javax.persistence.*;
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
	@Column(name="course_id")
	private int courseId;

	private int capacity;

	@Column(name="current_enrollment")
	private int currentEnrollment;

	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;

	//bi-directional many-to-one association to CourseDetail
	@ManyToOne
	@JoinColumn(name="code")
	private CourseDetail courseDetail;

	//bi-directional many-to-many association to Student
	@ManyToMany
	@JoinTable(
		name="course_student"
		, joinColumns={
			@JoinColumn(name="course_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="student_id")
			}
		)
	private List<Student> students;

	//bi-directional many-to-many association to Lecturer
	@ManyToMany
	@JoinTable(
		name="course_lecturer"
		, joinColumns={
			@JoinColumn(name="course_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="lecturer_id")
			}
		)
	private List<Lecturer> lecturers;

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

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Lecturer> getLecturers() {
		return this.lecturers;
	}

	public void setLecturers(List<Lecturer> lecturers) {
		this.lecturers = lecturers;
	}

}
