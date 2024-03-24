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
    private Long id;

    @ManyToOne
    private Pedido pedido;

    @ManyToOne
    private Comida comida;

    @ManyToOne
    private Bebida bebida;

    @ManyToOne
    private Sobremesa sobremesa;

    public PedidoProduto(Pedido pedido, Comida comida) {
        this.pedido = pedido;
        this.comida = comida;
    }

    public PedidoProduto(Pedido pedido, Bebida bebida) {
        this.pedido = pedido;
        this.bebida = bebida;
    }

    public PedidoProduto(Pedido pedido, Sobremesa sobremesa) {
        this.pedido = pedido;
        this.sobremesa = sobremesa;
    }

}
