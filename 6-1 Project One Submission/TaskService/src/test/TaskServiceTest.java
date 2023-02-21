package test;

import main.Task;
import main.TaskService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {
	@Test
	public void testUniqueId() {
		Task newTask = new Task("1", "New Task", "Task description");
		TaskService.addTask(newTask);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task newerTask = new Task("1", "New Task", "Task has an id that has already been used");
			TaskService.addTask(newerTask);
		});
	}
	
	@Test
	public void testAddTask() {
		Task newTask = new Task("2", "New Task", "Task description");
		TaskService.addTask(newTask);
		Assertions.assertTrue(TaskService.taskExists("2")); 
	}
	
	@Test
	public void testDeleteTask() {
		Task newTask = new Task("3", "New Task", "Task description");
		TaskService.addTask(newTask);
		TaskService.deleteTask("3");
		Assertions.assertFalse(TaskService.taskExists("3"));
	}
	
	@Test
	public void testUpdateTask() {
		Task newTask = new Task("4", "New Task", "Task description");
		TaskService.addTask(newTask);
		TaskService.updateTask("4", "updated task", "this task has been updated");
		Object compareMe = TaskService.readTask("4");
		Assertions.assertTrue(
				((Task) compareMe).getTaskName().equals("updated task") && ((Task) compareMe).getTaskDescription().equals("this task has been updated")
		);
	}
	
	@Test
	public void testReadTaskNotFound() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskService.readTask("789");
		});
	}
}
