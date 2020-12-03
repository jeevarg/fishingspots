<%--
  Created by IntelliJ IDEA.
  User: jeeva
  Date: 12/2/20
  Time: 4:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        Welcome to Fishing-Spots website! As a fishing enthusiast I am always on the look out for good fishing spots in
        and around my area. There are very few websites on the internet where you can look for spots but some of them are only
        revealed to only registered users.
    </h4>
    <h4>
        Fishing-Spots lets you look for any / all spots without any sign-up. However, if you do sign-up, then you can
        add, edit, delete your own spots and also rate any spot.You can do a search based on a zip-code and a given
        radius.
</h4>
</div>
    <c:import url="footer.jsp"/>

</div>
</body>
</html>
