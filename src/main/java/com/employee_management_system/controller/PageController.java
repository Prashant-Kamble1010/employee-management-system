package com.employee_management_system.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String index() {
        return "Home/index";
    }

    @GetMapping("/signup")
    public String signup() {
        return "Home/signup";
    }

    @GetMapping("/signin")
    public String signin() {
        return "Home/signin";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "Home/dashboard";
    }

    @GetMapping("/aboutus")
    public String about() {
        return "Home/aboutus";
    }

    @GetMapping("/contactus")
    public String contact() {
        return "Home/contactus";
    }
}