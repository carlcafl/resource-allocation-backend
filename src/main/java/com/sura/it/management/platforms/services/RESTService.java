package com.sura.it.management.platforms.services;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

public abstract class RESTService {

	@Context
	private HttpServletResponse response;
	
	protected void processResponse() {
		response.addHeader("Access-Control-Allow-Origin", "*");
	}
}
