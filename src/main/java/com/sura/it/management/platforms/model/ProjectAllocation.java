package com.sura.it.management.platforms.model;

import java.util.List;

import com.sura.it.management.platforms.model.util.ValidationMessage;

public class ProjectAllocation {

	private Project project = null;
	private List<ValidationMessage> messages = null;
	
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public List<ValidationMessage> getMessages() {
		return messages;
	}
	public void setMessages(List<ValidationMessage> messages) {
		this.messages = messages;
	}
	
	
}
