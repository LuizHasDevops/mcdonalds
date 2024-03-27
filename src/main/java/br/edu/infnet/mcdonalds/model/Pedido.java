package br.edu.infnet.mcdonalds.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Pedido {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID codigo;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private LocalDateTime data;

    @Column(nullable = false)
    private boolean web;

    @OneToMany(mappedBy = "idPedidoProduto", cascade = CascadeType.ALL)
    private List<PedidoProduto> listaDeProduto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "solicitante_id", referencedColumnName = "codigo")
    private Solicitante solicitante;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Pedido(String descricao, LocalDateTime data, boolean web, UUID codigo) {
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
