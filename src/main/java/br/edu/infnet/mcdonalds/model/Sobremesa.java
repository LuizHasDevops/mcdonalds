package br.edu.infnet.mcdonalds.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

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
        System.out.println("Preparando a sobremesa");
    }

}
