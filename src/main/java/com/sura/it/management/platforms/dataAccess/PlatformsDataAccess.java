package com.sura.it.management.platforms.dataAccess;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sura.it.management.platforms.model.Platform;
import com.sura.it.management.platforms.model.ProjectPlatform;

public class PlatformsDataAccess {

	private static final String LIST_PLATFORMS_SQL = "SELECT * FROM tblPlatforms";
	private static final String GET_PLATFORMS_BY_ID_SQL = "SELECT * FROM tblPlatforms WHERE id = ";
	private static final String INSERT_PLATFORM_SQL = "INSERT INTO tblPlatforms (shortName, fullName, department, owner, ownerEmail) VALUES ({{values}}) RETURNING id";
	private static final String UPDATE_PLATFORM_SQL = "UPDATE tblPlatforms SET shortName = '{{shortName}}', fullName = '{{fullName}}', department = '{{department}}', owner = '{{owner}}', ownerEmail = '{{ownerEmail}}' WHERE id = ";
	private static final String LIST_PLATFORMS_BY_PROJECT_ID_SQL = "SELECT DISTINCT platformId " + 
																	"FROM   tblPlatformCapacity cap, tblPlatformProjectCapacity prjCap, tblPlatformsByProject pbp " + 
																	"WHERE  pbp.teamMemberId = prjCap.id " + 
																	"AND    cap.id = prjCap.capacityId " + 
																	"AND    pbp.projectId = ";

	public static List<Platform> listAll() throws URISyntaxException, SQLException {
		List<Platform> list = new ArrayList<Platform>();

		Connection connection = null;
		try {
			connection = DataServiceHelper.getInstance().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(LIST_PLATFORMS_SQL);
			while (rs.next()) {
				Platform platform = new Platform();
				platform.setId(rs.getInt("id"));
				platform.setShortName(rs.getString("shortName"));
				platform.setName(rs.getString("fullName"));
				platform.setDepartment(DepartmentsDataAccess.getById(rs.getInt("department")));
				platform.setOwner(rs.getString("owner"));
				platform.setOwnerEmail(rs.getString("ownerEmail"));
				list.add(platform);
			}
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
				}
		}
		return list;
	}
	
	public static Platform getById(int id) throws URISyntaxException, SQLException {
		Platform platform = null;

		Connection connection = null;
		try {
			connection = DataServiceHelper.getInstance().getConnection();
			platform = getById(id, connection);
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
				}
		}
		return platform;
	}
	
	protected static Platform getById(int id, Connection connection) throws URISyntaxException, SQLException {
		Platform platform = null;

			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(GET_PLATFORMS_BY_ID_SQL + Integer.toString(id));
			while (rs.next()) {
				platform = new Platform();
				platform.setId(rs.getInt("id"));
				platform.setShortName(rs.getString("shortName"));
				platform.setName(rs.getString("fullName"));
				platform.setDepartment(DepartmentsDataAccess.getById(rs.getInt("department")));
				platform.setOwner(rs.getString("owner"));
				platform.setOwnerEmail(rs.getString("ownerEmail"));
				break;
			}
		return platform;
	}
	
	public static int insertNew(Platform platform) throws URISyntaxException, SQLException {
		int id = 0;

		Connection connection = null;
		try {
			connection = DataServiceHelper.getInstance().getConnection();
			Statement stmt = connection.createStatement();
			
			String sql = INSERT_PLATFORM_SQL.replace("{{values}}", "'" + platform.getShortName() + "','" + platform.getName() + "','" + platform.getDepartment() + "','" + platform.getOwner() + "','" + platform.getOwnerEmail() + "'" );
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				id = rs.getInt("id");
			}
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
				}
		}
		return id;
	}	

	public static void update(Platform platform) throws URISyntaxException, SQLException {
		Connection connection = null;
		try {
			connection = DataServiceHelper.getInstance().getConnection();
			Statement stmt = connection.createStatement();
			
			String sql = UPDATE_PLATFORM_SQL + platform.getId();			
			sql = sql.replace("{{shortName}}", platform.getShortName());
			sql = sql.replace("{{fullName}}", platform.getName());
			sql = sql.replace("{{department}}", Integer.toString(platform.getDepartment().getId()));
			sql = sql.replace("{{owner}}", platform.getOwner());
			sql = sql.replace("{{ownerEmail}}", platform.getOwnerEmail());
			
			stmt.execute(sql);
			
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
				}
		}
	}	

	public static List<ProjectPlatform> listByProjectId(int projectId) throws URISyntaxException, SQLException {
		List<ProjectPlatform> list = new ArrayList<ProjectPlatform>();

		Connection connection = null;
		try {
			connection = DataServiceHelper.getInstance().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(LIST_PLATFORMS_BY_PROJECT_ID_SQL + Integer.toString(projectId));
			while (rs.next()) {
				ProjectPlatform platform = new ProjectPlatform();
				platform.setPlatform(PlatformsDataAccess.getById(rs.getInt("platformId"), connection) );
				platform.setTeamMembers(CapacityDataAccess.getAssignedCapacityByPlatformId(rs.getInt("platformId"), connection) );
				list.add(platform);
			}
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
				}
		}
		return list;
	}
}
