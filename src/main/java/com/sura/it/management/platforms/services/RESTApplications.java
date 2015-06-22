package com.sura.it.management.platforms.services;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sura.it.management.platforms.model.Application;
import com.sura.it.management.platforms.model.ApplicationDataBaseProperties;
import com.sura.it.management.platforms.model.WebApplication;

@Path("/applications")
public class RESTApplications extends RESTService {

	@GET
	@Path("/")
	@Produces( MediaType.APPLICATION_JSON ) 
	public List<Application> listApplications() throws URISyntaxException, SQLException {
		List<Application> list = new ArrayList<Application>();

		WebApplication app1 = new WebApplication();
		app1.setId(1);
		app1.setName("Asistencia");
		app1.setProgrammingLanguage("Java");
		app1.setSecurityType("SEUS");
		app1.setJenkinsName("TestJenkins");
		app1.setSourceQualityProjectURL("www.sonar.com");
		app1.setVersionControlURL("svn.com");
		app1.setContainerName("OC4J_ASISTENCIA");
		app1.setContextName("/asistencia");
		app1.setServerName("mdeapsoas01");
		ApplicationDataBaseProperties dbProperties = new ApplicationDataBaseProperties();
		dbProperties.setDbConnectionUser("adm_asistencia");
		dbProperties.setDbInstanceName("PDN");
		dbProperties.setDbOwnerUser("asistencia");
		dbProperties.setDbType("Oracle");
		app1.setDbProperties(dbProperties);
		
		list.add(app1);
		
		Application app2 = new Application();
		app2.setId(2);
		app2.setAppType("Other");
		app2.setName("MEVI");
		app2.setProgrammingLanguage("Java");
		app2.setSecurityType("SEUS");
		app2.setJenkinsName("TestJenkinsMEVI");
		app2.setSourceQualityProjectURL("www.sonar.com/mevi");
		app2.setVersionControlURL("svn.com/mevi");
		ApplicationDataBaseProperties dbProperties2 = new ApplicationDataBaseProperties();
		dbProperties2.setDbConnectionUser("adm_mevi");
		dbProperties2.setDbInstanceName("PDN");
		dbProperties2.setDbOwnerUser("mevi");
		dbProperties2.setDbType("Oracle");
		app2.setDbProperties(dbProperties);
		
		list.add(app2);
		
		processResponse();
		return list;
	}

}
