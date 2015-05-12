package com.sura.it.management.platforms.model;

import com.sura.it.management.platforms.model.enumerations.TeamMemberRole;

public class ProjectTeamMember {
	
	private int id;
	private String name;
	private TeamMemberRole role;
	private float capacity;
	
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

}
