package org.viewtrol.energy.core.servlets;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.viewtrol.energy.core.utils.JSONBuilder;

/* TRY
 * http://localhost:8967/bin/energy/sample-twoway-servlet
 */

@SlingServlet(paths = { "/bin/energy/sample-twoway-servlet" })
@Properties({
		@Property(name = "service.pid", value = "org.viewtrol.servlets.TwoWayServlet", propertyPrivate = false),
		@Property(name = "service.description", value = "This servlet is a sample for two way read write servlet", propertyPrivate = false),
		@Property(name = "service.vendor", value = "Viewtrol", propertyPrivate = false) })
public class TwoWayServlet extends SlingAllMethodsServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(SlingHttpServletRequest request,
			SlingHttpServletResponse response) throws ServletException,
			IOException {
		// Write your custom code here
		JSONBuilder jBuild = new JSONBuilder();
		response.getWriter().write(jBuild.SampleJSON());
	}

	@Override
	protected void doPost(SlingHttpServletRequest request,
			SlingHttpServletResponse response) throws ServletException,
			IOException {
		// Write your custom code here
	}
}
