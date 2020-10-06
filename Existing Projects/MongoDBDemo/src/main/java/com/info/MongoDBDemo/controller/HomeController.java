package com.info.MongoDBDemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mdtofazzal.hossain on 2/25/2019.
 */

@RestController
@RequestMapping(value = "/home")
public class HomeController {

    @RequestMapping(value = "/val")
    public String getValue(){
        return "This Is The First Test MongoDB Application";
    }



}
