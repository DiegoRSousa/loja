package dev.diego.pedido;

import dev.diego.orcamento.Orcamento;
import dev.diego.pedido.repository.PedidoRepository;
import dev.diego.pedido.service.EmailService;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;

public class GeraPedido {
    private final String cliente;
    private final String valorOrcamento;
    private final int quantidadeItens;

    private final List<AcaoAposGerarPedido> acoes;


    public GeraPedido(String cliente, String valorOrcamento, int quantidadeItens, List<AcaoAposGerarPedido> acoes) {
        this.cliente = cliente;
        this.valorOrcamento = valorOrcamento;
        this.quantidadeItens = quantidadeItens;
        this.acoes = acoes;

    }

    public boolean executa() {
        var orcamento = new Orcamento(new BigDecimal(valorOrcamento), quantidadeItens);
        var pedido = new Pedido(cliente, orcamento);

        acoes.forEach(a -> a.executarAcao(pedido));
        return true;
    }
}
