package org.example.doitone;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// http://localhost:8080/param

@WebServlet(name = "paramServlet", urlPatterns = "/param")
public class ParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Request Parameter
        // /param?name={name}&age={age}
        String name = req.getParameter("name").toString();
        String age = req.getParameter("age").toString();

        System.out.println("name = " + name);
        System.out.println("age = " + age);

        resp.getWriter().write("param param!");
    }
}
