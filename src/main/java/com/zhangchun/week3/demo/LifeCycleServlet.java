package com.zhangchun.week3.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LifeCycleServlet extends HttpServlet {

    public LifeCycleServlet(){
        System.out.println("i am in constructor --> LifeCycleServlet()");
    }
    public void init(){
        System.out.println("i am in init()");

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("i am in service()--> doGet()");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    public void destroy(){
        System.out.println("i am in destroy()--> doGet()");

    }
}
