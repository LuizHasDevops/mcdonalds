package br.edu.infnet.mcdonalds.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.*;


@Entity
public class Sobremesa extends Produto{

    @Column(nullable = false)
    private float quantidade;

    @Column(nullable = false)
    private boolean doce;

    @Column(nullable = false)
    private String informacao;

    public Sobremesa(String nome, float valor, Long codigo, float quantidade, boolean doce, String informacao){
        super(nome, valor, codigo);
        this.doce = doce;
        this.informacao = informacao;
        this.quantidade = quantidade;

    }

    @Override
    public void preparar(){
        System.out.println("Preparando a sobremesa");
    }

    @Override
    public String toString() {
        return null;
    }

}
