<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jeeva
  Date: 12/16/20
  Time: 11:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div class="w3-content" style="width:100%;height:100%">
    ${pageContext.request.logout()}
    ${pageContext.response.sendRedirect("index.jsp")}
</div>
</body>
</html>
