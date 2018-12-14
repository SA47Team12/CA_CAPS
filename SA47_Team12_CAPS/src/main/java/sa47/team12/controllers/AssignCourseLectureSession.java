package sa47.team12.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class AssignCourseLectureSession {
	private Integer sessionLecturerID = null;
	private Integer sessionCourseID = null;
	public Integer getSessionLecturerID() {
		return sessionLecturerID;
	}
	public void setSessionLecturerID(Integer sessionLecturerID) {
		this.sessionLecturerID = sessionLecturerID;
	}
	public Integer getSessionCourseID() {
		return sessionCourseID;
	}
	public void setSessionCourseID(Integer sessionCourseID) {
		this.sessionCourseID = sessionCourseID;
	}
	
	

}
