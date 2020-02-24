package healthcaresystemproject.dto;

import java.sql.Date;

public class Appointment {
    User user;
	long appointmentId;
	Date datetime;
	Test test;
	boolean approved;
	public Appointment() {
		
	}
	public Appointment(User user, long appointmentId, Date datetime, Test test, boolean approved) {
		super();
		this.user = user;
		this.appointmentId = appointmentId;
		this.datetime = datetime;
		this.test = test;
		this.approved = approved;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	@Override
	public String toString() {
		return "Appointment [user=" + user + ", appointmentId=" + appointmentId + ", datetime=" + datetime + ", test="
				+ test + ", approved=" + approved + "]";
	}
	
}
