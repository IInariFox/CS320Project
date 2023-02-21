package test;

import main.Appointment;
import main.AppointmentService;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppointmentServiceTest {
	@Test
	public void testUniqueId() {

		@SuppressWarnings("deprecation")
		Date date = new Date(124, 2, 06, 14, 28, 36); 

		Appointment newAppointment = new Appointment("1", date, "Appointment description");
		AppointmentService.addAppointment(newAppointment);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {

			Appointment newerAppointment = new Appointment("1", date, "Appointment has an id that has already been used");
			AppointmentService.addAppointment(newerAppointment);
		});
	}
	
	@Test
	public void testAddAppointment() {

		@SuppressWarnings("deprecation")
		Date date = new Date(124, 2, 06, 14, 28, 36); 

		Appointment newAppointment = new Appointment("2", date, "Appointment description");
		AppointmentService.addAppointment(newAppointment);

		Assertions.assertTrue(AppointmentService.appointmentExists("2")); 
	}
	
	@Test
	public void testDeleteAppointment() {

		@SuppressWarnings("deprecation")
		Date date = new Date(124, 2, 06, 14, 28, 36); 

		Appointment newAppointment = new Appointment("3", date, "Appointment description");
		AppointmentService.addAppointment(newAppointment);
		AppointmentService.deleteAppointment("3");
		Assertions.assertFalse(AppointmentService.appointmentExists("3"));
	}
	
	@Test
	public void testUpdateAppointment() {

		@SuppressWarnings("deprecation")
		Date date = new Date(124, 2, 06, 14, 28, 36); 

		Appointment newAppointment = new Appointment("4", date, "Appointment description");
		AppointmentService.addAppointment(newAppointment);


		@SuppressWarnings("deprecation")
		Date newDate = new Date(127, 2, 06, 14, 28, 36); 
		AppointmentService.updateAppointment("4", newDate, "this appointment has been updated");

		Object compareMe = AppointmentService.readAppointment("4");

		Assertions.assertTrue(
				((Appointment) compareMe).getAppointmentDate().equals(newDate) && ((Appointment) compareMe).getAppointmentDescription().equals("this appointment has been updated")
		);
	}
	
	@Test
	public void testReadAppointmentNotFound() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			AppointmentService.readAppointment("237");
		});
	} 
	
}