<%--
<%@include file="/libs/foundation/global.jsp"%>
--%>

<%@page session="false"%>
    
    <%--
   ==============================================================================
 
  Account Selector component.

  Account Selector displays customer accounts from which he/she can choose one or more accounts

--%>
        

<%@ page import="
    com.day.cq.wcm.api.WCMMode,com.day.cq.wcm.foundation.Placeholder" %><%
%>
    
    <h2>---- accountselector.jsp -----</h2>
    
    <%@include file="/libs/foundation/global.jsp"%><%
 
        String heading = (String)properties.get("jcr:Heading");
    
if (heading == null) {
    if(WCMMode.fromRequest(slingRequest) == WCMMode.EDIT) {
        %><%= Placeholder.getDefaultPlaceholder(slingRequest, component,
        "<img src=\"/libs/cq/ui/resources/0.gif\" class=\"cq-list-placeholder\" alt=\"\">")%><%}    
}
else {
%>
        <header>
            <cq:text property="jcr:Heading" placeholder="Hero Text" tagName="h1" escapeXml="true"/>
            <cq:text property="jcr:description" placeholder="" tagName="p" tagClass="intro" escapeXml="true"/>
        </header>
        
        
<%
}
   
%>
    
    <%
  
   
%>
    
    <h2>---- accountselector.jsp -----</h2>
    
