package br.edu.infnet.mcdonalds.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Sobremesa extends Produto{

    private float quantidade;

    private boolean doce;

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
