package com.inventory.yasser.smartStash.models;

public class AuthenticationResponse {

    private final String response;
    private final String token;


    public AuthenticationResponse(String token, String response) {
        this.token = token;
        this.response = response;
    }

    public String getToken() {
        return token;
    }

    public String getResponse() {
        return response;
    }
}
