package main;

public class Task {
	private String taskId;
	private String taskName;
	private String taskDescription;
	
	public String getTaskId() {
		return this.taskId;
	}
	
	public String getTaskName() {
		return this.taskName;
	}
	
	public String getTaskDescription() {
		return this.taskDescription;
	}
	
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	
	private void verifyIdRequirements(String taskId) {
		if (taskId == null) {
			throw new IllegalArgumentException("ID cannot be null");
		}
		if (taskId.length() > 10) {
			throw new IllegalArgumentException("ID too long");
		}
	}
	
	private void verifyNameRequirements(String taskName) {
		if (taskName == null) {
			throw new IllegalArgumentException("Name ! null");
		}
		if (taskName.length() > 20) {
			throw new IllegalArgumentException("Name too long");
		}
	}
	
	private void verifyDescriptionRequirements(String taskDescription) {
		if (taskDescription == null) {
			throw new IllegalArgumentException("Description cannot be null!");
		}
		if (taskDescription.length() > 50) {
			throw new IllegalArgumentException("Description is too long!");
		}
	}

	public Task(String taskId, String taskName, String taskDescription) {
		verifyIdRequirements(taskId);
		verifyNameRequirements(taskName);
		verifyDescriptionRequirements(taskDescription);
		
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
	}
}
