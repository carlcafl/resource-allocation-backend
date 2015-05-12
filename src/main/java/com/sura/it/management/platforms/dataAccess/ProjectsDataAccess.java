package com.sura.it.management.platforms.dataAccess;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sura.it.management.platforms.model.Project;
import com.sura.it.management.platforms.model.enumerations.ProjectSize;

public class ProjectsDataAccess {

	private static final String LIST_PROJECTS_SQL = "SELECT * FROM tblProjects";

	public static List<Project> listAll() throws URISyntaxException, SQLException {
		List<Project> list = new ArrayList<Project>();

		Connection connection = null;
		try {
			connection = DataServiceHelper.getInstance().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(LIST_PROJECTS_SQL);
			while (rs.next()) {
				Project project = new Project();
				project.setId( rs.getInt("id") );
				project.setName( rs.getString("name") );
				project.setProjectType( ProjectTypeDataAccess.getById(rs.getInt("projectType"), connection) );
				project.setLeadAnalyst( rs.getString("leadAnalyst") );
				project.setLeadAnalystEmail( rs.getString("leadAnalystEmail") );
				project.setLeadPlatform( PlatformsDataAccess.getById(rs.getInt("platformId"), connection) );
				project.setSize( ProjectSize.valueOf(rs.getString("size")) );
				project.setStart( rs.getDate("startDate") );
				project.setFinish( rs.getDate("endDate") );
				
				list.add(project);
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
