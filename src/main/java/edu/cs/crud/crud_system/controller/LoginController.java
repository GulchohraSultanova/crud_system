package edu.cs.crud.crud_system.controller;

import edu.cs.crud.crud_system.model.Human;
import edu.cs.crud.crud_system.model.User;
import edu.cs.crud.crud_system.service.HumanService;
import edu.cs.crud.crud_system.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class LoginController {

    private final HumanService humanService;
    private final UserService userService;

    @GetMapping("/main")
    public String main_menuHtml() {
        return "index";
    }

    @GetMapping("/main/register")
    public String registerHtml(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("human", new Human());
        return "register";
    }

    @PostMapping("/main/register")
    public String register(@ModelAttribute("user") User user, @ModelAttribute("human") Human human) {

        user.setHuman(human);
        humanService.createHuman(human);
        userService.createUser(user);
        return "redirect:/indexhtml";
    }

    @GetMapping("/indexhtml")
    public String indexHtmlHtml(){
        return "pleaselogin";
    }

    @GetMapping("/main/login")
    public String loginHtml(){
        return "login";
    }

    @PostMapping("/main/login")
    public String login(@RequestParam String email, @RequestParam String password){
        User user= userService.findByEmailAndPassword(email,password);

        if(user!=null && user.getEmail().equals(email)&& user.getPassword().equals(password)){
                return "user/dashboard";
        }
        return "error";
    }
}
