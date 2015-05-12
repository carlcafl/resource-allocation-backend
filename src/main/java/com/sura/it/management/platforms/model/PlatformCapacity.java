package com.sura.it.management.platforms.model;

import java.util.Hashtable;
import java.util.List;

import com.sura.it.management.platforms.model.enumerations.ProjectSize;

public class PlatformCapacity {

	private Platform platform = null;
	private float maintenanceCapacity;
	private float supportCapacity;
	private List<ProjectTeamMember> projectCapacity;
	private Hashtable<ProjectSize,Float> capacityConfiguration;
	
	public Platform getPlatform() {
		return platform;
	}
	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
	public float getMaintenanceCapacity() {
		return maintenanceCapacity;
	}
	public void setMaintenanceCapacity(float maintenanceCapacity) {
		this.maintenanceCapacity = maintenanceCapacity;
	}
	public float getSupportCapacity() {
		return supportCapacity;
	}
	public void setSupportCapacity(float supportCapacity) {
		this.supportCapacity = supportCapacity;
	}
	public List<ProjectTeamMember> getProjectCapacity() {
		return projectCapacity;
	}
	public void setProjectCapacity(List<ProjectTeamMember> projectCapacity) {
		this.projectCapacity = projectCapacity;
	}
	public Hashtable<ProjectSize,Float> getCapacityConfiguration() {
		return capacityConfiguration;
	}
	public void setCapacityConfiguration(Hashtable<ProjectSize,Float> capacityConfiguration) {
		this.capacityConfiguration = capacityConfiguration;
	}
	
}
