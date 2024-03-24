package br.edu.infnet.mcdonalds.testes;

import br.edu.infnet.mcdonalds.model.Sobremesa;

import java.util.UUID;

public class SobremesaTeste {

    public static void main(String[] args){

        UUID codigo1 = UUID.randomUUID();
        UUID codigo2 = UUID.randomUUID();
        UUID codigo3 = UUID.randomUUID();

        Sobremesa sobremesaTeste1 = new Sobremesa("Sorvete", 12,codigo1,  1, false, "Coco");
        Sobremesa sobremesaTeste2 = new Sobremesa("Bolo", 15, codigo2, 2, false, "chocolate");
        Sobremesa sobremesaTeste3 = new Sobremesa("Picole", 5, codigo3, 3, false, "Limao");
    }

}
