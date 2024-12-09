package com.http.servlet;

import com.http.service.TicketService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/ticket")
public class TicketServlets extends HttpServlet {
    private final TicketService ticketService = TicketService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var flightId = Long.valueOf(req.getParameter("flightId"));
        req.setAttribute("tickets", ticketService.findAll(flightId));

        req.getRequestDispatcher("/WEB-INF/jsp/tickets.jsp")
                .forward(req, resp);


//        resp.setContentType("text/html");
//        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
//
//        var paramValue = Long.valueOf(req.getParameter("flightId"));
//
//        try(PrintWriter printWriter = resp.getWriter()) {
//            printWriter.write("<h1>Список билетов </h1>");
//            printWriter.write("<ul>");
//            ticketService.findAll(paramValue).forEach(ticketDto -> {
//                printWriter.write("""
//                        <li>
//                            Ticket id: %d, Description: %s
//                        </li>
//                        """.formatted(ticketDto.getId(), ticketDto.getDescription()));
//            });
//            printWriter.write("</ul>");
//        }



    }
}
