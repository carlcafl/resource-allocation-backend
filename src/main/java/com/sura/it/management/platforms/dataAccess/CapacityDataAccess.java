package com.sura.it.management.platforms.dataAccess;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.sura.it.management.platforms.model.Platform;
import com.sura.it.management.platforms.model.PlatformCapacity;
import com.sura.it.management.platforms.model.ProjectTeamMember;
import com.sura.it.management.platforms.model.enumerations.ProjectSize;
import com.sura.it.management.platforms.model.enumerations.TeamMemberRole;

public class CapacityDataAccess {

	//TODO: Consultar por fecha???
	private static final String GET_CAPACITY_BY_ID_SQL = "SELECT * FROM tblPlatformCapacity WHERE platformId = ";
	private static final String GET_CAPACITY_CONFIG_BY_ID_SQL = "SELECT * FROM tblPlatformProjectConfig WHERE platformId = ";
	private static final String GET_PROJECT_CAPACITY_BY_ID_SQL = "SELECT * FROM tblPlatformProjectCapacity WHERE capacityId = ";
	
	
	public static PlatformCapacity getByPlatformId(int platformId) throws URISyntaxException, SQLException {
		PlatformCapacity capacity = null;

		Connection connection = null;
		try {
			connection = DataServiceHelper.getInstance().getConnection();
			capacity = getByPlatformId(platformId, connection);
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
				}
		}
		return capacity;
	}
	
	protected static PlatformCapacity getByPlatformId(int platformId, Connection connection) throws URISyntaxException, SQLException {
		PlatformCapacity capacity = null;

		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(GET_CAPACITY_BY_ID_SQL + Integer.toString(platformId));
		while (rs.next()) {
			capacity = new PlatformCapacity();
			Platform platform = new Platform();
			platform.setId(platformId);
			capacity.setPlatform(platform);
			capacity.setId(rs.getInt("id"));
			capacity.setMaintenanceCapacity( rs.getFloat("maintenanceCapacity") );
			capacity.setSupportCapacity( rs.getFloat("supportCapacity") );
			capacity.setProjectCapacity( CapacityDataAccess.getByCapacityId(capacity.getId(), connection) );
			capacity.setCapacityConfiguration( CapacityDataAccess.getCapacityConfigById(platformId, connection) );
			break;
		}
		return capacity;
	}
	
	protected static List<ProjectTeamMember> getByCapacityId(int capacityId, Connection connection) throws URISyntaxException, SQLException {
		List<ProjectTeamMember> teamMembers = new ArrayList<ProjectTeamMember>();

		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(GET_PROJECT_CAPACITY_BY_ID_SQL + Integer.toString(capacityId));
		while (rs.next()) {
			ProjectTeamMember member = new ProjectTeamMember();
			member.setId(rs.getInt("id"));
			member.setName(rs.getString("teamMemberName"));
			member.setRole(TeamMemberRole.valueOf(rs.getString("role")));
			member.setCapacity(rs.getFloat("capacity"));
			teamMembers.add(member);
		}
		return teamMembers;
	
	}
	
	protected static Hashtable<ProjectSize,Float> getCapacityConfigById(int platformId, Connection connection) throws URISyntaxException, SQLException {
		Hashtable<ProjectSize,Float> configuration = new Hashtable<ProjectSize,Float>();

		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(GET_CAPACITY_CONFIG_BY_ID_SQL + Integer.toString(platformId));
		while (rs.next()) {
			
			ProjectSize size = ProjectSize.valueOf(rs.getString("projectSize"));
			Float capacity = Float.valueOf(rs.getFloat("capacity"));
			configuration.put(size, capacity);
		}
		return configuration;
	}
	
}
