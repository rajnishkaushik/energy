package org.viewtrol.energy.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.viewtrol.energy.core.utils.JSONBuilder;

/* TRY
 * http://localhost:8967/sp.oneway.html
 */
@org.apache.felix.scr.annotations.Component(metatype = false, label = "A one way read servlet registered by resourceTypes", description = "Simple demo for cron-job like task with properties")
@Service(Servlet.class)
@Properties({
		@Property(name = "sling.servlet.resourceTypes", value = "sling/servlet/default"),
		@Property(name = "sling.servlet.selectors", value = "oneway"),
		@Property(name = "sling.servlet.extensions", value = "html"),
		@Property(name = "sling.servlet.methods", value = "GET"),
		@Property(name = "service.pid", value = "org.viewtrol.servlets.OneWayServlet", propertyPrivate = false),
		@Property(name = "service.vendor", value = "Viewtrol", propertyPrivate = false),
		@Property(name = "service.description", value = "This servlet is a sample for one way read servlet", propertyPrivate = false), })
public class OneWayServlet extends SlingSafeMethodsServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 12L;

	@Override
	protected void doGet(SlingHttpServletRequest request,
			SlingHttpServletResponse response) throws ServletException,
			IOException {
		/* Write your logic here. */
		JSONBuilder jBuild = new JSONBuilder();
		response.getWriter().write(jBuild.SampleJSON());
	}
}
