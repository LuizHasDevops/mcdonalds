package br.edu.infnet.mcdonalds.repositories;

import br.edu.infnet.mcdonalds.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
