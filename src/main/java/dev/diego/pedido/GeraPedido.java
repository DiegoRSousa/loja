package dev.diego.pedido;

import dev.diego.orcamento.ItemOrcamento;
import dev.diego.orcamento.Orcamento;
import dev.diego.pedido.acoes.AcaoAposGerarPedido;

import java.util.List;

public class GeraPedido {
    private final String cliente;

    private final List<ItemOrcamento> itens;

    private final List<AcaoAposGerarPedido> acoes;


    public GeraPedido(String cliente, List<AcaoAposGerarPedido> acoes, List<ItemOrcamento> itens) {
        this.cliente = cliente;
        this.acoes = acoes;
        this.itens = itens;

    }

    public boolean executa() {
        var orcamento = new Orcamento();
        itens.forEach(orcamento::adicionarItem);

        var pedido = new Pedido(cliente, orcamento);

        acoes.forEach(a -> a.executarAcao(pedido));
        return true;
    }
}
