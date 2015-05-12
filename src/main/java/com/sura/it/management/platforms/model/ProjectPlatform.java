package com.sura.it.management.platforms.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sura.it.management.platforms.model.enumerations.ProjectSize;

public class ProjectPlatform {

	private Platform platform;
	private ProjectSize size;
	private Date start;
	private Date finish;
	private List<ProjectTeamMember> teamMembers;
	
	public Platform getPlatform() {
		return platform;
	}
	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
	public ProjectSize getSize() {
		return size;
	}
	public void setSize(ProjectSize size) {
		this.size = size;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getFinish() {
		return finish;
	}
	public void setFinish(Date finish) {
		this.finish = finish;
	}
	public List<ProjectTeamMember> getTeamMembers() {
		return teamMembers;
	}
	public void setTeamMembers(List<ProjectTeamMember> teamMembers) {
		this.teamMembers = teamMembers;
	}
	public void addTeamMember(ProjectTeamMember teamMember) {
		if (this.getTeamMembers() == null)
			this.setTeamMembers(new ArrayList<ProjectTeamMember>());
		this.getTeamMembers().add(teamMember);
	}
}
