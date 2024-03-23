package br.edu.infnet.mcdonalds.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Data
@Entity

public class Solicitante {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String email;

    @Column(nullable = true)@Embedded
    private List<Pedido> listaDePedido;

    @Column(nullable = true)
    private Set<String> telefones;

    @Column(nullable = true)
    private String[] enderecos;

    public Solicitante(String nome, String cpf, String email){
        super();
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefones = new HashSet<>();
        this.enderecos = new String[3];
    }

    public Solicitante(String nome, String cpf, String email, Pedido pedido) throws Exception {
        this.nome = nome;
        this.cpf = cpf;
        this.telefones = new HashSet<>();
        this.enderecos = new String[3];
        setEmail(email);

        if (listaDePedido == null) {
            this.listaDePedido = new ArrayList<>();
            this.listaDePedido.add(pedido);
        }else {
            listaDePedido.add(pedido);
        }
    }

    public void setEmail(String email) throws Exception{
        Predicate<String> isValidEmail = emailAddress ->
                emailAddress.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");

        if (isValidEmail.test(email)) {
            this.email = email;
        } else {
            throw new Exception("O e-mail do solicitante é inválido.");
        }
    }
    public void adicionarPedido(Pedido pedido) {
        if (listaDePedido == null) {
            listaDePedido = new ArrayList<>();
        }
        listaDePedido.add(pedido);
    }

    public void adicionarEndereco(String endereco, int posicao) {
        if (posicao >= 0 && posicao < enderecos.length) {
            this.enderecos[posicao] = endereco;
        } else {
            System.out.println("Posição inválida para adicionar endereço.");
        }
    }

    public void adicionarTelefone(String telefone) {
        this.telefones.add(telefone);
    }
}
