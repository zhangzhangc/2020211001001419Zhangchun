package com.zhangchun.week3.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import static java.lang.System.out;

public class RegisterServlet extends HttpServlet {
    Connection con = null;
    Statement stmt = null;

    @Override
    public void init() throws ServletException {
        super.init();
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://localhost:1433;database=userdb;encrypt=false";
        String username = "sa";
        String password = "123456";


        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            out.println("Connection --> in RegisterDemoServlet" + con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthDate");
        try {
            stmt = con.createStatement();
            String sql = "insert into usertable(username,password,email,gender,birthDate) values (?,?,?,?,?)";
            sql = "select * from   usertable";
            PreparedStatement statement = null;
            try (ResultSet rs = statement.executeQuery(sql)) {

                out.println("<HTML>");
                out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
                out.println("  <BODY>");
                out.println("	<TABLE align='center'border='1' cellspacing='1' cellpadding='1'>");
                out.println("		<tr><th>id</th><th>username</th><th>password</th><th>email</th><th>gender</th><th>birthDate</th> </tr>");

                while (rs.next()) {
                    out.println("		<TR><TD>" + rs.getString(1) + "</TD>");
                    out.println("		<TD>" + rs.getString(2) + "</TD>");
                    out.println("		<TD>" + rs.getString(3) + "</TD></TR>");
                    out.println("		<TD>" + rs.getString(4) + "</TD></TR>");
                    out.println("		<TD>" + rs.getString(5) + "</TD></TR>");
                    out.println("		<TD>" + rs.getString(6) + "</TD></TR>");
                }
                out.println("  </TABLE>");
                out.println("  </BODY>");
                out.println("</HTML>");


                int count = stmt.executeUpdate(sql);
                out.println(count == 1 ? "保存成功" : "保存失败");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }


            PrintWriter writer = response.getWriter();

            writer.println("<br>username :" + username);
            writer.println("<br>password :" + password);
            writer.println("<br>email :" + email);
            writer.println("<br>gender :" + gender);
            writer.println("<br>birthDate :" + birthDate);
            writer.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
