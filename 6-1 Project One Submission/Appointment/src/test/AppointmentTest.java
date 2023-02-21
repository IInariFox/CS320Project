package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.Appointment;

import java.util.Date;
import java.io.*;

class AppointmentTest { 

	@Test
	void testIdNull() {
		Date date = new Date();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment appointment = new Appointment(null, date, "A whole bunch of stuff and things");
		});
	}
	
	@Test
	void testIdTooLong() {
		Date date = new Date();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment appointment = new Appointment("12345678910", date, "A whole bunch of stuff and things");
		});
	}
	
	@Test
	void testDateNull() {
		Date date = new Date();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment appointment = new Appointment("123456789", null, "A whole bunch of stuff and things");
		});
	}
	
	@Test
	void testDateInPast() throws InterruptedException {
		Date date = new Date();
        Thread.sleep(1000);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment appointment = new Appointment("123456789", date, "A whole bunch of stuff and things");
		});
	}
	
	@Test
	void testDescriptionNull() {
		Date date = new Date();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment appointment = new Appointment("123456789", date, null);
		});
	}
	
	@Test
	void testDescriptionTooLong() {
		Date date = new Date();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment appointment = new Appointment("12345678910", date, "Too long");
		});
	}

}
