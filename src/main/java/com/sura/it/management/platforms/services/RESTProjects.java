package com.sura.it.management.platforms.services;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sura.it.management.platforms.dataAccess.ProjectTypeDataAccess;
import com.sura.it.management.platforms.dataAccess.ProjectsDataAccess;
import com.sura.it.management.platforms.model.Project;
import com.sura.it.management.platforms.model.ProjectType;

@Path("/projects")
public class RESTProjects extends RESTService {

	@OPTIONS
	@Path("/")
	public Response doOptions() {
		processResponse();
		return Response.ok().build();
	}

	@OPTIONS
	@Path("/{id}")
	public Response doOptions(@PathParam("id") int id) {
		processResponse();
		return Response.ok().build();
	}
	
	@GET
	@Path("/")
	@Produces( MediaType.APPLICATION_JSON ) 
	public List<Project> listProjects() throws URISyntaxException, SQLException {
		List<Project> list = new ArrayList<Project>();

		list = ProjectsDataAccess.listAll();
		
		processResponse();
		return list;
	}

	@GET
	@Path("/{id}")
	@Produces( MediaType.APPLICATION_JSON ) 
	public Project getProject(@PathParam("id") int id) throws URISyntaxException, SQLException {
		Project project = new Project();
		
		project = ProjectsDataAccess.getById(id);
		
		processResponse();
		return project;
	}

	@GET
	@Path("/types")
	@Produces( MediaType.APPLICATION_JSON ) 
	public List<ProjectType> getProjectTypes() throws URISyntaxException, SQLException {
		List<ProjectType> projectTypes = new ArrayList<ProjectType>();
		
		projectTypes = ProjectTypeDataAccess.listAll();
		
		processResponse();
		return projectTypes;
	}
}
