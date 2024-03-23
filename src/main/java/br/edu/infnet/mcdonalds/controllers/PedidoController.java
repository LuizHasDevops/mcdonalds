package br.edu.infnet.mcdonalds.controllers;


import br.edu.infnet.mcdonalds.model.Pedido;
import br.edu.infnet.mcdonalds.services.impl.PedidoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    PedidoServiceImpl pedidoService;

    @GetMapping("/index")
    public String getAll(Model model , @ModelAttribute("sucesso") Object sucesso,
                         @ModelAttribute("sucessoDelete") Object sucessoDelete,
                         @ModelAttribute("message") Object message) {
        model.addAttribute("module", "bebidas");
        model.addAttribute("bebidas", pedidoService.findAll());

        model.addAttribute(sucesso);
        model.addAttribute(sucessoDelete);

        return "pedido/index";
    }

    @PostMapping("/addPedido")
    public String add(Pedido pedido, Model model, RedirectAttributes redirectAttributes){
        System.out.println(pedido);
        pedidoService.save(pedido);
        redirectAttributes.addFlashAttribute("sucesso", true);
        redirectAttributes.addFlashAttribute("message", "Pedido adicionado com sucesso!");

        return "redirect:index";
    }

    @GetMapping("/remover-pedido/{id}")
    public RedirectView delete(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes){

        model.addAttribute("module", "pedido");

        try{
            pedidoService.deleteById(id);
            redirectAttributes.addFlashAttribute("sucesso", true);
            redirectAttributes.addFlashAttribute("message", "Pedido deletado com sucesso!");
        }catch (Exception ex){
            redirectAttributes.addFlashAttribute("sucessoDelete",false);
        }
        return new RedirectView("../index");
    }

    @PostMapping("/edit")
    public String update(Pedido pedido, Model model, RedirectAttributes redirectAttributes){
        pedidoService.save(pedido);
        redirectAttributes.addFlashAttribute("sucesso", true);
        redirectAttributes.addFlashAttribute("message", "Pedido Editado com sucesso!");
        return "redirect:index";
    }

}
