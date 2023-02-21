package test;

import main.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {
	void testTask() {
		Task task = new Task("123", "Description", "Read description");
		Assertions.assertTrue(task.getTaskId().equals("123"));
		Assertions.assertTrue(task.getTaskName().equals("Description"));
		Assertions.assertTrue(task.getTaskDescription().equals("Description read"));
	}
		@Test
	void testIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task task = new Task(null, "Description", "Description read");
		});
	}
	
	@Test
	void testNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task task = new Task("123", null, "Description");
		});
	}
	
	@Test
	void testDescriptionNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task task = new Task("123", "Description", null);
		});
	}
	
	@Test
	void testIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task task = new Task("12345678901", "Totally valid", "Description.");
		});
	}
	@Test
	void testNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task task = new Task("123", "Longer than 20 characters", "Description");
		});
	}
	
	@Test
	void testDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task task = new Task("12345678901", "Description", "Description read");
		});
	}
	
	@Test
	void testSetTaskName() {
		Task task = new Task("123", "Description", "Description Read");
		task.setTaskName("Passed");
		Assertions.assertTrue(task.getTaskName().equals("Passed"));
	}
	
	@Test
	void testSetTaskDescription() {
		Task task = new Task("123", "Description", "Description");
		task.setTaskDescription("Passed Description");
		Assertions.assertTrue(task.getTaskDescription().equals("Description passed"));
	}
}
