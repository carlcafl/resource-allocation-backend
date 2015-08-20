package com.sura.it.management.platforms.facades;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

import com.sura.it.management.platforms.dataAccess.ApplicationsDataAccess;
import com.sura.it.management.platforms.model.Application;

public class ApplicationFacade {
	
	public static List<Application> getAll() throws URISyntaxException, SQLException {
		return ApplicationsDataAccess.listAll();
	}

	public static List<Application> getApplicationsByPlatform(int platformId) throws URISyntaxException, SQLException {
		return ApplicationsDataAccess.getByPlatformId(platformId);
	}
	
	public static Application getApplication(int id) throws URISyntaxException, SQLException {
		return ApplicationsDataAccess.getById(id);
	}

}
