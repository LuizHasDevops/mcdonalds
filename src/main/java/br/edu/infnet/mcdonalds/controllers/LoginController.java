package br.edu.infnet.mcdonalds.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {
    @GetMapping("/login")
    public String getAll(){

        return "login";
    }
    @GetMapping("/signup")
    public String showSignUpForm() {

        return "signup";
    }

    @GetMapping("/index")
    public String getIndexPage() {

        return "index";
    }

    @GetMapping("/forgotpassword")
    public String showForgotPasswordForm() {
        return "forgotpassword";
    }

}
