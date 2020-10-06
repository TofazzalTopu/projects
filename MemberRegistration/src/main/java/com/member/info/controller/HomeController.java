package com.member.info.controller;

/**
 * Created by mdtofazzal.hossain on 4/3/2019.
 */

import com.member.info.model.User;
import com.member.info.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/userIndex")
    public String userIndex() {
        return "user/index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }


    @GetMapping("/userList")
    public String userList(User user) {
//        model.addAttribute("users", userRepository.findAll());

//        List<User> userList = userRepository.findAll();
        return "update-user";
    }


}
