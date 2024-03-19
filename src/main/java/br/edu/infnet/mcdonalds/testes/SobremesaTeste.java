package br.edu.infnet.mcdonalds.testes;

import br.edu.infnet.mcdonalds.model.Sobremesa;

public class SobremesaTeste {

    public static void main(String[] args){
        Sobremesa sobremesaTeste1 = new Sobremesa("Sorvete", 12,0L,  1, false, "Coco");
        Sobremesa sobremesaTeste2 = new Sobremesa("Bolo", 15, 1L, 2, false, "chocolate");
        Sobremesa sobremesaTeste3 = new Sobremesa("Picole", 5, 2L, 3, false, "Limao");
    }

}
