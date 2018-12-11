package sa47.team12.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

 
/**
 * The persistent class for the lecturer database table.
 * 
 */
@Entity
@NamedQuery(name="Lecturer.findAll", query="SELECT l FROM Lecturer l")
public class Lecturer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="lecturer_id")
	private int lecturerId;

	private String address;

	private String email;

	private String firstname;

	private String lastname;

	private String password;

	private String phone;

	//bi-directional many-to-one association to CourseLecturer
	@OneToMany(mappedBy="lecturer")
	private List<CourseLecturer> courseLecturers;

	public Lecturer() {
	}

	public int getLecturerId() {
		return this.lecturerId;
	}

	public void setLecturerId(int lecturerId) {
		this.lecturerId = lecturerId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
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

	public List<CourseLecturer> getCourseLecturers() {
		return this.courseLecturers;
	}

	public void setCourseLecturers(List<CourseLecturer> courseLecturers) {
		this.courseLecturers = courseLecturers;
	}

	public CourseLecturer addCourseLecturer(CourseLecturer courseLecturer) {
		getCourseLecturers().add(courseLecturer);
		courseLecturer.setLecturer(this);

		return courseLecturer;
	}

	public CourseLecturer removeCourseLecturer(CourseLecturer courseLecturer) {
		getCourseLecturers().remove(courseLecturer);
		courseLecturer.setLecturer(null);

		return courseLecturer;
	}

}