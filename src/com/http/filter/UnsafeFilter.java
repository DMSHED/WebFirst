package com.http.filter;

import com.http.dao.UserDao;
import com.http.dto.UserDto;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/admin")
public class UnsafeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        UserDto user = (UserDto)((HttpServletRequest) servletRequest).getSession().getAttribute("user");

        if (user != null) {
            filterChain.doFilter(servletRequest,servletResponse);
        } else{
            ((HttpServletResponse) servletResponse).sendRedirect("/registration");
        }
    }
}
