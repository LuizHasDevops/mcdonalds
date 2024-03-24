package br.edu.infnet.mcdonalds.services.impl;

import br.edu.infnet.mcdonalds.model.*;
import br.edu.infnet.mcdonalds.repositories.BebidaRepository;
import br.edu.infnet.mcdonalds.repositories.ComidaRepository;
import br.edu.infnet.mcdonalds.repositories.PedidoRepository;
import br.edu.infnet.mcdonalds.repositories.SobremesaRepository;
import br.edu.infnet.mcdonalds.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ComidaRepository comidaRepository;
    @Autowired
    BebidaRepository bebidaRepository;

    @Autowired
    SobremesaRepository sobremesaRepository;

    @Override
    public void save(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> findById(UUID id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public void deleteById(UUID id) {
        pedidoRepository.deleteById(id);
    }

    @Override
    public Pedido update(UUID id, Pedido atualizada) {
        atualizada.setCodigo(id);
        return pedidoRepository.save(atualizada);
    }


    @Override
    public void adicionarItem(UUID pedidoId, UUID produtoId) {


        String tipoProduto = pedidoRepository.findTipoProdutoById(produtoId);

        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));

        switch (tipoProduto) {
            case "Comida":
                Comida comida = comidaRepository.findById(produtoId)
                        .orElseThrow(() -> new IllegalArgumentException("Comida não encontrada"));
                pedido.adicionarComida(pedido, comida);
                break;
            case "Bebida":
                Bebida bebida = bebidaRepository.findById(produtoId)
                        .orElseThrow(() -> new IllegalArgumentException("Bebida não encontrada"));
                pedido.adicionarBebida(pedido, bebida);
                break;
            case "Sobremesa":
                Sobremesa sobremesa = sobremesaRepository.findById(produtoId)
                        .orElseThrow(() -> new IllegalArgumentException("Sobremesa não encontrada"));
                pedido.adicionarSobremesa(pedido, sobremesa);
                break;
            default:
                throw new IllegalArgumentException("Produto não encontrado");
        }

        pedidoRepository.save(pedido);
    }

    @Override
    public void removerItem(UUID pedidoId, UUID itemId) {

        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));

        PedidoProduto itemToRemove = null;
        for (PedidoProduto item : pedido.getListaDeProduto()) {
            if (item.getProduto().getCodigo().equals(itemId)) {
                itemToRemove = item;
                break;
            }
        }

        if (itemToRemove != null) {
            pedido.getListaDeProduto().remove(itemToRemove);
            pedidoRepository.save(pedido);
        } else {
            throw new IllegalArgumentException("Item do pedido não encontrado");
        }
    }
}
