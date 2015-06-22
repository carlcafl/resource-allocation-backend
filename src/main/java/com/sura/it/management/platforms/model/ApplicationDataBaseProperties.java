package com.sura.it.management.platforms.model;

public class ApplicationDataBaseProperties {

	private String dbType = null;
	private String dbInstanceName = null;
	private String dbOwnerUser = null;
	private String dbConnectionUser = null;
	
	public String getDbType() {
		return dbType;
	}
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
	public String getDbInstanceName() {
		return dbInstanceName;
	}
	public void setDbInstanceName(String dbInstanceName) {
		this.dbInstanceName = dbInstanceName;
	}
	public String getDbOwnerUser() {
		return dbOwnerUser;
	}
	public void setDbOwnerUser(String dbOwnerUser) {
		this.dbOwnerUser = dbOwnerUser;
	}
	public String getDbConnectionUser() {
		return dbConnectionUser;
	}
	public void setDbConnectionUser(String dbConnectionUser) {
		this.dbConnectionUser = dbConnectionUser;
	}

}
