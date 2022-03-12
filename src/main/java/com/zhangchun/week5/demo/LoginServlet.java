package com.zhangchun.week5.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet",value="/login")
public class LoginServlet extends HttpServlet {



    @Override
    public void init() throws ServletException {
        super.init();
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://localhost:1433;database=userdb;encrypt=false";
        String username = "sa";
        String password = "123456";

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out =response.getWriter();
        String username =request.getParameter("username");
        String password =request.getParameter("password");
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=userdb;encrypt=false",
                    "sa", "123456");
            stat = conn.prepareStatement("select *from usertable where username=? and password=?");
            stat.setString(1,username);
            stat.setString(2,password);
            rs = stat.executeQuery();
            if(rs.next()){
                out.println("Login Success!!!");
                out.println("Welcome!!!"+username);
            }else{
                out.println("Username or Password Error!!!");
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
