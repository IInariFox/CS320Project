package main;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
	private static List<Task> tasks = new ArrayList<Task>();

	public static List<String> idList = new ArrayList<String>();
	
	public static void addTask(Object task) {
		tasks.add((Task) task);
		for (int i = 0; i < idList.size(); i++) {
			if (((Task) task).getTaskId().equals(idList.get(i))) {
				throw new IllegalArgumentException("Not a unique ID!");
			}
		}
		idList.add(((Task) task).getTaskId());
	}
	
	public static boolean taskExists(String taskId) {
		for (int i = 0; i < tasks.size(); i++) {
			if (tasks.get(i).getTaskId().equals(taskId)) {
				return true;
			}
		}
		return false;
	}
	
	public static Object readTask(String taskId) {
		for (int i = 0; i < tasks.size(); i++) {
			if (tasks.get(i).getTaskId().equals(taskId)) {
				return tasks.get(i);
			}
		}
		throw new IllegalArgumentException("Task not found");
	}
	
	public static void updateTask(String taskId, String taskName, String taskDescription) {
		for (int i = 0; i < tasks.size(); i++) {
			if (tasks.get(i).getTaskId().equals(taskId)) {
				tasks.get(i).setTaskName(taskName);
				tasks.get(i).setTaskDescription(taskDescription);
			}
		}
	}
	
	public static void deleteTask(String taskId) {
		for (int i = 0; i < tasks.size(); i++) {
			if (tasks.get(i).getTaskId().equals(taskId)) {
				tasks.remove(i);
			}
		}
	}
}
