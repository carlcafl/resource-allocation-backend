package com.sura.it.management.platforms.services;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sura.it.management.platforms.dataAccess.ProjectsDataAccess;
import com.sura.it.management.platforms.model.Project;

@Path("/projects")
public class RESTProjects extends RESTService {

	@GET
	@Path("/")
	@Produces( MediaType.APPLICATION_JSON ) 
	public List<Project> listProjects() throws URISyntaxException, SQLException {
		List<Project> list = new ArrayList<Project>();

		list = ProjectsDataAccess.listAll();
		
		processResponse();
		return list;
	}
}
