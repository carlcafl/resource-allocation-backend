package com.sura.it.management.platforms.dataAccess;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

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
		//TODO: Eliminar. Buscar opción para pruebas
		String dbURL = System.getenv("DATABASE_URL");
		if (dbURL==null) {
			dbURL = "postgres://nhdszqrzsjqvrx:b7HQcMK2oRXcFvdR8t9erWhe-b@ec2-54-163-238-169.compute-1.amazonaws.com:5432/ddeelfaukkgi7j";
		}		
		URI dbUri = new URI(dbURL);

		String username = dbUri.getUserInfo().split(":")[0];
		String password = dbUri.getUserInfo().split(":")[1];
		int port = dbUri.getPort();

		String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ":" + port
				+ dbUri.getPath();
		
		Properties props = new Properties();
		props.put("user", username);
		props.put("password", password);
		props.put("sslmode","require");
		return DriverManager.getConnection(dbUrl, props);
	}

}
