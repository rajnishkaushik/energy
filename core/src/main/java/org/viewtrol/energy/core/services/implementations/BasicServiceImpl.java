package org.viewtrol.energy.core.services.implementations;

import java.util.HashMap;
import java.util.Map;

import javax.jcr.LoginException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.felix.scr.annotations.Reference;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.jcr.api.SlingRepository;

import org.viewtrol.energy.core.services.interfaces.BasicService;
import org.viewtrol.energy.core.utils.JCRSearch;

@Component
@Service
public class BasicServiceImpl implements BasicService {

	@Reference
	private SlingRepository slingRepository;

	@Reference
	private ResourceResolverFactory resolverFactory;

	@Override
	public String SearchWithSQL2() {
		String message = "";

		// Option 1: Using ResourceResolver
		Map<String, Object> serviceParams = new HashMap<String, Object>();
		serviceParams.put(ResourceResolverFactory.SUBSERVICE,
				"limited-reader-viewtrol-subservice");
		ResourceResolver resolver = null;

		try {
			resolver = resolverFactory.getServiceResourceResolver(serviceParams);

			Session session1 = resolver.adaptTo(Session.class);

			JCRSearch repo = new JCRSearch();
			message = repo.GetJCRTreeNodes(session1, "/content/testsql");

			session1.logout();
		} catch (Exception e) {

		} finally {
			if (resolver != null) {
				resolver.close();
			}
		}

		// Option 2: Using SlingRepository
		try {

			Session session = slingRepository.loginService("limited-reader-viewtrol-subservice", null);

			JCRSearch repo = new JCRSearch();
			message = repo.GetJCRTreeNodes(session, "/content/testsql");

			// close the session
			session.logout();
		} catch (LoginException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (RepositoryException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		return message;
	}

}
