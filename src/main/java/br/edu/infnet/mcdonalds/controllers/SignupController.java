package br.edu.infnet.mcdonalds.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
 public class SignupController {

    @GetMapping()
    public String showSignUpPage(Model model) {
        // Adicione aqui qualquer lógica necessária para a página de SignUp
        return "redirect:/signup";
    }
}
