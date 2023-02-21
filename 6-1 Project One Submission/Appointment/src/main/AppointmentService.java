package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppointmentService {
	private static List<Appointment> appointments = new ArrayList<Appointment>();
	
 	public static List<String> idList = new ArrayList<String>();
	
 	public static void addAppointment(Object appointment) {

		appointments.add((Appointment) appointment);

		for (int i = 0; i < idList.size(); i++) {
			if (((Appointment) appointment).getAppointmentId().equals(idList.get(i))) {
				throw new IllegalArgumentException("Not a unique ID!");
			}
		}

		idList.add(((Appointment) appointment).getAppointmentId());
	}
	

	public static boolean appointmentExists(String appointmentId) {

		for (int i = 0; i < appointments.size(); i++) {
			if (appointments.get(i).getAppointmentId().equals(appointmentId)) {
				return true;
			}
		}
		return false;
	}
	

	public static Object readAppointment(String appointmentId) {
		for (int i = 0; i < appointments.size(); i++) {
			if (appointments.get(i).getAppointmentId().equals(appointmentId)) {
				return appointments.get(i);
			}
		}
		throw new IllegalArgumentException("Appointment not found");
	}
	

	public static void updateAppointment(String appointmentId, Date appointmentDate, String appointmentDescription) {

		for (int i = 0; i < appointments.size(); i++) {
			if (appointments.get(i).getAppointmentId().equals(appointmentId)) {
				appointments.get(i).setAppointmentDate(appointmentDate);
				appointments.get(i).setAppointmentDescription(appointmentDescription);
			}
		}
	}
	

	public static void deleteAppointment(String appointmentId) {

		for (int i = 0; i < appointments.size(); i++) {
			if (appointments.get(i).getAppointmentId().equals(appointmentId)) {
				appointments.remove(i);
			}
		}
	}
}
