package br.edu.infnet.mcdonalds.controllers;

import br.edu.infnet.mcdonalds.model.Bebida;
import br.edu.infnet.mcdonalds.services.BebidaService;
import br.edu.infnet.mcdonalds.services.impl.BebidaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.UUID;

@Controller
@RequestMapping("/bebidas")
public class BebidaController {

    @Autowired
    BebidaServiceImpl bebidaService;

    @GetMapping("/index")
    public String getAll(Model model , @ModelAttribute("sucesso") Object sucesso,
                         @ModelAttribute("sucessoDelete") Object sucessoDelete,
                         @ModelAttribute("message") Object message) {
        model.addAttribute("module", "bebidas");
        model.addAttribute("bebidas", bebidaService.findAll());

        model.addAttribute(sucesso);
        model.addAttribute(sucessoDelete);

        return "bebidas/index";
    }

    @PostMapping("/addBebida")
    public String add(Bebida bebida, Model model, RedirectAttributes redirectAttributes){
        System.out.println(bebida);
        bebidaService.save(bebida);
        redirectAttributes.addFlashAttribute("sucesso", true);
        redirectAttributes.addFlashAttribute("message", "Bebida adicionada com sucesso!");

        return "redirect:index";
    }

    @GetMapping("/remover-bebida/{id}")
    public RedirectView delete(@PathVariable("id") UUID id, Model model, RedirectAttributes redirectAttributes){

        model.addAttribute("module", "cervejas");

        try{
            bebidaService.deleteById(id);
            redirectAttributes.addFlashAttribute("sucesso", true);
            redirectAttributes.addFlashAttribute("message", "Bebida deletada com sucesso!");
        }catch (Exception ex){
            redirectAttributes.addFlashAttribute("sucessoDelete",false);
        }
        return new RedirectView("../index");
    }

    @PostMapping("/edit")
    public String update(Bebida bebida, Model model, RedirectAttributes redirectAttributes){
        bebidaService.save(bebida);
        redirectAttributes.addFlashAttribute("sucesso", true);
        redirectAttributes.addFlashAttribute("message", "Bebida Editada com sucesso!");
        return "redirect:index";
    }

}
