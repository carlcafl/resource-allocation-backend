package com.sura.it.management.platforms.dataAccess;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataServiceHelper {

	private static DataServiceHelper instance = null;

	private DataServiceHelper() {
	}

	public static DataServiceHelper getInstance() {
		if (instance == null)
			instance = new DataServiceHelper();
		return instance;
	}

	public Connection getConnection() throws URISyntaxException, SQLException {
		URI dbUri = new URI(System.getenv("DATABASE_URL"));

		String username = dbUri.getUserInfo().split(":")[0];
		String password = dbUri.getUserInfo().split(":")[1];
		int port = dbUri.getPort();

		String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ":" + port
				+ dbUri.getPath();

		return DriverManager.getConnection(dbUrl, username, password);
	}

}
