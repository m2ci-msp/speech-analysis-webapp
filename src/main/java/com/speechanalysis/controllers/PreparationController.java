package com.speechanalysis.controllers;


import com.speechanalysis.model.Txt;
import com.speechanalysis.service.TxtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pmusset on 6/15/16.
 */

@Controller
public class PreparationController {

    private TxtService txtService;

    @Autowired
    public void setTxtService(TxtService txtService){
        this.txtService=txtService;
    }

    @ModelAttribute("txts")
    public List<Txt> populateTxts(){
        List<Txt> txtIterable = new ArrayList<Txt>();
        for (Txt t: txtService.listAllTxts()){
            System.out.println(t.getUrl());
            txtIterable.add(t);
        }
        return  txtIterable;
    }

    @RequestMapping("/preparation")
    public String listPreparation(Model model){
        return "preparation";
    }
}
