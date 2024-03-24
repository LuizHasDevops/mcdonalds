package br.edu.infnet.mcdonalds.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private LocalDateTime data;

    @Column(nullable = false)
    private boolean web;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<PedidoProduto> listaDeProduto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "solicitante_id", referencedColumnName = "codigo")
    private Solicitante solicitante;

    public Pedido(String descricao, LocalDateTime data, boolean web, int codigo) {
        this.descricao = descricao;
        this.data = data;
        this.web = web;
        this.codigo = codigo;
    }

    public void adicionarComida(Pedido pedido, Comida produto) {
        if (listaDeProduto == null) {
            listaDeProduto = new ArrayList<>();
        }
        listaDeProduto.add(new PedidoProduto(this, produto));
    }

    public void adicionarBebida(Pedido pedido, Bebida produto) {
        if (listaDeProduto == null) {
            listaDeProduto = new ArrayList<>();
        }
        listaDeProduto.add(new PedidoProduto(this, produto));
    }

    public void adicionarSobremesa(Pedido pedido, Sobremesa produto) {
        if (listaDeProduto == null) {
            listaDeProduto = new ArrayList<>();
        }
        listaDeProduto.add(new PedidoProduto(this, produto));
    }

}
