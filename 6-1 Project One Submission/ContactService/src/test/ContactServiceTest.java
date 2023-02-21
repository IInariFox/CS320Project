package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.ContactService;

public class ContactServiceTest {

	@Test
	public void contactAddedSuccessfully() throws Exception {
		int listSize = ContactService.readContactSize();
		int expectedSize = listSize + 1;
		ContactService.addContact();
		int actualSize = ContactService.readContactSize();
		Assertions.assertEquals(expectedSize, actualSize);
	}
	
	@Test
	public void deleteContactSuccessfully() throws Exception {
		ContactService.addContact();
		ContactService.addContact();
		ContactService.addContact();
		ContactService.deleteContact("2");
		Assertions.assertTrue(ContactService.readContactSize() == 2);
	}
	
	@Test
	public void updateContactSuccessfully() throws Exception {
		ContactService.addContact();
		ContactService.updateContact("1", "John", "Snow", "9999999999", "Main St");
		Assertions.assertTrue(ContactService.checkUpdateSuccessful("1", "John", "Snow", "9999999999", "Main St"));
	}
}
