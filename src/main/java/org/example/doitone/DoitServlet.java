package org.example.doitone;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// http://localhost:8080/doit

@WebServlet(name = "doitServlet", urlPatterns = "/doit")
public class DoitServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { // control + o

        String requestUrl = req.getRequestURL().toString(); // option + command + v
        System.out.println("requestUrl = " + requestUrl); // soutv
        resp.getWriter().write("Do it!");
    }
}
