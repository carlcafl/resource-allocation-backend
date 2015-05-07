package com.sura.it.management.platforms.dataAccess;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sura.it.management.platforms.model.Platform;

public class PlatformsDataAccess {

	private static final String LIST_PLATFORMS_SQL = "SELECT * FROM tblPlatforms";
	private static final String GET_PLATFORMS_BY_ID_SQL = "SELECT * FROM tblPlatforms WHERE id = ";
	private static final String INSERT_PLATFORM_SQL = "INSERT INTO tblPlatforms (shortName, fullName, department, owner, ownerEmail) VALUES ({{values}}) RETURNING id";

	public static List<Platform> listPlatforms() throws URISyntaxException, SQLException {
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
				platform.setDepartment(rs.getString("department"));
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
	
	public static Platform getPlatformById(int id) throws URISyntaxException, SQLException {
		Platform platform = null;

		Connection connection = null;
		try {
			connection = DataServiceHelper.getInstance().getConnection();
			platform = getPlatformById(id, connection);
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
				}
		}
		return platform;
	}
	
	protected static Platform getPlatformById(int id, Connection connection) throws URISyntaxException, SQLException {
		Platform platform = null;

			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(GET_PLATFORMS_BY_ID_SQL + Integer.toString(id));
			while (rs.next()) {
				platform = new Platform();
				platform.setId(rs.getInt("id"));
				platform.setShortName(rs.getString("shortName"));
				platform.setName(rs.getString("fullName"));
				platform.setDepartment(rs.getString("department"));
				platform.setOwner(rs.getString("owner"));
				platform.setOwnerEmail(rs.getString("ownerEmail"));
				break;
			}
		return platform;
	}
	
	public static int insertNewPlatform(Platform platform) throws URISyntaxException, SQLException {
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
}
