package br.edu.infnet.mcdonalds.testes;

import br.edu.infnet.mcdonalds.model.Bebida;

import java.util.UUID;

public class BebidaTeste {

    public static void main(String[] args){

        UUID codigo1 = UUID.randomUUID();
        UUID codigo2 = UUID.randomUUID();
        UUID codigo3 = UUID.randomUUID();

        Bebida bebidaTeste1 = new Bebida("coca", 30, codigo1, true, 10, "coca");
        Bebida bebidaTeste2 = new Bebida("pepsi", 20, codigo2,  true,  5,"pepsi");
        Bebida bebidaTeste3 = new Bebida("kuat", 30, codigo3,  false,  3,"kuat");
    }

}
