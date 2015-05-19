package com.sura.it.management.platforms.model;

import java.util.Date;

import com.sura.it.management.platforms.model.enumerations.ProjectSize;
import com.sura.it.management.platforms.model.enumerations.TeamMemberRole;

public class ProjectTeamMember {
	
	private int id;
	private String name;
	private TeamMemberRole role;
	private float capacity;
	private String projectName;
	private ProjectSize projectSize;
	private Date start;
	private Date end;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TeamMemberRole getRole() {
		return role;
	}
	public void setRole(TeamMemberRole role) {
		this.role = role;
	}
	public float getCapacity() {
		return capacity;
	}
	public void setCapacity(float capacity) {
		this.capacity = capacity;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public ProjectSize getProjectSize() {
		return projectSize;
	}
	public void setProjectSize(ProjectSize projectSize) {
		this.projectSize = projectSize;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}

}
