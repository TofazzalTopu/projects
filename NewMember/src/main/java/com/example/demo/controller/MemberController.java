package com.example.demo.controller;

import com.example.demo.Validator.AppUserValidator;
import com.example.demo.dao.AppUserDAO;
import com.example.demo.dao.CountryDAO;
import com.example.demo.formbean.AppUserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mdtofazzal.hossain on 4/1/2019.
 */

@Controller
@RequestMapping(value = "/member")
public class MemberController {
    @Autowired
    private AppUserDAO appUserDAO;

    @Autowired
    private CountryDAO countryDAO;

    @Autowired
    private AppUserValidator appUserValidator;

    // Set a form validator
    @InitBinder
    protected void initBinder(WebDataBinder dataBinder) {
        // Form target
        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }
        System.out.println("Target=" + target);

        if (target.getClass() == AppUserForm.class) {
            dataBinder.setValidator(appUserValidator);
        }
        // ...
    }


    @RequestMapping("/home")
    public String viewHome(Model model) {

        return "home";
    }
}
