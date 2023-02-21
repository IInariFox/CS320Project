package main;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.awt.List;
import java.util.ArrayList;
import java.util.UUID;

public class ContactService {
	private static ArrayList<Contact> contacts = new ArrayList<Contact>();

	private static Long count = new Long(0);
	private static String generateUniqueId() throws Exception {
		count++;
		String newId = Long.toString(count);
		if (newId.length() <= 10) {
			return newId;
		} else {
			throw new Exception("You have reached the limit");
		}
	}
	
	// add contact
	public static void addContact() throws Exception {
		Contact newContact = new Contact(generateUniqueId(), "first", "last", "1234567890", "Main st");
		contacts.add(newContact);
	}



	public static int readContactSize() {
		return contacts.size();
	}
	
	public static void deleteContact(String id) {
		for (int i = 0; i < contacts.size(); i++) {
			if (contacts.get(i).getContactId().equals(id)) {
				contacts.remove(i);
			}
		}
	}
	
	public static void updateContact(String id, String firstName, String lastName, String phoneNumber, String userAddress) {
		for (int i = 0; i < contacts.size(); i++) {
			if (contacts.get(i).getContactId().equals(id)) {
				contacts.get(i).setFirstName(firstName);
				contacts.get(i).setLastName(lastName);
				contacts.get(i).setPhoneNumber(phoneNumber);
				contacts.get(i).setUserAddress(userAddress);
			}
		}
	}
	

	public static boolean checkUpdateSuccessful(String id, String firstName, String lastName, String phoneNumber, String userAddress) {
		boolean passed = false;
		for (int i = 0; i < contacts.size(); i++) {
			if (contacts.get(i).getContactId().equals(id) &&
				contacts.get(i).getFirstName().equals(firstName) &&
				contacts.get(i).getLastName().equals(lastName) &&
				contacts.get(i).getPhoneNumber().equals(phoneNumber) &&
				contacts.get(i).getUserAddress().equals(userAddress)) {
				passed = true;
			}
		}
		return passed;
	}
}
