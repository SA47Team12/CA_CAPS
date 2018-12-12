package sa47.team12.model;

 
import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


/**
 * The persistent class for the course_student database table.
 * 
 */
@Entity
@Table(name="course_student")
@NamedQuery(name="CourseStudent.findAll", query="SELECT c FROM CourseStudent c")
public class CourseStudent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="course_student_id")
	private int courseStudentId;

	@Column(name="enrollment_status")
	private String enrollmentStatus;

	private float grade;

	//bi-directional many-to-one association to Course
	@ManyToOne (fetch = FetchType.EAGER)

	@JoinColumn(name="course_id")
	private Course course;

	//bi-directional many-to-one association to Student
	@ManyToOne (fetch = FetchType.EAGER)
	// @OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name="student_id")
	private Student student;

	public CourseStudent() {
	}

	public int getCourseStudentId() {
		return this.courseStudentId;
	}

	public void setCourseStudentId(int courseStudentId) {
		this.courseStudentId = courseStudentId;
	}

	public String getEnrollmentStatus() {
		return this.enrollmentStatus;
	}

	public void setEnrollmentStatus(String enrollmentStatus) {
		this.enrollmentStatus = enrollmentStatus;
	}

	public float getGrade() {
		return this.grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}