<%@ page import="com.fishingspots.utilities.PropertiesLoader" %>
<%@ page import="java.util.Properties" %>
<% PropertiesLoader loader = new PropertiesLoader();
    Properties properties = loader.loadProperties();
    final String key = properties.getProperty("googleMapAPIKey");
%>

