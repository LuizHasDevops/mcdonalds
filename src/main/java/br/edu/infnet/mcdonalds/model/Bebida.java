package br.edu.infnet.mcdonalds.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Entity
public class Bebida extends Produto{

    @Column(nullable = false)
    private boolean gelada;

    @Column(nullable = false)
    private float tamanho;

    @Column(nullable = false)
    private String marca;

    private static final Logger logger = LoggerFactory.getLogger(Produto.class);

    public Bebida(String nome, float valor, Long codigo, boolean gelada, float tamanho, String marca){
        super(nome, valor, codigo);
        this.setNome(nome);
        this.setValor(valor);
        this.setCodigo(codigo);
        this.gelada = gelada;
        this.marca = marca;
        this.tamanho = tamanho;

    }

    @Override
    public void preparar(){
        logger.info("Preparando o produto: {}", this.getNome());
    }

    @Override
    public String toString() {
        return null;
    }

}