package br.edu.infnet.mcdonalds.services;

import br.edu.infnet.mcdonalds.model.Comida;
import br.edu.infnet.mcdonalds.model.Pedido;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PedidoService {

    void save(Pedido pedido);
    List<Pedido> findAll();
    Optional<Pedido> findById(UUID id);
    void deleteById(UUID id);
    Pedido update(UUID id, Pedido atualizada);

    void adicionarItem(UUID pedidoId, UUID produtoId);
    void removerItem(UUID pedidoId, UUID itemId);

}
