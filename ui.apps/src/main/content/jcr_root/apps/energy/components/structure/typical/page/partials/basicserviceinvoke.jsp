<%@include file="/libs/foundation/global.jsp"%>


<%@ page
	import="org.viewtrol.energy.core.services.interfaces.BasicService"%>
<%@ page import="org.apache.sling.jcr.api.SlingRepository"%>
<%@ page import="org.apache.sling.commons.json.io.JSONWriter"%>

<h2>Service queryservice.jsp counts # of nodes under'/content/testsql'</h2>

<%
	BasicService sqlService = sling.getService(BasicService.class);

	String jsonString = sqlService.SearchWithSQL2();

	out.println("# of records returned: </br>" + jsonString);
%>
