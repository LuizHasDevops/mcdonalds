package br.edu.infnet.mcdonalds.controllers;

import br.edu.infnet.mcdonalds.model.Pedido;
import br.edu.infnet.mcdonalds.services.impl.PedidoServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.UUID;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    PedidoServiceImpl pedidoService;

    private static final Logger logger = LoggerFactory.getLogger(BebidaController.class);

    @GetMapping("/listar-todos")
    public String getAll(Model model , @ModelAttribute("sucesso") Object sucesso,
                         @ModelAttribute("sucessoDelete") Object sucessoDelete,
                         @ModelAttribute("message") Object message) {
        model.addAttribute("module", "pedidos");
        model.addAttribute("pedidos", pedidoService.findAll());

        model.addAttribute(sucesso);
        model.addAttribute(sucessoDelete);

        return "redirect:/meus_pedidos";
    }

    @PostMapping("/adicionar")
    public String add(Pedido pedido, Model model, RedirectAttributes redirectAttributes){
        logger.info(pedido.toString());
        pedidoService.save(pedido);
        redirectAttributes.addFlashAttribute("sucesso", true);
        redirectAttributes.addFlashAttribute("message", "Bebida adicionada com sucesso!");

        return "redirect:index";
    }

    @GetMapping("/remover/{id}")
    public RedirectView delete(@PathVariable("id") UUID id, Model model, RedirectAttributes redirectAttributes){

        model.addAttribute("module", "cervejas");

        try{
            pedidoService.deleteById(id);
            redirectAttributes.addFlashAttribute("sucesso", true);
            redirectAttributes.addFlashAttribute("message", "Bebida deletada com sucesso!");
        }catch (Exception ex){
            redirectAttributes.addFlashAttribute("sucessoDelete",false);
        }
        return new RedirectView("../index");
    }

    @PostMapping("/edit")
    public String update(Pedido pedido, Model model, RedirectAttributes redirectAttributes){
        pedidoService.save(pedido);
        redirectAttributes.addFlashAttribute("sucesso", true);
        redirectAttributes.addFlashAttribute("message", "Bebida Editada com sucesso!");
        return "redirect:index";
    }
}
