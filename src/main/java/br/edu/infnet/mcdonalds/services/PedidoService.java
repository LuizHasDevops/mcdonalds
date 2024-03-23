package br.edu.infnet.mcdonalds.services;


import br.edu.infnet.mcdonalds.model.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoService {

    void save(Pedido pedido);
    List<Pedido> findAll();
    Optional<Pedido> findById(Long id);
    Pedido update(Long id, Pedido atualizada);
    void deleteById(Long id);
}

