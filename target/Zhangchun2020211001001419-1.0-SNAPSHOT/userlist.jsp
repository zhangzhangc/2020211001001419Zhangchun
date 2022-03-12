<%--
  Created by IntelliJ IDEA.
  User: zc
  Date: 2022/3/23
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1px;">
  <!-- 第一行 -->
  <tr>
    <td>id</td>
    <td>username</td>
    <td>password</td>
    <td>email</td>
    <td>gender</td>
    <td>birthDate</td>
  </tr>
  <!-- 第二行 -->

  <tr>
    <td><%=1%></td>
    <td><%=user.getAccount()%></td>
    <td><%=user.getName()%></td>
    <td><%=user.getGender()%></td>
    <td><%=user.getInterest()%></td>
    <td><%=user.getMsg()%></td>
  </tr>

</table>

</body>
</html>
