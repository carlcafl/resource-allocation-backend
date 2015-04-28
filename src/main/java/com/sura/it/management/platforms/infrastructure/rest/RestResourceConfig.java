package com.sura.it.management.platforms.infrastructure.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api/rest/*")
public class RestResourceConfig extends ResourceConfig {

	public RestResourceConfig()
	{
		packages("com.sura.it.management.platforms.rest,com.sura.it.management.platforms.util");
		register(JacksonFeature.class);
		register(org.glassfish.jersey.server.mvc.jsp.JspMvcFeature.class);
	}
}
