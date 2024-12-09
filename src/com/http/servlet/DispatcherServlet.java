package com.http.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/dispatcher")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/flights");
//        req.setAttribute("1", "234");
//        requestDispatcher.forward(req, resp);

//        перенаправляет запрос и больше уже его не изменить в текущем сервлете
//        req.getRequestDispatcher("/flights").forward(req, resp);

//        после перенаправления запроса можно дальше писать в OutputStream/Writer
//        req.getRequestDispatcher("/flights").include(req, resp);
//
//        var writer = resp.getWriter();
//        writer.write("Hello 2");

//          говорим клиенту перенаправить запрос на /flights
        resp.sendRedirect("/flights");

        System.out.println();
    }
}
