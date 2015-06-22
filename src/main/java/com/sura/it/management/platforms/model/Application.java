package com.sura.it.management.platforms.model;

public class Application extends Component {

	private String appType = null;
	private String programmingLanguage = null;
	private ApplicationDataBaseProperties dbProperties = null;
	private String securityType = null;
	private String versionControlURL = null;
	private String jenkinsName = null;
	private String sourceQualityProjectURL = null;

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public String getProgrammingLanguage() {
		return programmingLanguage;
	}

	public void setProgrammingLanguage(String programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}

	public ApplicationDataBaseProperties getDbProperties() {
		return dbProperties;
	}

	public void setDbProperties(ApplicationDataBaseProperties dbProperties) {
		this.dbProperties = dbProperties;
	}

	public String getVersionControlURL() {
		return versionControlURL;
	}

	public void setVersionControlURL(String versionControlURL) {
		this.versionControlURL = versionControlURL;
	}

	public String getSecurityType() {
		return securityType;
	}

	public void setSecurityType(String securityType) {
		this.securityType = securityType;
	}

	public String getJenkinsName() {
		return jenkinsName;
	}

	public void setJenkinsName(String jenkinsName) {
		this.jenkinsName = jenkinsName;
	}

	public String getSourceQualityProjectURL() {
		return sourceQualityProjectURL;
	}

	public void setSourceQualityProjectURL(String sourceQualityProjectURL) {
		this.sourceQualityProjectURL = sourceQualityProjectURL;
	}
	
}
