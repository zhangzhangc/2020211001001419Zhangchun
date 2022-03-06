package com.zhangchun.week2.demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("Name :Zhangchun\n ID :2020211001001419\n Date and Time: 3/5" );


    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){

    }
}
