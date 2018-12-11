package sa47.team12.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the course_lecturer database table.
 * 
 */ 
@Entity
@Table(name="course_lecturer")
@NamedQuery(name="CourseLecturer.findAll", query="SELECT c FROM CourseLecturer c")
public class CourseLecturer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="course_lecturer_id")
	private int courseLecturerId;

	@Temporal(TemporalType.DATE)
	@Column(name="schedule_enddate")
	private Date scheduleEnddate;

	@Temporal(TemporalType.DATE)
	@Column(name="schedule_startdate")
	private Date scheduleStartdate;

	//bi-directional many-to-one association to Course
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;

	//bi-directional many-to-one association to Lecturer
	@ManyToOne
	@JoinColumn(name="lecturer_id")
	private Lecturer lecturer;

	public CourseLecturer() {
	}

	public int getCourseLecturerId() {
		return this.courseLecturerId;
	}

	public void setCourseLecturerId(int courseLecturerId) {
		this.courseLecturerId = courseLecturerId;
	}

	public Date getScheduleEnddate() {
		return this.scheduleEnddate;
	}

	public void setScheduleEnddate(Date scheduleEnddate) {
		this.scheduleEnddate = scheduleEnddate;
	}

	public Date getScheduleStartdate() {
		return this.scheduleStartdate;
	}

	public void setScheduleStartdate(Date scheduleStartdate) {
		this.scheduleStartdate = scheduleStartdate;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Lecturer getLecturer() {
		return this.lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

}