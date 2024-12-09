package com.http.filter;

import com.http.servlet.RegistrationServlet;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;

import java.io.IOException;
import java.nio.charset.StandardCharsets;



//@WebFilter(servletNames = {
//        "RegistrationServlet"
//        },
//        initParams = {
//        @WebInitParam(name = "param1", value = "paramValue")
//        }
//)
//в основном задается просто urlPatterns
@WebFilter(urlPatterns = "/*")
public class CharsetFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(StandardCharsets.UTF_8.name());
        servletResponse.setCharacterEncoding(StandardCharsets.UTF_8.name());

        filterChain.doFilter(servletRequest, servletResponse);
    }

}
