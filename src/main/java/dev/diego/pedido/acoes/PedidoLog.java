package dev.diego.pedido.acoes;

import dev.diego.pedido.Pedido;

public class PedidoLog implements AcaoAposGerarPedido{
    @Override
    public void executarAcao(Pedido pedido) {
        System.out.println("Pedido gerado: " + pedido);
    }
}
