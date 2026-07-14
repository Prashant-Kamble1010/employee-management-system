package com.employee_management_system.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String index() {
        return "Home/index";
    }

    @GetMapping("/signu")
    public String signup() {
        return "Home/signup";
    }

    @GetMapping("/signi")
    public String signin() {
        return "Home/signin";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "Home/dashboard";
    }

    @GetMapping("/about")
    public String about() {
        return "Home/aboutus";
    }

    @GetMapping("/contact")
    public String contact() {
        return "Home/contactus";
    }
}