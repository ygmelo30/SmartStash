package com.inventory.yasser.smartStash.models;

public class AuthenticationResponse {

    private  String response;
    private  String token;


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
