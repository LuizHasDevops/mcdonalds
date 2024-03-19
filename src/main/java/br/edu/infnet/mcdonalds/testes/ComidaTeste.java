package br.edu.infnet.mcdonalds.testes;

import br.edu.infnet.mcdonalds.model.Comida;

public class ComidaTeste {

    public static void main(String[] args){

        Comida comidaTeste1 = new Comida("carne", 100,0L, 200, true, "alho");
        Comida comidaTeste2 = new Comida("Hamburgue", 50,1L,  30, false, "Queijo");
        Comida comidaTeste3 = new Comida("Lasanha", 45,2L,  23, false, "Presunto");
    }
}
