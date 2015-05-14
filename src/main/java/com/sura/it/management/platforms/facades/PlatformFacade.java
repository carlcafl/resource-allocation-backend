package com.sura.it.management.platforms.facades;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.sura.it.management.platforms.dataAccess.CapacityDataAccess;
import com.sura.it.management.platforms.dataAccess.PlatformsDataAccess;
import com.sura.it.management.platforms.model.Platform;
import com.sura.it.management.platforms.model.PlatformCapacity;
import com.sura.it.management.platforms.model.ProjectTeamMember;
import com.sura.it.management.platforms.model.enumerations.ProjectSize;
import com.sura.it.management.platforms.model.enumerations.TeamMemberRole;

public class PlatformFacade {
	
	public static PlatformCapacity getCurrentCapacity(Platform platform) throws URISyntaxException, SQLException {
//		PlatformCapacity capacity = new PlatformCapacity();
//		capacity.setPlatform(platform);
//		capacity.setMaintenanceCapacity(0.4f);
//		capacity.setSupportCapacity(1.6f);
		PlatformCapacity capacity = CapacityDataAccess.getByPlatformId(platform.getId()); 
		/*if (capacity==null) {
			throw new SQLException("No se encontró capacidad configurada para la plataforma " + platform.getName());
		}*/
		
		List<ProjectTeamMember> projectCapacity = new ArrayList<ProjectTeamMember>();
		
		ProjectTeamMember tm = new ProjectTeamMember();
		tm.setId(1);
		tm.setCapacity(0.5f);
		tm.setName("Johan Ruíz");
		tm.setRole(TeamMemberRole.Architect);
		projectCapacity.add(tm);
		
		ProjectTeamMember tm2 = new ProjectTeamMember();
		tm2.setId(1);
		tm2.setCapacity(1f);
		tm2.setName("Carlos Carmona");
		tm2.setRole(TeamMemberRole.TeamMember);
		projectCapacity.add(tm2);

		capacity.setProjectCapacity(projectCapacity);
		
		Hashtable<ProjectSize,Float> capacityConfiguration = new Hashtable<ProjectSize,Float>();
		capacityConfiguration.put(ProjectSize.XL, new Float(1f));
		capacityConfiguration.put(ProjectSize.L, new Float(0.8f));
		capacityConfiguration.put(ProjectSize.M, new Float(0.5f));
		capacityConfiguration.put(ProjectSize.S, new Float(0.3f));
		
		capacity.setCapacityConfiguration(capacityConfiguration);
		
		return capacity;
	}
}
