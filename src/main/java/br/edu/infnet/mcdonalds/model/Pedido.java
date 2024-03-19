package br.edu.infnet.mcdonalds.model;

import lombok.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Pedido {

    private String descricao;

    private LocalDateTime data;

    private boolean web;

    private List<Produto> listaDeProduto;

    private Solicitante solicitante;

    private int codigo;

    public Pedido(String descricao, LocalDateTime data, boolean web, int codigo) {
        this.descricao = descricao;
        this.data = data;
        this.web = web;
        this.codigo = codigo;
    }

    public Pedido(String descricao, LocalDateTime data, boolean web, List<Produto> listaDeProduto, Solicitante solicitante, int codigo) throws Exception {
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
