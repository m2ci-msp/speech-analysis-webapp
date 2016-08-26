package com.speechanalysis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by plam on 21/07/16.
 */
@Controller
public class resultController {
    @RequestMapping("/resultanalysis")
    String resultanalysis(){ return "report"; }

    @RequestMapping("/comparison")
    String comparison(){ return "signal_comparison"; }
}
