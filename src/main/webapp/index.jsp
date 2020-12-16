<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <c:import url="title.jsp"/>
    <c:import url="metaInfo.jsp"/>
    <c:import url="styleSheet.jsp"/>
</head>
<body>
<div class="w3-content" style="width:100%;height:100%">

<c:import url="header.jsp"/>
    <div class="w3-container w3-light-gray w3-left w3-border" style="width:100%;height:70%">
        <h4>
            <p>Welcome to Fishing-Spots!</p>
            <p>Fishing-Spots lets you look up for any / all spots without any sign-up. However, if you do sign-up, you can
            add, edit, delete your own spots and also rate any spot. </p>
        </h4>
            <a href="spots.jsp"> <button class="w3-button w3-dark-gray w3-padding-large w3-margin-bottom">Continue As Guest</button></a>
            <a href="loginAction"> <button class="w3-button w3-dark-gray w3-padding-large w3-margin-bottom">Log In</button></a>
            <a href="register.jsp"> <button class="w3-button w3-dark-gray w3-padding-large w3-margin-bottom">Register</button></a>
        <c:if test="${pageContext.request.isUserInRole('admin'||'user')}">
            <a href="spots.jsp"> <button class="w3-button w3-dark-gray w3-padding-large w3-margin-bottom">Search Spots</button></a>
        </c:if>

    </div>

    <c:import url="footer.jsp"/>
</div>
</body>
</html>