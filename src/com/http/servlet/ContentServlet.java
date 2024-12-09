package com.http.servlet;

import com.http.dto.FlightDto;
import com.http.service.FlightService;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/content")
public class ContentServlet extends HttpServlet {

    private final FlightService flightService = FlightService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<FlightDto> flightsDto = flightService.findAll();

        req.setAttribute("flights", flightsDto);
        req.getSession().setAttribute("flightsMap", flightsDto.stream().collect(Collectors.toMap(FlightDto::getId, FlightDto::getDescription)));

        try (ServletOutputStream outputStream = resp.getOutputStream()) {
            outputStream.write(1);
        }

        req.getRequestDispatcher("/WEB-INF/jsp/content.jsp")
                .forward(req, resp);





    }
}
