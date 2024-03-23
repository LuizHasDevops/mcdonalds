package br.edu.infnet.mcdonalds.services.impl;


import br.edu.infnet.mcdonalds.model.Pedido;
import br.edu.infnet.mcdonalds.repositories.PedidoRepository;
import br.edu.infnet.mcdonalds.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    @Override
    public void save(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> findById(Long id) {
        return findById(id);
    }

    @Override
    public Pedido update(Long id, Pedido atualizada) {
        atualizada.setCodigo(id);
        return pedidoRepository.save(atualizada);
    }

    @Override
    public void deleteById(Long id) {
        pedidoRepository.deleteById(id);
    }
}

