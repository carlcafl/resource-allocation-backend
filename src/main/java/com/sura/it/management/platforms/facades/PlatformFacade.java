package com.sura.it.management.platforms.facades;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

import com.sura.it.management.platforms.dataAccess.CapacityDataAccess;
import com.sura.it.management.platforms.model.Platform;
import com.sura.it.management.platforms.model.PlatformCapacity;
import com.sura.it.management.platforms.model.ProjectTeamMember;

public class PlatformFacade {
	
	public static PlatformCapacity getMaxCapacity(Platform platform) throws URISyntaxException, SQLException {
		PlatformCapacity capacity = CapacityDataAccess.getByPlatformId(platform.getId()); 
		return capacity;
	}

	public static List<ProjectTeamMember> getAssignedProjectCapacity(Platform platform) throws URISyntaxException, SQLException {
		List<ProjectTeamMember> capacity = CapacityDataAccess.getAssignedCapacityByPlatformId(platform.getId()); 
		return capacity;
	}
	
	public static List<ProjectTeamMember> getCurrentProjectCapacity(Platform platform) throws URISyntaxException, SQLException {
		List<ProjectTeamMember> capacity = CapacityDataAccess.getAssignedCapacityByPlatformId(platform.getId());
		PlatformCapacity maximumCapacity = CapacityDataAccess.getByPlatformId(platform.getId()); 
		
		for (ProjectTeamMember teamMember : capacity) {
			for (ProjectTeamMember teamMemberConfig : maximumCapacity.getProjectCapacity()) {
				if (teamMemberConfig.getId() == teamMember.getId()) {
					teamMember.setCapacity( teamMemberConfig.getCapacity() - teamMember.getCapacity() );
					break;
				}
			}
		}
		
		return capacity;
	}
}
