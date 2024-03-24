package br.edu.infnet.mcdonalds.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Bebida extends Produto{

    @Column(nullable = false)
    private boolean gelada;

    @Column(nullable = false)
    private float tamanho;

    @Column(nullable = false)
    private String marca;

    private static final Logger logger = LoggerFactory.getLogger(Bebida.class);

    public Bebida(String nome, float valor, Long codigo, boolean gelada, float tamanho, String marca){
        super();
        this.setNome(nome);
        this.setValor(valor);
        this.setCodigo(codigo);
        this.gelada = gelada;
        this.marca = marca;
        setTamanho(tamanho);

    }

    @Override
    public void preparar(){
        logger.info("Preparando o produto: {}", this.getNome());
    }

}