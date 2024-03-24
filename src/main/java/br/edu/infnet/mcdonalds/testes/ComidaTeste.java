package br.edu.infnet.mcdonalds.testes;

import br.edu.infnet.mcdonalds.model.Comida;

import java.util.UUID;

public class ComidaTeste {

    public static void main(String[] args){

        UUID codigo1 = UUID.randomUUID();
        UUID codigo2 = UUID.randomUUID();
        UUID codigo3 = UUID.randomUUID();

        Comida comidaTeste1 = new Comida("carne", 100,codigo1, 200, true, "alho");
        Comida comidaTeste2 = new Comida("Hamburgue", 50,codigo2,  30, false, "Queijo");
        Comida comidaTeste3 = new Comida("Lasanha", 45,codigo3,  23, false, "Presunto");
    }
}
