package com.speechanalysis.security.service;

/**
 * Created by plam on 09/08/16.
 */

public interface SecurityService {
    String findLoggedInUsername();//find the name of the connected user

    void autologin(String username, String password);//connect the user automatically when he registered
}