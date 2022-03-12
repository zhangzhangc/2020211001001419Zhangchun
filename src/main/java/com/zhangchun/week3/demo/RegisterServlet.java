package com.zhangchun.week3.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//@WebServlet(urlPatterns = {"/register"},loadOnStartup = 1)
public class RegisterServlet extends HttpServlet {
    Connection con=null;
//    Statement stmt = null;

    @Override
    public void init() throws ServletException {
        super.init();
    /*    ServletContext context=getServletContext();

        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");
        try {
            Class.forName(driver);
            con =DriverManager.getConnection(url,username,password);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        con = (Connection) getServletContext().getAttribute("con");



    }
//
//
//        try {
//            Class.forName(driver);
//            con = DriverManager.getConnection(url, username, password);
//            out.println("Connection --> in RegisterDemoServlet" + con);
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//
//        }
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        PrintWriter writer=response.getWriter();
        String username =request.getParameter("username");
        String password =request.getParameter("password");
        String email =request.getParameter("email");
        String gender =request.getParameter("gender");
        String birthDate =request.getParameter("birthDate");


        try {
            Statement st=con.createStatement();
            String sql="insert into usertable(username,password,email,gender,birthDate)"+
                    "values('"+username+"','"+password+"','"+email+"','"+gender+"','"+birthDate+"')";
            System.out.println("sql"+sql);

            int n= st.executeUpdate(sql);


            sql="select *from usertable";
            ResultSet rs =st.executeQuery(sql);
            PrintWriter out=response.getWriter();
//            out.println("<html><title></title><body><table border=1><tr>");
//            out.println("<td>UserName</td><td>Password</td><td>Email</td><td>Gender</td><td>birthDate</td>");
//            while(rs.next()){
//                out.println("<tr>");
//                out.println("<td>"+rs.getString("username")+"</td>");
//                out.println("<td>"+rs.getString("password")+"</td>");
//                out.println("<td>"+rs.getString("email")+"</td>");
//                out.println("<td>"+rs.getString("gender")+"</td>");
//                out.println("<td>"+rs.getString("birthDate")+"</td>");
//
//                out.println("</tr>");
//            }
//            out.println("</table></body></html>");
            request.setAttribute("name",rs);
            request.getRequestDispatcher("userList.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }






//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out =response.getWriter();
//        String username =request.getParameter("username");
//        String password =request.getParameter("password");
//        String email =request.getParameter("email");
//        String gender =request.getParameter("gender");
//        String birthDate =request.getParameter("birthDate");
//
//        Connection conn=null;
//        PreparedStatement stat =null;
//        ResultSet rs=null;
//        try{
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            conn =DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=userdb;encrypt=false",
//                    "sa","123456");
//            stat = conn.prepareStatement("insert into usertable values"+"(?,?,?,?,?)");
//            stat.setString(1, username);
//            stat.setString(2,password);
//            stat.setString(3,email);
//            stat.setString(4,gender);
//            stat.setString(5,birthDate);
//            stat.executeUpdate();
//            out.println("添加成功");
//            stat = conn.prepareStatement("select * from usertable");
//            rs = stat.executeQuery();
//            out.println("<HTML>");
//            out.println("<HEAD></HEAD>");
//            out.println("<BODY>");
//            out.println("<table border='1' cellpadding='0' cellspacing='0'  width='60%'> ");
//            out.println("<caption>用户信息表</caption>");
//            out.println("<tr><td>ID</td><td>username</td><td>password</td><td>email</td><td>gender</td><td>birthDate</td></tr>");
//            while(rs.next()){
//                int id=rs.getInt("id");
//                String username1=rs.getString("username");
//                String password1=rs.getString("password");
//                String email1=rs.getString("email");
//                String gender1=rs.getString("gender");
//                String birthDate1=rs.getString("birthDate");
//                out.println("<tr><td>"+
//                        id+"</td><td>"+
//                        username+"</td><td>"+
//                        password+"</td><td>"+
//                        email+"</td><td>"+
//                        gender+"</td><td>"+
//                        birthDate+"</td><td>");
//            }
//            out.println("</table>");
//
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//            out.println("添加失败");
//        } finally {
//            if (stat!=null){
//                try {
//                    stat.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

    }
}
