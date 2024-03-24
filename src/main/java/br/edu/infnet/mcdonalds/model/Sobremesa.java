package br.edu.infnet.mcdonalds.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sobremesa extends Produto{

    @Column(nullable = false)
    private float quantidade;

    @Column(nullable = false)
    private boolean doce;

    @Column(nullable = false)
    private String informacao;

    private static final Logger logger = LoggerFactory.getLogger(Sobremesa.class);

    public Sobremesa(String nome, float valor, Long codigo, float quantidade, boolean doce, String informacao){
        this.setNome(nome);
        this.setValor(valor);
        this.setCodigo(codigo);
        this.doce = doce;
        this.informacao = informacao;
        setQuantidade(quantidade);

    }

    @Override
    public void preparar(){
        logger.info("Preparando a Sobremesa: {}", this.getNome());
    }

}
