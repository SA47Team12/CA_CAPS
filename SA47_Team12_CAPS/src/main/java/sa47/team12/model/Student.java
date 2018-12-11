package sa47.team12.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

 
/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="student_id")
	private int studentId;

	private String address;

	@Temporal(TemporalType.DATE)
	private Date dob;

	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name="enrollment_date")
	private Date enrollmentDate;

	private String firstname;

	private String gender;

	private String lastname;

	private String password;

	private String phone;

	//bi-directional many-to-one association to CourseStudent
	@OneToMany(mappedBy="student",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<CourseStudent> courseStudents;

	public Student() {
	}

	public int getStudentId() {
		return this.studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getEnrollmentDate() {
		return this.enrollmentDate;
	}

	public void setEnrollmentDate(Date enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<CourseStudent> getCourseStudents() {
		return this.courseStudents;
	}

	public void setCourseStudents(List<CourseStudent> courseStudents) {
		this.courseStudents = courseStudents;
	}

	public CourseStudent addCourseStudent(CourseStudent courseStudent) {
		getCourseStudents().add(courseStudent);
		courseStudent.setStudent(this);

		return courseStudent;
	}

	public CourseStudent removeCourseStudent(CourseStudent courseStudent) {
		getCourseStudents().remove(courseStudent);
		courseStudent.setStudent(null);

		return courseStudent;
	}

	public String getstudentId() {
		// TODO Auto-generated method stub
		return null;
	}

}