package br.edu.infnet.mcdonalds.controllers;

import br.edu.infnet.mcdonalds.model.Sobremesa;
import br.edu.infnet.mcdonalds.services.impl.SobremesaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/sobremesa")
public class SobremesaController {

    @Autowired
    SobremesaServiceImp sobremesaService;

    @GetMapping("/index")
    public String getAll(Model model , @ModelAttribute("sucesso") Object sucesso,
                         @ModelAttribute("sucessoDelete") Object sucessoDelete,
                         @ModelAttribute("message") Object message) {
        model.addAttribute("module", "sobremesa");
        model.addAttribute("bebidas", sobremesaService.findAll());

        model.addAttribute(sucesso);
        model.addAttribute(sucessoDelete);

        return "bebidas/index";
    }

    @PostMapping("/addBebida")
    public String add(Sobremesa sobremesa, Model model, RedirectAttributes redirectAttributes){
        System.out.println(sobremesa);
        sobremesaService.save(sobremesa);
        redirectAttributes.addFlashAttribute("sucesso", true);
        redirectAttributes.addFlashAttribute("message", "Sobremesa adicionada com sucesso!");

        return "redirect:index";
    }

    @GetMapping("/remover-sobremesa/{id}")
    public RedirectView delete(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes){

        model.addAttribute("module", "sobremesa");

        try{
            sobremesaService.deleteById(id);
            redirectAttributes.addFlashAttribute("sucesso", true);
            redirectAttributes.addFlashAttribute("message", "Sobremesa deletada com sucesso!");
        }catch (Exception ex){
            redirectAttributes.addFlashAttribute("sucessoDelete",false);
        }
        return new RedirectView("../index");
    }

    @PostMapping("/edit")
    public String update(Sobremesa sobremesa, Model model, RedirectAttributes redirectAttributes){
        sobremesaService.save(sobremesa);
        redirectAttributes.addFlashAttribute("sucesso", true);
        redirectAttributes.addFlashAttribute("message", "Sobremesa Editada com sucesso!");
        return "redirect:index";
    }

}
