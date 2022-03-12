<%@ page import="javax.xml.transform.Result" %>
<%--
  Created by IntelliJ IDEA.
  User: zc
  Date: 2022/3/30
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.SQLException" %>
<h1> User List</h1>
<table border=1>
    <tr>
        <td>ID</td>
        <td>UserName</td>
        <td>Password</td>
        <td>Email</td>
        <td>Gender</td>
        <td>birthDate</td>
    </tr>
<%
    ResultSet rs = (ResultSet) request.getAttribute("name");
    if(rs==null){
%>
    <tr>
        <td>
            No Date!!!
        </td>
    </tr>
<%}else {
    while (rs.next()) {
        out.println("<tr>");
        out.println("<td>" + rs.getString("id") + "</td>");
        out.println("<td>" + rs.getString("username") + "</td>");
        out.println("<td>" + rs.getString("password") + "</td>");
        out.println("<td>" + rs.getString("email") + "</td>");
        out.println("<td>" + rs.getString("gender") + "</td>");
        out.println("<td>" + rs.getString("birthDate") + "</td>");

        out.println("</tr>");
    }


}
%>
</table>

<%@include file="footer.jsp"%>
