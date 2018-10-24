package com.my.myservlet;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.mockito.exceptions.verification.NoInteractionsWanted;

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

    final HttpServletRequest req = mock(HttpServletRequest.class);
    final HttpServletResponse resp = mock(HttpServletResponse.class);
    final RequestDispatcher dispatcher = mock(RequestDispatcher.class);

    @Captor
    ArgumentCaptor <String> argumentGetParameter = ArgumentCaptor.forClass(String.class);
    ArgumentCaptor <String> argumentSetAttribute = ArgumentCaptor.forClass(String.class);

    @Test
    public void testServlet() throws ServletException, IOException {

        when(req.getParameter("username")).thenReturn("myName");
        when(req.getParameter("password")).thenReturn("myPassword");
        when(req.getRequestDispatcher("user.jsp")).thenReturn(dispatcher);

        helloServlet.doPost(req, resp);

        verify(req).setCharacterEncoding("UTF-8");
        verify(req, times(1)).getParameter("username");
        verify(req, times(1)).getParameter("password");
        verify(req, times(1)).getRequestDispatcher("user.jsp");
        verify(dispatcher).forward(req, resp);
        verify(req, times(2)).getParameter(argumentGetParameter.capture());
        verify(req, times(1)).setAttribute(eq("username"), argumentSetAttribute.capture());
        verify(req, times(1)).setAttribute(eq("password"), argumentSetAttribute.capture());
        verifyNoMoreInteractions(req, resp, dispatcher);

        List expectedGetParameter = asList("username", "password");
        assertEquals(expectedGetParameter, argumentGetParameter.getAllValues());
        List expectedSetAttribute = asList("myName", "myPassword");
        assertEquals(expectedSetAttribute, argumentSetAttribute.getAllValues());

    }

}