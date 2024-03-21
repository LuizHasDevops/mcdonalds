package br.edu.infnet.mcdonalds.controllers;

import br.edu.infnet.mcdonalds.model.Usuario;
import br.edu.infnet.mcdonalds.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/signup")
public class SignupController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public String showSignupForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "signup";
    }

    @PostMapping("/save-signup")
    public String signup(Usuario usuario, RedirectAttributes redirectAttributes) {
        // Lógica para salvar o usuário no banco de dados
        usuarioService.save(usuario);
        redirectAttributes.addFlashAttribute("signupSuccess", true);
        return "redirect:/login";
    }
}
