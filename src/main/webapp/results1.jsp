<%--
  Created by IntelliJ IDEA.
  User: jeeva
  Date: 12/2/20
  Time: 12:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="spots">
    <c:if test="${requestScope.containsKey('spots')}">
        ${requestScope.spots}
    </c:if>
</div>
</body>
</html>
