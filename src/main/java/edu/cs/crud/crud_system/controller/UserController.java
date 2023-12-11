package edu.cs.crud.crud_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user/about")
    public String aboutHtml() {
        return "/user/about";
    }

    @GetMapping("/user/biometric")
    public String biometricHtml() {
        return "/user/biometric";
    }

    @GetMapping("/user/dashboard")
    public String dashboardHtml() {
        return "/user/dashboard";
    }

    @GetMapping("/user/exercises")
    public String exercisesHtml() {
        return "/user/exercises";
    }

    @GetMapping("/user/food")
    public String foodHtml() {
        return "/user/food";
    }

    @GetMapping("/user/support")
    public String supportHtml() {
        return "/user/support";
    }
}
