<%--
  Created by IntelliJ IDEA.
  User: zc
  Date: 2022/3/26
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<h1>Login</h1>
<form method="post" action="login">
    UserName:<input type="text" name="username"><br>
    Password:<input type="password" name="password"><br>

    <input type="submit" value="login">
</form>

<%@include file="footer.jsp"%>