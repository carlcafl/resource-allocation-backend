package com.sura.it.management.platforms.services;

import java.util.ArrayList;
import java.util.List;

//import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.sura.it.management.platforms.model.Platform;


public class RESTPlatforms {

	
	@GET
	@Path("/platforms/{id}")
	//@Consumes( "application/json" )
	@Produces( "application/json" ) 
	public List<Platform> getPlatforms(@PathParam("id") String id) {
		List<Platform> list = new ArrayList<Platform>();
		if (id==null || "1".equals(id)) {
			Platform p = new Platform();
			p.setId(1);
			p.setName("Core de Seguros");
			p.setShortName("CORE_SEG");				
			list.add(p);
		}
		
		return list;
	}

}
