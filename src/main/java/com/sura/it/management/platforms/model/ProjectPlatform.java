package com.sura.it.management.platforms.model;

import java.util.Date;

public class ProjectPlatform {

	private Platform platform;
	private ProjectSize size;
	private Date start;
	private Date finish;
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
}
