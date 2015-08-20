package com.sura.it.management.platforms.dataAccess;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sura.it.management.platforms.model.Application;
import com.sura.it.management.platforms.model.ApplicationDataBaseProperties;

public class ApplicationsDataAccess {

	private static final String LIST_APPLICATIONS_BY_PLATFORM_SQL = "SELECT * FROM tblApplications WHERE platformId = ";
	private static final String LIST_ALL_SQL = "SELECT * FROM tblApplications";
	private static final String GET_APPLICATION_BY_ID_SQL = "SELECT * FROM tblApplications WHERE id = ";
	//private static final String INSERT_APPLICATION_SQL = "INSERT INTO tblApplications (name, platformId, applicationType, programmingLanguage, securityType, sourceControlURL, jenkinsProjectName, sourceAnalysisURL, serverName, webContainerName, webContextName, dbType, dbInstanceName, dbOwnerUser, dbConnectionUser) VALUES ({{values}}) RETURNING id";

	// private static final String UPDATE_APPLICATION_SQL =
	// "UPDATE tblApplications SET shortName = '{{shortName}}', fullName = '{{fullName}}', department = '{{department}}', owner = '{{owner}}', ownerEmail = '{{ownerEmail}}' WHERE id = ";

	private static Application loadObject(ResultSet rs) throws SQLException {
		Application application = new Application();
		application.setId(rs.getInt("id"));
		application.setName(rs.getString("name"));
		application.setAppType(rs.getString("applicationType"));
		application.setProgrammingLanguage(rs.getString("programmingLanguage"));
		application.setSecurityType(rs.getString("securityType"));
		application.setVersionControlURL(rs.getString("sourceControlURL"));
		application.setJenkinsName(rs.getString("jenkinsProjectName"));
		application.setSourceQualityProjectURL(rs
				.getString("sourceAnalysisURL"));
		application.setServerName(rs.getString("serverName"));
		application.setWebContainerName(rs.getString("webContainerName"));
		application.setWebContextName(rs.getString("webContextName"));

		ApplicationDataBaseProperties dbProperties = new ApplicationDataBaseProperties();
		dbProperties.setDbType(rs.getString("dbType"));
		dbProperties.setDbInstanceName(rs.getString("dbInstanceName"));
		dbProperties.setDbOwnerUser(rs.getString("dbOwnerUser"));
		dbProperties.setDbConnectionUser(rs.getString("dbConnectionUser"));
		application.setDbProperties(dbProperties);

		return application;

	}

	public static List<Application> listAll()
			throws URISyntaxException, SQLException {
		List<Application> list = null;

		Connection connection = null;
		try {
			connection = DataServiceHelper.getInstance().getConnection();
			list = listAll(connection);
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
				}
		}
		return list;
	}

	protected static List<Application> listAll(Connection connection) throws URISyntaxException, SQLException {
		Application application = null;
		List<Application> list = new ArrayList<Application>();

		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(LIST_ALL_SQL);
		while (rs.next()) {
			application = loadObject(rs);
			list.add(application);
		}
		return list;
	}

	public static List<Application> getByPlatformId(int platformId)
			throws URISyntaxException, SQLException {
		List<Application> list = null;

		Connection connection = null;
		try {
			connection = DataServiceHelper.getInstance().getConnection();
			list = getByPlatformId(platformId, connection);
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
				}
		}
		return list;
	}

	protected static List<Application> getByPlatformId(int platformId,
			Connection connection) throws URISyntaxException, SQLException {
		Application application = null;
		List<Application> list = new ArrayList<Application>();

		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(LIST_APPLICATIONS_BY_PLATFORM_SQL
				+ Integer.toString(platformId));
		while (rs.next()) {
			application = loadObject(rs);
			list.add(application);
		}
		return list;
	}

	public static Application getById(int id) throws URISyntaxException,
			SQLException {
		Application application = null;

		Connection connection = null;
		try {
			connection = DataServiceHelper.getInstance().getConnection();
			application = getById(id, connection);
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
				}
		}
		return application;
	}

	protected static Application getById(int id, Connection connection)
			throws URISyntaxException, SQLException {
		Application application = null;

		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(GET_APPLICATION_BY_ID_SQL
				+ Integer.toString(id));
		while (rs.next()) {
			application = loadObject(rs);
			break;
		}
		return application;
	}

	/*
	 * public static int insertNew(Platform platform) throws URISyntaxException,
	 * SQLException { int id = 0;
	 * 
	 * Connection connection = null; try { connection =
	 * DataServiceHelper.getInstance().getConnection(); Statement stmt =
	 * connection.createStatement();
	 * 
	 * String sql = INSERT_APPLICATION_SQL.replace("{{values}}", "'" +
	 * platform.getShortName() + "','" + platform.getName() + "','" +
	 * platform.getDepartment() + "','" + platform.getOwner() + "','" +
	 * platform.getOwnerEmail() + "'" ); ResultSet rs = stmt.executeQuery(sql);
	 * 
	 * while (rs.next()) { id = rs.getInt("id"); } } finally { if (connection !=
	 * null) try { connection.close(); } catch (SQLException e) { } } return id;
	 * }
	 * 
	 * public static void update(Platform platform) throws URISyntaxException,
	 * SQLException { Connection connection = null; try { connection =
	 * DataServiceHelper.getInstance().getConnection(); Statement stmt =
	 * connection.createStatement();
	 * 
	 * String sql = UPDATE_PLATFORM_SQL + platform.getId(); sql =
	 * sql.replace("{{shortName}}", platform.getShortName()); sql =
	 * sql.replace("{{fullName}}", platform.getName()); sql =
	 * sql.replace("{{department}}", platform.getDepartment()); sql =
	 * sql.replace("{{owner}}", platform.getOwner()); sql =
	 * sql.replace("{{ownerEmail}}", platform.getOwnerEmail());
	 * 
	 * stmt.execute(sql);
	 * 
	 * } finally { if (connection != null) try { connection.close(); } catch
	 * (SQLException e) { } } }
	 * 
	 * public static List<ProjectPlatform> listByProjectId(int projectId) throws
	 * URISyntaxException, SQLException { List<ProjectPlatform> list = new
	 * ArrayList<ProjectPlatform>();
	 * 
	 * Connection connection = null; try { connection =
	 * DataServiceHelper.getInstance().getConnection(); Statement stmt =
	 * connection.createStatement(); ResultSet rs =
	 * stmt.executeQuery(LIST_PLATFORMS_BY_PROJECT_ID_SQL +
	 * Integer.toString(projectId)); while (rs.next()) { ProjectPlatform
	 * platform = new ProjectPlatform();
	 * platform.setPlatform(PlatformsDataAccess.getById(rs.getInt("platformId"),
	 * connection) );
	 * platform.setTeamMembers(CapacityDataAccess.getAssignedCapacityByPlatformId
	 * (rs.getInt("platformId"), connection) ); list.add(platform); } } finally
	 * { if (connection != null) try { connection.close(); } catch (SQLException
	 * e) { } } return list; } }
	 */
}
