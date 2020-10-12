package com.tofazzal.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tofazzal.model.Employee;

@Controller
public class EmployeeController {

    @RequestMapping(value = "/user/getEmployeesList", produces = "application/json")
    @ResponseBody
    public List<Employee> getEmployeesList() {
        List<Employee> employees = new ArrayList<>();
        Employee emp = new Employee();
        emp.setEmpId("2");
        emp.setEmpName("emp1");
        employees.add(emp);
        return employees;

    }

    @PostMapping(value = "/login")
    public String login(){
        return "LoginPage";
    }

}