<%@ page import="com.zhangchun.model.User" %><%--
  Created by IntelliJ IDEA.
  User: zc
  Date: 2022/3/5
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<%--    <style>--%>
<%--        * {--%>
<%--            padding: 0;--%>
<%--            margin: 0;--%>
<%--        }--%>

<%--        p {--%>
<%--            color: #bdbdbd;--%>
<%--        }--%>

<%--        input {--%>
<%--            font-size: 120%;--%>
<%--            color: #5a5854;--%>
<%--            background-color: #f2f2f2;--%>
<%--            border: 1px solid #bdbdbd;--%>
<%--            padding: 5px 5px 5px 5px;--%>
<%--            margin-bottom: 10px;--%>
<%--            border-radius: 5px;--%>
<%--        }--%>

<%--        #submit {--%>
<%--            width: 100px;--%>
<%--            height: 30px;--%>
<%--            color: white;--%>
<%--            background-color: rgb(255, 153, 0);--%>
<%--        }--%>

<%--        .info {--%>
<%--            float: left;--%>
<%--            text-align: right;--%>
<%--            clear: left;--%>
<%--            margin: 2px;--%>
<%--            padding: 2px;--%>
<%--        }--%>
<%--    </style>--%>

<%--<form method="post" action="register">
<div class="info">
    <p>New User Registration</p>
</div>
<div class="info">
    <label><input type="text" name="username" placeholder="UserName" size="30" maxlength="100" /></label>
    <br />
    <label><input type="password" name="password" placeholder="password" size="30"
                  maxlength="100" /></label><br />
    <label><input type="text" name="email" placeholder="Email" size="30" maxlength="100" /></label>
</div>
<div class="info">
    <label>Gender</label>
    <label><input type="radio" name="gender" value="male">Male</label>
    <label><input type="radio" name="gender" value="female">Female</label>
</div>
<div class="info">
    <label><input type="text" name="birthDate" placeholder="Date of Birth(yyyy-mm-dd)" size="30"
                  maxlength="100" /></label><br />
</div>

    <div class="info"> <input  type="submit" value="Register"></div>
    </form>--%>



<form method="post"action="register" >
    username<input type="text" name="username"><br>
    password<input type="password" name="password"><br>
    Email<input type="text" name="email"><br>
    Gender:<input type="radio" name="gender" value="male">Male<input type="radio" name="gender" value="female">Female<br>
    Date of Birth:<input type="text name" name="birthDate">(yyyy-mm-dd)<br>
    <input type="submit" value="Register">



</form>

<%@include file="footer.jsp"%>
