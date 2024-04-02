package org.example.doitone;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

// http://localhost:8080/json

@WebServlet(name = "jsonServlet", urlPatterns = "/json")
public class JsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletInputStream inputStream = req.getInputStream();
        String body = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        JsonData jsonData = objectMapper.readValue(body, JsonData.class);
        System.out.println("jsonData.name = " + jsonData.name);
        System.out.println("jsonData.age = " + jsonData.age);

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write(jsonData.name + "님 반갑습니다!");
    }

    @Data
    static class JsonData {
        String name;
        int age;
    }
    // ORM : Object Relation Mapping
    // json <-> 객체
}
