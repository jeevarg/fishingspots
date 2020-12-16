<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 10/21/20
  Time: 12:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <c:import url="metaInfo.jsp"/>
    <c:import url="title.jsp"/>
    <c:import url="styleSheet.jsp"/>
    <c:import url="styleSheetJQuery.jsp"/>
</head>
<body>
<div class="w3-content" style="width:100%;height:100%">
    <c:import url="header.jsp"/>
    <div class="w3-container w3-light-gray w3-left w3-border" style="width:100%;height:70%">
        <!--div class="w3-panel w3-light-blue w3-round-xlarge" style="width:90%;height:90%"-->
        <br><br><br><br>
        <c:if test="${userID != 0}">
            <h4>Registration successful!</h4>
            ${pageContext.request.logout()}
            <br><br>
            <h4>You can <b>log-in</b> now to <b>add / edit / delete / rate </b> spots</h4>
        </c:if>
    </div>
    <c:import url="footer.jsp"/>
</div>

</body>
</html>
