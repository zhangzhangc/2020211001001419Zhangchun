<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/15/2021
  Time: 11:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%-- todo 9: use c:out to print message fron request --%>
<%--<label>username:</label>--%>
<%--<span><c:out value="${username}" /></span><br>--%>
<%--<label>password:</label>--%>
<%--<span><c:out value="${password}" /></span><br>--%>
<%--<%=//request.getAttribute("message")%>--%>

<%--todo 1: use c:url to set url in action="validate.jsp" --%>
<%--<c:url value="validate.jsp"/>--%>
<c:out value="Username Password Error"/>
<form action="validate.jsp">
    Username : <input type="text" name="username"><br>
    Password : <input type="password" name="password"><br>
    <input type="submit" value="Login"/>
</form>

</body>
</html>
