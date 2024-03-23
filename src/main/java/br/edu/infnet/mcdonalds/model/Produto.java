
package br.edu.infnet.mcdonalds.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.*;

@MappedSuperclass
@Setter
@Getter
public abstract class Produto {

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private float valor;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    public Produto(String nome, float valor, Long codigo) {
        this.nome = nome;
        this.codigo = codigo;
        this.valor = valor;
    }
    public abstract void preparar();
    public abstract String toString();

}
