package br.edu.infnet.mcdonalds.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Solicitante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "solicitante", cascade = CascadeType.ALL)
    private List<Pedido> listaDePedido;

    public Solicitante(String nome, String cpf, String email){
        super();
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public Solicitante(String nome, String cpf, String email, Pedido pedido) throws Exception {
        this.nome = nome;
        this.cpf = cpf;
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

}
