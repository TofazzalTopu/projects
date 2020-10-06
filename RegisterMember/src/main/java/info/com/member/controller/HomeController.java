package info.com.member.controller;

/**
 * Created by mdtofazzal.hossain on 4/3/2019.
 */

import info.com.member.model.User;
import info.com.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/home")
public class HomeController {

    @Autowired
    MemberRepository memberRepository;

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

    @GetMapping("/success")
    public String success() {
        return "success";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }


    @GetMapping("/userList")
    public String userList(User user) {
        return "update-user";
    }

}
