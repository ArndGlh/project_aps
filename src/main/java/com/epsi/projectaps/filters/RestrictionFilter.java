package com.epsi.projectaps.filters;

import com.epsi.projectaps.controller.RegisterController;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RestrictionFilter implements Filter {
    public static final String ACCES_PUBLIC     = "/index.xhtml";

    @Inject
    RegisterController registerController;

    public void init( FilterConfig config ) throws ServletException {
        System.out.println("filter init");
    }

    public void doFilter( ServletRequest req, ServletResponse res, FilterChain chain ) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        HttpSession session = request.getSession();

        if (!registerController.isLoggedIn()) {
            response.sendRedirect( request.getContextPath() + ACCES_PUBLIC );
        }
        else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {
    }
}