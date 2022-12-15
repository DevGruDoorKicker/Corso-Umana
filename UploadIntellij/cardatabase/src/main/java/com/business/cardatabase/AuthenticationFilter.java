package com.business.cardatabase;

import com.business.cardatabase.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        System.out.println("in AuthFilter");

        if (request.getRequestURI().equals("/login")){
            filterChain.doFilter(request,response);
            return;
        }

        String jwt = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(jwt!=null){
            String user = jwtService.getAuthUser(request);
            //token validation
            System.out.println(user);
            filterChain.doFilter(request,response);
        }


        else {

            try {
                throw new ServletException("Not Authorized");
            } catch (ServletException se) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        }
    }
}
