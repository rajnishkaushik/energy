<%--

  Sling servlet in template code component.

  This template demonstrates how a sling servlet be housed in the front end and called as well

--%><%
%><%@include file="/libs/foundation/global.jsp"%><%
%><%@page session="false" %><%
%><%
	// TODO add you code here
	
	
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<body>

<img alt="<%= currentPage.getTitle() %>" src="<%= currentPage.getPath() %>.navimg.png">
<br>
<br>
<% out.println(currentPage.getPath() + ".navimg.png"); %>

<h1>something</h1>
</body>
</html>

