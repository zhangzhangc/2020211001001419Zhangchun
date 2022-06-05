package com.zhangchun.controller;

import com.zhangchun.dao.OrderDao;
import com.zhangchun.dao.UserDao;
import com.zhangchun.model.Order;
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
import java.util.List;

@WebServlet(name = "AccountDetailsServlet", value = "/accountDetails")
public class AccountDetailsServlet extends HttpServlet {
    private Connection con =null;
    @Override
    public void init() throws ServletException{
        con =(Connection) getServletContext().getAttribute("con");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        if(session!=null && session.getAttribute("user")!=null){
            User user =(User) session.getAttribute("user");
            int id =user.getId();
            UserDao dao =new UserDao();
            try{
                user=dao.findById(con,id);
                request.setAttribute("user",user);
                OrderDao orderDao =new OrderDao();
                List<Order> orderList=orderDao.findByUserId(con,id);
                request.setAttribute("orderList",orderList);
                request.getRequestDispatcher("WEB-INF/views/accountDetails.jsp").forward(request,response);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
            else{
                response.sendRedirect("login");

            }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }
}
