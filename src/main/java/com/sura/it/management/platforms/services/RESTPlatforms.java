package com.sura.it.management.platforms.services;

import java.util.ArrayList;
import java.util.List;

//import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.sura.it.management.platforms.model.Platform;

@Path("/platforms")
public class RESTPlatforms {

	
	@GET
	@Path("/")
	//@Consumes( "application/json" )
	@Produces( "application/json" ) 
	public List<Platform> listPlatforms() {
		List<Platform> list = new ArrayList<Platform>();

		Platform p = new Platform();
		p.setId(1);
		p.setName("Core de Seguros");
		p.setShortName("CORE_SEG");				
		list.add(p);
 
		Platform p2 = new Platform();
		p2.setId(2);
		p2.setName("Automatización de Procesos");
		p2.setShortName("AUTOM_PROC");
		list.add(p2);
		
		return list;
	}

	@GET
	@Path("/{id}")
	//@Consumes( "application/json" )
	@Produces( "application/json" ) 
	public List<Platform> getPlatform(@PathParam("id") String id) {
		List<Platform> list = new ArrayList<Platform>();
		if ("1".equals(id)) {
			Platform p = new Platform();
			p.setId(1);
			p.setName("Core de Seguros");
			p.setShortName("CORE_SEG");				
			list.add(p);
		}		
		return list;
	}
}
