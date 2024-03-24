package br.edu.infnet.mcdonalds.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PedidoProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedidoProduto;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public PedidoProduto(Pedido pedido, Comida comida) {
        this.pedido = pedido;
        this.produto = comida;
    }

    public PedidoProduto(Pedido pedido, Bebida bebida) {
        this.pedido = pedido;
        this.produto = bebida;
    }

    public PedidoProduto(Pedido pedido, Sobremesa sobremesa) {
        this.pedido = pedido;
        this.produto = sobremesa;
    }

}
