package com.zhangchun.week6.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;



public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text=request.getParameter("text");
        String search=request.getParameter("search");


        if(text!=null ){


            if(search.equals("baidu")){
                response.sendRedirect("https://www.baidu.com/s?wd="+text);
            }else if (search.equals("bing")){
                response.sendRedirect("https://cn.bing.com/search?q="+text);
            }else if(search.equals("google")){
                response.sendRedirect("https://www.google.com/search?q="+text);
            }

        }else{

            request.getRequestDispatcher("index.jsp").forward(request,response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
