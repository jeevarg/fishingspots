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
        <FORM ACTION="j_security_check" METHOD="POST">
            <h4>Email ID:</h4>
            <input class="w3-input w3-border" type="text" NAME="j_username"/>
            <h4>Password:</h4>
            <input class="w3-input w3-border" TYPE="PASSWORD" NAME="j_password"/>
            <br>
            <button class="w3-button w3-dark-gray w3-padding-large w3-margin-bottom" type="submit">Log In</button>
        </form>
    </div>
    <c:import url="footer.jsp"/>
</div>

</body>
</html>
