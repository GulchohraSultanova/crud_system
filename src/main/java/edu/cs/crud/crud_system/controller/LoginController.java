package edu.cs.crud.crud_system.controller;

import edu.cs.crud.crud_system.model.User;
import edu.cs.crud.crud_system.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class LoginController {

    private final UserService userService;

    @GetMapping("/main")
    public String main_menuHtml() {
        return "index";
    }

    @GetMapping("/main/register")
    public String registerHtml(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/main/register")
    public String register(@ModelAttribute("user") User user) {

        userService.createUser(user);
        return "redirect:/indexhtml";
    }

    @GetMapping("/indexhtml")
    public String indexHtmlHtml() {
        return "pleaselogin";
    }

    @GetMapping("/main/login")
    public String loginHtml() {
        return "login";
    }

    @PostMapping("/main/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        User user = userService.findByEmailAndPassword(email, password);


        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
            return "user/dashboard";
        }
        return "error";
    }

    @GetMapping("/user/about/{userId}")
    public String showAboutPage(@PathVariable Long userId, Model model) {
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "user/about";
    }


    @GetMapping("/users/edit/{userId}")
    public String editUserHtml(@PathVariable Long userId, Model model) {
        model.addAttribute("user", userService.getUserById(userId));
        return "edit_user";
    }

    @PostMapping("/users/{userId}")
    public String edit_user(@PathVariable Long userId, @ModelAttribute("user") User user) {
        User excitingUser = userService.getUserById(userId);

        excitingUser.setUserId(user.getUserId());
        excitingUser.setFirstname(user.getFirstname());
        excitingUser.setLastname(user.getLastname());
        excitingUser.setEmail(user.getEmail());
        excitingUser.setSex(user.getSex());
        excitingUser.setBirthday(user.getBirthday());
        excitingUser.setHeight(user.getHeight());
        excitingUser.setWeight(user.getWeight());
        excitingUser.setNumber(user.getNumber());

        userService.updateUser(excitingUser);

        return "redirect:/users";
    }

    @GetMapping("/users/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return "redirect:/users";
    }

    @GetMapping("/users/create_user")
    public String createUserHtml(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "create_user";
    }

    @PostMapping("/users")
    public String createUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/users";
    }
}
