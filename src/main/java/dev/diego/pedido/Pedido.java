package dev.diego.pedido;

import dev.diego.orcamento.Orcamento;

import java.time.LocalDateTime;

public class Pedido {
    private final String cliente;
    private final LocalDateTime data = LocalDateTime.now();
    private final Orcamento orcamento;

    public Pedido(String cliente, Orcamento orcamento) {
        this.cliente = cliente;
        this.orcamento = orcamento;
    }

    public String getCliente() {
        return cliente;
    }

    public LocalDateTime getData() {
        return data;
    }

    public Orcamento getOrcamento() {
        return orcamento;
    }
}
