<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="w3-container w3-blue-gray">

<h1> <b> Fishing Spots </b>
    <img src="fishing.png" alt="Image" class="w3-left w3-margin-right" style="width:100px">
</h1>
<a href="index.jsp"> <button class="w3-button w3-light-gray w3-padding-large w3-margin-bottom">Home</button></a>
<a href="spots.jsp"> <button class="w3-button w3-light-gray w3-padding-large w3-margin-bottom">Spots</button></a>
<a href="about.jsp"> <button class="w3-button w3-light-gray w3-padding-large w3-margin-bottom">About</button></a>
    <c:if test="${pageContext.request.remoteUser == null}">
        <a href="loginAction"> <button id="loginButton" class="w3-button w3-light-gray w3-padding-large w3-margin-bottom">Login</button></a>
    </c:if>
    <c:if test="${pageContext.request.remoteUser != null}">
        <span id="userLabel" class="w3-tag w3-blue-gray"><h4>Hello, ${pageContext.request.remoteUser}!</h4></span>
        <a href="logout.jsp"> <button id="logoutButton" class="w3-button w3-light-gray w3-padding-large w3-margin-bottom">Logout</button></a>
    </c:if>

</header>

