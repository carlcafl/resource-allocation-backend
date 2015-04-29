package com.sura.it.management.platforms.services;

import java.util.ArrayList;
import java.util.List;

//import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.sura.it.management.platforms.model.Platform;

@Path("/platforms")
public class RESTPlatforms {

	
	@GET
	//@Consumes( "application/json" )
	@Produces( "application/json" ) 
	public List<Platform> list() {
		System.out.println(this.getClass().getName() + "--> Entró");
		List<Platform> list = new ArrayList<Platform>();
		
		Platform p = new Platform();
		p.setId(1);
		p.setName("Core de Seguros");
		p.setShortName("CORE_SEG");
		
		return list;
	}

}
