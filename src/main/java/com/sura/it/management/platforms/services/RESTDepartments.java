package com.sura.it.management.platforms.services;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sura.it.management.platforms.dataAccess.DepartmentsDataAccess;
import com.sura.it.management.platforms.model.Department;

@Path("/departments")
public class RESTDepartments extends RESTService {

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
	public List<Department> listDepartments() throws URISyntaxException, SQLException {
		List<Department> list = new ArrayList<Department>();

		list = DepartmentsDataAccess.listAll();
		processResponse();
		return list;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON) 
	public Department getDepartment(@PathParam("id") int id) throws URISyntaxException, SQLException {
		processResponse();
		return DepartmentsDataAccess.getById(id);
	}
	
	@GET
	@Path("/type/{departmentType}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Department> listDepartmentsByType(@PathParam("departmentType") String departmentType)  throws URISyntaxException, SQLException {
		List<Department> list = new ArrayList<Department>();

		list = DepartmentsDataAccess.getByDepartmentType(departmentType);
		processResponse();
		return list;
	}

	@GET
	@Path("/{id}/children")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Department> listDepartmentsByParent(@PathParam("id") int id)  throws URISyntaxException, SQLException {
		List<Department> list = new ArrayList<Department>();

		list = DepartmentsDataAccess.getByParent(id);
		processResponse();
		return list;
	}
}
