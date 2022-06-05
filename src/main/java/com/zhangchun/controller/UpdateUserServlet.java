package com.zhangchun.controller;

import com.zhangchun.dao.UserDao;
import com.zhangchun.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        String username =request.getParameter("username");
//        String password =request.getParameter("password");
//        String email =request.getParameter("email");
//        String gender =request.getParameter("gender");
//        Date birthDate = Date.valueOf(request.getParameter("birthDate"));
//
//
//        User user =new User();
//        user.setUsername("username");
//        user.setPassword("password");
//        user.setEmail("email");
//        user.setGender("gender");
////        user.setBirthDate("birthDate");
//        UserDao userDao=new UserDao();
//        userDao.updateUser(con,username,password,email,gender,birthDate);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");

//        Date birthDate = Date.valueOf(request.getParameter("birthDate"));
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setGender(gender);
//        user.setBirthDate(birthDate);
        UserDao userDao = new UserDao();
        try {
            int update = 0;
            try {
                update = userDao.updateUser(con, user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (update == 0) {
                request.getRequestDispatcher("accountDetails.jsp").forward(request, response);
            }

        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }


    }
}
