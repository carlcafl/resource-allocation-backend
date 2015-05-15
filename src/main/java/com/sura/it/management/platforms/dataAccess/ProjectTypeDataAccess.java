package com.sura.it.management.platforms.dataAccess;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sura.it.management.platforms.model.ProjectType;

public class ProjectTypeDataAccess {

	private static final String LIST_PROJECT_TYPES_SQL = "SELECT * FROM tblProjectTypes";
	private static final String GET_PROJECT_TYPES_BY_ID_SQL = "SELECT * FROM tblProjectTypes WHERE id = ";

	public static List<ProjectType> listAll() throws URISyntaxException, SQLException {
		List<ProjectType> list = new ArrayList<ProjectType>();

		Connection connection = null;
		try {
			connection = DataServiceHelper.getInstance().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(LIST_PROJECT_TYPES_SQL);
			while (rs.next()) {
				ProjectType projectType = new ProjectType();
				projectType.setId( rs.getInt("id") );
				projectType.setName( rs.getString("name") );				
				list.add(projectType);
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

	public static ProjectType getById(int id) throws URISyntaxException, SQLException {
		ProjectType projectType = null;

		Connection connection = null;
		try {
			connection = DataServiceHelper.getInstance().getConnection();
			projectType = getById(id, connection);
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
				}
		}
		return projectType;
	}
	
	protected static ProjectType getById(int id, Connection connection) throws URISyntaxException, SQLException {
		ProjectType projectType = null;

			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(GET_PROJECT_TYPES_BY_ID_SQL + Integer.toString(id));
			while (rs.next()) {
				projectType = new ProjectType();
				projectType.setId( rs.getInt("id") );
				projectType.setName( rs.getString("projectType") );				
				break;
			}
		return projectType;
	}
}
