package com.http.servlet;

import com.http.dto.CreateUserDto;
import com.http.entity.Gender;
import com.http.entity.Role;
import com.http.exception.ValidationException;
import com.http.service.UserService;
import com.http.util.UrlPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.util.List;

@MultipartConfig(location = "", fileSizeThreshold = 1024 * 1024)
@WebServlet(value = UrlPath.REGISTRATION, name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        if (true) throw new RuntimeException();
        req.setAttribute("roles", Role.values());
        req.setAttribute("gender", Gender.values());

        req.getRequestDispatcher("/WEB-INF/jsp/registration.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        var createUserDto = CreateUserDto.builder()
                .name(req.getParameter("username"))
                .Image(req.getPart("image"))
                .birthday(req.getParameter("birthday"))
                .email(req.getParameter("email"))
                .password(req.getParameter("password"))
                .role(req.getParameter("role"))
                .gender(req.getParameter("gender"))
                .build();

        try {
            userService.create(createUserDto);
            resp.sendRedirect("/login");
        } catch (ValidationException exception) {
            req.setAttribute("errors", exception.getErrorList());
            doGet(req, resp);
        }

    }










    //    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("roles", List.of("USER", "ADMIN"));
//        req.setAttribute("gender", List.of("MALE", "FEMALE"));
//
//        req.getRequestDispatcher("/WEB-INF/jsp/registration.jsp")
//                .forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("username");
//        String birthday = req.getParameter("birthday");
//        String email = req.getParameter("email");
//        String password = req.getParameter("password");
//        String role = req.getParameter("role");
//        String gender = req.getParameter("gender");
//
//
//    }
}
