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

	public static List<Platform> listPlatforms() throws URISyntaxException, SQLException {
		List<Platform> list = new ArrayList<Platform>();

		Connection connection = null;
		try {
			connection = DataServiceHelper.getInstance().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(LIST_PLATFORMS_SQL);
			while (rs.next()) {
				Platform p = new Platform();
				p.setId(rs.getLong("id"));
				p.setShortName(rs.getString("shortName"));
				p.setName(rs.getString("fullName"));
				list.add(p);
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
