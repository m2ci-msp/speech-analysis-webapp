package com.speechanalysis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by plam on 17/08/16.
 */

@Controller
public class AccountController {
    @RequestMapping("/account")
    public String account(){
        return "account";
    }
}
