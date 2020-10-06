package com.info.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@EnableResourceServer
@EnableAuthorizationServer
@RestController
@RequestMapping(value = "/")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/")
    public String getUserEmail(Principal principal){
        System.out.println("User Name " + principal.getName());
        return "Hello " + principal.getName();
    }

    @GetMapping("/login")
    public Principal login(Principal principal) {
        System.out.println("login User Name " + principal.getName());
        return principal;
    }

    @GetMapping("/show")
    public Principal show(Principal principal) {
        System.out.println("show User Name " + principal.getName());
        return principal;
    }
}
