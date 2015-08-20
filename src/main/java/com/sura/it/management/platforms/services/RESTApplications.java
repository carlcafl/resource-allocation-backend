package com.sura.it.management.platforms.services;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sura.it.management.platforms.facades.ApplicationFacade;
import com.sura.it.management.platforms.model.Application;

@Path("/applications")
public class RESTApplications extends RESTService {

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON ) 
	public List<Application> listApplications() throws URISyntaxException, SQLException {
		List<Application> list = new ArrayList<Application>();
		processResponse();
		list = ApplicationFacade.getAll();
		return list;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON ) 
	public Application getApplication(@PathParam("id") int id) throws URISyntaxException, SQLException {
		Application application = new Application();
		processResponse();
		application = ApplicationFacade.getApplication(id);
		return application;
	}

}
