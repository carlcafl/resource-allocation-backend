package com.sura.it.management.platforms.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Project {

	private int id;
	private String name;
	private Platform leaderPlatform;
	private String leadAnalyst;
	private String leadAnalystEmail;
	private Date start;
	private Date finish;
	//TODO: Definir tipo de dato
	private String status;
	private ProjectSize size;
	private List<ProjectPlatform> platformsInvolved;
	
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
	public Platform getLeaderPlatform() {
		return leaderPlatform;
	}
	public void setLeadPlatform(Platform leaderPlatform) {
		this.leaderPlatform = leaderPlatform;
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
	public ProjectSize getSize() {
		return size;
	}
	public void setSize(ProjectSize size) {
		this.size = size;
	}
	public List<ProjectPlatform> getPlatformsInvolved() {
		return platformsInvolved;
	}
	public void setPlatformsInvolved(List<ProjectPlatform> platformsInvolved) {
		this.platformsInvolved = platformsInvolved;
	}
	public void addPlatformInvolved(ProjectPlatform platform) {
		if (this.getPlatformsInvolved() == null) {
			this.setPlatformsInvolved(new ArrayList<ProjectPlatform>());
		}
		this.getPlatformsInvolved().add(platform);
	}
	public String getLeadAnalyst() {
		return leadAnalyst;
	}
	public void setLeadAnalyst(String leadAnalyst) {
		this.leadAnalyst = leadAnalyst;
	}
	public String getLeadAnalystEmail() {
		return leadAnalystEmail;
	}
	public void setLeadAnalystEmail(String leadAnalystEmail) {
		this.leadAnalystEmail = leadAnalystEmail;
	}
}
