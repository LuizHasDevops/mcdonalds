package br.edu.infnet.mcdonalds.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForgotPasswordController {

    @GetMapping("/forgotpassword")
    public String showForgotPasswordPage() {
        return "forgotpassword";
    }
}
