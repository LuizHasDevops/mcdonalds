package br.edu.infnet.mcdonalds.testes;

import br.edu.infnet.mcdonalds.model.*;

import java.time.LocalDateTime;

public class PedidoTeste {

    public static void main(String[] args) throws Exception {

        Solicitante solicitanteTeste1 = new Solicitante("Paulo", "11111122221", "paulo@gmail.com");
        Solicitante solicitanteTeste2 = new Solicitante("Luiz", "11122233345", "luiz@gmail.com");
        Solicitante solicitanteTeste3 = new Solicitante("Bruno", "22233344456", "bruno@gmail.com");

        Bebida bebidaTeste1 = new Bebida("coca", 10,0L,  true, 15, "coca");
        Comida comidaTeste3 = new Comida("Lasanha", 45, 1L,3,  false, "Presunto");
        Sobremesa sobremesaTeste1 = new Sobremesa("Sorvete", 12, 2L,1,  false, "Coco");

        Pedido pedidoTeste1 = new Pedido("Mesa 02", LocalDateTime.now(), false, 1);
        pedidoTeste1.adicionarBebida( pedidoTeste1, bebidaTeste1);
        pedidoTeste1.setSolicitante(solicitanteTeste1);

        Pedido pedidoTeste2 = new Pedido("Mesa 03", LocalDateTime.now(), false, 2);
        pedidoTeste2.adicionarComida(pedidoTeste2, comidaTeste3);
        pedidoTeste2.setSolicitante(solicitanteTeste2);

        Pedido pedidoTeste3 = new Pedido("Mesa 07", LocalDateTime.now(), false, 3);
        pedidoTeste3.adicionarSobremesa(pedidoTeste3,sobremesaTeste1);
        pedidoTeste3.setSolicitante(solicitanteTeste3);

        Comida comidaTeste2 = new Comida("Hamburguer", 50,0L,  30, false, "Queijo");
        pedidoTeste1.adicionarComida(pedidoTeste1,comidaTeste2);
    }

}
