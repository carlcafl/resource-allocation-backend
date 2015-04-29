package com.sura.it.management.platforms.services;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.sura.it.management.platforms.dataAccess.PlatformsDataAccess;
import com.sura.it.management.platforms.model.Platform;

@Path("/platforms")
public class RESTPlatforms {

	
	@GET
	@Path("/")
	//@Consumes( "application/json" )
	@Produces( "application/json" ) 
	public List<Platform> listPlatforms() throws URISyntaxException, SQLException {
		List<Platform> list = new ArrayList<Platform>();

		list = PlatformsDataAccess.listPlatforms();
		
		return list;
	}

	@GET
	@Path("/{id}")
	//@Consumes( "application/json" )
	@Produces( "application/json" ) 
	public Platform getPlatform(@PathParam("id") int id) throws URISyntaxException, SQLException {
		Platform platform = new Platform();
		PlatformsDataAccess.getPlatformById(id);
		return platform;
	}
}
