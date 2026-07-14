package com.employee_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.employee_management_system.entity.Employee;
import com.employee_management_system.service.EmployeeService;

@Controller
public class AuthController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    @GetMapping("/signin")
    public String signinPage() {
        return "signin";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee,
                               @RequestParam String confirmPassword,
                               Model model) {

        if (!employee.getPassword().equals(confirmPassword)) {
            model.addAttribute("error",
                    "Password and Confirm Password do not match");
            return "signup";
        }

        service.saveEmployee(employee);

        model.addAttribute("success",
                "Registration Successful. Please Login.");

        return "signin";
    }

    @PostMapping("/loginEmployee")
    public String loginEmployee(@RequestParam String email,
                                @RequestParam String password,
                                Model model) {

        Employee employee = service.login(email);

        if (employee != null &&
                employee.getPassword().equals(password)) {

            model.addAttribute("employee", employee);

            return "dashboard";
        }

        model.addAttribute("error",
                "Invalid Email or Password");

        return "signin";
    }
}