package com.http.servlet;

import com.http.dto.UserDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


//куки хранятся на клиенте, сессии на сервере
@WebServlet("/sessions")
public class SessionServlet extends HttpServlet {

//    private static final String USER = "user";
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        var user = (UserDto) session.getAttribute(USER);
//        if (user == null) {
//            user = UserDto.builder()
//                    .id(25L)
//                    .mail("test@gmail.com")
//                    .build();
//            session.setAttribute(USER, user);
//        }
//
//    }
}
