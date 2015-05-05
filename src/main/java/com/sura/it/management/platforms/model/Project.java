package com.sura.it.management.platforms.model;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;;

public class Project {

	private int id;
	private String name;
	private String leader;
	private Date start;
	private Date finish;
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
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
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
}
