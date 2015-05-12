package com.sura.it.management.platforms.services;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sura.it.management.platforms.dataAccess.PlatformsDataAccess;
import com.sura.it.management.platforms.model.Platform;

@Path("/platforms")
public class RESTPlatforms extends RESTService {

  
	@GET
	@Path("/")
	@Produces( MediaType.APPLICATION_JSON ) 
	public List<Platform> listPlatforms() throws URISyntaxException, SQLException {
		List<Platform> list = new ArrayList<Platform>();

		list = PlatformsDataAccess.listAll();
		processResponse();
		return list;
	}

	@GET
	@Path("/{id}")
	@Produces( MediaType.APPLICATION_JSON ) 
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

	@OPTIONS
	@Path("/")
	public Response doOptions() {
		processResponse();
		return Response.ok().build();
	}
	
}
