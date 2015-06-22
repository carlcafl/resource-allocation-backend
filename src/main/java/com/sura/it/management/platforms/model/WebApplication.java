package com.sura.it.management.platforms.model;

public class WebApplication extends Application {

	private final String appType = "WEB";
	private String serverName = null;
	private String containerName = null;
	private String contextName = null;
	
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public String getContainerName() {
		return containerName;
	}
	public void setContainerName(String containerName) {
		this.containerName = containerName;
	}
	public String getContextName() {
		return contextName;
	}
	public void setContextName(String contextName) {
		this.contextName = contextName;
	}
	
}
