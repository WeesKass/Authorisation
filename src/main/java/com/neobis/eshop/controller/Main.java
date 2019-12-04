package com.neobis.eshop.controller;

import com.neobis.eshop.entity.User;
import com.neobis.eshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class Main{
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerForm(Model model) {

        model.addAttribute("user", new User());
        return "views/registerForm";
    }


    @PostMapping("/register")
    public String registerUser(@Valid User user, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "views/registerForm";
        }
        if(userService.isUserPresent(user.getEmail())) {
            model.addAttribute("exist",true);

            return "views/registerForm";

        }
        userService.createUser(user);

        return "views/main";

    }
    @GetMapping("/")
    public String showIndexPage() {

        return "index";
    }

    @GetMapping("/main")
    public String showMain(){
        return "views/main";
    }


    @GetMapping("/login")
    public String showLoginForm() {

        return "views/loginForm";
    }


}