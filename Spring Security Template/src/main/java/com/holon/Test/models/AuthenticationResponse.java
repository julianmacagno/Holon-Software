package com.holon.Test.models;

public class AuthenticationResponse {
    private String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public AuthenticationResponse() {
    }

    public String getJwt() {
        return jwt;
    }
}
