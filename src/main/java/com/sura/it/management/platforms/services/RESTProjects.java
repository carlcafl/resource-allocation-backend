package com.sura.it.management.platforms.services;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.sura.it.management.platforms.dataAccess.PlatformsDataAccess;
import com.sura.it.management.platforms.dataAccess.ProjectsDataAccess;
import com.sura.it.management.platforms.model.Platform;
import com.sura.it.management.platforms.model.Project;
import com.sura.it.management.platforms.model.ProjectPlatform;
import com.sura.it.management.platforms.model.ProjectSize;

@Path("/projects")
public class RESTProjects extends RESTService {

	@GET
	@Path("/")
	//@Consumes( "application/json" )
	@Produces( "application/json" ) 
	public List<Project> listProjects() throws URISyntaxException, SQLException {
		List<Project> list = new ArrayList<Project>();

		list = ProjectsDataAccess.listProjects();
		
		processResponse();
		return list;
	}
}
