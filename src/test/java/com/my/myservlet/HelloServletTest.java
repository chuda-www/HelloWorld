package com.my.myservlet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

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

    @Mock
    private HttpServletRequest req;
    @Mock
    private HttpServletResponse resp;
    @Mock
    private RequestDispatcher dispatcher;

    @Captor
    ArgumentCaptor <String> argPostGetParameter;
    @Captor
    ArgumentCaptor <String> argPostSetAttribute;
    @Captor
    ArgumentCaptor <String> argPostDispatcher;
    @Captor
    ArgumentCaptor <String> argGetDispatcher;
    @Captor
    ArgumentCaptor <String> argGetSetAttribute;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
        verify(dispatcher).forward(req, resp);
        verifyNoMoreInteractions(req, resp, dispatcher);
    }

    @Test
    public void testDoPost() throws ServletException, IOException {

        when(req.getParameter(anyString())).thenReturn("TEST");
        when(req.getRequestDispatcher("user.jsp")).thenReturn(dispatcher);
        helloServlet.doPost(req, resp);

        verify(req).setCharacterEncoding("UTF-8");
        verify(req, times(1)).getRequestDispatcher(argPostDispatcher.capture());
        verify(req, times(2)).getParameter(anyString());
        verify(req, times(2)).getParameter(argPostGetParameter.capture());
        verify(req, times(2)).setAttribute(anyString(), argPostSetAttribute.capture());

        assertEquals("user.jsp", argPostDispatcher.getValue());
        List expectedGetParameter = asList("username", "password");
        assertEquals(expectedGetParameter, argPostGetParameter.getAllValues());
        assertEquals("TEST", argPostSetAttribute.getValue());

//        when(req.getParameter("username")).thenReturn("myName");
//        when(req.getParameter("password")).thenReturn("myPassword");
//        when(req.getRequestDispatcher("user.jsp")).thenReturn(dispatcher);
//        helloServlet.doPost(req, resp);
//        verify(req).setCharacterEncoding("UTF-8");
//        verify(req, times(1)).getParameter("username");
//        verify(req, times(1)).getParameter("password");
//        verify(req, times(1)).getRequestDispatcher(argPostDispatcher.capture());
//        verify(req, times(2)).getParameter(argPostGetParameter.capture());
//        verify(req, times(1)).setAttribute(eq("username"), argPostSetAttribute.capture());
//        verify(req, times(1)).setAttribute(eq("password"), argPostSetAttribute.capture());
//        assertEquals("user.jsp", argPostDispatcher.getValue());
//        List expectedGetParameter = asList("username", "password");
//        assertEquals(expectedGetParameter, argPostGetParameter.getAllValues());
//        List expectedSetAttribute = asList("myName", "myPassword");
//        assertEquals(expectedSetAttribute, argPostSetAttribute.getAllValues());

    }

    @Test
    public void testDoGet() throws ServletException, IOException {

        when(req.getHeader(anyString())).thenReturn("testName");
        when(req.getRequestDispatcher("myfile.jsp")).thenReturn(dispatcher);

        helloServlet.doGet(req, resp);

        verify(req, times(1)).getHeader("X-Name");
        verify(req, times(1)).setAttribute(eq("name"), argGetSetAttribute.capture());
        verify(req, times(1)).getRequestDispatcher(argGetDispatcher.capture());

        assertEquals("testName", argGetSetAttribute.getValue());
        assertEquals("myfile.jsp", argGetDispatcher.getValue());

    }

}