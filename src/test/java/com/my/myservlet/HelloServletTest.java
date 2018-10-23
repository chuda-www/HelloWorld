package com.my.myservlet;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

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

        verify(req, times(1)).getParameter("username");
        verify(req, times(1)).getParameter("password");
        verify(req, times(1)).getRequestDispatcher("user.jsp");
        verify(dispatcher).forward(req, resp);
//        verifyNoMoreInteractions(req, resp, dispatcher);

    }

    @Captor
    ArgumentCaptor <String> argument = ArgumentCaptor.forClass(String.class);

    @Test
    public void doSomeChecksWithCaptor() throws ServletException, IOException {
        final HttpServletRequest req = mock(HttpServletRequest.class);
        final HttpServletResponse resp = mock(HttpServletResponse.class);
        final RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        when(req.getParameter(anyString())).thenReturn("myName");
        when(req.getParameter(anyString())).thenReturn("myPassword");
        when(req.getRequestDispatcher("user.jsp")).thenReturn(dispatcher);


        helloServlet.doPost(req, resp);
        verify(req, times(2)).getParameter(argument.capture());

        List expected = asList("username", "password");
        assertEquals(expected, argument.getAllValues());

    }

    @Test
    public void doSetRequestTest() throws ServletException, IOException {
        final HttpServletRequest req = mock(HttpServletRequest.class);
        final HttpServletResponse resp = mock(HttpServletResponse.class);
        final RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        req.setAttribute("username", req.getParameter("username"));
        req.setAttribute("password", req.getParameter("password"));
        when(req.getRequestDispatcher("user.jsp")).thenReturn(dispatcher);

        helloServlet.doPost(req, resp);
        verify(req, times(2)).setAttribute("username", req.getParameter("username"));
        verify(req, times(2)).setAttribute("password", req.getParameter("password"));

    }

}