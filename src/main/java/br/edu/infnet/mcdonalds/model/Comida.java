package br.edu.infnet.mcdonalds.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger logger = LoggerFactory.getLogger(Comida.class);

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
        logger.info("Preparando a Comida: {}", this.getNome());
    }
}
