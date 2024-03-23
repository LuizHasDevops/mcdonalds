package br.edu.infnet.mcdonalds.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Embeddable
@Entity
@Data

public class Pedido {

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private LocalDateTime data;

    @Column(nullable = false)
    private boolean web;

    @Column(nullable = true)
    private List<Produto> listaDeProduto;

    @ManyToOne
    @JoinColumn(name = "solicitante_id")
    private Solicitante solicitante;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    public Pedido(String descricao, LocalDateTime data, boolean web, Long codigo) {
        this.descricao = descricao;
        this.data = data;
        this.web = web;
        this.codigo = codigo;
    }

    public Pedido(String descricao, LocalDateTime data, boolean web, List<Produto> listaDeProduto, Solicitante solicitante, Long codigo) throws Exception {
        this.descricao = descricao;
        this.web = web;
        this.listaDeProduto = listaDeProduto != null ? listaDeProduto : new ArrayList<>();
        this.solicitante = solicitante;
        this.codigo = codigo;
        setData(data);

    }

    public Pedido(String descricao, LocalDateTime data, boolean web, Produto produto, Solicitante solicitante) throws Exception {
        this.descricao = descricao;
        this.web = web;
        setData(data);
        this.listaDeProduto = new ArrayList<>();
        if (produto != null) {
            listaDeProduto.add(produto);
        }
        this.solicitante = solicitante;
    }

    public void setData(LocalDateTime data) throws Exception {
        LocalDateTime dataAtualFinalDoDia = LocalDateTime.of(LocalDateTime.now().toLocalDate(), LocalTime.MAX);

        if (data.isAfter(dataAtualFinalDoDia)) {
            throw new Exception("Não é permitido lançar data futura.");
        }
        this.data = data;
    }
    public void adicionarProduto(Produto produto) {
        if (listaDeProduto == null) {
            listaDeProduto = new ArrayList<>();
        }
        listaDeProduto.add(produto);
    }

}
