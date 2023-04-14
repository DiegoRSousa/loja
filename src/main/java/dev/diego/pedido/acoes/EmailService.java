package dev.diego.pedido.acoes;

import dev.diego.pedido.Pedido;

public class EmailService implements AcaoAposGerarPedido {

    @Override
    public void executarAcao(Pedido pedido) {
        System.out.println("Pedido enviado: " + pedido);
    }
}
