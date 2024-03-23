package br.edu.infnet.mcdonalds.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

@Entity
public class Comida extends Produto{

    @Column(nullable = false)
    private float peso;

    @Column(nullable = false)
    private boolean vegano;

    @Column(nullable = false)
    private String ingredientes;

    public Comida(String nome, float valor, Long codigo, float peso, boolean vegano, String ingredientes){
        super(nome, valor, codigo);
        this.ingredientes = ingredientes;
        this.peso = peso;
        this.vegano = vegano;

    }

    @Override
    public void preparar() {
        System.out.println("Preparando a comida.");
    }

    @Override
    public String toString() {
        return null;
    }
}
