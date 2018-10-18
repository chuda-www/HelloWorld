package com.my.myservlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
    final static Logger log = LogManager.getLogger(HelloServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getHeader("X-Name");

        req.setAttribute("name", title);
        req.getRequestDispatcher("myfile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        log.debug(username + " " + password);
        req.setAttribute("username", username);
        req.setAttribute("password", password);

        PrintWriter out = resp.getWriter();
        req.getRequestDispatcher("user.jsp").forward(req, resp);
        // out.println("<html><body><p>" + req.getParameter("username") + "</p></body></html>");

    }

}

