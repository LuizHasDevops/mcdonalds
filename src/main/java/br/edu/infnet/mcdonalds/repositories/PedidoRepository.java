package br.edu.infnet.mcdonalds.repositories;

import br.edu.infnet.mcdonalds.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface PedidoRepository extends JpaRepository<Pedido, UUID> {

    @Query("SELECT CASE "
            + "WHEN (SELECT COUNT(*) FROM Comida c WHERE c.codigo = :produtoId) > 0 THEN 'Comida' "
            + "WHEN (SELECT COUNT(*) FROM Bebida b WHERE b.codigo = :produtoId) > 0 THEN 'Bebida' "
            + "WHEN (SELECT COUNT(*) FROM Sobremesa s WHERE s.codigo = :produtoId) > 0 THEN 'Sobremesa' "
            + "ELSE 'Produto não encontrado' "
            + "END "
            + "FROM Pedido")
    String findTipoProdutoById(@Param("produtoId") UUID produtoId);


}
