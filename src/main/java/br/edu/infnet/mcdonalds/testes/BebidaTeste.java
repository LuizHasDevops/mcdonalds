package br.edu.infnet.mcdonalds.testes;

import br.edu.infnet.mcdonalds.model.Bebida;

public class BebidaTeste {

    public static void main(String[] args){

        Bebida bebidaTeste1 = new Bebida("coca", 10, 0L, true, 2, "coca");
        Bebida bebidaTeste2 = new Bebida("pepsi", 20, 1L,  true,  5,"pepsi");
        Bebida bebidaTeste3 = new Bebida("kuat", 30, 2L,  false,  3,"kuat");
    }

}
