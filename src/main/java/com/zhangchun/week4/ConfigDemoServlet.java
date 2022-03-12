package com.zhangchun.week4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name="ConfigDemoServlet", urlPatterns={"/conig"},
        initParams={
                @WebInitParam( name="name",value="zhangchun"),
                @WebInitParam(name="studentid",value="2020211001001419")
        }
)


public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer =response.getWriter();

        writer.println("name:" + getServletConfig().getInitParameter("name"));
        writer.println("studentid:" + getServletConfig().getInitParameter("studentid"));



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
