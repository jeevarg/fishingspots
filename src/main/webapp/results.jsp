<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

<div class="container-fluid">
    <h2>User Search Results: </h2>
    <table border="1" width="100%">
        <thead>
        <th>ID</th>
        <th>User Name</th>
        <th>Email</th>
        <th>Password</th>
        <th>Spots</th>

        </thead>
        <tbody>

        <c:if test="${requestScope.containsKey('user')}">
            <td>${user.id}</td>
            <td>${user.firstName} ${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.password}</td>

            <td>
                <c:forEach var="spot" items="${user.spots}">
                    ${spot.id} || ${spot.spotName} || ${spot.city} || ${spot.state} || ${spot.zipCode} || ${spot.lat} || ${spot.lon} <br/>
                </c:forEach>
            </td>
        </c:if>

        <c:if test="${requestScope.containsKey('users')}">
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.firstName} ${user.lastName}</td>
                    <td>${user.email}</td>
                    <td>${user.password}</td>
                    <td>
                        <c:forEach var="spot" items="${user.spots}">
                            ${spot.id} || ${spot.spotName} || ${spot.city} || ${spot.state} || ${spot.zipCode} || ${spot.lat} || ${spot.lon} <br/>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </c:if>

        </tbody>
    </table>
</div>

</body>
</html>
