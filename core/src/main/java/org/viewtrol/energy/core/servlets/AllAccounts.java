package org.viewtrol.energy.core.servlets;

import java.io.IOException;
import java.io.StringWriter;
import java.rmi.ServerException;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.commons.json.io.JSONWriter;
import org.apache.sling.jcr.api.SlingRepository;
import java.util.UUID;

@SlingServlet(paths = { "/bin/myAllAccounts" }, methods = "POST", metatype = true)
@Properties({
		@Property(name = "service.pid", value = "org.viewtrol.energy.core.servlets.AllAccounts", propertyPrivate = false),
		@Property(name = "service.description", value = "HandleClaim", propertyPrivate = false),
		@Property(name = "service.vendor", value = "Viewtrol", propertyPrivate = false) })
public class AllAccounts extends org.apache.sling.api.servlets.SlingAllMethodsServlet {
	private static final long serialVersionUID = 2598426539166789515L;

	@Reference
	private SlingRepository repository;

	public void bindRepository(SlingRepository repository) {
		this.repository = repository;
	}

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServerException, IOException {

		try {
			// Get the submitted form data that is sent from the
			// CQ web page
			String id = UUID.randomUUID().toString();
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String address = request.getParameter("address");
			String cat = request.getParameter("cat");
			String state = request.getParameter("state");
			String details = request.getParameter("details");
			String date = request.getParameter("date");
			String city = request.getParameter("city");

			// Encode the submitted form data to JSON
			StringWriter sw = new StringWriter();
			JSONWriter writer = new JSONWriter(sw);

			writer.object();
			writer.key("id").value(id);
			writer.key("firstname").value(firstName);
			writer.key("lastname").value(lastName);
			writer.key("address").value(address);
			writer.key("cat").value(cat);
			writer.key("state").value(state);
			writer.key("details").value(details);
			writer.key("date").value(date);
			writer.key("city").value(city);
			writer.endObject();

			// Return the JSON formatted data
			response.getWriter().write(sw.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}