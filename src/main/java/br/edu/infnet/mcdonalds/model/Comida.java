package br.edu.infnet.mcdonalds.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comida extends Produto{

    @Column(nullable = false)
    private float peso;

    @Column(nullable = false)
    private boolean vegano;

    @Column(nullable = false)
    private String ingredientes;

    public Comida(String nome, float valor, Long codigo, float peso, boolean vegano, String ingredientes){
        this.setNome(nome);
        this.setValor(valor);
        this.setCodigo(codigo);
        this.ingredientes = ingredientes;
        this.peso = peso;
        this.vegano = vegano;
        setPeso(peso);

    }

    @Override
    public void preparar() {
        System.out.println("Preparando a comida.");
    }
}
