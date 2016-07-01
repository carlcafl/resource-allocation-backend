package com.sura.it.management.platforms.facades;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

import com.sura.it.management.platforms.dataAccess.ApplicationsDataAccess;
import com.sura.it.management.platforms.dataAccess.DepartmentsDataAccess;
import com.sura.it.management.platforms.model.Application;
import com.sura.it.management.platforms.model.Department;

public class DepartmentFacade {

	public static List<Department> getAll() throws URISyntaxException, SQLException {
		return DepartmentsDataAccess.listAll();
	}

	public static List<Department> getDepartmentsByType(String departmentType) throws URISyntaxException, SQLException {
		return DepartmentsDataAccess.getByDepartmentType(departmentType);
	}
	
	public static Department getDepartment(int id) throws URISyntaxException, SQLException {
		return DepartmentsDataAccess.getById(id);
	}

}
