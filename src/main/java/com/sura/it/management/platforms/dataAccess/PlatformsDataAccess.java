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

	public static List<Platform> listPlatforms() throws URISyntaxException, SQLException {
		List<Platform> list = new ArrayList<Platform>();

		Connection connection = null;
		try {
			connection = DataServiceHelper.getInstance().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(LIST_PLATFORMS_SQL);
			while (rs.next()) {
				Platform platform = new Platform();
				platform.setId(rs.getLong("id"));
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
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(GET_PLATFORMS_BY_ID_SQL + Integer.toString(id));
			while (rs.next()) {
				platform.setId(rs.getLong("id"));
				platform.setShortName(rs.getString("shortName"));
				platform.setName(rs.getString("fullName"));
				platform.setDepartment(rs.getString("department"));
				platform.setOwner(rs.getString("owner"));
				platform.setOwnerEmail(rs.getString("ownerEmail"));
				break;
			}
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
				}
		}
		return platform;
		
	}
}
