package sa47.team12.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the course_details database table.
 * 
 */ 
@Entity
@Table(name="course_details")
public class CourseDetail implements Serializable {
	private static final long serialVersionUID = 1L;
 
	@Id
	@Column(name="course_code")
	private int courseCode;

	private int credit;

	private String description;

	private int duration;

	private String name;

	//bi-directional many-to-one association to Course
	@OneToMany(mappedBy="courseDetail")
	private List<Course> courses;

	public CourseDetail() {
	}

	public int getCourseCode() {
		return this.courseCode;
	}

	public void setCourseCode(int courseCode) {
		this.courseCode = courseCode;
	}

	public int getCredit() {
		return this.credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Course addCours(Course cours) {
		getCourses().add(cours);
		cours.setCourseDetail(this);

		return cours;
	}

	public Course removeCours(Course cours) {
		getCourses().remove(cours);
		cours.setCourseDetail(null);

		return cours;
	}

}