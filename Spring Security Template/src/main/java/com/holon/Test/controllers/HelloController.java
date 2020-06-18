package com.holon.Test.controllers;

import com.holon.Test.models.AuthenticationRequest;
import com.holon.Test.models.AuthenticationResponse;
import com.holon.Test.services.MyUserDetailsService;
import com.holon.Test.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
class HelloWorldController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @RequestMapping(value="/hello", produces = "application/json")
    public HashMap<String, String> helloWorld() {
        HashMap map = new HashMap<String, String>();
        map.put("Response", "Hello World");
        return map;
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authReq) throws Exception {
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(authReq.getUsername(), authReq.getPassword()));
        } catch (BadCredentialsException e ) {
            throw new Exception("Incorrect Username or Password provided", e);
        }

        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authReq.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @RequestMapping({ "/vevo" })
    public String vevo() {
        return "Vevo";
    }
}
