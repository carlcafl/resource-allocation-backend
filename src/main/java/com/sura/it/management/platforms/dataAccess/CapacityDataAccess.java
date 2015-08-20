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
	private static final String GET_PLATFORM_ASSIGNED_CAPACITY_SQL ="SELECT p.name, pbp.size,pbp.assignedCapacity,p.startDate,p.endDate,pc.platformId,ppc.id,ppc.teamMemberName,ppc.role " +
																	"FROM   tblPlatformsByProject pbp, tblProjects p, tblPlatformProjectCapacity ppc, tblPlatformCapacity pc " +
																	"WHERE  pbp.projectId = p.id " +
																	"AND    ppc.id = pbp.teamMemberId " +
																	"AND    pc.id = ppc.capacityId " +
																	"AND    pc.platformId = ";
	private static final String GET_TEAM_MEMBER_ASSIGNED_CAPACITY_SQL = "SELECT p.name, pbp.size,pbp.assignedCapacity,p.startDate,p.endDate,pc.platformId,ppc.id,ppc.teamMemberName,ppc.role " +
																		"FROM   tblPlatformsByProject pbp, tblProjects p, tblPlatformProjectCapacity ppc, tblPlatformCapacity pc " +
																		"WHERE  pbp.projectId = p.id " +
																		"AND    ppc.id = pbp.teamMemberId " +
																		"AND    pc.id = ppc.capacityId " +
																		"AND    ppc.id = ";
	
	
	public static PlatformCapacity getByPlatformId(int platformId) throws URISyntaxException, SQLException {
		PlatformCapacity capacity = new PlatformCapacity();

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
		PlatformCapacity capacity = new PlatformCapacity();

		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(GET_CAPACITY_BY_ID_SQL + Integer.toString(platformId));
		while (rs.next()) {
			capacity = new PlatformCapacity();
			Platform platform = new Platform();
			platform.setId(platformId);
			capacity.setPlatform(platform);
			capacity.setId(rs.getInt("id"));
			capacity.setMaintenanceCapacity(rs.getFloat("maintenanceCapacity") );
			capacity.setSupportCapacity(rs.getFloat("supportCapacity") );
			capacity.setProjectCapacity(CapacityDataAccess.getByCapacityId(capacity.getId(), connection) );
			capacity.setCapacityConfiguration(CapacityDataAccess.getCapacityConfigById(platformId, connection) );
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
	
	public static List<ProjectTeamMember> getAssignedCapacityByPlatformId(int platformId) throws URISyntaxException, SQLException {
		List<ProjectTeamMember> teamMembers = new ArrayList<ProjectTeamMember>();

		Connection connection = null;
		try {
			connection = DataServiceHelper.getInstance().getConnection();
			teamMembers = getAssignedCapacityByPlatformId(platformId, connection);
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
				}
		}
		return teamMembers;
	}

	public static List<ProjectTeamMember> getAssignedCapacityByPlatformId(int platformId, Connection connection) throws URISyntaxException, SQLException {
		List<ProjectTeamMember> teamMembers = new ArrayList<ProjectTeamMember>();

		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(GET_PLATFORM_ASSIGNED_CAPACITY_SQL + Integer.toString(platformId));
		while (rs.next()) {
			ProjectTeamMember member = new ProjectTeamMember();
			member.setId(rs.getInt("id"));
			member.setName(rs.getString("teamMemberName"));
			member.setRole(TeamMemberRole.valueOf(rs.getString("role")));
			member.setCapacity(rs.getFloat("assignedCapacity"));
			member.setProjectName(rs.getString("name"));
			member.setProjectSize(ProjectSize.valueOf(rs.getString("size")));
			member.setStart(rs.getDate("startDate"));
			member.setEnd(rs.getDate("endDate"));
			teamMembers.add(member);
		}
		return teamMembers;
	}
	
	public static List<ProjectTeamMember> getAssignedCapacityByTeamMember(int teamMemberId) throws URISyntaxException, SQLException {
		List<ProjectTeamMember> assignedProjects = new ArrayList<ProjectTeamMember>();
	
		Connection connection = null;
		try {
			connection = DataServiceHelper.getInstance().getConnection();
			assignedProjects = getAssignedCapacityByTeamMember(teamMemberId, connection);
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
				}
		}
		return assignedProjects;
		
	}
	public static List<ProjectTeamMember> getAssignedCapacityByTeamMember(int teamMemberId, Connection connection) throws URISyntaxException, SQLException {
		List<ProjectTeamMember> assignedProjects = new ArrayList<ProjectTeamMember>();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(GET_TEAM_MEMBER_ASSIGNED_CAPACITY_SQL + Integer.toString(teamMemberId));
		while (rs.next()) {
			ProjectTeamMember teamMember = new ProjectTeamMember();
			teamMember.setId(rs.getInt("id"));
			teamMember.setName(rs.getString("teamMemberName"));
			teamMember.setRole(TeamMemberRole.valueOf(rs.getString("role")));
			teamMember.setCapacity(rs.getFloat("assignedCapacity"));
			teamMember.setProjectName(rs.getString("name"));
			teamMember.setProjectSize(ProjectSize.valueOf(rs.getString("size")));
			teamMember.setStart(rs.getDate("startDate"));
			teamMember.setEnd(rs.getDate("endDate"));
			assignedProjects.add(teamMember);
		}
		return assignedProjects;
	}

}
