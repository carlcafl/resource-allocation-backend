package com.sura.it.management.platforms.dataAccess;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sura.it.management.platforms.model.Platform;
import com.sura.it.management.platforms.model.PlatformCapacity;

public class CapacityDataAccess {

	//TODO: Consultar por fecha???
	private static final String GET_CAPACITY_BY_ID_SQL = "SELECT * FROM tblPlatformCapacity WHERE platformId = ";
	
	
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
				//capacity.setId(rs.getInt("id"));
				capacity.setMaintenanceCapacity( rs.getFloat("maintenanceCapacity") );
				capacity.setSupportCapacity( rs.getFloat("supportCapacity") );
				break;
			}
		return capacity;
	}
	
}
