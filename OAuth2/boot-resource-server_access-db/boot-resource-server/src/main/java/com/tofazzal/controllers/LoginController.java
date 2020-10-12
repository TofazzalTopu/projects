package com.tofazzal.controllers;

import com.tofazzal.model.Employee;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/")
public class LoginController {

    @PostMapping(value = "/login")
    public String login(){
        List<Employee> employees = new ArrayList<>();
        Employee emp = new Employee();
        emp.setEmpId("2");
        emp.setEmpName("emp1");
        employees.add(emp);
        return "LoginPage";
    }
    @GetMapping(value = "/success")
    public String success(){
        Object principle = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Employee> employees = new ArrayList<>();
        Employee emp = new Employee();
        emp.setEmpId("2");
        emp.setEmpName("emp1");
        employees.add(emp);
        return principle.toString();
    }

    @GetMapping(value = "/")
    public String successs(){
        Object principle = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Employee> employees = new ArrayList<>();
        Employee emp = new Employee();
        emp.setEmpId("2");
        emp.setEmpName("emp1");
        employees.add(emp);
        return "LoginPage";
    }
}
