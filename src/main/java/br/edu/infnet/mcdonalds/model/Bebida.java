package br.edu.infnet.mcdonalds.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import java.util.UUID;
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

    @Column(nullable = true)
    private boolean gelada;

    @Column(nullable = true)
    private float tamanho;

    @Column(nullable = true)
    private String marca;

    private static final Logger logger = LoggerFactory.getLogger(Bebida.class);

    public Bebida(String nome, float valor, UUID codigo, boolean gelada, float tamanho, String marca){
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
        logger.info("Preparando a Bebida {}", this.getNome());
    }

}