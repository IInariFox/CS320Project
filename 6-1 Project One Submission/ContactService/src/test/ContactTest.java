package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.Contact;

class ContactTest {
	
	@Test
	public void IdLongerThanTen() {
		Assertions.assertThrows(ArithmeticException.class, () -> {
			Contact newContact = new Contact("455678765456765578", "John", "Smith", "1234567890", "Main St");
		});
	}
	
	@Test
	public void firstNameLongerThanTen() {
		Assertions.assertThrows(ArithmeticException.class, () -> {
			Contact newContact = new Contact("455578", "Too Long", "heff", "1234567890", "Main St");
		});
	}
	
	@Test
	public void lastNameLongerThanTen() {
		Assertions.assertThrows(ArithmeticException.class, () -> {
			Contact newContact = new Contact("455578", "first", "Too Long", "1234567890", "100 ave");
		});
	}
	
	@Test
	public void phoneNumberMoreThanTen() {
		Assertions.assertThrows(ArithmeticException.class, () -> {
			Contact newContact = new Contact("455578", "first", "last", "12345678945670", "Congress Ave");
		});
	}
	
	@Test
	public void phoneNumberLessThanTen() {
		Assertions.assertThrows(ArithmeticException.class, () -> {
			Contact newContact = new Contact("455578", "first", "last", "123670", "Congress Ave");
		});
	}
	
	@Test
	public void addressMoreThanThirtyCharacters() {
		Assertions.assertThrows(ArithmeticException.class, () -> {
			Contact newContact = new Contact("455578", "first", "last", "12345678945670", "Too long");
		});
	}
	
	@Test
	public void testIdNull() {
		Assertions.assertThrows(ArithmeticException.class, () -> {
			Contact newContact = new Contact(null, "first", "last", "12345678945670", "Too long");
		});
	}
	
	@Test
	public void testFirstNull() {
		Assertions.assertThrows(ArithmeticException.class, () -> {
			Contact newContact = new Contact("45678", null, "last", "12345678945670", "Too long");
		});
	}
	
	@Test
	public void testLastNull() {
		Assertions.assertThrows(ArithmeticException.class, () -> {
			Contact newContact = new Contact("45678", "first", null, "12345678945670", "Too long");
		});
	}
	
	@Test
	public void testPhoneNull() {
		Assertions.assertThrows(ArithmeticException.class, () -> {
			Contact newContact = new Contact("45678", "first", "last", null, "Too long");
		});
	}
	
	@Test
	public void testAddressNull() {
		Assertions.assertThrows(ArithmeticException.class, () -> {
			Contact newContact = new Contact("45678", "first", "last", "1234567890", null);
		});
	}
	
	@Test
	public void firstNameUpdatable() {
		Contact newContact = new Contact("12345", "John", "Smith", "1234567890", "Main St");
		newContact.setFirstName("Ted");
		Assertions.assertEquals("Ted", newContact.getFirstName());
	}
	
	@Test
	public void lastNameUpdatable() {
		Contact newContact = new Contact("12345", "John", "Smith", "1234567890", "Main St");
		newContact.setLastName("Hoffman");
		Assertions.assertEquals("Hoffman", newContact.getLastName());
	}
	
	@Test
	public void phoneNumberUpdatable() {
		Contact newContact = new Contact("12345", "John", "Smith", "1234567890", "Main St");
		newContact.setPhoneNumber("0987654321");
		Assertions.assertEquals("0987654321", newContact.getPhoneNumber());
	}
	
	@Test
	public void addressUpdatable() {
		Contact newContact = new Contact("12345", "John", "Smith", "1234567890", "Congress Ave");
		newContact.setUserAddress("Main St");
		Assertions.assertEquals("Main St", newContact.getUserAddress());
	}
	
	@Test
	public void idGettable() {
		Contact newContact = new Contact("12345", "John", "Smith", "1234567890", "Congress Ave");
		Assertions.assertEquals("12345", newContact.getContactId());
	}

}
