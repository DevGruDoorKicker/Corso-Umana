package com.business.cardatabase.web;

import com.business.cardatabase.domain.AccountCredentials;
import com.business.cardatabase.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping (value = "/login", method = RequestMethod.GET)
    public HttpEntity getToken(@RequestBody AccountCredentials credentials){

        System.out.println("interni a loginController - GetToken" + " " + credentials.getUsername() + " "+ credentials.getPassword());

        UsernamePasswordAuthenticationToken creds= new UsernamePasswordAuthenticationToken(credentials.getUsername(),credentials.getPassword());

        Authentication auth = authenticationManager.authenticate(creds);

        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + jwtService.getToken(auth.getName()))
                .build();

    }





}
