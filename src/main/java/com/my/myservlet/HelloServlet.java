package com.my.myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("findname");
        PrintWriter out = resp.getWriter();

        req.setAttribute("name", req.getParameter("findname"));

//        out.write("hello "+title+" from servlet");
        req.getRequestDispatcher("myfile.jsp").forward(req, resp);

    }
}