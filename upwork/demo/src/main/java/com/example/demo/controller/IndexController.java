package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@RequestMapping(value = "/index")
public class IndexController {

    @RequestMapping("/welcome")
    public String welcome(Map<String, Object> model) {
        model.put("message", "Welcome");
        return "welcome";
    }

    @RequestMapping("/index")
    public ModelAndView index(Map<String, Object> model) {
        model.put("message", "Welcome");
        ModelAndView view = new ModelAndView();
        view.setViewName("welcome");
        return view;
    }
}
