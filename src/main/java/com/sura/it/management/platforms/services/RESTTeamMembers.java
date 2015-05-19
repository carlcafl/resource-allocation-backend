package com.sura.it.management.platforms.services;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sura.it.management.platforms.dataAccess.CapacityDataAccess;
import com.sura.it.management.platforms.dataAccess.PlatformsDataAccess;
import com.sura.it.management.platforms.model.Platform;
import com.sura.it.management.platforms.model.ProjectTeamMember;

@Path("/teamMembers")
public class RESTTeamMembers extends RESTService {

	@OPTIONS
	@Path("/")
	public Response doOptions() {
		processResponse();
		return Response.ok().build();
	}

	@GET
	@Path("/{id}/capacity/assigned")
	@Produces( MediaType.APPLICATION_JSON ) 
	public List<ProjectTeamMember> getAssignedCapacity(@PathParam("id") int id) throws URISyntaxException, SQLException {
		processResponse();
		return CapacityDataAccess.getAssignedCapacityByTeamMember(id);
	}

}
