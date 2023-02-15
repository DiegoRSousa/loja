package dev.diego.pedido;

import dev.diego.orcamento.Orcamento;
import dev.diego.pedido.repository.PedidoRepository;
import dev.diego.pedido.service.EmailService;

import java.math.BigDecimal;

public class GeraPedido {
    private final String cliente;
    private final String valorOrcamento;
    private final int quantidadeItens;

    private final PedidoRepository repository;
    private final EmailService service;

    public GeraPedido(String cliente, String valorOrcamento, int quantidadeItens,
                      PedidoRepository repository, EmailService service) {
        this.cliente = cliente;
        this.valorOrcamento = valorOrcamento;
        this.quantidadeItens = quantidadeItens;
        this.repository = repository;
        this.service = service;
    }

    public boolean executa() {
        var orcamento = new Orcamento(new BigDecimal(valorOrcamento), quantidadeItens);
        var pedido = new Pedido(cliente, orcamento);
        repository.save(pedido);
        service.send(pedido);
        return true;
    }
}
