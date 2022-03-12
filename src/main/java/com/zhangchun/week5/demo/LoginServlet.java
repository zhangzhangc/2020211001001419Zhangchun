package com.zhangchun.week5.demo;

import com.zhangchun.dao.UserDao;
import com.zhangchun.model.User;

import javax.servlet.ServletContext;
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
    Connection con=null;



    @Override
    public void init() throws ServletException {
        super.init();
            ServletContext context=getServletContext();

        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");
        try {
            Class.forName(driver);
            con =DriverManager.getConnection(url,username,password);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request,response);
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out =response.getWriter();
        String username =request.getParameter("username");
        String password =request.getParameter("password");
        UserDao userDao= new UserDao();
        try {
            User user=userDao.findByUsernamePassword(con,username,password);
            if(user!=null){
                request.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);

            }else{
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PreparedStatement stat = null;
        ResultSet rs = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=userdb;encrypt=false",
                    "sa", "123456");
            stat = con.prepareStatement("select *from usertable where username=? and password=?");
            stat.setString(1, username);
            stat.setString(2, password);
            rs = stat.executeQuery();
           /* if(rs.next()){
//                out.println("Login Success!!!");
//                out.println("Welcome!!!"+username);
                request.setAttribute("id",rs.getInt("id"));
                request.setAttribute("username",rs.getString("username"));
                request.setAttribute("password",rs.getString("password"));
                request.setAttribute("email",rs.getString("email"));
                request.setAttribute("gender",rs.getString("gender"));
                request.setAttribute("birthDate",rs.getString("birthDate"));

                request.getRequestDispatcher("userInfo.jsp").forward(request,response);

            }else{
//                out.println("Username or Password Error!!!");
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }*/

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
