package br.edu.infnet.mcdonalds.controllers;


import br.edu.infnet.mcdonalds.model.Comida;
import br.edu.infnet.mcdonalds.services.impl.ComidaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/comidas")
public class ComidaController {

    @Autowired
    ComidaServiceImpl comidaService;

    @GetMapping("/index")
    public String getAll(Model model , @ModelAttribute("sucesso") Object sucesso,
                         @ModelAttribute("sucessoDelete") Object sucessoDelete,
                         @ModelAttribute("message") Object message) {
        model.addAttribute("module", "comida");
        model.addAttribute("comida", comidaService.findAll());

        model.addAttribute(sucesso);
        model.addAttribute(sucessoDelete);

        return "comidas/index";
    }

    @PostMapping("/addComida")
    public String add(Comida comida, Model model, RedirectAttributes redirectAttributes){
        System.out.println(comida);
        comidaService.save(comida);
        redirectAttributes.addFlashAttribute("sucesso", true);
        redirectAttributes.addFlashAttribute("message", "Comida adicionada com sucesso!");

        return "redirect:index";
    }

    @GetMapping("/remover-comida/{id}")
    public RedirectView delete(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes){

        model.addAttribute("module", "cervejas");

        try{
            comidaService.deleteById(id);
            redirectAttributes.addFlashAttribute("sucesso", true);
            redirectAttributes.addFlashAttribute("message", "Comida deletada com sucesso!");
        }catch (Exception ex){
            redirectAttributes.addFlashAttribute("sucessoDelete",false);
        }
        return new RedirectView("../index");
    }

    @PostMapping("/edit")
    public String update(Comida comida, Model model, RedirectAttributes redirectAttributes){
        comidaService.save(comida);
        redirectAttributes.addFlashAttribute("sucesso", true);
        redirectAttributes.addFlashAttribute("message", "Comida Editada com sucesso!");
        return "redirect:index";
    }

}
