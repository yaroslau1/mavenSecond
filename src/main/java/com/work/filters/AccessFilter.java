package com.work.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import java.io.IOException;

public class AccessFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String action = request.getParameter("action");
        System.out.println(action);

        if (action == null) {
            action = "/logIn";
        }

        switch (action) {
            case "/insert":
                check(request, response, filterChain);
                break;
            case "/delete":
                check(request, response, filterChain);
                break;
            case "/update":
                check(request, response, filterChain);
                break;
            case "/validateUpdate":
                check(request, response, filterChain);
                break;
            case "/validateInsert":
                check(request, response, filterChain);
                break;
            case "/validateFindByName":
                check(request, response, filterChain);
                break;
            case "/logIn":
                filterChain.doFilter(request, response);
                break;
            case "/signIn":
                filterChain.doFilter(request, response);
                break;
            default:
                check(request, response, filterChain);
                break;
        }
    }

    private void check(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("userRole");
        if(role.equals("admin")){
            filterChain.doFilter(request, response);
        } else{
            request.getRequestDispatcher("/accessDenied.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
