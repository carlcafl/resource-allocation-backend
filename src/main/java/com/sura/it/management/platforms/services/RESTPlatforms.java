package com.sura.it.management.platforms.services;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sura.it.management.platforms.dataAccess.PlatformsDataAccess;
import com.sura.it.management.platforms.facades.ApplicationFacade;
import com.sura.it.management.platforms.facades.PlatformFacade;
import com.sura.it.management.platforms.model.Application;
import com.sura.it.management.platforms.model.Platform;
import com.sura.it.management.platforms.model.PlatformCapacity;
import com.sura.it.management.platforms.model.ProjectTeamMember;

@Path("/platforms")
public class RESTPlatforms extends RESTService {

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
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Platform> listPlatforms() throws URISyntaxException, SQLException {
		List<Platform> list = new ArrayList<Platform>();

		list = PlatformsDataAccess.listAll();
		processResponse();
		return list;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON) 
	public Platform getPlatform(@PathParam("id") int id) throws URISyntaxException, SQLException {
		processResponse();
		return PlatformsDataAccess.getById(id);
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public Response addNew(Platform platform) throws URISyntaxException, SQLException {	
		processResponse();
		int id = PlatformsDataAccess.insertNew(platform);
		platform.setId(id);
		return Response.status(Response.Status.CREATED)
				.header("Location", "/platforms/" + id)
				.entity("/platforms/" + id).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public Response update(@PathParam("id") int id, Platform platform) throws URISyntaxException, SQLException {
		processResponse();
		platform.setId(id);
		PlatformsDataAccess.update(platform);
		return Response.status(Response.Status.OK)
				.entity("/platforms/" + id).build();
	}
	

	@GET
	@Path("/{id}/capacity")
	@Produces(MediaType.APPLICATION_JSON)
	public PlatformCapacity getCapacity(@PathParam("id") int id)  throws URISyntaxException, SQLException {
		processResponse();
		PlatformCapacity capacity = null;
		Platform platform = new Platform();
		platform.setId(id);
		capacity = PlatformFacade.getMaxCapacity(platform);
		return capacity;
	}

	@GET
	@Path("/{id}/applications")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Application> getApplicationsByPlatform(@PathParam("id") int platformId)  throws URISyntaxException, SQLException {
		processResponse();		
		return ApplicationFacade.getApplicationsByPlatform(platformId);
	}

	@GET
	@Path("/{id}/capacity/assigned")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProjectTeamMember> getAssignedCapacity(@PathParam("id") int id)  throws URISyntaxException, SQLException {
		processResponse();
		List<ProjectTeamMember> teamMembers = new ArrayList<ProjectTeamMember>();
		Platform platform = new Platform();
		platform.setId(id);
		teamMembers = PlatformFacade.getAssignedProjectCapacity(platform);
		return teamMembers;
	}
	
}
