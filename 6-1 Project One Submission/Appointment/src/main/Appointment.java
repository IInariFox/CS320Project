package main;

import java.util.Date;

public class Appointment {
	private String appointmentId;
	private Date date;
	private String description;
	
	public void setAppointmentDate(Date date) {
		this.date = date;
	}
	public void setAppointmentDescription(String description) {
		this.description = description;
	}
	public String getAppointmentId() {
		return appointmentId;
	}
	public Date getAppointmentDate() {
		return date;
	}
	public String getAppointmentDescription() {
		return description;
	}
	
	private void verifyIdRequirements(String appointmentId) {
		if (appointmentId == null) {
			throw new IllegalArgumentException("Id cannot be null!");
		}
		if (appointmentId.length() > 10) {
			throw new IllegalArgumentException("Id cannot be longer than 10 characters!");
		}
	}
	
	private void verifyDateRequirements(Date date) {
		if (date == null) {
			throw new IllegalArgumentException("Date cannot be null!");
		}
		if (date.before(new Date())) {
			throw new IllegalArgumentException("Date cannot be in the past");
		}
	}
	
	private void verifyDescriptionRequirements(String description) {
		if (description == null) {
			throw new IllegalArgumentException("Description cannot be null!");
		}
		if (description.length() > 50) {
			throw new IllegalArgumentException("Description cannot be longer than 50 characters!");
		}
	}
	
	public Appointment(String appointmentId, Date date, String description) {
		verifyIdRequirements(appointmentId);
		verifyDateRequirements(date);
		verifyDescriptionRequirements(description);

		this.appointmentId = appointmentId;
		this.date = date;
		this.description = description;
	}
	
}
