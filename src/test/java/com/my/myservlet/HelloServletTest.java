package com.my.myservlet;

import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.*;

public class HelloServletTest extends Mockito {

    private HelloServlet helloServlet = new HelloServlet();

    @Test
    public void testServlet() throws ServletException, IOException {
        final HttpServletRequest req = mock(HttpServletRequest.class);
        final HttpServletResponse resp = mock(HttpServletResponse.class);
        final RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        when(req.getParameter("username")).thenReturn("test_username");
        when(req.getParameter("password")).thenReturn("test_password");
        when(req.getRequestDispatcher("user.jsp")).thenReturn(dispatcher);

        helloServlet.doPost(req, resp);

        verify(req, atLeast(1)).getParameter("username");
        verify(req, atLeast(1)).getParameter("password");
        verify(req, atLeast(1)).getRequestDispatcher("user.jsp");
        verify(dispatcher).forward(req, resp);

    }
}