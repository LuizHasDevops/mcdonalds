package br.edu.infnet.mcdonalds.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class LogoutController {
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        // Aqui você encerraria a sessão do usuário
        request.getSession().invalidate();
        // Redireciona para a página de login ou para a página inicial
        return "redirect:/login";
    }
}
