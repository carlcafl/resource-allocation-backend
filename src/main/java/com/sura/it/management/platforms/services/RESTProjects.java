package com.sura.it.management.platforms.services;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.sura.it.management.platforms.dataAccess.PlatformsDataAccess;
import com.sura.it.management.platforms.model.Platform;
import com.sura.it.management.platforms.model.Project;
import com.sura.it.management.platforms.model.ProjectPlatform;
import com.sura.it.management.platforms.model.ProjectSize;

@Path("/projects")
public class RESTProjects extends RESTService {

	@GET
	@Path("/")
	//@Consumes( "application/json" )
	@Produces( "application/json" ) 
	public List<Project> listProjects() throws URISyntaxException, SQLException {
		List<Project> list = new ArrayList<Project>();

		//list = PlatformsDataAccess.listPlatforms();
		
		Project a = new Project();
		a.setId(1);
		a.setName("Evaluación del Core");
		a.setLeader("David Cardona");
		a.setSize(ProjectSize.XLARGE);
		Platform p = PlatformsDataAccess.getPlatformById(1);
		ProjectPlatform pp = new ProjectPlatform();
		pp.setPlatform(p);
		pp.setSize(ProjectSize.XLARGE);
		a.addPlatformInvolved(pp);
		

		Project b = new Project();
		b.setId(2);
		b.setName("Rediseño MVEE Autos");
		b.setLeader("Mildred Marín");
		b.setSize(ProjectSize.LARGE);
		Platform p2 = PlatformsDataAccess.getPlatformById(2);
		ProjectPlatform pp2 = new ProjectPlatform();
		pp2.setPlatform(p2);
		pp2.setSize(ProjectSize.LARGE);
		b.addPlatformInvolved(pp2);
		b.addPlatformInvolved(pp);

		list.add(a);
		list.add(b);
		
		processResponse();
		return list;
	}
}
