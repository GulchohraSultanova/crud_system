package edu.cs.crud.crud_system.controller;

import edu.cs.crud.crud_system.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

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

    @GetMapping("/loginasadmin")
    public String loginAsAdminHtml() {
        return "/loginasadmin";
    }

    @GetMapping("/users")
    public String getAllUsersHtml(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping("/loginasadmin")
    public String loginAsAdmin(@RequestParam String username, @RequestParam String password) {
        if (username.equals("admin") && password.equals("admin")) {
            return "redirect:/users";
        }
        return "redirect:/error";
    }

}
