package com.sura.it.management.platforms.services;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.sura.it.management.platforms.dataAccess.PlatformsDataAccess;
import com.sura.it.management.platforms.model.Platform;
//import javax.ws.rs.Consumes;

@Path("/platforms")
public class RESTPlatforms extends RESTService {

  
	@GET
	@Path("/")
	//@Consumes( "application/json" )
	@Produces( "application/json" ) 
	public List<Platform> listPlatforms() throws URISyntaxException, SQLException {
		List<Platform> list = new ArrayList<Platform>();

		list = PlatformsDataAccess.listPlatforms();
		processResponse();
		return list;
	}

	@GET
	@Path("/{id}")
	//@Consumes( "application/json" )
	@Produces( "application/json" ) 
	public Platform getPlatform(@PathParam("id") int id) throws URISyntaxException, SQLException {
		processResponse();
		return PlatformsDataAccess.getPlatformById(id);
	}
	
	@POST
	@Path("/")
	@Consumes("application/json")
	//@Produces("application/json")
	public void addNew(Platform platform) throws URISyntaxException, SQLException {	
		int id = PlatformsDataAccess.insertNewPlatform(platform);
		platform.setId(id);
		processResponse();
		response.addHeader("Location", "/platforms/" + id);
		response.setStatus(201);
	}
	
}
